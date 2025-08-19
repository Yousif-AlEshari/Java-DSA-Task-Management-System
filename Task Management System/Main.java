import java.util.Scanner;

public class Main {
    static TMS system1 = new TMS();
    static Scanner input = new Scanner(System.in);

    public static void TMSoptions() {
        System.out.println("Please choose one of the following actions to perform: \n"
                + "1: Add a new Task \n"
                + "2: Mark a Task Complete \n"
                + "3: View All Completed Tasks \n"
                + "4: View All Urgent Tasks \n"
                + "5: View All Tasks ordered by Due Date \n"
                + "6: View All Tasks ordered by their category \n"
                + "7: Exit The System");
        int choice = input.nextInt();
        input.nextLine(); // consume the newline character
        switch(choice) {
            case 1:
                system1.addTask();
                System.out.println("Operation Completed");
                AnotherAction();
                break;
            case 2:
                system1.setTaskComplete();
                System.out.println("Operation Completed");
                AnotherAction();
                break;
            case 3:
                system1.printCompletedTasks();
                System.out.println("Operation Completed");
                AnotherAction();
                break;
            case 4:
                system1.printUrgentTasks();
                System.out.println("Operation Completed");
                AnotherAction();
                break;
            case 5:
                system1.printOrderedTasksDueDate();
                System.out.println("Operation Completed");
                AnotherAction();
                break;
            case 6:
                system1.printOrderedTasksCategory();
                System.out.println("Operation Completed");
                AnotherAction();
                break;
            case 7:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Undefined Input, Please Try Again");
                TMSoptions();
        }
    }

    public static void AnotherAction() {
        System.out.println("Perform another Task? Yes/No");
        String option = input.nextLine();
        switch(option) {
            case "Yes":
            case "yes":
                TMSoptions();
                break;
            case "No":
            case "no":
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Undefined input");
                AnotherAction();
                break;
        }
    }

    public static void main(String[] Args) {
        System.out.println("Welcome to your Task Management System \n");
        TMSoptions();
        System.out.println("Thank you for using the Task Management System");
    }
}
