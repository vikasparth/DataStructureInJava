package com.vikas.crackingcodinginterview;
import java.lang.NullPointerException;

public class SingleLinkedListVik {

	public SingleLinkNode header ;
	public SingleLinkNode tail;
	
	
	public SingleLinkedListVik()
	{
		header = null;
		tail = null;
	}
	
	public SingleLinkedListVik(int data)
	{
		SingleLinkNode node = new SingleLinkNode(data);
		header = tail = node;
	}
	
	
	public boolean addatstart(int value)
	{
		try{
		SingleLinkNode node = new SingleLinkNode(value);
		if(this.isempty())
		{
			header = tail = node;
			return true;
		}
		else
		{
			if(this.issinglelength())
			{
				node.next = header;
				header = node;	
				return true;
			}
			else
			{
				node.next = header;
				header = node;	
				return true;
			}				
		}
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return false;
		}
	}
	
	public boolean addatend(int value)
	{
      try {
		SingleLinkNode node = new SingleLinkNode(value);
		if(this.isempty())
		{
			header = tail = node;
			return true;
		}
		else
		{
			if(this.issinglelength())
			{
				tail.next = node;
				tail = node;
			
			}
			else
			{
				tail.next = node;
				tail = node;
			}
			return true;
		}
      }
      catch(NullPointerException npe){
    	  System.out.println(npe.getMessage());
    	  System.out.println(npe.getStackTrace());
    	  return false;
      }
	}
	
	public boolean addbefore(int before, int value)
	{
		try{
			if(this.isempty())
			{
				System.out.format("String is empty, given element %d is not found",before);
				return false;
			}
			else
			{
				SingleLinkNode runner = header;
				SingleLinkNode previous = header;
				SingleLinkNode node = new SingleLinkNode(value);
				while(runner.data!=before && runner.next!=null)
				{
					previous = runner;
					runner = runner.next;
				}
				if(runner.data==before)
				{
					if(runner == header)
					{
						node.next = header;
						header = node;
					}
					else
					{
						previous.next =  node;
						node.next = runner;
					}
					return true;
				}
				else
				{
					System.out.format("Given element %d is not found",before);
					return false;
				}
			}
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return false;
		}
	}
	
	public boolean addafter(int after, int value)
	{
		try {
		if(this.isempty())
		{
			System.out.format("Linked list is empty, given number %d is not found", after);
			return false;
		}
		else
		{
			SingleLinkNode node = new SingleLinkNode(value);
			SingleLinkNode runner = this.header;
			//SingleLinkNode previous = this.header;
			while(runner.data!=after && runner.next!=null)
			{
				//previous = runner;
				runner = runner.next;				
			}
			if(runner.data==after)
			{
				if(runner == tail)
				{
					tail.next = node;
					tail = node;
				}
				else
				{
					node.next = runner.next;
					runner.next = node;					
				}
				return true;
			}
			else
			{
				System.out.format("Given number %d is not found", after);
				return false;
			}
		}
		}
		catch(NullPointerException npe){
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return false;
		}
	}
	
	public boolean  removefirstnode()
	{
		try {		
		if(this.isempty())
		{
			System.out.println("Linked list is empty, nothing to remove");
			return false;
		}
		else
		{
			if(this.issinglelength())
			{
				header = tail = null;			
			}
			else
			{
				header = header.next;
			}
			return true;
		}		
		}
		catch(NullPointerException npe)
		{
			System.out.print(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return false;
		}
	}
	
	public boolean removelastnode()
	{
		try{
			if(this.isempty())
			{
				System.out.println("Linked list is empty, nothing to remove");
				return false;
			}
			else
			{
				if(this.issinglelength())
				{
					header = tail = null;
				}
				else
				{
					SingleLinkNode runner = header;
					SingleLinkNode previous = null;
					while(runner.next!=null)
					{
						previous = runner;
						runner = runner.next;
					}
					tail = previous;
					previous.next = null;
				}
				return true;
			}			
		}
		catch(NullPointerException npe)
		{
			System.out.print(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return  false;
		}
	}
	public boolean contains(int value)
	{
		try{
			if(this.isempty())
			{
				System.out.println("Linked list is empty, no elements in the list");
				return false;
			}
			else
			{
			SingleLinkNode runner = header;
			while(runner.next!=null && runner.data!=value)
			{
				runner = runner.next;
			}
			if(runner.data==value)
			{
				System.out.println("The given element exists in the linked list");
				return true;
			}
			else
			{
				System.out.println("The given element does not exist in the linked list");
				return false;
			}
			}
			
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return false;
		}
	}
	
	public boolean removenode(int value)
	{
		try{
			if(this.isempty())
			{
				System.out.println("Linked list is empty, no elements to remove");
				return false;
			}
			SingleLinkNode runner = header;
			SingleLinkNode previous = null;
			while(runner.next!=null && runner.data!=value)
			{
				previous = runner;
				runner = runner.next;
			}			
			if(runner.data==value)
			{
			 if(this.issinglelength())
			 {
				 header = tail = null;
			 }
			 else
			 {
				 if(runner == header)
				 {
					 this.removefirstnode();
				 }
				 else if(runner==tail)
				 {
					 this.removelastnode();
				 }
				 else
				 {
					 previous.next = runner.next;
					 runner.next = null;
				 }				 
			 }
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
	
	public boolean addnode(int value)
	{
		try{
			return addatend(value);			
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return false;
		}
	}
	
	public boolean isempty()
	{
		if(header==tail && header==null)
		{
			return true;
		}
		return false;
	}
	
	public boolean issinglelength()
	{
		if(header==tail && header!=null)
		{
			return true;
		}
		return false;
	}
}
