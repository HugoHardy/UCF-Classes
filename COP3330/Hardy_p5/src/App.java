import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private Scanner input = new Scanner(System.in);
    private int appInput = 0; //maintains the choice of which app the user chooses
    private int menuInput = 0;
    private TaskList taskList;
    private String fileName;

    //private ContactList contactList;
    public static void main(String[] args) {
        App A = new App();
        A.AppSelection();
    }

    public App() {
        taskList = new TaskList();
        //contactList = new contactList();
    }

    private void AppSelection() {//asks user to select an application
        System.out.println("Select Your Application");
        System.out.println("-----------------------");
        System.out.println("1) Task list");
        System.out.println("2) Contact list");
        System.out.print("Please choose one of them options above: ");
        AppSelectionInput();
    }

    private void AppSelectionInput() {//user input methods to select the application
        do {
            try {
                appInput = input.nextInt();
                if (appInput == 1) {
                    ListMenu();
                    MenuInput();
                } else if (appInput == 2) {
                    ListMenu();
                    MenuInput();
                } else if (appInput == 3) {
                    System.out.println("Exiting Application Selection");
                    System.exit(-1);
                } else {
                    System.out.println("invalid input, please try again");
                }
            } catch (InputMismatchException e) {

                System.out.println("invalid input, please try again");
                input.next();
                //throw new IllegalArgumentException("I");
            }
        } while (appInput < 2 || appInput > 0);
    }

    private void ListMenu() {//menu which lists out the choice after user selected an application
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
                    System.out.println("Please select a list");
                    TaskList.DisplayLists();
                    LoadedList();
                } else if (menuInput == 3) {
                    ListMenu();
                    System.out.println("returning to App selection");
                    AppSelection();
                } else {
                    System.out.println("invalid input, please try again");
                }
            } catch (InputMismatchException e) {

                System.out.println("invalid input, please try again");
                input.next();
                //throw new IllegalArgumentException("I");
            }
        } while (menuInput < 3 || menuInput > 0);

    }


    private void ListCreation() {//asks user for the name of the new list and uses the appInput variable value to specify which app the user is using
        String ListName;
        System.out.println("Enter name of of the new list");
        ListName = input.nextLine();
        System.out.println("new list name is: ");
        System.out.print(ListName);
        fileName = ListName + ".txt";// saves the file name in txt format
        if (appInput == 1) { //if the user selected the task list the appInput maintains the selection
            TaskList.writeList(ListName);
        } else if (appInput == 2) { //if the user selected the contact list the appInput maintains the selection
            System.out.println("Contact list and item not coded yet, please come back later");
            ListMenu();
            //ContactList.writeList(ListName);
        }
    }

    private void LoadedList() {
        TaskList.ReadList(input.nextLine());
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
                if (menuInput == 1) { //view list
                    TaskList.ReadList(fileName);
                } else if (menuInput == 2) { //add an item
                    //TaskList.AddTaskData();
                    System.out.println("ERROR: Operation unavailable");
                    LoadedList();
                } else if (menuInput == 3) { //edit an item
                    //TaskList.EditTaskData();
                    System.out.println("ERROR: Operation unavailable");
                    LoadedList();
                }else if (menuInput == 4) { //remove an item
                    //TaskList.RemoveTaskData();
                    System.out.println("ERROR: Operation unavailable");
                    LoadedList();
                }else if (menuInput == 5) { //mark an item as completed
                    //TaskList.MarkTaskAsComplete();
                    System.out.println("ERROR: Operation unavailable");
                    LoadedList();
                }else if (menuInput == 6) { //unmark an item as completed
                    //TaskList.RemoveTaskAsComplete();
                    System.out.println("ERROR: Operation unavailable");
                    LoadedList();
                }else if (menuInput == 7) { //save the current list
                    //TaskList.SaveList();
                    System.out.println("ERROR: Operation unavailable");
                    LoadedList();
                }else if (menuInput == 8) { //quit to the main menu"
                    AppSelection();
                } else {
                    System.out.println("invalid input, please try again");
                }
            } catch (InputMismatchException e) {

                System.out.println("invalid input, please try again");
                input.next();
            }
        } while (menuInput < 8 || menuInput > 0);
    }
}

