import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {
    private final String listName = "list3";
    List<TaskItem> Tasks;

    @BeforeEach
    public void test() {
        new TaskList();
        Tasks = new ArrayList<>();
    }
    @Test
    public void addingItemsIncreasesSize(){
        TaskItem data;
        data = new TaskItem("2020-01-01", "Task 1", "My First task");
        TaskList.AddTaskData(data);
        data = new TaskItem("2021-01-01", "Task 2", "My second task");
        TaskList.AddTaskData(data);
        assertEquals(2, TaskList.GetListSize());
    }//@Test
    //completingTaskItemChangesStatus()
    //@Test
    //completingTaskItemFailsWithInvalidIndex()
    @Test
    public void editingItemDescriptionFailsWithInvalidIndex(){
        Assertions.assertThrows(IndexOutOfBoundsException.class , () ->{
            TaskItem data;
            data = new TaskItem("2020-01-01", "Task 1", "My First task");
            TaskList.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My second task");
            TaskList.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My 2nd task");
            TaskList.SetEdit(10, data);
        });
    }
    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue() {
        TaskItem data;
        data = new TaskItem("2020-01-01", "Task 1", "My First task");
        TaskList.AddTaskData(data);
        data = new TaskItem("2021-01-01", "Task 2", "My second task");
        TaskList.AddTaskData(data);
        data = new TaskItem("2022-01-01", "second Task", "My 2nd task");
        TaskList.SetEdit(1, data);
        assertEquals("My 2nd task", data.getTaskDescription());
    }
    @Test
    public void editingItemDueDateSucceedsWithExpectedValue(){
        TaskItem data;
        data = new TaskItem("2020-01-01", "Task 1", "My First task");
        TaskList.AddTaskData(data);
        data = new TaskItem("2021-02-02", "Task 2", "My second task");
        TaskList.AddTaskData(data);
        data = new TaskItem("2021-03-03", "Task 2", "My second task");
        TaskList.SetEdit(1, data);
        assertEquals("2021-03-03", data.getTaskDate());
    }
    @Test
    public void editingItemTitleFailsWithEmptyString(){
        Assertions.assertThrows(IllegalArgumentException.class , () ->{
            TaskItem data;
            data = new TaskItem("2020-01-01", "Task 1", "My First task");
            TaskList.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My second task");
            TaskList.AddTaskData(data);
            data = new TaskItem("2021-02-02", "", "My second task");
            TaskList.SetEdit(1, data);
        });
    }
    @Test
    public void editingItemTitleFailsWithInvalidIndex(){
        Assertions.assertThrows(IndexOutOfBoundsException.class , () ->{
            TaskItem data;
            data = new TaskItem("2020-01-01", "Task 1", "My First task");
            TaskList.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My second task");
            TaskList.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2nd", "My second task");
            TaskList.SetEdit(10, data);
        });
    }
    @Test
    public void editingItemTitleSucceedsWithExpectedValue(){
        TaskItem data;
        data = new TaskItem("2020-01-01", "Task 1", "My First task");
        TaskList.AddTaskData(data);
        data = new TaskItem("2021-02-02", "Task 2", "My second task");
        TaskList.AddTaskData(data);
        data = new TaskItem("2021-02-02", "second Task", "My second task");
        TaskList.SetEdit(1, data);
        assertEquals("second Task", data.getTaskName());
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat(){

        Assertions.assertThrows( NumberFormatException.class ,() -> {
            TaskItem data;
            data = new TaskItem("2020-01-01", "Task 1", "My First task");
            TaskList.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My second task");
            TaskList.AddTaskData(data);
            data = new TaskItem("03-2022-03", "third Task", "My 3rd task");
            TaskList.SetEdit(1, data);
        });
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        Assertions.assertThrows( IndexOutOfBoundsException.class ,() -> {
            TaskItem data;
            data = new TaskItem("2020-01-01", "Task 1", "My First task");
            TaskList.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My second task");
            TaskList.AddTaskData(data);
            data = new TaskItem("2022-03-03", "My second task", "Task 2");
            TaskList.SetEdit(3, data);
        });
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD(){
        Assertions.assertThrows( NumberFormatException.class ,() -> {
            TaskItem data;
            data = new TaskItem("2020-01-01", "Task 1", "My First task");
            TaskList.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My second task");
            TaskList.AddTaskData(data);
            data = new TaskItem("202-03-03", "third Task", "My 3rd task");
            TaskList.SetEdit(1, data);
        });
    }
    @Test
    public void EnteringNonExistenceFileThrowsException(){
        assertThrows(FileNotFoundException.class, ()-> TaskList.DataSetter("t"));

    }
    //@Test
    //public void gettingItemDescriptionFailsWithInvalidIndex()
    //@Test
    //public void gettingItemDescriptionSucceedsWithValidIndex(){
    //    TLTest = new TaskList();
    //    TaskItem data = null;
    //    data = new TaskItem("2020-01-01", "Task 1", "My First task");
    //    TLTest.AddTaskData(data);
    //    data = new TaskItem("2021-02-02", "Task 2", "My second task");
    //    TLTest.AddTaskData(data);
    //    Assertions.assertEquals("My second task", TLTest.get(1));
    //}
    //@Test
    //public void gettingItemDueDateFailsWithInvalidIndex()
    //@Test
    //public void gettingItemDueDateSucceedsWithValidIndex()
    //@Test
    //public void gettingItemTitleFailsWithInvalidIndex()
    //@Test
    //public void gettingItemTitleSucceedsWithValidIndex()
    @Test
    public void newListIsEmpty() throws FileNotFoundException {
        TaskList.ListCreation("templist");
        TaskList.DisplayLists();
        assertEquals( "List is empty", TaskList.EmptyList());
    }
    @Test
    public void removingItemsDecreasesSize(){
        TaskItem data;
        data = new TaskItem("2020-01-01", "Task 1", "My First task");
        TaskList.AddTaskData(data);
        data = new TaskItem("2021-01-01", "Task 2", "My second task");
        TaskList.AddTaskData(data);
        TaskList.RemoveTaskData(1);
        assertEquals(1, TaskList.GetListSize());
    }
    @Test
    public void removingItemsFailsWithInvalidIndex(){
        Assertions.assertThrows( IndexOutOfBoundsException.class ,() -> {
            TaskItem data;
            data = new TaskItem("2020-01-01", "Task 1", "My First task");
            TaskList.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My second task");
            TaskList.AddTaskData(data);
            TaskList.RemoveTaskData(5);
        });
    }
    @Test
    public void savedTaskListCanBeLoaded() throws FileNotFoundException {
        TaskItem data;
        TaskList.ListCreation("templist");
        data = new TaskItem("2020-01-01", "Task 1", "My First task");
        TaskList.AddTaskData(data);
        data = new TaskItem("2021-01-01", "Task 2", "My second task");
        TaskList.AddTaskData(data);
        TaskList.WriteToList("templist");

        assertDoesNotThrow(()-> TaskList.DataSetter(listName));
    }
    //@Test
    //public void uncompletingTaskItemChangesStatus()
    //@Test
    //public void uncompletingTaskItemFailsWithInvalidIndex()
}
