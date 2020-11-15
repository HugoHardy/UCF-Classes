import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class TaskList {
    private int TaskListSize = 0;
    List<TaskItem> Tasks;

    public TaskList() {
        Tasks = new ArrayList<>();
    }
    private boolean newTaskListIsEmpty() {
        return Tasks.size() <= 0;
    }


    //completingTaskItemChangesStatus()
    //completingTaskItemFailsWithInvalidIndex()
    //editingTaskItemChangesValues()
    //editingTaskItemDescriptionChangesValue()
    //editingTaskItemDescriptionFailsWithInvalidIndex()
    //editingTaskItemDueDateChangesValue()
    //editingTaskItemDueDateFailsWithInvalidIndex()
    //editingTaskItemTitleChangesValue()
    //editingTaskItemTitleFailsWithInvalidIndex()
    //gettingTaskItemDescriptionFailsWithInvalidIndex()
    //gettingTaskItemDescriptionSucceedsWithValidIndex()
    //gettingTaskItemDueDateFailsWithInvalidIndex()
    //gettingTaskItemDueDateSucceedsWithValidIndex()
    //gettingTaskItemTitleFailsWithInvalidIndex()
    //gettingTaskItemTitleSucceedsWithValidIndex()
    private void addingTaskItemsIncreasesSize(){
        TaskListSize++;
    }
    private void removingTaskItemsDecreasesSize() {
        TaskListSize--;
    }

    //removingTaskItemsFailsWithInvalidIndex()
    //savedTaskListCanBeLoaded()
    //uncompletingTaskItemChangesStatus()
    //uncompletingTaskItemFailsWithInvalidIndex()
    public void write(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < Tasks.size(); i++) {
                TaskItem Item = Tasks.get(i);
                output.format("%s;%s%n", Item.getTaskname(), Item.getTaskDate());
            }

        }
    }

}




