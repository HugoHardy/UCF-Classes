import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){//work on
        Assertions.assertThrows( IllegalArgumentException.class ,() -> {
            new TaskItem("", "task 1", "this is a bad task");
        });
}
    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        Assertions.assertThrows(IllegalArgumentException.class , () ->{
            new TaskItem("2020-10-12", "", "a task");
        });
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        Assertions.assertDoesNotThrow( () -> new TaskItem("2020-10-15", "task 1", "this is a good task"));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        Assertions.assertDoesNotThrow( () -> new TaskItem("2020-10-15", "task 1", "this is a good task"));

    }
    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() throws Exception {
        Assertions.assertEquals( false, TaskItem.isDateValid("2020-15-10"));
    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() throws Exception {
        assertFalse(TaskItem.isDateValid("2020-10-15"));
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        assertFalse(!TaskItem.isTaskNameValid(" "));
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        assertFalse(TaskItem.isTaskNameValid("task 1"));
    }
}
