import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp {
    private Scanner input = new Scanner(System.in);
    private int menuInput = 0;
    private String listName;
    private TaskItem data;
    private TaskList Tasks;

    public TaskApp(){
        Tasks = new TaskList();
        TaskMenu();
    }
    private void TaskMenu() {//menu which lists out the choice after user selected an application
        System.out.print("Main menu");
        System.out.println();
        System.out.println("--------");
        System.out.println("\n");
        System.out.println("1) Create a new List");
        System.out.println("2) Load an existing List");
        System.out.println("3) Quit to main menu");
        System.out.print("Please choose one of the options above: ");
        MenuInput();
    }

    private void MenuInput() {//menu input to select which app function to choose from
        do {
            try {
                menuInput = input.nextInt();
                if (menuInput == 1) {
                    ListCreation();
                } else if (menuInput == 2) {
                    TaskList.DisplayLists();
                    SelectList();
                    TaskMenu();
                } else if (menuInput == 3) {

                    System.out.println("Exiting Task Application");
                    System.exit(-1);
                } else {
                    System.out.println("invalid input, please try again");
                }
            } catch (InputMismatchException | FileNotFoundException e) {

                System.out.println("invalid input, please try again");
                input.next();
                //throw new IllegalArgumentException("I");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (menuInput < 3 || menuInput > 0);

    }


    private void ListCreation() throws FileNotFoundException {//asks user for the name of the new list and uses the appInput variable value to specify which app the user is using
        System.out.print("Enter name of of the new list: ");
        listName = input.next();
        System.out.println();
        System.out.print("new list name is: ");
        System.out.print(listName);
        if(listName.length() > 0){// checks to see if the user entered an empty file name
            //if the user selected the task list the appInput maintains the selection
            TaskList.listCreation(listName);
            ListOperationMenu();
            ListOperationInput();
            System.out.println("Contact list and item not coded yet, please come back later");
            TaskMenu();

        } else {
            throw new IllegalArgumentException("ERROR: invalid list name, please enter new list name");
        }

    }
    private void SelectList() throws IOException {
        listName = input.next();
        if(!listName.endsWith(".txt")){
            listName = listName + ".txt";
        }
        TaskList.DataSetter(listName);
        ListOperationMenu();
        ListOperationInput();
    }
    private void ListOperationMenu() {

        System.out.println("List Operation Menu");
        System.out.println("-------------------");
        System.out.println();
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
    }
    private void ListOperationInput(){
        do {
            try {
                int OperationInput = input.nextInt();
                if (OperationInput == 1) { //view list: works
                    TaskList.ReadList(listName);
                    ListOperationMenu();
                } else if (OperationInput == 2) { //add an item: works
                    data = TaskList.GetData();
                    TaskList.AddTaskData(data);
                    ListOperationMenu();
                    System.out.println("Task added");
                } else if (OperationInput == 3) { //edit an item
                    TaskList.EditPrompt();
                    TaskList.EditTaskData();
                    System.out.println("ERROR: Operation unavailable");
                }else if (OperationInput == 4) { //remove an item: works
                    TaskList.RemovePrompt();
                    TaskList.RemoveTaskData();
                    System.out.println("Task removed");
                }else if (OperationInput == 5) { //mark an item as completed
                    //TaskList.MarkTaskAsComplete();
                    System.out.println("ERROR: Operation unavailable");
                }else if (OperationInput == 6) { //unmark an item as completed
                    //TaskList.RemoveTaskAsComplete();
                    System.out.println("ERROR: Operation unavailable");
                }else if (OperationInput == 7) { //save the current list: works
                    TaskList.WriteToList(listName);
                }else if (OperationInput == 8) { //quit to the main menu"
                    TaskMenu();
                } else {
                    System.out.println("invalid input operation, please try again");
                }
            } catch (InputMismatchException | FileNotFoundException e) {

                System.out.println("invalid input Operations, please try again");
                input.next();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (menuInput < 8 || menuInput > 0);
    }
}
