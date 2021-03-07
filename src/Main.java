// { Driver Code Starts
import java.util.*;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;

            for (int i=0; i<n-1; i++)
            {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();

            Rotate g = new Rotate();
            head = g.rotate(head,k);
            printList(head);
        }
    }

    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}
// } Driver Code Ends


/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

Input:
N = 8
value[] = {1,2,3,4,5,6,7,8}
k = 4
Output: 5 6 7 8 1 2 3 4

*/



class Rotate{
    // This function should rotate list counter-
    // clockwise by k and return head node

    public Node rotate(Node head, int k) {

        Node temp = head;
        Node curr = null;

        while(temp != null){
            k--;
            if(k==0 && temp.next != null){
                curr = temp.next;
                temp.next = null;
            }
            temp = temp.next;
        }

        temp = curr;
        if(curr == null){
            return head;
        }

        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = head;

        head = temp;

        return head;

    }
}
