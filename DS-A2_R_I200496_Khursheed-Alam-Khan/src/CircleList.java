/* Name: Khursheed Alam Khan					      Assignment 2: Implementation of Citizen Database
 * Roll# 20i-0496
 * Section: SE-R
 */

// Circular Linked List

public class CircleList <T> 
{

    Node head;
    Node tail;

  //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    // Node Insertion Function
    void InsertNode(T data)
    {
        Node newNode = new Node();
        newNode.data=data;

        if(head == null) 
        {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else 
        {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Node Display function
    void PrintNode()
    {
        Node current = head;
        if(head == null) 
        {
            System.out.println("Circular List is empty");
        }
        else 
        {
            System.out.println("Nodes of the circular linked list: ");
            do
            {
                System.out.println(" "+ current.data);
                current = current.next;
            }while(current != head);
        }
    }
    
  //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Node deletion at any index Function
    public void deleteAny(int index) 
	{   
		  Node nodeToDelete = head;
		  Node temp = head;
		  int NoOfElements = 0;

		  if(temp != null) 
		  {
		    NoOfElements++;
		    temp = temp.next;
		  }
		  while(temp != head) 
		  {
		    NoOfElements++;
		    temp = temp.next;
		  }

		  if(index < 1 || index > NoOfElements) 
		  {
		    System.out.print("Index out of Bound !!!");
		  } 
		  else if (index == 1) 
		  {
		    if(head.next == head) 
		    {
		      head = null;
		    } 
		    else 
		    {
		      while(temp.next != head)
		      {
		        temp = temp.next;
		      }
		      head = head.next;
		      temp.next = head; 
		      head.previous = temp;
		      nodeToDelete = null; 
		    }
		  } 
		  else 
		  { 
		    temp = head;
		    for(int i = 1; i < index-1; i++)
		    {
		      temp = temp.next;
		    }
		    
		    nodeToDelete = temp.next;
		    temp.next = temp.next.next;
		    temp.next.previous = temp;
		    nodeToDelete = null;   
		  }
		  System.out.println();
		}
    
  //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    // Head node deletion function (First node)
    public void deleteStart() 
    {  
        if(head == null) 
        {  
            return;  
        }  
        else 
        {  
            if(head != tail ) 
            {  
                head = head.next;  
                tail.next = head;  
            }   
            else 
            {  
                head = tail = null;  
            }  
        }  
    }
}
