import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TMS {
    private LinkedList taskList;
    private QueueLinkedList completedTaskQueue;
    private LinkedList urgentTaskList;
    private QueueLinkedList dueDateTaskQueue;
    private QueueLinkedList categoryTaskQueue;
    public Scanner input = new Scanner(System.in);

    public TMS() {
        taskList = new LinkedList();
        completedTaskQueue = new QueueLinkedList();
        urgentTaskList = new LinkedList();
        dueDateTaskQueue = new QueueLinkedList();
        categoryTaskQueue = new QueueLinkedList();
    }

    public void addTask() {
        System.out.print("Please Enter Task name: ");
        String name = input.nextLine();

        System.out.print("Please Enter Task ID: ");
        int ID = input.nextInt();
        input.nextLine();

        System.out.print("Please Enter Task Due Date (yyyy-MM-dd): ");
        String DueDate = input.nextLine();
        input.nextLine();

        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            date = LocalDate.parse(DueDate, formatter);
            System.out.println("Valid date entered: " + date);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use the format yyyy-MM-dd.");
        }

        System.out.print("Is the task urgent: (true/false) ");
        boolean IsUrgent = input.nextBoolean();
        input.nextLine();

        System.out.print("Please Enter Category of Task: ");
        String Category = input.nextLine();

        Task task = new Task(name, ID, date, IsUrgent, Category);
        taskList.insertEnd(task);
        if (task.isUrgent()) {
            urgentTaskList.insertBeginning(task);
        }
        dueDateTaskQueue.Enqueue(task);
        categoryTaskQueue.Enqueue(task);
        System.out.println(" ");
    }

    public void setTaskComplete() {
        System.out.println("Enter ID of completed Task: ");
        int ID = input.nextInt();

        Task taskToComplete = iterate(taskList, ID);
        if (taskToComplete != null) {
            taskToComplete.setComplete(true);
            Task completedTask = new Task(taskToComplete.getName(),
                                          taskToComplete.getID(),
                                          taskToComplete.getDueDate(),
                                          taskToComplete.isUrgent(),
                                          taskToComplete.getCategory());
            completedTask.setComplete(true);
            completedTaskQueue.Enqueue(completedTask);
        } else {
            System.out.println("Task with ID " + ID + " not found.");
        }
    }

    public void printCompletedTasks() {
        printQueue(completedTaskQueue);
    }

    public void printUrgentTasks() {
    	printList(urgentTaskList);
    }

    public void printOrderedTasksDueDate() {
        sortQueueByDate(dueDateTaskQueue);
        printQueue(dueDateTaskQueue);
    }

    public void printOrderedTasksCategory() {
        sortQueueByCategory(categoryTaskQueue);
        printQueue(categoryTaskQueue);
    }

    private void printQueue(QueueLinkedList queue) {
    	QueueLinkedList temp = queue;
    	while(!temp.isEmpty()) {
    		temp.DeQueue();
    	}

    }

    private static void printList(LinkedList list) {
    	LinkedList tempLinkedList = list;
    	 int size = list.size(); 
    	    for(int i = 0; i < size; i++) {
    	        tempLinkedList.deleteAtIndex(0);  
    	    }
    }



    private Task iterate(LinkedList list, int num) {
        Node current = list.head;
        while (current != null) {
            if (current.value.getID() == num) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    private void sortQueueByDate(QueueLinkedList queue) {
        queue.front = mergeSort(queue.front);
    }

    private void sortQueueByCategory(QueueLinkedList queue) {
        queue.front = mergeSortString(queue.front);
    }

    private Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        return sortedMerge(left, right);
    }

    private Node mergeSortString(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSortString(head);
        Node right = mergeSortString(nextOfMiddle);

        return sortedMergeString(left, right);
    }

    private Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node sortedMerge(Node a, Node b) {
        Node temp;
        if (a == null) return b;
        if (b == null) return a;

        if (a.value.getDueDate().isBefore(b.value.getDueDate())) {
        	temp = a;
        	temp.next = sortedMerge(a.next, b);
        } else {
        	temp = b;
        	temp.next = sortedMerge(a, b.next);
        }
        return temp;
    }

    private Node sortedMergeString(Node a, Node b) {
        Node temporary;
        if (a == null) return b;
        if (b == null) return a;

        if (a.value.getCategory().compareTo(b.value.getCategory()) <= 0) {
        	temporary = a;
        	temporary.next = sortedMergeString(a.next, b);
        } else {
        	temporary = b;
        	temporary.next = sortedMergeString(a, b.next);
        }
        return temporary;
    }

    public static void main(String[] args) {

    }
}
