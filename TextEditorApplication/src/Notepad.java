import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class Notepad {
    
    ArrayList<String> allContents;
    Stack<ArrayList<String>> undoStack;
    Stack<ArrayList<String>> redoStack;
    ArrayList<String> clipBoard;
    
    Notepad(String text){
        allContents = new ArrayList<>();
        String[] allLines = text.split("\n");
        for(String line: allLines){
            allContents.add(line);
        }
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        clipBoard = new ArrayList<>();
    }
    
    private boolean checkValidIndices(int m, int n){
        if(n > allContents.size()){
            System.out.println("n more than number of lines in the file");
            return false;
        }
        if(m > allContents.size()){
            System.out.println("m more than number of lines in the file");
            return false;
        }
        if(m > n){
            System.out.println("The value of m exceed n");
            return false;
        }
        return true;
    }
    
    public void display(){
        for(String line: allContents){
            System.out.println(line);
        }
    }
    
    public boolean display(int m, int n){
        if(checkValidIndices(m, n)){
//        ListIterator iterator = allContents.listIterator(m-1);
//        while(iterator.hasNext() && iterator.nextIndex() < n){
//            System.out.println(iterator.next());
//        }
            for (int i = m; i <= n; i++) {
                System.out.println(allContents.get(i - 1));
            }
            return true;
        }
        return false;
    }
    
    public boolean insert(int n, String text){
        if(n > allContents.size()){
            System.out.println("n more than number of lines in the file");
            return false;
        }
        undoStack.push((ArrayList<String>) allContents.clone());
        allContents.set(n-1, allContents.get(n-1) + text);
        return true;
    }

    public boolean delete(int n){
        if(n > allContents.size()){
            System.out.println("n more than number of lines in the file");
            return false;
        }
        undoStack.push((ArrayList<String>) allContents.clone());
        allContents.remove(n-1);
        return true;
    }

    public boolean delete(int n, int m){
        if(checkValidIndices(m, n)) {
            undoStack.push((ArrayList<String>) allContents.clone());
            for (int i = n; i <= m; i++) {
                delete(i);
            }
            return true;
        }
        return false;
    }

    public boolean copy(int n, int m){
//        clipBoard = new ArrayList<>();
        if(checkValidIndices(m, n)){
            for (int i = n; i <= m; i++) {
                clipBoard.add(allContents.get(i-1));
            }
            return true;
        }
        return false;
    }

    public boolean paste(int n){
        if(n > allContents.size()){
            System.out.println("n more than number of lines in the file");
            return false;
        }
        undoStack.push((ArrayList<String>) allContents.clone());
        allContents.addAll(n-1, clipBoard);
        clipBoard.clear();
        return true;
    }

    public boolean undo(){
        if(undoStack.isEmpty()){
            System.out.println("Nothing to undo");
            return false;
        }
        redoStack.push((ArrayList<String>) allContents.clone());
        allContents = undoStack.pop();
        return true;
    }

    public boolean redo(){
        if(redoStack.isEmpty()){
            System.out.println("Nothing to redo");
            return false;
        }
        undoStack.push((ArrayList<String>) allContents.clone());
        allContents = redoStack.pop();
        return true;
    }
}