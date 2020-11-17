import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class TaskList {
    //A task list shall contain 0 or more task items
    private int TaskListSize = 0;
    static List<TaskItem> Tasks;

    public TaskList() {
        Tasks = new ArrayList<>();
    }

    public static void createNewList(String listName) {
        try(Formatter output = new Formatter(listName)) {
            for(int i = 0; i < Tasks.size(); i++) {
                TaskItem Item = Tasks.get(i);
                output.format("%s%;%s; s%n",Item.getTaskName(), Item.getTaskDescription(), Item.getTaskDate());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addTaskData(TaskItem data){
        Tasks.add(data);
    }

}




