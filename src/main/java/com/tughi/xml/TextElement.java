package com.tughi.xml;

import org.xml.sax.Attributes;

public abstract class TextElement extends TagElement {

	protected StringBuilder text;

	public TextElement(String name, String... namespaces) {
		super(name, namespaces);
	}

	@Override
	protected void start(String namespace, String name, Attributes attributes) {
		text = new StringBuilder();
	}

	@Override
	protected void end(String namespace, String name) {
		handleText(text.toString());
		text = null;
	}

	@Override
	protected void characters(char[] chars, int start, int length) {
		text.append(chars, start, length);
	}

	protected abstract void handleText(String text);

}
