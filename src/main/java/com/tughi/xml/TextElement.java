package com.tughi.xml;

import org.xml.sax.Attributes;

public abstract class TextElement extends TagElement {

    protected StringBuilder text;

    public TextElement(String name) {
        super(name);
    }

    public TextElement(String uri, String name) {
        super(uri, name);
    }

    public TextElement(String[] uris, String name) {
        super(uris, name);
    }

    @Override
    protected void start(String uri, String name, Attributes attributes) {
        text = new StringBuilder();
    }

    @Override
    protected void end(String uri, String name) {
        handleText(text.toString());
        text = null;
    }

    @Override
    protected void characters(char[] chars, int start, int length) {
        text.append(chars, start, length);
    }

    protected abstract void handleText(String text);

}
