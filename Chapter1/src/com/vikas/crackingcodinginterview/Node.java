package com.vikas.crackingcodinginterview;

public class Node {
	
	public int data;
	public Node next;
	public Node prev;
	
	public Node()
	{
		data = -99;
		next = null;
		prev = null;
	}

	public Node(int dataparam)
	{
		data = dataparam;
		next = null;
		prev = null;
	}
}
