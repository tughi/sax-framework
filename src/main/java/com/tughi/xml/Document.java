package com.tughi.xml;

import org.xml.sax.SAXException;

public class Document extends Element {

    public org.xml.sax.ContentHandler getContentHandler() {
        return new ContentHandler(this);
    }

    @Override
    public Element getChild(String namespace, String name) throws SAXException {
        Element child = super.getChild(namespace, name);

        if (child == null) {
            throw new UnexpectedElementException(namespace, name);
        }

        return child;
    }

    @Override
    public String toString() {
        return "<DOC>";
    }

}
