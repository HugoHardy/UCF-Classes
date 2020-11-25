import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private Scanner input = new Scanner(System.in);
    private int appInput = 0; //maintains the choice of which app the user chooses
    private int menuInput = 0;
    private TaskList taskList;
    //private ContactList contactList;
    public static void main(String[] args){
        App A = new App();
        A.AppSelection();
    }
    public App(){
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

    private void AppSelectionInput() {
        do{
            try {
                appInput = input.nextInt();
                if (appInput == 1) {
                    ListMenu();
                    MenuInput();
                } else if (appInput == 2) {
                    ListMenu();
                    MenuInput();
                } else if(appInput == 3) {
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
        }while(appInput < 2 || appInput > 0);
    }

    private void ListMenu() {
        System.out.print("Main menu");
        System.out.println();
        System.out.println("--------");
        System.out.println("\n" );
        System.out.println("1) Create a new List");
        System.out.println("2) Load an existing List");
        System.out.println("3) Quit to main menu");
        System.out.print("Please choose one of the options above: ");
        MenuInput();
    }

    private void MenuInput() {
        do {
            try {
                menuInput = input.nextInt();
                if (menuInput == 1) {
                    ListCreation();
                } else if (menuInput == 2) {
                    System.out.println("Loading list");
                    //TaskListLoading();
                } else if (menuInput == 3) {
                    ListMenu();
                    System.out.println("returning to App selection");
                    AppSelection();
                } else {
                    System.out.println("invalid input, please try again");
                }
            }catch (InputMismatchException e) {

                System.out.println("invalid input, please try again");
                input.next();
                //throw new IllegalArgumentException("I");
            }
        }while(menuInput < 3 || menuInput > 0);

    }

    private void ListCreation() {
        String ListName;
        System.out.println("Enter name of of the new list");
        ListName = input.nextLine();
        System.out.println("new list name is: ");
        System.out.print(ListName);
        if(appInput == 1){ //if the user selected the task list the appInput maintains the selection
            TaskList.writeList(ListName);
        } else if(appInput == 2){ //if the user selected the contact list the appInput maintains the selection
            System.out.println("Contact list and item not coded yet, please come back later");
            ListMenu();
            //ContactList.writeList(ListName);
        }
    }
}

