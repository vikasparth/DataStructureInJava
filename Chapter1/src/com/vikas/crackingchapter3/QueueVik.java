package com.vikas.crackingchapter3;

public class QueueVik {

	private QueueNode start;
	private QueueNode end;
	
	public QueueVik()
	{
		start = end = null;
	}
	
	public QueueVik(int num)
	{
		start = new QueueNode(num);
		end = start;
	}
	
	
	public boolean add(int num)
	{
		try
		{
			if(this.isEmpty())
			{
				this.start = new QueueNode(num);
				this.end = this.start;
			}
			else
			{
				QueueNode newNode = new QueueNode(num);
				this.end.next = newNode;
				this.end = newNode;
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
	
	
	public int retrieve()
	{
		try 
		{
			if(this.isEmpty())
			{
				System.out.println("Nothing to retrieve, the queue is empty");
				return -1;
			}
			else
			{
			 int num;
			 num = start.data;
			 if(this.start==this.end)
			 {				
				 start = end = null;
			 }
			 else
			 {
				 start = start.next;
			 }
			 return num;
			}
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return -1;
			
		}
	}
	
	public boolean isEmpty()
	{
		try
		{			
	
		if(this.start==this.end && this.start==null)
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
