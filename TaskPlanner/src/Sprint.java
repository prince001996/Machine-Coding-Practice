import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sprint {
    private int begin;
    private int end;
    private String name;
    private List<Task> tasks;
    
    Sprint(int begin, int end, String name){
        this.begin = begin;
        this.end = end;
        this.name = name;
        tasks = new ArrayList<>();
    }
    
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Sprint sprint = (Sprint) o;
//        return begin == sprint.begin && end == sprint.end && name.equals(sprint.name) && Objects.equals(tasks, sprint.tasks);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(begin, end, name);
//    }
    
    public List<Task> getTasks() {
        return tasks;
    }
    
    public void addTask(Task task){
        tasks.add(task);
    }
    
    public void printDetails(){
        System.out.println("Sprint Name : " + name +
                            " begins at : " + begin +
                            " ends at : " + end);
    }
}
