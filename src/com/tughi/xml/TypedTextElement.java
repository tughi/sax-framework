package com.tughi.xml;

import org.xml.sax.Attributes;

public abstract class TypedTextElement extends TextElement {

    private String type;

    public TypedTextElement(String name) {
        super(name);
    }

    public TypedTextElement(String uri, String name) {
        super(uri, name);
    }

    public TypedTextElement(String[] uris, String name) {
        super(uris, name);
    }

    @Override
    public Element getChild(String uri, String name) {
        return this;
    }

    @Override
    protected void start(String uri, String name, Attributes attributes) {
        if (this.name.equals(name)) {
            String type = attributes.getValue("type");
            if (type == null) {
                type = "text";
            }

            this.type = type;

            super.start(uri, name, attributes);
        } else {
            text.append('<').append(name);
            for (int index = 0; index < attributes.getLength(); index ++) {
                text.append(' ').append(attributes.getLocalName(index)).append("=\"").append(attributes.getValue(index)).append('"');
            }
            text.append('>');
        }
    }

    @Override
    protected void end(String uri, String name) {
        if (this.name.equals(name)) {
            super.end(uri, name);
        } else {
            text.append("</").append(name).append('>');
        }
    }

    @Override
    protected void handleText(String text) {
        handleText(text, type);
    }

    protected abstract void handleText(String text, String type);

}
