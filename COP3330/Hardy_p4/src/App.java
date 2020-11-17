import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class App {
    private String txt;
    private File file;
    //private List<String> contentOfFile = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private TaskList taskList;
    private TaskItem data;
    private String listName;
    public static void main(String[] args){
        App A = new App();
        A.mainMenu();
    }
    public App(){
        taskList = new TaskList();
    }
    private void mainMenu(){
        int menuInput;

            System.out.print("Main menu" +
                    "\n-------------" +
                    "\n" +
                    "\n1) Create a new List" +
                    "\n2) Load an existing List" +
                    "\n3) Quit" +
                    "\nPlease choose one of the options above: ");
            
            try {
                while(true){
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

    private void lisCreation(){// creates a new list text file with a user specified name
        System.out.print("Please enter list name: ");
        listName = input.next();
        if(isListNameValid()) {
            if (listName.endsWith(".txt")) { //checks to see if user inputs file extension
                TaskList.writeList(listName);
            } else {
                TaskList.writeList(listName + ".txt");
            }
        }
        System.out.println("New task list has been created");
        
    }
    //A title shall be 1 or more characters in length
    private boolean isListNameValid(){

        return listName.length() > 0;
    }
    private boolean isDateValid(String date) {
        SimpleDateFormat dateCheck = new SimpleDateFormat("yyyy-M-d");
        boolean isValid;
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

    private void fileOpener() throws IOException {
        System.out.print("Please select a txt file to open: ");
        txt = input.next() + ".txt";
        fileInitializer();
        listOperationMenu(txt);
    }

    private void fileInitializer() throws IOException { //stores file info into taskList
        System.out.println("Loading " + txt);
        file = new File("."+ "\\" +txt);

        BufferedReader read = new BufferedReader(new FileReader(file));

        String content;
        while ((content = read.readLine()) != null) {
            String contentDate = content.substring(content.indexOf("["), content.indexOf("]"));
            String contentName = content.substring(content.indexOf("] "), content.indexOf(":"));
            String contentDescription = content.substring(content.indexOf(": "), content.length());
            //System.out.println(contentDate + contentName + contentDescription);

            data = new TaskItem(contentDate, contentName, contentDescription);
            storeTaskData(data);
        }
        //System.out.println(TaskList);
    }

    private void listOperationMenu(String txt) {
        this.txt = txt;
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
            menuInput = input.nextInt();
            try {
                switch (menuInput) {
                    case 1:
                        System.out.println("Current Task");
                        readTaskData(txt);
                    case 2:
                        addTaskData(txt);
                    case 3:
                        editTaskData(txt);
                    case 4:
                        //removeItem();
                    case 5:
                        //MarkItemComplete();
                    case 6:
                        //unmarkItem();
                    case 7:
                        saveList(); //storeTaskData(data);
                    case 8:
                        mainMenu();
                    default:
                        System.out.println("Invalid menu option. Please try again.");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }



    private void readTaskData(String txt) throws IOException {
        //A user shall be able to view the current task list
        System.out.println("Loading " + txt);
        file = new File("."+ "\\" +txt);

        BufferedReader read = new BufferedReader(new FileReader(file));

        String content;
        while ((content = read.readLine()) != null)
            System.out.println(content);
    }
    private void addTaskData(String txt) throws IOException {
        data = getTaskData();
        //writeTaskData();
    }


    private TaskItem getTaskData() throws IOException {
        TaskItem item;
        while(true){

            try{
                String taskName = getTaskName();
                String description = getDescriptionName();
                String date = getDate();
                //contentOfFile.add(date + taskName + description);
                item = new TaskItem(date, taskName, description );
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
        return input.next();
    }
    private String getDescriptionName(){
        System.out.print("Please enter task description: ");
        return input.next();
    }
    private String getDate() throws ParseException {
        System.out.print("Please enter Date with the YYYY-MM-DD format: ");
        String date = input.next();

        return date;
    }private void storeTaskData(TaskItem data){
        taskList.addTaskData(data);
    }
    private void editTaskData(String txt) {
    }
    private void saveList() {
        storeTaskData(data);
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

DONE: A user shall be able to view the current task list
A user shall be able to save the current task list
A user shall be able to add an item to the current task list
A user shall be able to edit an item in the current task list
A user shall be able to remove an item from the current task list
A user shall be able to mark an item in the current task list as completed
A user shall be able to unmark an item in the current task list as completed
 */