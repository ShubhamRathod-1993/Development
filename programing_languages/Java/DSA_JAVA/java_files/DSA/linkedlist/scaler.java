package DSA_JAVA.java_files.DSA.linkedlist;

public class scaler {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    private ListNode breakLoop(ListNode A){
        ListNode fast=A;
        ListNode slow=A;

        while(fast !=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                break;
            }
        }

        if (fast==null || fast.next==null){
            return A;
        }

        slow=A;

        while(slow.next!= fast.next){
            slow=slow.next;
            fast=slow.next;
        }

        fast.next=null;
        return A;
    }

    private void printList(ListNode head){
        ListNode current= head;
        int count=0;
        while(current != null && count<10){
            System.out.print(current.val + " ");
            current= current.next;
            count++;
        }
        System.out.println();
    }
    public void solve(ListNode A) {
        ListNode brk= breakLoop(A);
        printList(brk);
    }

    public static void main(String[] args) {
        scaler solution = new scaler();

        // Example usage:
        // scaler.ListNode A = solution.new ListNode(1);
        // A.next = solution.new ListNode(2);
        // A.next.next = solution.new ListNode(3);

        ListNode A2 = solution.new ListNode(3);
        A2.next = solution.new ListNode(2);
        A2.next.next = solution.new ListNode(4);
        A2.next.next.next = solution.new ListNode(5);
        A2.next.next.next.next = solution.new ListNode(6);
        A2.next.next.next.next.next = A2.next.next; 

        System.out.println("Original List:");
        
        solution.solve(A2);
    }
}


