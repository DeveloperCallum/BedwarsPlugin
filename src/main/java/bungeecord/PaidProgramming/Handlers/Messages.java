package bungeecord.PaidProgramming.Handlers;

import bungeecord.PaidProgramming.Handlers.Tags.TagHandler;
import bungeecord.PaidProgramming.Handlers.Tags.TagNotClosedException;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.HashMap;

public class Messages { //This class will allow for messages to be set inside a config. | Use / as an escape char
    //This class will allow for a string to be formatted, tags will be created so that <PLAYER> would be replaced with the players name. Space Independent.
    private static TagHandler tagHandler = null;
    private static final HashMap<COMMAND_MESSAGES, BaseComponent> messages = new HashMap<>(); //TODO: Change COMMAND_MESSAGES to strings or allow them to be parsed to strings, so if i was to create an API users would only be able to add it to the handler.

    //Class_Entity_MessageType...
    public enum COMMAND_MESSAGES {
        //region LobbyCmds
        LOBBYCMDS_CONSOLE_ENABLED,
        LOBBYCMDS_CONSOLE_DISABLED,
        //endregion

        //region LOBBY
        LOBBY_PLAYER_PROCESSING,
        LOBBY_PLAYER_REQUEST_ACCEPTED,
        LOBBY_PLAYER_REQUEST_DENIED,
        LOBBY_CONSOLE_DENIED
        //endregion
    }


    public static String formatted(COMMAND_MESSAGES type, Object... data) {
        String formattedString = "";

        if (messages.containsKey(type)) {
            TextComponent message = (TextComponent) messages.get(type).duplicate();


            String _tag = "";
            boolean isFormatting = false;
            int passedTags = 0;

            char[] messageChars = message.getText().toCharArray();

            for (int x = 0; x < messageChars.length; x++) {
                char currentChar = messageChars[x]; //Get current Char

                switch (currentChar) {
                    case '<': //If current char is tag opening
                        if (x + 1 < messageChars.length) { //if there is another char after this
                            char nextChar = messageChars[x + 1]; //get next char
                            if (nextChar != '/') { //if char is not escaped
                                isFormatting = true;
                                continue;
                            } else {
                                formattedString += currentChar;
                                continue;
                            }
                        } else throw new TagNotClosedException("Message for type " + type + " is incomplete"); // if these is not char after this, it is impossible for it to be a tag.

                    case '>':
                        isFormatting = false;

                        if (tagHandler.tagExists(_tag)){
                            formattedString += tagHandler.getTag(_tag).getValue(data[passedTags++]); //Get string value
                        }else formattedString += currentChar;
                        break;

                    default:
                        if (currentChar == '/') continue; //Do not include the escape char.

                        if (isFormatting){
                            _tag += String.valueOf(currentChar).toLowerCase();
                        }else formattedString += currentChar;
                        break;
                }

            }
        }

        return formattedString;
    }

    public static void setTagHandler(TagHandler taghandler) {
        if (taghandler == null) return;
        if (tagHandler == null) tagHandler = taghandler;
    }

    //region Getter & Setter
    public static BaseComponent getMessage(COMMAND_MESSAGES type) {
        if (!messages.containsKey(type)) return null;
        return messages.get(type);
    }

    public static void setMessage(COMMAND_MESSAGES type, BaseComponent text) {
        if (!messages.containsKey(type)) messages.put(type, text);
    }
    //endregion
}




