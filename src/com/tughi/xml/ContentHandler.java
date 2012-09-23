package com.tughi.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

class ContentHandler extends DefaultHandler {

    private static final Element NOP_ELEMENT = new Element();

    private Stack<Element> stack = new Stack<Element>();

    protected ContentHandler(Document document) {
        stack.push(document);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        Element child = stack.peek().getChild(uri, localName);
        if (child == null) {
            child = NOP_ELEMENT;
        }
        stack.push(child).start(uri, localName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        stack.peek().end(uri, localName);
        stack.pop();
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        stack.peek().characters(chars, start, length);
    }

}
