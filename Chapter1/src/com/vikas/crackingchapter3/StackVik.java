
package com.vikas.crackingchapter3;
public class StackVik {

	private StackNode top;
	
	public StackVik(int data)
	{
		this.top = new StackNode(data);
	}
   
	public StackVik()
	{
		this.top=null;
	}
	
	public int pop()
	{
		try
		{
		if(this.isEmpty())
		{
			System.out.println("The Stack is Empty, Nothing to pop");
			return -1;
		}
		else
		{
			int item = this.top.data;
			top = top.next;
			return item;
		}
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return -1;
		}
	}
	
	public int peek()
	{
		try
		{
		if(this.isEmpty())
		{
			System.out.println("The Stack is Empty, Nothing to peek");
			return -1;
		}
		else
		{
			int item = this.top.data;			
			return item;
		}
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return -1;
		}
	}
	
	public boolean push(int num)
	{
		try
		{
		StackNode n = new StackNode(num);
		if(this.isEmpty())
		{
			top = n;
		}
		else
		{
			n.next  = top;
			top = n;
		}
		return true;
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return false;
		}
	}
	
	public boolean isEmpty()
	{
		try{
		
		if(this.top==null)
		{
			return true;
		}
		else
		{
			return false;
		}		
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return false;
		}
	}
}
