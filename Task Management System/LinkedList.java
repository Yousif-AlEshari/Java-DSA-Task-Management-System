public class LinkedList {
    Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void insertBeginning(Task data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertEnd(Task data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public Task deleteBeginning() {
        if (head == null) {
            return null;
        }
        Task removedTask = head.value;
        head = head.next;
        size--;
        printTaskDetails(removedTask);
        return removedTask;
    }

    public Task deleteEnd() {
    	 if (head == null) {
             return null;
         }
         if (head.next == null) {
             Task removedTask = head.value;
             head = null;
             size--;
             printTaskDetails(removedTask);
             return removedTask;
         }
         Node current = head;
         while (current.next.next != null) {
             current = current.next;
         }
         Task removedTask = current.next.value;
         current.next = null;
         size--;
         printTaskDetails(removedTask);
         return removedTask;
    }
    
    public Task deleteAtIndex(int index) {
    	 if (index < 0 || index >= size) {
             throw new IndexOutOfBoundsException("Index out of bounds");
         }
         if (index == 0) {
             return deleteBeginning();
        }
         Node previous = null;
         Node current = head;
         for (int i = 0; i < index; i++) {
             previous = current;
             current = current.next;
         }
         if (previous != null) {
             previous.next = current.next;
         }
         size--;
         printTaskDetails(current.value);
         return current.value;
         }
    

    public int size() {
        return size;
    }

    private void printTaskDetails(Task task) {
        System.out.println("Task Name: " + task.getName());
        System.out.println("Task ID: " + task.getID());
        System.out.println("Task Due Date: " + task.getDueDate());
        System.out.println("Task Category: " + task.getCategory());
        System.out.println("Urgent Task: " + task.isUrgent());
        System.out.println("Is Task Complete: " + task.isComplete());
        System.out.println("************************************************");
        }
    }

