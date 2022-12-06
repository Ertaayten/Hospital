
//Stack with Linked List
public class Service_2 {
    Service_1 stack; // Your stack. Use this
    Patient head = null;
    Patient tail = null;
    int size = 0;

    // Constructor to initialize the stack
    Service_2() {
        this.stack = new Service_1();
    }

    // Utility function to add an element `x` to the stack
    public void push(Patient p) {
        stack.insertStart(p.getName());
        size++;
    }
    public Patient popLast(){

        Patient patient = stack.head;
        Patient prev = stack.tail.previous;

        if(prev !=null ){
           prev.next = null;
        }
       stack.tail.previous = null;
        stack.tail = prev;
        return patient;
    }

    // Utility function to pop a top element from the stack
    public Patient pop() {
        Patient patient = stack.head;
        Patient next = stack.head.next;
        if(next!=null){
            next.previous=null;
        }
        stack.head.next = null;
        stack.head = next;
        size--;
        return patient;
    }

    // Utility function to check if the stack is empty or not
    public Boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    // Utility function to return the size of the stack
    public int size() {
        return size;
    }

}
