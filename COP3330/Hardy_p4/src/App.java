import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class App {
    private Scanner input = new Scanner(System.in);
    private TaskList task;
    private String listName;
    public static void main(String[] args){
        App A = new App();
        A.mainMenu();
    }
    public App(){
        task = new TaskList();
    }
    private void mainMenu(){
        int menuInput = 0;

            System.out.print("Main menu" +
                    "\n-------------" +
                    "\n" +
                    "\n1) Create a new List" +
                    "\n2) Load an existing List" +
                    "\n3) Quit" +
                    "\nPlease choose one of the options above: ");
            
            try {
                while(menuInput != 3){
                    menuInput = input.nextInt();
                    switch (menuInput) {
                        case 1:
                            lisCreation();

                        case 2:

                            listLoading();
                            break;
                        case 3:
                            System.out.println("exiting program");
                            System.exit(0);
                        default:
                            System.out.println("Invalid menu option. Please try again.");

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
    private void processTaskData(String txt) {
            TaskItem data = getTaskData();
            storeTaskData(data);
        //writeTaskData();
    }

    
    private TaskItem getTaskData(){
        TaskItem item;
        while(true){
            try{
                String taskName = getTaskName();
                String description = getDescriptionName();
                String date = getDate();

                item = new TaskItem(taskName, description, date);
                break;
            } catch (InvalidDescriptionException e){
                System.out.print("Warning: description is invalid, please reenter ");
            } catch (ParseException e) {
                System.out.print("Warning: invalid date, please try again");
            }
        }
        return item;
    }
    private String getTaskName(){
        System.out.print("Please enter task name: ");
        return input.nextLine();
    }
    private String getDescriptionName(){
        System.out.print("Please enter task description: ");
        return input.nextLine();
    }
    private String getDate() throws ParseException {
        System.out.print("Please enter Date with the YYYY-MM-DD format: ");
        String date = input.nextLine();

        return date;
    }
    private void lisCreation(){// creates a new list text file with a user specified name
        System.out.print("Please enter list name: ");
        listName = input.next();
        if(isListNameValid()) {
            if (listName.endsWith(".txt")) { //checks to see if user inputs file extension
                TaskList.createNewList(listName);
            } else {
                TaskList.createNewList(listName + ".txt");
            }
        }
        System.out.println("New task list has been created");
        
    }
    //A title shall be 1 or more characters in length
    private boolean isListNameValid(){

        return listName.length() > 0;
    }
    private boolean isDateValid(String date) throws ParseException {
        SimpleDateFormat dateCheck = new SimpleDateFormat("yyyy-M-d");
        boolean isValid = false;
        try {
            dateCheck.parse(date); //checks is date is valid
            dateCheck.setLenient(false);
            isValid = true;

        } catch (ParseException e) {
            e.printStackTrace();
            isValid = false;
        }

        return isValid;
    }
    private void storeTaskData(TaskItem data){
         task.addTaskData(data);
    }
    private void listLoading()throws Exception {
        //A user shall be able to load an existing task list
        System.out.println("Please select which list to load: ");

        try
        {
            String[] pathnames;

            File f = new File(".");

            FilenameFilter filter = (f1, name) -> name.endsWith(".txt");
            pathnames = f.list(filter);

            for (String pathname : pathnames) {

                System.out.println(pathname);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        fileOpener();

    }

    private void fileOpener() {
        System.out.print("Please select a txt file to open: ");
        String txtFile = input.next() + ".txt";
        listOperationMenu(txtFile);
    }

    private void listOperationMenu(String txt) {
        System.out.println("List Operation Menu\n" +
                "---------\n" +
                "\n" +
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) mark an item as completed\n" +
                "6) unmark an item as completed\n" +
                "7) save the current list\n" +
                "8) quit to the main menu");
        int menuInput;
        do {
            menuInput = input.nextInt();
            try {
                switch (menuInput) {
                    case 1:
                        System.out.println("Current Task");
                        readTaskData(txt);
                    case 2:
                        processTaskData(txt);
                    case 3:
                        //exditTaskData();
                    case 4:
                        //removeItem();
                    case 5:
                        //MarkItemComplete();
                    case 6:
                        //unmarkItem();
                    case 7:
                        //saveList();
                    case 8:
                        mainMenu();
                    default:
                        System.out.println("Invalid menu option. Please try again.");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while(menuInput != 3);
    }

    private void readTaskData(String txt) throws IOException {
        System.out.println("Loading " + txt);
        File file = new File("."+ "\\" +txt);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
    }

}
/*
DONE: A task list shall contain 0 or more task items
DONE: An task item shall contain a title
DONE: A title shall be 1 or more characters in length
DONE: An task item shall contain a description
DONE: A description shall be 0 or more characters in length
An task item shall contain a due date
A due date shall be in the format of YYYY-MM-DD

DONE: A user shall be able to create a new task list
Done: A user shall be able to load an existing task list

A user shall be able to view the current task list
A user shall be able to save the current task list
A user shall be able to add an item to the current task list
A user shall be able to edit an item in the current task list
A user shall be able to remove an item from the current task list
A user shall be able to mark an item in the current task list as completed
A user shall be able to unmark an item in the current task list as completed
 */