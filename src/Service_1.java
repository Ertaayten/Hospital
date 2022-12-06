
//**************Double Linked List************************//
public class Service_1 {
    Patient head; //head of list
    Patient tail; //tail of list
    public int size;

    //Constructor
    public Service_1() {
        head = null;
        tail = null;
        size = 0;
    }

    //Check list is empty or not
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    //This function first builds new patient with the given data
    //than adds it to the LinkedList
    //new nodes are added to the tail of LinkedList
    public void insert(String name) {
        //Write your codes here
        Patient patient = new Patient(name);
        if (isEmpty() == true) {
            head = patient;
            tail = patient;
        } else {            /** If user wants to insert element to tail */
            tail.next = patient;
            patient.previous = tail.next;
            tail = patient;
        }
        size++;
    }

    public void insertStart(String name) {
        Patient patient = new Patient(name);
        if (head == null) {
            head = patient;
            tail = head;
        } else {
            head.previous = patient;
            patient.next = head;
            head = patient;
        }
        size++;
    }

    // overload this method as new nodes are added to given position (int pos)
    // fill the rest
    public void insert(String name, int pos) {
        Patient patient = new Patient(name);

        Patient pointer = head;

        if (pos == 0) {
            insertStart(name);
            return;
        } else {
            for (int i = 1; i <= size; i++) {
                if (i == pos) {
                    Patient temp = pointer.next;
                    pointer.next = patient;
                    patient.previous = pointer;
                    patient.next = temp;
                    temp.previous = patient;
                }
                pointer = pointer.next;
            }
            size++;
        }
    }


    //This method finds how many patients are exist in LinkedList
    public int size() {
        return size;
    }

    // This functions delete a node in the LinkedList by a given "data"
    // parameter name changed as key in order to prevent confusion
    public Patient deleteByName(String name) {
        Patient patient = head;
        while (patient != null) {
            if (patient.getName() == name) {
                break;
            }
            patient = patient.next;
        }
        if (patient != null) {
            if (patient == head) {             /** If user wants to delete the first element */
                if (patient == tail) {         /** Patient equals head and tail means; linked list has only one element */
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.previous = null;
                }
            } else {
                if (patient == tail) {         /** If user wants to delete the last element */
                    tail = tail.previous;
                    tail.next = null;
                } else {                     /** If user wants to delete another element in the linked list **/
                    patient.previous.next = patient.next;
                    patient.next.previous = patient.previous;
                }
            }


        }
        size--;
        return patient;
    }

    // This functions delete a node in the LinkedList by a given position
    public Patient deleteByPosition(int pos) {
        Patient patient = head;
        if (pos == 0) {      /** If user wants to delete the first element, this if is run */
            head = head.next;
            head.previous = null;
            size--;
            return patient;
        } else if (pos == size) {   /** If user wants to delete the last element, this if is run */
            Patient previous = tail.previous;
            if (previous != null) {
                previous.next = null;
            }
            tail.previous = null;
            tail = previous;
            size--;
            return previous;
        } else {       /** If user wants to delete another element, this if is run */
            for (int i = 0; i < size; i++) {
                if (i == pos) {
                    Patient previous = patient.previous;
                    Patient next = patient.next;
                    previous.next = next;
                    next.previous = previous;
                    size--;
                    break;
                }
                patient = patient.next;

            }
            return patient;
        }
    }

    //This function get the node in the given index
    //*********************DO NOTHING*********************
    public Patient getByPosition(int pos) {
        if (this.isEmpty())
            return new Patient("empty");
        Patient current = this.head;
        int index = 0;

        while (current != null) {
            if (index++ == pos)
                break;
            current = current.next;
        }

        if (current == null)
            return new Patient("empty");

        return current;
    }

    // This function prints  the LinkedList
    //*********************DO NOTHING*********************
    public void print() {

        if (this.isEmpty())
            return;
        Patient patient = this.head;  // make a copy of head
        int index = 1;

        // never operate on "head", otherwise you will lost the linkedlist
        //unless you want to change "head"
        while (patient != null) {
            System.out.println(index++ + ". " + patient.getName());

            patient = patient.next;  // iterate to next node
        }

    }

}
