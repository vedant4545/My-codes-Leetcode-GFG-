//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution {
    public static Node addOne(Node head) { 
        //code here.
        head = reverse(head);
        
        Node curr = head;
        Node prev = head;
        
        int sum = curr.data+1;
        curr.data = sum%10;
        int carry = sum/10;
        
        curr = curr.next;
        
        while(curr!=null){
            sum = curr.data+carry;
            curr.data = sum%10;
            carry = sum/10;
            
            prev = curr;
            curr = curr.next;
        }
        if(carry > 0) {
            prev.next = new Node(carry);
        }
        
        head = reverse(head);
        return head;
    }
    public static Node reverse(Node head) {
        Node prevNode = null;
        Node currNode = head;
        Node nextNode;
        
        while(currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }
}
