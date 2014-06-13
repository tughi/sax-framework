package com.tughi.xml;

public class TagElement extends Element {

	private static final String[] DEFAULT_NAMESPACES = {""};

	protected final String name;
	protected final String[] namespaces;

	public TagElement(String name, String... namespaces) {
		this.namespaces = namespaces.length == 0 ? DEFAULT_NAMESPACES : namespaces;
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
