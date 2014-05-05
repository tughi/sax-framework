package com.tughi.xml;

import org.xml.sax.SAXException;

public class UnexpectedElementException extends SAXException {

    public UnexpectedElementException(String uri, String name) {
        super(uri.length() > 0 ? uri + ":" + name : name);
    }

}
