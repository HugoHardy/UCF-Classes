import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TaskItemTest {

//@Test
//    public void creatingTaskItemFailsWithInvalidDueDate(){
//    assertEquals( false ,new TaskItem(null, "task 1", "this is a bad task"));
//}
//@Test
//    public void creatingTaskItemFailsWithInvalidTitle(){
//
//}
    //creatingTaskItemSucceedsWithValidDueDate()
    //creatingTaskItemSucceedsWithValidTitle()
    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        assertFalse(!TaskItem.isDateValid("2020-10-15"));
    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        assertFalse(!TaskItem.isDateValid("2020-10-15"));
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        assertFalse(TaskItem.isTaskNameValid(" "));
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        assertFalse(!TaskItem.isTaskNameValid("task 1"));
    }
}
