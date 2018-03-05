/**
 * 
 */

package com.vikas.crackingcodinginterview;
import com.vikas.crackingchapter3.*;

/**
 * @author vikas
 *
 */
public class Chapter1 {

	public void test(){
		System.out.println("Hello World");
	}
	
	/*Below Prints compressed string*/
	public void compressedstring(String str)
	{
		char[] array = new char [str.length()];
		int currentpos = 0;
		int counter = 1;
		array[0] = str.charAt(0);
		/*/navigate through the string and add counter to character
		 when character at a position does not match with next character*/
		for(int i =0;i<str.length();i++)
		{
			if(str.charAt(i)!=array[currentpos])
			{
				/*As new character is found, add counter value for previous character
				 * and now start counting for new character*/
				array[++currentpos] = new Integer(counter).toString().charAt(0);
				array[++currentpos] = str.charAt(i);				
				counter = 1;
			}
			else
			{
				counter++;
			}
			
		}
		for(int i =0; i< array.length;i++)
		{
			System.out.print(array[i]);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
{
		try
		{
     Chapter1 c = new Chapter1();
     c.test();
     String str = new String();
     str = "Ram Ram Bhai Log";
     for(int i =0;i<str.length();i++)
     {
    	 System.out.print(str.charAt(i));
     }
     System.out.println("");
    /* c.compressedstring("aabcccccaaa");*/
     
//     LinkedListVik lsv = new LinkedListVik(10);
//     lsv.addafter(10, 20);
//     lsv.addatstart(50);
//     lsv.addatend(60);
//     lsv.addbefore(20,70);
//     lsv.removefirstnode();
//     lsv.removelastnode();
//     Node n = lsv.header;
//     
//     while(n !=null)
//     {
//    	 System.out.println(n.data);
//    	 n=n.next;
//     }
     /*SingleLinkedListVik slsv = new SingleLinkedListVik();
     slsv.addnode(10);
     slsv.addafter(10, 20);
     slsv.addatstart(50);
     slsv.addatend(60);
     slsv.addbefore(20,70);
     slsv.removefirstnode();
     slsv.removelastnode();
     SingleLinkNode n = slsv.header;
     
     while(n !=null)
     {
    	 System.out.println(n.data);
    	 n=n.next;
     }*/
     
     /*Below is the code to use and test Stack implementation*/
//    StackVik st = new StackVik();
//     int num;
//     st.peek();
//     st.pop();
//     st.push(7);
//     st.push(54);
//     st.push(6);
//     st.push(97);
//     st.push(100);
//
//    num = st.peek();
//    System.out.format("%d,",num);
//  
//     System.out.println("The popped elements are as below");
//     while(!st.isEmpty())
//     {
//    	 num = st.pop();
//    	 System.out.format("%d,",num);
//    	 
//     }   

    /*Below code is testing methods for removing duplicate nodes from a single linked list*/ 
//    SingleLinkedListVik sllv = new SingleLinkedListVik();
//    sllv.addnode(10);
//    sllv.addnode(20);
//    sllv.addnode(30);
//    sllv.addnode(10);
//    sllv.addnode(20);
//    sllv.addnode(30);
//    sllv.addnode(40);
//    System.out.println("Linked list before removal of duplicate nodes is as below");
//    SingleLinkNode runner = sllv.header;
//    while(runner!=null)
//    {
//    	System.out.print(runner.data+",");
//    	runner = runner.next;
//    }
//    System.out.println("");
//    Chapter3 ch3 = new Chapter3();
//    ch3.RmvDuplctFrmLinkedListApproach1(sllv);
//    //ch3.RmvDuplctFrmLinkedListApproach2(sllv);
//    
//    System.out.println("Linked list after removal of node is as below");
//    runner = sllv.header;
//    while(runner!=null)
//    {
//    	System.out.print(runner.data+",");
//    	runner=runner.next;
//    }
//    System.out.println("");
    
     /*Below code tests method to remove kth element from last for a SingleLinkedList*/
//    SingleLinkedListVik slv2 = new SingleLinkedListVik();
//    slv2.addnode(10);
//    slv2.addnode(20);
//    slv2.addnode(30);
//    slv2.addnode(40);
//    slv2.addnode(50);
//    slv2.addnode(60);
//    
//    Chapter3 chap32 = new Chapter3();
//    int k =3;
//    int kthdata;
//    
//  // kthdata = chap32.LinkedListKthToLastApproach1(slv2, k);
//  //kthdata = chap32.LinkedListKthToLastApproach2(slv2, k);
//    kthdata = chap32.LinkedListKthToLastApproach3(slv2, k);
//    System.out.format("%d th position element from last is %d : ", k,kthdata);
    
    /*Below code test deleting a node in linked list when header is not known*/
//    SingleLinkedListVik slv3 = new SingleLinkedListVik();
//    slv3.addnode(10);
//    slv3.addnode(20);
//    slv3.addnode(30);
//    slv3.addnode(40);
//    slv3.addnode(50);
//    slv3.addnode(60);
//  SingleLinkNode runner = slv3.header;
//    for(int i =0;i<3;i++)
//    {
//    	runner=runner.next;
//    }
//    SingleLinkNode middle = runner;  
//  System.out.println("Linked list before removal of duplicate nodes is as below");
//  runner =  slv3.header;
//  while(runner!=null)
//  {
//  	System.out.print(runner.data+",");
//  	runner = runner.next;
//  }
//
//  System.out.println("");
//
//  Chapter3 ch3 = new Chapter3();
//  ch3.DeleteNodeInMiddle(middle);
// 
//  System.out.println("Linked list after removal of middle node is as below");
//  runner = slv3.header;
//  while(runner!=null)
//  {
//  	System.out.print(runner.data+",");
//  	runner=runner.next;
//  }
  
  /*Below code tests the approach where we partition a linked list around a number*/
  Chapter3 ch3 = new Chapter3();
  SingleLinkedListVik slv4 = new SingleLinkedListVik();
  slv4.addnode(3);
  slv4.addnode(5);
  slv4.addnode(8);
  slv4.addnode(5);
  slv4.addnode(10);
  slv4.addnode(2);
  slv4.addnode(1);
  slv4.addnode(11);
  slv4.addnode(21);
  slv4.addnode(4);
  SingleLinkNode runner = slv4.header;
  System.out.println("Linkedlist before partition is as below");
  runner =  slv4.header;
  while(runner!=null)
  {
  	System.out.print(runner.data+",");
  	runner = runner.next;
  }

  System.out.println("");
  
 // slv4 = ch3.PartitionAroundElementApproach1(slv4, 5);
//  ch3.PartitionAroundElementApproach2(slv4, 5);
  ch3.PartitionAroundElementApproach3(slv4, 5);
  
  System.out.println("Linkedlist after partition is as below");
  runner =  slv4.header;
  while(runner!=null)
  {
  	System.out.print(runner.data+",");
  	runner = runner.next;
  }

  System.out.println("");
  
  System.out.println("");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}



}
