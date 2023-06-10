package ru.jaxptoobjects;

import org.w3c.dom.Node;


public abstract class BaseSimpleElement extends BaseElement implements SimpleElement {

    private String value;

    public BaseSimpleElement(Node node) {
        super(node);
        this.value = node.getTextContent();
    }

    @Override
    public String getValue() {
        return value;
    }






}
