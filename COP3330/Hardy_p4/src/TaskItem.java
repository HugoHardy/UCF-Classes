

public class TaskItem {
    //LocalDate;
    private String task;
    private String date;
    public TaskItem(String task, String date){
        if(!creatingTaskItemFailsWithInvalidTitle() || creatingTaskItemSucceedsWithValidTitle()){
            this.task = task;
        } else {
            new IllegalArgumentException("Task title not valid, please enter a new Task name");
        }

        if(!creatingTaskItemFailsWithInvalidTitle() || creatingTaskItemSucceedsWithValidTitle()){
            this.date = date;
        } else{
            new IllegalArgumentException("Date invalid, please enter a new date (YYYY-MM-DD): ");
        }


    }
    public String getTaskName() {
        return this.task;
    }
    public String getTaskDate(){
        return this.date;
    }
    //creatingTaskItemFailsWithInvalidDueDate()
    private boolean creatingTaskItemFailsWithInvalidTitle(){
        return task.length() <= 0;
    }


    //creatingTaskItemSucceedsWithValidDueDate()
    private boolean creatingTaskItemSucceedsWithValidTitle(){
        return task.length() > 0;
    }
    private boolean settingTaskItemDueDateFailsWithInvalidDate(){
        return true;
    }
    private boolean settingTaskItemDueDateSucceedsWithValidDate(){
        return true;
    }
    //settingTaskItemTitleFailsWithInvalidTitle()
    //settingTaskItemTitleSucceedsWithValidTitle()

}
//InvalidTaskItemTitle