import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private Scanner input = new Scanner(System.in);
    private int appInput = 0; //maintains the choice of which app the user chooses
    private int menuInput = 0;
    private String listName;
    private TaskItem data;

    //private ContactList contactList;
    public static void main(String[] args) {
        App A = new App();
        A.AppSelection();
    }
    private void AppSelection() {//asks user to select an application
        System.out.println("Select Your Application");
        System.out.println("-----------------------");
        System.out.println("1) Task list");
        System.out.println("2) Contact list");
        System.out.println("3) Exit Program");
        System.out.print("Please choose one of them options above: ");
        AppSelectionInput();
    }

    private void AppSelectionInput() {//user input methods to select the application
        do {
            try {
                appInput = input.nextInt();
                if (appInput == 1) {
                    new TaskApp();
                    //ListMenu();
                    //MenuInput();
                } else if (appInput == 2) {
                    System.out.println("ERROR: Application not available yet");
                    AppSelection();
                    //ListMenu();
                    //MenuInput();
                } else if (appInput == 3) {
                    System.out.println("Exiting Application Selection");
                    System.exit(-1);
                } else {
                    System.out.println("invalid input, please try again");
                }
            } catch (InputMismatchException e) {

                System.out.println("invalid input, please try again");
                input.next();
                throw new IllegalArgumentException("ERROR: Invalid input");
            }
        } while (appInput < 2 || appInput > 0);
    }
}

