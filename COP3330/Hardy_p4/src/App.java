import java.util.Scanner;

public class App {
    private Scanner input = new Scanner(System.in);
    public void App(String[] args){
        int menuInput = input.nextInt();;
        do {

            System.out.println("Main menu" +
                    "/n-------------" +
                    "/n" +
                    "/n1) Create a new List" +
                    "/n2) Load an existing List" +
                    "/n3) Quit" +
                    "/nPlease choose one of the options above");

            switch (menuInput) {
                case 1:
                    System.out.println("Creating new List");
                    //TaskList.();
                case 2:
                    System.out.println("Opening available List");
                    //TaskList();
                case 3:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
        }while(menuInput != 3);

    }
}
/*
A task list shall contain 0 or more task items
An task item shall contain a title
A title shall be 1 or more characters in length
An task item shall contain a description
A description shall be 0 or more characters in length
An task item shall contain a due date
A due date shall be in the format of YYYY-MM-DD

A user shall be able to create a new task list
A user shall be able to load an existing task list

A user shall be able to view the current task list
A user shall be able to save the current task list
A user shall be able to add an item to the current task list
A user shall be able to edit an item in the current task list
A user shall be able to remove an item from the current task list
A user shall be able to mark an item in the current task list as completed
A user shall be able to unmark an item in the current task list as completed
 */