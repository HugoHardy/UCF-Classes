public class TaskItem {
    //localBackup;
    private String taskName;
    private String taskDescription;
    private String date;

    public TaskItem(String date, String title, String description) {

        if (!isDateValid(date)) {
            throw new IllegalArgumentException("Date invalid, please enter a new date (YYYY-MM-DD): ");
        } else {
            this.date = date;
        }
        if (isTaskNameValid(title)) {
            this.taskName = title;
        } else {
            throw new IllegalArgumentException("task name is invalid, please enter a new task name");

        }
        if (isTaskDescriptionValid(description)) {
            this.taskDescription = description;
        } else {
            throw new IllegalArgumentException("Description invalid, please enter a new description");
        }
    }
    public String getTaskDate() {

        return this.date;
    }
    public boolean isDateValid(String date){
        return !date.isEmpty();// needs to work on date verification
    }
    public String getTaskName() {
        return this.taskName;
    }
    private boolean isTaskNameValid(String name){
        return !name.isEmpty();
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }
    public boolean isTaskDescriptionValid(String description){
        return !description.isEmpty();
    }


}