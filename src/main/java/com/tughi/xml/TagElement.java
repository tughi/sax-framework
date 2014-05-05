package com.tughi.xml;

public class TagElement extends Element {

    private static final String[] NULL_URIS = {""};

    protected final String[] uris;
    protected final String name;

    public TagElement(String name) {
        this(NULL_URIS, name);
    }

    public TagElement(String uri, String name) {
        this.uris = new String[] { uri };
        this.name = name;
    }

    public TagElement(String[] uris, String name) {
        this.uris = uris;
        this.name = name;
    }

}
