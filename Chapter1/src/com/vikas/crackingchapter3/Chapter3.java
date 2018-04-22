package com.vikas.crackingchapter3;
import com.vikas.crackingcodinginterview.*;
import java.util.Hashtable;

import javax.swing.JSpinner.ListEditor;

public class Chapter3 {

	private int countdown;
	private int countup;
	private int data;
	private boolean isPalindrome;
	
	private class PartialSum
	{
		int sum = 0;
		int carry = 0;
	}
	private class Intersection
	{
		SingleLinkNode intersectionNode;
		boolean flag;
	}
	
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
	public void DeleteNodeInMiddle(SingleLinkNode middle)
	{
		try
		{
		SingleLinkNode nextnode = middle.next;
		middle.data = nextnode.data;
		middle.next = nextnode.next;
		nextnode.next = null;
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
		}
	}

	public SingleLinkedListVik PartitionAroundElementApproach1(SingleLinkedListVik slv,int pivot)
	{
		try
		{
			SingleLinkedListVik lesserElements = new SingleLinkedListVik();
			SingleLinkedListVik higherElements = new SingleLinkedListVik();
			SingleLinkNode runner = slv.header;
			SingleLinkNode lrunner = null;
			SingleLinkNode hrunner = null;
			
			while(runner!=null)
			{
				if(runner.data<pivot)
				{
					if(lesserElements.header==null)
					{
						lesserElements.header = new SingleLinkNode(runner.data);						
						lrunner = lesserElements.header;
					}
					else
					{
						lrunner.next = new SingleLinkNode(runner.data);
						lrunner = lrunner.next;
					}
				}
				else
				{
					if(higherElements.header==null)
					{
						higherElements.header = new SingleLinkNode(runner.data);
						hrunner = higherElements.header;
					}
					else
					{
						hrunner.next = new SingleLinkNode(runner.data);
						hrunner = hrunner.next;
					}
				}
				runner = runner.next;
			}
			if(!lesserElements.isempty())
			{
				lrunner.next = higherElements.header;
				slv = lesserElements;
			}
			return slv;			
		}
		catch(NullPointerException npe)
		{
			System.out.print(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return new SingleLinkedListVik();
		}
	}
   
	/*Below approach implements by maintaining leserPoint and higerPointer to adjust nodes*/
	public boolean PartitionAroundElementApproach2(SingleLinkedListVik slv,int pivot)
    {
    	try
    	{
    		if(slv.isempty())
    		{
    			return false;
    		}
    		if(slv.issinglelength())
    		{
    			return false;
    		}
    		
    		SingleLinkNode lessPoint=null;
    		SingleLinkNode highPoint=null;
    		SingleLinkNode runner=null;
    		SingleLinkNode previous=null;
    		runner = slv.header;
    		
    		while(runner!=null)
    		{
    			if(runner.data<pivot)
    			{
    				if(previous==lessPoint ||  lessPoint == null)
    				{
    				lessPoint = runner;
    				previous = runner;
    				runner = runner.next;
    				}
    				else
    				{
    				 previous.next = runner.next;    				 
    				 runner.next = lessPoint.next;
    				 lessPoint.next = runner;
    				 lessPoint = runner;
    				 runner = previous.next;
    				}
    			}
    			else
    			{
    				if(previous==highPoint || highPoint == null)
    				{
    				highPoint = runner;
    				previous = runner;
    				runner = runner.next;
    				}
    				else
    				{
    				 previous.next = runner.next;    				 
       				 runner.next = highPoint.next;
       				 highPoint.next = runner;
       				 highPoint = runner;
       				 runner = previous.next;
    				}
    			}
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
	public boolean PartitionAroundElementApproach3(SingleLinkedListVik slv,int pivot)
	{
		try
		{
			if(slv.isempty())
			{
				return false;
			}
			if(slv.issinglelength())
			{
				return false;
			}		
		SingleLinkNode runner = slv.header;
		SingleLinkNode previous = null;
		while(runner!=null)
		{
			if(runner.data<pivot && previous!=null)
			{
				previous.next = runner.next;				
				runner.next = slv.header;
				slv.header = runner;
				runner = previous.next;
				
			}
			else
			{
				previous = runner;
				runner = runner.next;
			}
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
    
	public void SumLists(SingleLinkNode l1, SingleLinkNode l2)
	{
		try{
			
			addListByRecursion(l1,l2,0);
			
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());			
		}
		
	}
	private void addListByRecursion(SingleLinkNode l1, SingleLinkNode l2, int carry)
	{
		try{
			if(l1==null && l2 ==null)
			{
				return;
			}
			int num1=0;
			int num2=0;
			int sum = 0;
			int value=0;
			if(l1!=null)
			{
				num1 = l1.data;
				l1 = l1.next;
			}
			if(l2!=null)
			{
				num2 = l2.data;
				l2 = l2.next;
			}
			sum = num1 + num2+carry;
			carry = sum/10;			
			
			if(l1 == null && l2 ==null)
			{
				value = sum;
			}
			else
			{
			value = sum%10;
			}
			addListByRecursion(l1,l2,carry);
			
			System.out.print(value);
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());			
		}
		
	}
	
	
	public void SumListsFollowup(SingleLinkNode l1, SingleLinkNode l2)
	{
		try{
			
			addListByRecursionFollowUp(l1,l2,0,l1,l2);
			
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());			
		}
	}
	
	/*Vikas - Below method needs to be fixed, I shall come back to it*/
	private PartialSum addListByRecursionFollowUp(SingleLinkNode l1, SingleLinkNode l2, int carry, SingleLinkNode l1Header, SingleLinkNode l2Header)
	{
		try{
			int num1=0;
			int num2=0;
			int sum = 0;
			int value=0;
			if(l1.next==null && l2.next ==null)
			{
				PartialSum psum = new PartialSum();
				psum.sum = (l1.data + l2.data) % 10;
				psum.carry = (l1.data + l2.data) / 10;
				return psum;				
			}
			
			if(l1.next!=null)
			{				
				l1 = l1.next;
			}
			if(l2.next!=null)
			{				
				l2 = l2.next;
			}
			PartialSum psum;
			psum = addListByRecursionFollowUp(l1,l2,carry,l1Header,l2Header);
			System.out.print(psum.sum);
			num1 = l1.data;
			num2=l2.data;
			
			psum.sum = num1 + num2 + psum.carry;
			carry = sum/10;	
			if(l1 == l1Header && l2 ==l2Header)
			{
				value = sum;
			}
			else
			{
			value = sum%10;
			}
			
			return psum;
			//System.out.print(value);
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());		
			PartialSum psum2 = null;
			return psum2;
		}
		
	}


	public boolean isLinkedListPalindromeApproach1(SingleLinkedListVik slv)
	{
		try{
			
			if(slv.isempty())
			{
				System.out.println("Linked list is empty, not valid to be checked for Palindrome");
				return false;
			}
		
			if(slv.issinglelength())
			{
				System.out.println("There is only one element in list, so i guess you can call it Palindrome");
				return true;
			}
			isPalindrome = true;
			SingleLinkNode header = slv.header;			
			checkListPalindrome(header,header);		
			
			return isPalindrome;
		}
		catch(NullPointerException npe )
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());	
			return false;
		}
		
	}
	
	private SingleLinkNode checkListPalindrome(SingleLinkNode runner1,SingleLinkNode runner2)
	{	
		try{
		if(runner2==null)
		{
			//Return the header node when linked list end is returned
		  return runner1;
		}
		runner2 = runner2.next;
	    runner1 = checkListPalindrome(runner1,runner2);		
	   if(runner2!=null)
		{
		   if( runner1.data!=runner2.data)
		   {
				isPalindrome = false;
		   }
		   // Now after runner2 has reached end runner1 will start walking from header
		   runner1 = runner1.next;
		}
	   // By returning the updated value of runner1, each unwinding will move a step forward in linked list
	   return runner1;
	}
	catch(NullPointerException npe )
	{
		System.out.println(npe.getMessage());
		System.out.println(npe.getStackTrace());	
		return null;
	}
	}	

	public SingleLinkNode checkListsIntersection(SingleLinkNode list1, SingleLinkNode list2)
	{
		try
		{
			Intersection validate = new Intersection();
			validate.flag = true;
			validate.intersectionNode = null;
		    checkListsIntersectionRecurse(list1,list2,validate);
			return validate.intersectionNode;
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
			return null;
		}
	}
	
	private void checkListsIntersectionRecurse(SingleLinkNode list1, SingleLinkNode list2,Intersection validate)
	{
		try{
		if(list1==null && list2==null)
		{
			return;
		}
		if(list1!=null)
		{
		list1 = list1.next;
		}
		if(list2!=null)
		{
		list2 = list2.next;
		}
		checkListsIntersectionRecurse(list1,list2,validate);
		if(list1!=null && list2!=null)
		{
		if(list1.next == null && list2.next == null)
		{
			if(list1 == list2)
			{
				validate.flag = true;
				System.out.println("Given linked lists intersect with each other");
			}
			else
			{
				validate.flag = false;
				System.out.println("Given linked lists do not intersect");
			}
		}
		
		if(validate.flag)
		{
			if(list1!=list2)
			{
				if(list1.next == list2.next)
				{
					validate.intersectionNode = list1.next;
					validate.flag = false;
				}
			}
		}		
		}
		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
			System.out.println(npe.getStackTrace());
		    return;
		}
	}

}
