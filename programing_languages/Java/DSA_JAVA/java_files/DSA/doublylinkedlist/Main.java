package DSA_JAVA.java_files.DSA.doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        // DoublyLinkedList myDLL= new DoublyLinkedList(7);
        // myDLL.printList();
        // System.out.println("**********************"); 

        // DoublyLinkedList myDLL= new DoublyLinkedList(7);
        // myDLL.getHead();
        // myDLL.getTail();
        // myDLL.getLength();
        // myDLL.printList();
        // System.out.println("**********************"); 
        
        // DoublyLinkedList myDLL= new DoublyLinkedList(1);

        // myDLL.append(2);
        // myDLL.printList();
        // System.out.println("**********************"); 

        // DoublyLinkedList myDLL= new DoublyLinkedList(1);
        // myDLL.append(2);

        // myDLL.printList();
        // // (2) Items - Returns 2 Node
        // System.out.println(myDLL.removeLast().value);

        // // (1) Items - Returns 1 Node
        // System.out.println(myDLL.removeLast().value);

        // // (0) Items - Returns null
        // System.out.println(myDLL.removeLast());
        // System.out.println("**********************"); 

        // DoublyLinkedList myDLL= new DoublyLinkedList(2);
        // myDLL.append(3);
        // myDLL.prepend(1);
        // myDLL.printList();
        // System.out.println("**********************"); 

        // DoublyLinkedList myDLL= new DoublyLinkedList(2);
        // myDLL.append(1);

        // // (2) Items - Returns 2 Node
        // System.out.println(myDLL.removeFirst().value);

        // // (1) Items - Returns 1 node
        // System.out.println(myDLL.removeFirst().value);

        // // (0) Items - Returns null
        // System.out.println(myDLL.removeFirst());

        // // myDLL.printList();
        // System.out.println("**********************"); 

        // DoublyLinkedList myDLL= new DoublyLinkedList(0);
        // myDLL.append(1);
        // myDLL.append(2);
        // myDLL.append(3);

        // System.out.println(myDLL.get(1).value);
        // System.out.println(myDLL.get(2).value + "\n");
        // myDLL.printList();
        // System.out.println("**********************"); 

        // DoublyLinkedList myDLL= new DoublyLinkedList(11);
        // myDLL.append(3);
        // myDLL.append(23);
        // myDLL.append(7);

        // myDLL.set(1, 4);
        // myDLL.printList();
        // System.out.println("**********************"); 

        // DoublyLinkedList myDLL= new DoublyLinkedList(1);
        // myDLL.append(3);
        // myDLL.insert(1, 2);
        // myDLL.printList();
        // System.out.println("**********************"); 

        DoublyLinkedList myDLL= new DoublyLinkedList(0);
        myDLL.append(1);
        myDLL.append(2);
        myDLL.remove(1);
        myDLL.printList();
        System.out.println("**********************"); 
    }
}
