import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class TaskList {
    private static final Scanner input = new Scanner(System.in);
    private static List<TaskItem> Tasks;

    public TaskList() {
        Tasks = new ArrayList<>();
    }
    public static void lisCreation(String listName) throws FileNotFoundException {// creates a new list text file with a user specified name

            if (listName.endsWith(".txt")) { //checks to see if user inputs file extension
                new Formatter(listName);
            } else {
                new Formatter(listName + ".txt");
            }
          System.out.println("New task list has been created");


    }

    public static void WriteToList(String FileName) { //creates a fresh list
        try(Formatter output = new Formatter(FileName)) {
            for (TaskItem Item : Tasks) {
                output.format("[%s%] %s: s%n", Item.getTaskDate(), Item.getTaskName(), Item.getTaskDescription());
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

        BufferedReader read = new BufferedReader(new FileReader(file));

        String content;
        int i  = 0;
        if((content = read.readLine()) == null){
            System.out.println("List is empty");
        } else {
            while ((content = read.readLine()) != null) {

                try {
                    String date = content.substring(content.indexOf("[") + 1, content.indexOf("]"));
                    String taskName = content.substring(content.indexOf("]") + 2, content.indexOf(":"));
                    String description = content.substring(content.indexOf(":") + 2);
                    //data = new TaskItem(date, taskName, description);
                    System.out.println(i + ") " + content);
                    Tasks.add(new TaskItem(date, taskName, description));// returns NullPointerException
                    //data = new TaskItem(date, taskName, description);// data is stored to TaskItem
                    //SaveTaskDataToTemp(data);
                    i++;
                } catch (NullPointerException e) {
                    throw new NullPointerException("ERROR: ");
                }
            }
        }
    }

    public static void AddTaskData(){
        while(true){
            int i = 0;
            try{
                String dateInput = getDate();
                String taskNameInput = getTaskName();
                String descriptionInput = getDescriptionName();
                Tasks.add(new TaskItem(dateInput, taskNameInput, descriptionInput));
                System.out.println("information inside data from AddTaskData " + Tasks.get(i));
                i++;
                break;
            } catch (InvalidDescriptionException e){
                System.out.print("Warning: description is invalid, please reenter ");
            }
        }

        //return data;
    }
    private static String getTaskName(){
        System.out.print("Please enter task name: ");
        return input.nextLine();
    }
    private static String getDescriptionName(){
        System.out.print("Please enter task description: ");
        return input.nextLine();
    }
    private static String getDate(){
        System.out.print("Please enter Date with the YYYY-MM-DD format: ");
        return input.nextLine();
    }
    /*public static void SaveTaskDataToTemp(TaskItem data){//stores information into the array list
        Tasks.add(data);
    }*/

}

