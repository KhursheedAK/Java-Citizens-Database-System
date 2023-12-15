/* Name: Khursheed Alam Khan					      Assignment 2: Implementation of Citizen Database
 * Roll# 20i-0496
 * Section: SE-R
 */

// Doubly Linked List

public class DoubleList <T>
{
	Node <T> head;
    Node <T> tail;
    
  //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    DoubleList()
    {
        head=null;
        tail=null;
    }
  //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    // Node insertion Function
    public Node InsertNode(int index, T data)
    {
        if (index < 0) return null;

        int currIndex	=	1;
        Node currNode	=	head;
        while (currNode!=null && index > currIndex) 
        {
            currNode=currNode.next;
            currIndex++;
        }
        
        if (index > 0 && currNode == null) 
        {
        	return null;
        }
        
        Node newNode =new Node();
        newNode.data	=	data;
        if (head==null) 
        {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        }
        
        else if(index==0 && head!=null)
        {
            newNode.next=head;
            head.previous=newNode;
            head=newNode;
        }

       else if(currNode.next==null)
       {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;

       }
       
        else 
        {
            newNode.next = currNode.next;
            currNode.next =	newNode;
            newNode.next.previous = newNode;
            newNode.previous = currNode;
        }
        return newNode;
    }

  //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    // Display Nodes Function
    void  displayNodes()
    {
        int num = 0;
        Node currNode = head;
        while (currNode != null)
        {
            System.out.println(currNode.data);
            currNode = currNode.next;
            num++;
        }
    }

  //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    // Deletion of Node Function
    public Boolean DeleteNode(int cnic) 
    {
        Node <CBID> prevNode=null;
        Node <CBID> currNode=(Node<CBID>) head;

        boolean flag= false;
        while (currNode!=null && currNode.data.getCnic() != cnic) 
        {
            prevNode=currNode;
            currNode=currNode.next;
        }
        
        if (currNode!=null) 
        {
            if (prevNode!=null&& currNode.next!=null) 
            {
                prevNode.next=currNode.next;
                currNode.next.previous=prevNode;
            }
            
            else if (prevNode!=null&& currNode.next==null)
            {
                prevNode.next=null;
                tail=(Node<T>) prevNode;
            }

            else 
            {
                head=currNode.next;
                head.previous=null;
            }
            flag= true;
            return flag;
        }
        return flag;
    }
}
