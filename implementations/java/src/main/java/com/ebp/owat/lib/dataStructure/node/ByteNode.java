package com.ebp.owat.lib.dataStructure.node;

import com.ebp.owat.lib.dataStructure.node.value.ByteValue;

/**
 *  A Node that holds a ByteValue.
 *
 * Created by Greg Stewart on 3/26/17.
 */
public class ByteNode extends Node<ByteValue> {
	/**
	 * Basic constructor. Does not set any values.
	 */
	public ByteNode() {
	}
	
	/**
	 * Constructor that sets this node's value.
	 *
	 * @param nodeValue The value to set this node to.
	 */
	public ByteNode(ByteValue nodeValue) {
		super(nodeValue);
	}
}
