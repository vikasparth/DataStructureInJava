package com.vikas.crackingchapter3;

public class StackNode {

	int data;
	StackNode next;
	public StackNode (int data)
	{
		this.data = data;
		//Do we really need below line?
		this.next = null;
	}
}
