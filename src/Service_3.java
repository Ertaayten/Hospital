
//Queue with Linked List
public class Service_3 {
    Service_1 queue; // Your queue. Use this
    int size;
    // Constructor to initialize a queue
    Service_3() {
        this.queue = new Service_1();
    }

    // Utility function to dequeue the front element
    public Patient dequeue() {
        Patient patient = queue.head;
        if(isEmpty() == false){
            Patient next = queue.head.next;
            if(next !=null){
                next.previous = null;
            }
            queue.head.next = null;
            queue.head = next;
            size--;

        }
        return patient;
    }

    // Utility function to add an item to the queue
    public void enqueue(Patient p) {
        queue.insert(p.getName());
        size++;
    }

    // Utility function to check if the queue is empty or not
    public Boolean isEmpty() {
        if(queue.size()==0){
            return true;
        }
        return false;
    }

    // Utility function to return the size of the queue
    public int size() {

        return size;
    }

}
