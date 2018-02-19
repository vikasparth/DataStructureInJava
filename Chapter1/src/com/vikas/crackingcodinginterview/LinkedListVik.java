package com.vikas.crackingcodinginterview;

public class LinkedListVik {
	
	public Node header;
	public Node tail;
	
	public LinkedListVik()
	{
		header = null;
		tail = null;
	}
	
	public LinkedListVik(int data)
	{
		this.header = new Node();
		this.header.data= data;
		this.tail = this.header;
	}
public void addatstart(int data)
{
	Node n = new Node(data);
	if(this.isempty())
	{
		this.header = n;
		this.tail = n;
	}
	else
	{
	n.next = header;
	header.prev=n;
	header = n;	
	}
}

public void addatend(int data)
{
  Node n = new Node(data);
  tail.next = n;
  n.prev = tail;
  tail= n;
  tail.next=null; 
}

public void addbefore(int data1, int data2)
{
 if(this.isempty())
 {
	 System.out.println("The String is Empty");
	 return;
 }
 Node n = new Node();
 n = this.header;
 while(n.data!=data1 && n.next!=null)
 {
	 n = n.next;
 }
 if(n.data==data1)
 {
	 Node add = new Node(data2);
	 if(n==header)
	 {
		 add.next = header;
		 header.prev = add;
		 header = add;
	 }
	 else
	 {
		 
		 n.prev.next = add;
		 add.prev = n.prev;
		 add.next = n; 
	 }	

 }
 else
 {
	 System.out.format("Given number %d was not found in the linked list",data1);
 }

}

public void addafter(int data1, int data2)
{
	
	if(this.isempty())
	 {
		 System.out.println("The String is Empty");
		 return;
	 }
	 Node n = new Node();
	 n = this.header;
	 while(n.data!=data1 || n.next!=null)
	 {
		 n = n.next;
	 }
	 
	 if(n.data==data1)
	 {
		 Node add = new Node(data2);
		
		 if(n==header || n==tail)
		 {	
			 if(header==tail)
			 {
				 add.next = header.next;
				 header.next = add;
				 add.prev = header;
				 tail = add;
			 }
			 else
			 {
			 if(n==header)
			 {
			 add.next = header.next;
			 header.next = add;
			 add.prev = header;
			 }
			 if(n==tail)
			 {
				 tail.next = add;
				 add.next = null;
				 add.prev = tail;
			 }
			 }
		 }
	
		 else
		 {
		
		 add.next = n.next;
		 n.next.prev = add;
		 n.next = add;	
		 add.prev = n;
		 }
	 }
	 else
	 {
		 System.out.format("Given number %d was not found in the linked list",data1);
	 }
}

public void removefirstnode()
{
	if(this.isempty())
	 {
		 System.out.println("The String is Empty");
		 return;
	 }
	if(this.isSingleLength())
	{
		header = tail = null;
	}
	else
	{
		header.next.prev = null;
		header = header.next;
	}	
}

public void removelastnode()
{
	if(this.isempty())
	 {
		 System.out.println("The String is Empty");
		 return;
	 }
	if(this.isSingleLength())
	{
		header = tail = null;
	}
	else
	{
		tail.prev.next = null;
		tail = tail.prev;
		
	}	
}


public boolean contains(int dataparam)
{
	if(this.isempty())
	 {
		 System.out.println("The String is Empty");
		 return false;
	 }
	Node n = header;
	while(n!=null)
	{
		if(n.data==dataparam)
		{
			return true;
		}
		n=n.next;
	}
	return false;
}
	
public boolean isempty()
{
 if(header==null)
 {
	 return true;
 }
 else
 {
	 return false;
 }
}

public boolean isSingleLength()
{
 if(header==tail && header!=null)
 {
	 return true;
 }
 else
 {
	 return false;
 }
}

}
