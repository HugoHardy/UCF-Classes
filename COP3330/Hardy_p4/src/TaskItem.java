

public class TaskItem {
    //LocalDate;
    private String taskName;
    private String taskDescription;
    private String date;
    public TaskItem(String taskName, String description,String date){

        if(isTaskNameValid()){
            this.taskName = taskName;
        } else {
            new IllegalArgumentException("task name is invalid, please enter a new task name");

        }
        if(isTaskDescriptionValid()){
            this.taskDescription = description;
        } else {
            new IllegalArgumentException("Description invalid, please enter a new description");
        }

        if(isDateValid()){
            this.date = date;
        } else{
            new IllegalArgumentException("Date invalid, please enter a new date (YYYY-MM-DD): ");
        }


    }

    public String getTaskName(){
        return this.taskName;
    }

    public String getTaskDescription(){
        return this.taskDescription;
    }
    public String getTaskDate(){

        return this.date;
    }

    public boolean isTaskNameValid(){
        return taskName.length() > 0;
    }

    private boolean isTaskDescriptionValid(){
        return taskDescription.length() > 0;
    }
    private boolean isDateValid(){

        return true;
    }
}
class InvalidNameException extends IllegalArgumentException {
    public InvalidNameException(String msg) {

        super(msg);
    }
}
class InvalidDescriptionException extends IllegalArgumentException {
    public InvalidDescriptionException(String msg) {

        super(msg);
    }
}

class InvalidDateException extends IllegalArgumentException {
    public InvalidDateException(String msg) {

        super(msg);
    }
}