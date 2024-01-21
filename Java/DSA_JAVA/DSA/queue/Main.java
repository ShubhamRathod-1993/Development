package DSA.queue;

public class Main {
    public static void main(String[] args) {
        // Queue myQueue = new Queue(4);
        // myQueue.printQueue();
        // System.out.println("**********************"); 

        // Queue myQueue = new Queue(4);

        // myQueue.getFirst();
        // myQueue.getLast();
        // myQueue.getLength();
        // myQueue.printQueue();
        // System.out.println("**********************"); 

        // Queue myQueue = new Queue(1);
        // myQueue.enqueue(2);
        // myQueue.printQueue();
        // System.out.println("**********************"); 

        Queue myQueue = new Queue(2);
        myQueue.enqueue(1);

        // (2) Items- Returns 2 Node 
        System.out.println(myQueue.dequeue().value);
        
        // (1) Items - Returns 1 Node
        System.out.println(myQueue.dequeue().value);

        // (0) Returns Null
        System.out.println(myQueue.dequeue());

        // myQueue.printQueue();
        System.out.println("**********************"); 

    }
}
