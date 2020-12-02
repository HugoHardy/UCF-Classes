import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {
    private Scanner input = new Scanner(System.in);
    private int menuInput = 0;
    private String listName;

    public ContactApp(){
        ContactList contacts = new ContactList();
        ContactMenu();
    }
    private void ContactMenu() {//menu which lists out the choice after user selected an application
        System.out.print("Main menu");
        System.out.println();
        System.out.println("--------");
        System.out.println("\n");
        System.out.println("1) Create a new List");
        System.out.println("2) Load an existing List");
        System.out.println("3) Quit to main menu");
        System.out.print("Please choose one of the options above: ");
        CMenuInput();
    }

    private void CMenuInput() {//menu input to select which app function to choose from
        do {
            try {
                menuInput = input.nextInt();
                if (menuInput == 1) {
                    ListCreation();
                } else if (menuInput == 2) {
                    ContactList.DisplayLists();
                    SelectList();
                    ContactMenu();
                } else if (menuInput == 3) {

                    System.out.println("Exiting Task Application");
                    System.exit(-1);
                } else {
                    System.out.println("invalid input, please try again");
                }
            } catch (InputMismatchException | FileNotFoundException e) {

                System.out.println("invalid input, please try again");
                input.next();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (menuInput < 3 || menuInput > 0);

    }


    private void ListCreation() throws FileNotFoundException {//asks user for the name of the new list and uses the appInput variable value to specify which app the user is using
        System.out.print("Enter name of of the new list: ");
        listName = input.next();
        System.out.println();
        System.out.println("new list name is: ");
        System.out.print(listName);
        if(listName.length() != 0 || !listName.isEmpty()){// checks to see if the user entered an empty file name
            ContactList.ListCreation(listName);
            ListOperationMenu();
            ListOperationInput();
            ContactMenu();

        } else {
            throw new IllegalArgumentException("ERROR: invalid list name, please enter new list name");
        }

    }
    private void SelectList() throws IOException {
        listName = input.next();
        if(!listName.endsWith(".txt")){
            listName = listName + ".txt";
        }
        ContactList.DataSetter(listName);
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
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");
    }
    private void ListOperationInput(){
        do {
            try {
                int OperationInput = input.nextInt();
                if (OperationInput == 1) { //view list: works
                    ContactList.ReadList(listName);
                    ListOperationMenu();
                } else if (OperationInput == 2) { //add an item: works
                    ContactItem data = ContactList.GetData();
                    ContactList.AddContactData(data);
                    ListOperationMenu();
                    System.out.println("contact added");
                } else if (OperationInput == 3) { //edit an item
                    ContactList.ReadList(listName);
                    ContactList.EditPrompt();
                    ContactList.EditTaskData();
                    ListOperationMenu();
                }else if (OperationInput == 4) { //remove an item: works
                    ContactList.RemovePrompt();
                    ContactList.RemoveContactData(input.nextInt());
                    ListOperationMenu();
                    System.out.println("contact removed");
                }else if (OperationInput == 5) { //save the current list: works
                    ContactList.WriteToList(listName);
                    ListOperationMenu();
                }else if (OperationInput == 8) { //quit to the main menu"
                    ContactMenu();
                } else {
                    System.out.println("invalid input operation, please try again");
                }
            } catch (InputMismatchException e) {

                System.out.println("invalid input Operations, please try again");
                input.next();
            }
        } while (menuInput < 8 || menuInput > 0);
    }
}
