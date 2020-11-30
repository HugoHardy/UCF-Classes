import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class TaskList {
    //A task list shall contain 0 or more task items
    private int TaskListSize = 0;
    private static List<TaskItem> Tasks;

    public TaskList() {
        Tasks = new ArrayList<>();
    }

    public static void writeList(String listName) {
        try(Formatter output = new Formatter(listName)) {
            for(int i = 0; i < Tasks.size(); i++) {
                TaskItem Item = Tasks.get(i);
                output.format("[%s%] %s: s%n",Item.getTaskDate(), Item.getTaskName(), Item.getTaskDescription() );
            }

        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void listCreation(String listName) {
    }

    public void addTaskData(TaskItem data){
        Tasks.add(data);
    }

}




