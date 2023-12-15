/* Name: Khursheed Alam Khan					      Assignment 2: Implementation of Citizen Database
 * Roll# 20i-0496
 * Section: SE-R
 */

// Singly Linked List

public class SingleList <T>
{
	Node head;
	
	 //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	SingleList()
	{
		head = null;
	}
	
	 //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Display
	public void display()
	{
		Node dNode = head;
		
		while(dNode != null)
		{
			System.out.println(dNode.data+" ");
			dNode = dNode.next;
		}
	}
	
	 //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Insert at Start
	public void insertStart(T x)
	{
		Node newNode = new Node(x);
		
		if(head == null)
		{
			head = new Node(x);
			
		}
		else
		{
			newNode.next = head;
			head = newNode;
		}
		return;
	}
	
	 //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Insert at End
	public void insertEnd(T nData)
	{
		if(head == null)
		{
			head = new Node(nData);
		}
		
		else if( head != null)
		{
			Node newNode = new Node(nData);
			newNode.next = null;
			Node endNode = head;
			while(endNode.next != null)
			{
				endNode = endNode.next;
			}
			
			endNode.next = newNode;
		}
		return;
	}
	
	 //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Insert After
	public void insertAfter(Node previousNode, T nData)
	{
		if(previousNode == null)
		{
			System.out.println("The previous node is Null !!!");
			
		}
		
		else
		{
			Node currentNode = new Node(nData);
			currentNode.next = previousNode.next;
			previousNode.next = currentNode;
		
		}
		return;
	}
	
	 //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Delete from Start
	public void deleteStart()
	{
		if(head != null)
		{
			Node temp = null;
			temp = head;
			head=head.next;
			temp = null;
		}
		else if(head == null)
		{
			System.out.println("There are no elements in the list !!!");
		}
		return;
	}
	
	 //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//  Delete from End
	public Node deleteEnd(Node head)
    {
        if(head == null)
        {
            return null;
        }
        
        if(head.next == null) 
        {
            return null;
        }
        
        Node second_last = head;
        while (second_last.next.next != null)
        {
            second_last = second_last.next;
        }
        second_last.next = null;
        return head;
    }
	
	 //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// delete a specific node
	public void deleteAny(int index)
	 {
	     if (head == null)
	     {
	         return;
	     }
	     
	     Node temp = head;
	     
	     if (index == 0)
	     {
	         head = temp.next;
	         return;
	     }

	     for (int i=0; i<index-1; i++)
	     {
	    	 if(temp!=null)
	    	 {
	    		 temp = temp.next;
	    	 }
	     }
	     
	     if (temp == null || temp.next == null)
	     {
	    	 return;
	     }
	     Node next = temp.next.next;
	     temp.next = next;
	 }
	
	 //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
}
