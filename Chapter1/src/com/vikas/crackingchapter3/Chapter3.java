package com.vikas.crackingchapter3;
import com.vikas.crackingcodinginterview.*;
import java.util.Hashtable;

public class Chapter3 {

	private int countdown;
	private int countup;
	private int data;
	/*Below approach removed duplicate from a linked list by using HashTable*/
	public boolean RmvDuplctFrmLinkedListApproach1(SingleLinkedListVik slv)
	{
		try
		{
			Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
			SingleLinkNode runner = slv.header;
			SingleLinkNode previous = slv.header;
			if(slv.issinglelength())
			{
				System.out.println("There is only one element in list, Nothing to remove");
				return true;
			}
			if(slv.isempty())
			{
				System.out.println("Linked list is empty, Nothing to remove");
				return true;
			}
			while(runner!=null)
			{
				if(ht.containsKey(runner.data))
				{
					previous.next = runner.next;
					
				}
				else
				{
					ht.put(runner.data, runner.data);
					previous = runner;
				}
				runner = runner.next;
			}
			return true;
		}
		catch(NullPointerException npe){
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return false;
			}
	}
	
	/*Below approach compares nodes one by one and removes the duplicates*/
	public boolean RmvDuplctFrmLinkedListApproach2(SingleLinkedListVik slv)
	{
		try
		{
			SingleLinkNode runner = slv.header;
			SingleLinkNode previous = slv.header;
			SingleLinkNode current = slv.header;
			if(slv.issinglelength())
			{
				System.out.println("There is only one element in list, Nothing to remove");
				return true;
			}
			if(slv.isempty())
			{
				System.out.println("Linked list is empty, Nothing to remove");
				return true;
			}
			
			while(runner!=null)
			{
				current = runner.next;
				previous = runner;
				while(current!=null)
				{
					if(runner.data==current.data)
					{
						previous.next = current.next;
					}
					else
					{
						previous = current;
					}
					current = current.next;
				}
				runner = runner.next;
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
	/*Below method finds the Kth element from last in a single linked list*/
	public int LinkedListKthToLastApproach1(SingleLinkedListVik slv,int k)
	{
		try
		{
			int linkedListLength = 0;
			SingleLinkNode runner = slv.header;
			if(slv.isempty())
			{
				System.out.print("Linked list is empty, nothing to be found");
				return -1;
			}
			
			while(runner!=null)
			{
				linkedListLength++;	
				runner = runner.next;
			}
			if(k>linkedListLength)
			{
				System.out.println("Linked list size is less than "+k+"given index is not valid");
				return -1;
			}
			else
			{
				int count = linkedListLength - k;
				runner = slv.header;
				while(count>0)
				{
					runner=runner.next;
					count--;
				}
				return runner.data;
			}
			
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return -1;
		}
	}
	
	public int LinkedListKthToLastApproach2(SingleLinkedListVik slv, int k)
	{
		try{
			if(slv.isempty())
			{
				System.out.print("Linked list is empty, nothing to find from");
			}
			if(slv.issinglelength())
			{
				if(k<=1)
				{
					return slv.header.data;
				}
				else
				{
					System.out.println("Linked list is having just one element, can not find given index element");
					return  -1;
				}
			}
			countdown = 0;
			countup = 1;
			SingleLinkNode current = slv.header;
			recursetokth(current,k);
			countdown++;
			if(countdown==k)
			{
				data=current.data;
			}
			return data;
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return -1;
		}
	}
	
	public int LinkedListKthToLastApproach3(SingleLinkedListVik slv,int k)
	{
		try
		{
			if(slv.isempty())
			{
				System.out.print("Linked list is empty, nothing to find from");
			}
			if(slv.issinglelength())
			{
				if(k<=1)
				{
					return slv.header.data;
				}
				else
				{
					System.out.println("Linked list is having just one element, can not find given index element");
					return  -1;
				}
			}
			SingleLinkNode runner = new SingleLinkNode();
			SingleLinkNode current;
			runner = current = slv.header;
			while(runner!=null)
			{
				current = runner;
				for(int i =1;i<k;i++)
				{
					if(current.next==null)
					{
						System.out.println("Given Linked list is shorter than provided index");
						System.out.println("Given index can not be found");
						return -1;
					}
					current=current.next;					
				}
				if(current.next==null)
				{
					return runner.data;
				}
				runner = runner.next;
			}
			return -1;
		}
		catch(NullPointerException npe){
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return -1;
		}
	}
	private void recursetokth(SingleLinkNode current, int k)
	{
		try
		{
			current = current.next;	
			countup++;
			if(current==null)
			{
				if(countup<=k)
				{
					System.out.println("Linked list length is less than desired index");
					System.out.println("Given indexed element can not be found");
				}
				return;
			}
			
			recursetokth(current,k);
			countdown++;
			if(countdown==k)
			{
				data = current.data;
			}
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
		}
		
	}
}
