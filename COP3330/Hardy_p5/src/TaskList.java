import java.io.*;
import java.util.*;

public class TaskList {
    private static final Scanner input = new Scanner(System.in);
    private static List<TaskItem> Tasks;

    public TaskList() {
        Tasks = new ArrayList<>();
    }
    public static void listCreation(String listName) throws FileNotFoundException {// creates a new list text file with a user specified name

            if (listName.endsWith(".txt")) { //checks to see if user inputs file extension then creates a .txt file with the specified name
                new Formatter(listName);
            } else {
                new Formatter(listName + ".txt");
            }
          System.out.println("New task list has been created");


    }

    public static void WriteToList(String FileName) { //writes the list to the specified .txt file
        try(Formatter output = new Formatter(FileName)) {
            for (TaskItem Item : Tasks) {
                output.format("[%s] %s: %s\n", Item.getTaskDate(), Item.getTaskName(), Item.getTaskDescription());
            }
        } catch(NullPointerException e){
            throw new NullPointerException("ERROR: Data not saved");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void DisplayLists(){
        try
        {
            String[] pathnames;

            File f = new File(".");

            FilenameFilter filter = (f1, name) -> name.endsWith(".txt");
            pathnames = f.list(filter);

            assert pathnames != null;
            for (String pathname : pathnames) {

                System.out.println(pathname);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void ReadList(String FileName) throws IOException { //reads the data specified folder
        if(!FileName.endsWith(".txt")){
            FileName = FileName + ".txt";
        }
        System.out.println("Reading: " + FileName);
        File file = new File("." + "\\" + FileName);
        int i  = 0;
        if(Tasks.get(i) == null){
            System.out.println("List is empty");
        } else {
            for (TaskItem Item : Tasks) {
                    System.out.println(i + ")" + "[" +  Item.getTaskDate() + "] " + Item.getTaskName() + ": " + Item.getTaskDescription());
                    i++;
            }
        }
    }
    public static void DataSetter(String FileName) throws IOException {
        if(!FileName.endsWith(".txt")){
            FileName = FileName + ".txt";
        }
        File file = new File("." + "\\" + FileName);
        BufferedReader read = new BufferedReader(new FileReader(file));

        String content;
        content = read.readLine();
        if(content == null){
            System.out.println("List is empty");
        } else {
            TaskItem data = null;
            while (content != null) {
                try {
                    String date = content.substring(content.indexOf("[") + 1, content.indexOf("]"));
                    String taskName = content.substring(content.indexOf("]") + 2, content.indexOf(":"));
                    String description = content.substring(content.indexOf(":") + 2);
                    data = new TaskItem(date, taskName, description);
                    AddTaskData(data);
                    content = read.readLine();
                } catch (NullPointerException e) {
                    throw new NullPointerException("ERROR: data null!");
                }
            }
        }
    }
    public static TaskItem GetData(){// asks user for data
        TaskItem data = null;
        try{
                String dateInput = getDate();
                String taskNameInput = getTaskName();
                String descriptionInput = getDescriptionName();
                data = new TaskItem(dateInput, taskNameInput, descriptionInput);
        } catch (InvalidDescriptionException e){
            System.out.print("Warning: description is invalid, please reenter ");
        }
        return data;
    }
    public static void AddTaskData(TaskItem data){
            try{
                Tasks.add(data);
            } catch (InvalidDescriptionException e){
                System.out.print("Warning: description is invalid, please reenter ");
            }
    }
    private static String getDate(){
        System.out.println();
        System.out.print("Please enter Date with the YYYY-MM-DD format: ");
        String date = input.nextLine();
        return date;
    }
    private static String getTaskName(){
        System.out.println();
        System.out.print("Please enter task name: ");
        String Name = input.nextLine();
        return Name;
    }
    private static String getDescriptionName(){
        System.out.println();
        System.out.println("Please enter task description: ");
        String desciption = input.nextLine();
        return desciption;
    }
    public static void EditPrompt(){
        System.out.print("Please choose a task to edit: ");
    }
    public static void EditTaskData(){
        TaskItem data = null;
        int setInput = input.nextInt();
        try{
            data.getTaskDate();
            if(IsWithinBound(setInput)) {
                String date = getDate();
                String task = getTaskName();
                String description = getDescriptionName();
                data = new TaskItem(date, task, description);
                SetEdit(setInput, data);// needs work
            }
        } catch (InputMismatchException e) {
            EditTaskData();
            throw new IllegalArgumentException("Not valid argument");
        }
    }
    public static void SetEdit(int i, TaskItem data){
        Tasks.set(i, data);
    }
    private static boolean IsWithinBound(int bounds){
        if(bounds <= Tasks.size()){
            return true;
        } else {
            return false;
        }
    }
    public static void RemovePrompt(){
        System.out.println("Please choose task to remove: ");
    }
    public static void RemoveTaskData(){
        Tasks.remove(input.nextInt());
    }

}

