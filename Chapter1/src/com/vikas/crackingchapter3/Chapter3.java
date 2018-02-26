package com.vikas.crackingchapter3;
import com.vikas.crackingcodinginterview.*;
import java.util.Hashtable;

public class Chapter3 {

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
	
}