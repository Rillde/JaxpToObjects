package ru.jaxptoobjects;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComplexElement extends BaseElement implements ComplexElement {

    private List<Node> elements;
    private List<String> namesChildren;


    public BaseComplexElement(Node node) {
        super(node);
        elements = new ArrayList();
        namesChildren = new ArrayList();
        NodeList elements = node.getChildNodes();
        for (int i = 0; i < elements.getLength(); i++) {
            if (elements.item(i).getNodeType() == Node.ELEMENT_NODE) {
                this.elements.add(elements.item(i));
                namesChildren.add(elements.item(i).getNodeName());
            }
        }
    }

    @Override
    public Node getElement(String elementName) {
        for (Node element: elements) {
            if (element.getNodeName().equals(elementName)) {
                return element;
            }
        }
        return null;
    }


    @Override
    public List<Node> getElementList(String elementName) {
        List<Node> elements = new ArrayList();
        for (Node element: this.elements) {
            if (element.getNodeName().equals(elementName)) {
                elements.add(element);
            }
        }
        return elements;
    }

    @Override
    public boolean hasElement(String elementName) {
        return getElement(elementName) != null;
    }

    @Override
    public List<String> getNamesChildren() {
        return namesChildren;
    }

}
