import java.util.ArrayList;
import java.util.List;

public class User {
    List<Task> taskList;
    List<Sprint> sprintList;
    
    User(){
        taskList = new ArrayList<>();
        sprintList = new ArrayList<>();
    }
    
    public Task createTask(TaskType taskType){
        if(taskType == TaskType.STORY){
            System.out.println("");
        }
        Task task = new Task();
        task.setTaskType(taskType);
        task.setUser(this);
        taskList.add(task);
        return task;
    }
    
    public Task createTask(String subtract){
        Task task = new Task();
        task.setTaskType(TaskType.STORY);
        task.setSubtract(subtract);
        task.setUser(this);
        taskList.add(task);
        return task;
    }

    public Sprint createSprint(int begin, int end, String name){
        Sprint sprint = new Sprint(begin, end, name);
        sprintList.add(sprint);
        return sprint;
    }

    public boolean addToSprint(Sprint sprint, Task task){
        for(Sprint eachSprint: sprintList){
            if(eachSprint == sprint){
                eachSprint.addTask(task);
                return true;
            }
        }
        return false;
    }

    public boolean removeFromSprint(Sprint sprint, Task task){
        for(Sprint eachSprint: sprintList){
            if(eachSprint == sprint){
                eachSprint.getTasks().remove(task);
                return true;
            }
        }
        return false;
    }

    public boolean changeStatus(Task task, TaskStatus taskStatus){
        task.setTaskStatus(taskStatus);
        return true;
    }

    public void printAllTasks(){
        for(Task task: taskList){
            System.out.print(task.getId() + " ");
        }
        System.out.println();
    }



}
