package TagAPI.Handler;

import TagAPI.Exceptions.TagNotFoundException;
import TagAPI.Exceptions.TagNotSupported;
import TagAPI.Handler.Tag.Tag;
import TagAPI.Handler.Tag.TagData;
import TagAPI.Handler.Tag.TagHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;

public class TagAPI {
    private final HashMap<String, String> messageData = new HashMap<>();
    private final TagHandler tagHandler = new TagHandler();

    public void addMessage(String UID, String message) {
        messageData.put(UID.toLowerCase(), message);
    }

    public TagHandler getTagHandler(){
        return tagHandler;
    }

    public String formatMessage(String key, Object instance) {
        String formattedString = "";

        if (!messageData.containsKey(key.toLowerCase())) throw new TagNotFoundException(key.toLowerCase() + " is not an existing key!");
        String rawMessage = messageData.get(key.toLowerCase());
        char[] messageChars = rawMessage.toCharArray();

        String _tag = "";
        boolean isFormatting = false;

        for (int x = 0; x < messageChars.length; x++) {
            char currentChar = messageChars[x]; //get current char

            switch (currentChar) {
                case '<': //opening tag char.
                    if (x + 1 < messageChars.length) {//if there is another char after this
                        char nextChar = messageChars[x + 1]; //get next char
                        if (nextChar != '/') { //if char is not escaped
                            isFormatting = true;
                            continue;
                        } else {
                            formattedString += currentChar;
                            continue;
                        }
                    } else throw new RuntimeException("TagAPI for type " + key + " is incomplete");

                case '>': //Closing tag char.
                    isFormatting = false; //No longer formatting.
                    if (_tag.isEmpty()) {
                        formattedString += currentChar;
                        continue;
                    }

                    if (tagHandler.tagExists(_tag)){ //if tag exists
                        //get instance data
                        Tag foundTag = tagHandler.getTag(_tag);

                        try {
                            Method data = null;
                            for (Method method : instance.getClass().getDeclaredMethods()){
                                if(method.getName().toLowerCase().equals("get" + foundTag.getKey().toLowerCase())){
                                    data = method;
                                    break;
                                }
                            }
                            if (data == null) throw new TagNotSupported("Tag has no get method for the data, tag is unsupported. Make sure method name equals " + "get" + foundTag.getKey());

                            if(data.getAnnotation(TagData.class) != null){
                                Object dataRaw = data.invoke(instance, null);
                                if (dataRaw.getClass().equals(((ParameterizedType) foundTag.getClass().getGenericSuperclass()).getActualTypeArguments()[0])){ //Check if the data retrieved is of the correct type
                                    Object dataObject = foundTag.getValue(dataRaw);
                                    if (dataObject == null) throw new TagNotSupported("Tag has no get method for the data, tag is unsupported. Make sure method name equals " + "get" + foundTag.getClass().getSimpleName());
                                    formattedString += dataObject;
                                    _tag = "";
                                }else throw new RuntimeException("Class is instance of " + dataRaw.getClass().getSimpleName() + " when it should be " + ((ParameterizedType) foundTag.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
                            } else throw new TagNotSupported("Tag has no get method for the data, tag is unsupported. Make sure method name equals " + "get" + foundTag.getKey());
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (ClassCastException e ) {
                            throw new TagNotSupported("Tag has no get method for the data, tag is unsupported. Make sure method name equals " + "get" + foundTag.getKey());
                        }
                    } else throw new TagNotFoundException("Tag was not found; Make sure tag " + _tag + " is registered!");
                    break;

                default:
                    if (currentChar == '/') continue; //Do not include the escape char.

                    if (isFormatting){
                        _tag += String.valueOf(currentChar).toLowerCase();
                    }else formattedString += currentChar;
                    break;
            }
        }

        return formattedString;
    }
}
