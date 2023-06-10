package ru.jaxptoobjects;

import org.w3c.dom.Node;

import java.util.List;

public interface ComplexElement extends Element {
    public Node getElement(String elementName);
    public List<Node> getElementList(String elementName);
    public boolean hasElement(String elementName);
    public List<String> getNamesChildren();
}
