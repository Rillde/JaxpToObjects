package ru.jaxptoobjects;

import java.util.List;

public interface Element {
    public String getAttribute(String attribute);
    public boolean hasAttribute(String attribute);
    public List<String> getAttributesNames();
}
