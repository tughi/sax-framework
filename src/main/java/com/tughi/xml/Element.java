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

		for (String namespace : element.namespaces) {
			nameElements.put(namespace, element);
			if (namespace.endsWith("/")) {
				nameElements.put(namespace.substring(0, namespace.length() - 1), element);
			}
		}

		return element;
	}

	public Element getChild(String namespace, String name) throws SAXException {
		Map<String, Map<String, Element>> children = this.children;

		if (children != null) {
			Map<String, Element> nameElements = children.get(name);
			return nameElements != null ? nameElements.get(namespace) : null;
		}

		return null;
	}

	protected void start(String namespace, String name, Attributes attributes) throws SAXException {
	}

	protected void end(String namespace, String name) throws SAXException {
	}

	protected void characters(char[] chars, int start, int length) {
	}

}
