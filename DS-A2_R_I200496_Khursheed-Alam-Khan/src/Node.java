/* Name: Khursheed Alam Khan					      Assignment 2: Implementation of Citizen Database
 * Roll# 20i-0496
 * Section: SE-R
 */

// Node Class

public class Node <T> 
{
	T data;
	Node next;
	Node previous;
	
	Node()
	{
		
	}
	
	
	Node(T data)
	{
		this.data=data;
		next=null;
		previous=null;
	}
	
	
}
