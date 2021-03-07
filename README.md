# _TagAPI Documentation_

# Tags
Tags are used to take a string, find placeholders and fill in the data and return the new string. Tags are marked with <tag> and can be escaped with a Slash (/) charactor.

## Creating Tags

#### Extended Class
```java
public abstract class Tag<t> {
    protected final String key;
    public String getKey() {return key;}

    public Tag(String key) {
        if (key.trim().isEmpty()) throw new IllegalArgumentException("Key cannot be empty!");
        this.key = key.toLowerCase().trim();
    }

    public abstract String getValue(t data);
}
```
When creating a new tag, you must define the *generic type* and *getValue()*; getValue is used to determine what the value of the placeholder text.


#### Pre-Defined Example Class
```java
public class DateTag extends Tag<Date> {

    public DateTag(String key) {
        super(key);
    }

    public String getValue(java.util.Date date) {
        return date.toString();
    }
}
```

This class takes a Date and then returns its string value.

## Handling Tags

```java
private final TagAPI tagAPI = new TagAPI();

    public TagTest() {
        tagAPI.getTagHandler().addTag(new DateTag("DateTag"));
    }
```


### Breakdown
```java
private final TagAPI tagAPI = new TagAPI();
```
Create new instance of the TagAPI class.

```java
tagAPI.getTagHandler().addTag(new DateTag("DateTag"));
```
Get the handler and add the tag. *Key* is the placeholder name. ``<DateTag>`` would referance that tag in **_this instance._**


## Defining the value of a tag
```java
    @TagData
    public Date getDateTag() {
        return new Date();
    }
```
```@TagData``` Tells the handler class this method should be used for the tags. **Methods will be ignored without it**

# Messages
## Setting messages

```java
tagAPI.addMessage("DateNow", "<DateTag> is current date!");
```
In the example above DateTag is the placeholder name and we set the value of DateNow to that placeholder text. We get the date and infom the user of what is being displayed.<br>
**Raw:**``"<DateTag> is current date!"``<br>**Formatted:** ``"Sun Mar 07 00:49:58 GMT 2021" is current date!``<br>

## Get formatted message

```java
tagAPI.formatMessage("DateNow", this);
```

In the example above, we get the placeholder text for ``DateNow`` and tell the handler that the data for this placeholder is in **this** class instance

Argument | Type | Desc
------------ | ------------- | -------------
Name | String | Referance the the placeholder text.
instance | Object | Tells the message handler to use the ``@TagData`` in this object.

# Errors
## Exception Classes

Name | Reason
------------ | -------------
TagNotFoundException | Thrown when the tag is does not exist inside the handler. must use ``TagApi.getTagHandler().addTag()`` OR ``TagApi.getTagHandler().addTags()``
TagNotSupported | Thrown when the data for the tag cannot be found. ``@TagData`` must be present and public method must follow ``get$Key`` for it to be found.