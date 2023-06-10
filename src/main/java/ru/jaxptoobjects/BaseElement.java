package ru.jaxptoobjects;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseElement implements Element {
    private NamedNodeMap attributes;
    private List<String> attributesNames;

    public BaseElement(Node node) {
        attributes = node.getAttributes();
        attributesNames = new ArrayList();
        for (int i = 0; i < attributes.getLength(); i++) {
            attributesNames.add(attributes.item(i).getNodeName());
        }
    }

    @Override
    public String getAttribute(String attribute) {
        if (attributes == null) {
            return null;
        }
        return attributes.getNamedItem(attribute) != null ? attributes.getNamedItem(attribute).getTextContent() : null;
    }

    @Override
    public boolean hasAttribute(String attribute){
        return getAttribute(attribute) != null;
    }

    @Override
    public List<String> getAttributesNames() {
        return attributesNames;
    }
}
