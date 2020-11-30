public class TaskItem {
    //localBackup;
    private String taskName;
    private String taskDescription;
    private String date;

    public TaskItem(String date, String title, String description) {

        if (isDateValid(date)) {
            System.out.println("date is valid");
            this.date = date;
        } else {
            throw new IllegalArgumentException("Date invalid, please enter a new date (YYYY-MM-DD): ");
        }
        if (isTaskNameValid(title)) {
            System.out.println("Name is valid");
            this.taskName = title;
        } else {
            throw new IllegalArgumentException("task name is invalid, please enter a new task name");

        }
        if (isTaskDescriptionValid(description)) {
            System.out.println("description is valid");
            this.taskDescription = description;
        } else {
            throw new IllegalArgumentException("Description invalid, please enter a new description");
        }
    }
    public String getTaskDate() {

        return this.date;
    }
    public boolean isDateValid(String date){
        return true;// needs to work on date verification
    }
    public String getTaskName() {
        return this.taskName;
    }
    private boolean isTaskNameValid(String name){
        return name.length() > 0;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }
    public boolean isTaskDescriptionValid(String description){
        return description.length() > 0;
    }


}