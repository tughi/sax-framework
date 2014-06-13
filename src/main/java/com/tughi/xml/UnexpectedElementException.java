package com.tughi.xml;

import org.xml.sax.SAXException;

public class UnexpectedElementException extends SAXException {

	public UnexpectedElementException(String namespace, String name) {
		super(namespace.length() > 0 ? namespace + ":" + name : name);
	}

}
