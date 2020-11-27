import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class TaskList {
    private static List<TaskItem> Tasks;

    public TaskList() {
        Tasks = new ArrayList<>();
    }

    public static void writeList(String listName) { //creates a fresh list
        try(Formatter output = new Formatter(listName)) {
            for(int i = 0; i < Tasks.size(); i++) {
                TaskItem Item = Tasks.get(i);
                output.format("[%s%] %s: s%n",Item.getTaskDate(), Item.getTaskName(), Item.getTaskDescription() );
            }
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

            for (String pathname : pathnames) {

                System.out.println(pathname);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void ReadList(String fileName){ //reads the data specified folder
        try(FileReader fileReader = new FileReader("." + fileName)) {
            int ch = fileReader.read();
            while(ch != -1) {
                System.out.print((char)ch);
                fileReader.close();
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("ERROR: List not found");// catches if file is not found
        } catch (IOException e) {
            throw new IllegalArgumentException("ERROR: Unexpected problem, please ensure you are able to read this file"); //catches in case user does not have authorization to read file or other error occurs
        }

    }

    public void addTaskData(TaskItem data){//stores information into the array list

        Tasks.add(data);
    }
}

