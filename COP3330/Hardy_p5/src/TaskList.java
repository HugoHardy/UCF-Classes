import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class TaskList {
    private static List<TaskItem> Tasks;

    public TaskList() {
        Tasks = new ArrayList<>();
    }

    public static void writeList(String listName) { //creates a freshlist
        try(Formatter output = new Formatter(listName)) {
            for(int i = 0; i < Tasks.size(); i++) {
                TaskItem Item = Tasks.get(i);
                output.format("[%s%] %s: s%n",Item.getTaskDate(), Item.getTaskName(), Item.getTaskDescription() );
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void ReadList(){


    }

    public void addTaskData(TaskItem data){
        Tasks.add(data);
    }}