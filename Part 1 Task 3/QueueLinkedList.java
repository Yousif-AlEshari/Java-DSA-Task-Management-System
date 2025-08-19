public class QueueLinkedList {

    Node front, rear;
    private int counter;

    public QueueLinkedList() {
        this.front = this.rear = null;
        counter = 0;
    }

    public boolean isEmpty() {
        return (this.counter == 0);
    }

    public int Size() {
        return this.counter;
    }

    public void Enqueue(Task x) {
        Node newnode = new Node(x);
        if (isEmpty()) {
            front = newnode;
            rear = newnode;
        } else {
            rear.next = newnode;
            rear = newnode;
        }
        counter++;
    }

    public Task DeQueue() {
        Task x;
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            x = null;
        } else if (counter == 1) {
            x = front.value;
            front = null;
            rear = null;
            counter--;
        } else {
            x = front.value;
            front = front.next;
            counter--;
        }
        if(x != null) {
        	System.out.println("Task Name: " + x.getName());
            System.out.println("Task ID: " + x.getID());
            System.out.println("Task Due Date: " + x.getDueDate());
            System.out.println("Task Category: " + x.getCategory());
            System.out.println("Urgent Task: " + x.isUrgent());
            System.out.println("Is Task Complete: " + x.isComplete());
            System.out.println("************************************************");
        }
        return x;
    }
}
