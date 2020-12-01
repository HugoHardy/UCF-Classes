import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskItemTest {

@Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
    assertEquals( false ,new TaskItem(null, "task 1", "this is a bad task"));
}
@Test
    public void creatingTaskItemFailsWithInvalidTitle(){
    assertEquals( false , TaskItem.isTaskNameValid(" "));
}
    //creatingTaskItemSucceedsWithValidDueDate()
    //creatingTaskItemSucceedsWithValidTitle()
    //settingTaskItemDueDateFailsWithInvalidDate()
    //settingTaskItemDueDateSucceedsWithValidDate()
    //settingTaskItemTitleFailsWithInvalidTitle()
    //settingTaskItemTitleSucceedsWithValidTitle()
}
