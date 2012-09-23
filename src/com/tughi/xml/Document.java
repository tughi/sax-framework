package com.tughi.xml;

import org.xml.sax.SAXException;

public class Document extends Element {

    public ContentHandler getContentHandler() {
        return new ContentHandler(this);
    }

    @Override
    public Element getChild(String uri, String name) throws SAXException {
        Element child = super.getChild(uri, name);

        if (child == null) {
            throw new UnexpectedElementException(uri, name);
        }

        return child;
    }

}
