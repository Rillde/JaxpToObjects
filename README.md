# JaxpToObjects

## Purpose

---
This project is used to map xml elements into Java classes and compose them using Java API for XML Processing (JAXP).
You may want to use this approach to make the xml elements clearer and at the same time encapsulate the logic for getting data out of the elements.

## Download

---
[JAR on release page](https://github.com/Rillde/JaxpToObjects/releases)

## Simple example

---
Example xml elements:
```xml
<Bot token="11223">
    <Replies>
        <Reply>Text1</Reply>
        <Reply>Text2</Reply>
    </Replies>
</Bot>
```

An example of mapping `xml elements` with `JaxpToObjects`:

## Bot
```java
public class Bot extends AbstractComplexElement {
    private String token;
    private Replies replies;

    public Bot(Node node) {
        super(node);
        replies = new Replies(getElement("Replies"));
        token = getAttribute("token");
    }
    
    public String getToken() {
        return token;
    }

    public Replies getReplies() {
        return replies;
    }
}
```

## Replies
```java
public class Replies extends AbstractComplexElement {
    private List<Reply> replyList;

    public Replies(Node node) {
        super(node);
        replyList = new ArrayList();
        for (Node reply: getElements("Reply")) {
            replyList.add(new Reply(reply));
        }
    }

    public List<Reply> getReplyList() {
        return replyList;
    }
}
```

## Reply
```java
public class Reply extends AbstractSimpleElement {
    public Reply(Node node) {
        super(node);
    }
}
```

## License

MIT