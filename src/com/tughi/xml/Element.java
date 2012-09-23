package com.tughi.xml;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.HashMap;
import java.util.Map;


public class Element {

    private Map<String, Map<String, Element>> children;

    public TagElement addChild(TagElement element) {
        Map<String, Map<String, Element>> children = this.children;
        if (children == null) {
            children = new HashMap<String, Map<String, Element>>();
            this.children = children;
        }

        Map<String, Element> nameElements = children.get(element.name);
        if (nameElements == null) {
            nameElements = new HashMap<String, Element>();
            children.put(element.name, nameElements);
        }

        for (String uri : element.uris) {
            nameElements.put(uri, element);
            if (uri.endsWith("/")) {
                nameElements.put(uri.substring(0, uri.length() - 1), element);
            }
        }

        return element;
    }

    public Element getChild(String uri, String name) throws SAXException {
        Map<String, Map<String, Element>> children = this.children;

        if (children != null) {
            Map<String, Element> nameElements = children.get(name);
            return nameElements != null ? nameElements.get(uri) : null;
        }

        return null;
    }

    protected void start(String uri, String name, Attributes attributes) throws SAXException {
    }

    protected void end(String uri, String name) throws SAXException {
    }

    protected void characters(char[] chars, int start, int length) {
    }

}
