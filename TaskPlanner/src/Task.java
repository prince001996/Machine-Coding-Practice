public class Task {
    private static int taskId = 1;
    private int id;
    private String subtract;
    private User user;
    private TaskType taskType;
    private TaskStatus taskStatus;
    
//    public Task(String subtract, User user, TaskType taskType, TaskStatus taskStatus) {
//        this.subtract = subtract;
//        this.user = user;
//        this.taskType = taskType;
//        this.taskStatus = taskStatus;
//    }
    Task(){
        this.id = getUniqueId();
        this.taskStatus = TaskStatus.OPEN;
    }
    
    public int getId() {
        return id;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }
    
    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
    
    public void setSubtract(String subtract) {
        this.subtract = subtract;
    }
    
    public int getUniqueId(){
        return taskId++;
    }
    
    
}
