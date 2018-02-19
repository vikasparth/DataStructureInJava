/**
 * 
 */
package com.vikas.crackingcodinginterview;
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
	public static void main(String[] args) {
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
     SingleLinkedListVik slsv = new SingleLinkedListVik();
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
     }
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

}