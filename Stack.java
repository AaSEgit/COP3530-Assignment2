/* This class creates a stack by implementing a linked list ADT */

public class Stack
{
    public LinkedListDeque linkedlList = new LinkedListDeque();

    // insert element at the front of the list
    void push(int item) { 
        
        linkedlList.insertFirst(item);
    }

    void push(String item) { 
        
        linkedlList.insertFirst(item);
    }

    // delete element at the front of the list
    String pop() {
        String temp = (String) linkedlList.getFirst();
        linkedlList.removeFirst();
        return temp;
    }

    // returns element at the front of the list
    String peek() {
        return (String) linkedlList.getFirst();
    }

    boolean isEmpty () {
        return linkedlList.isEmpty();
    }
}