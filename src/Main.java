import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        main.testRideSharingApp();
//        main.testMeetingScheduler();
//        main.testTextEditor();
//        main.testTaskPlanner();
        main.testBowlingGameSystem();
    }
    
    private void testBowlingGameSystem() {
        Game game = new Game();
        
        
        Player player1 = new Player("Prince");
        Player player2 = new Player("Vishal");
        Player player3 = new Player("Raushan");
        Player player4 = new Player("Sudhanshu");
        
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        
        int gameIndex = game.createSession(players);
        
        List<Integer> score1 = new ArrayList<>();
        List<Integer> score2 = new ArrayList<>();
        List<Integer> score3 = new ArrayList<>();
        List<Integer> score4 = new ArrayList<>();
    
        Random random = new Random();
        int score = 0;
        for(int i=0; i<20; i++){
            score = random.nextInt(11);
            score1.add(score);
            game.roll(gameIndex, player1, score);

            score = random.nextInt(11);
            score2.add(score);
            game.roll(gameIndex, player2, score);
    
            score = random.nextInt(11);
            score3.add(score);
            game.roll(gameIndex, player3, score);
    
            score = random.nextInt(11);
            score4.add(score);
            game.roll(gameIndex, player4, score);
        }
    
        System.out.println("Player 1 : ");
        for(int eachScore: score1){
            System.out.print(eachScore + " ");
        }
        System.out.println();
    
        System.out.println("Player 2 : ");
        for(int eachScore: score2){
            System.out.print(eachScore + " ");
        }
        System.out.println();
    
        System.out.println("Player 3 : ");
        for(int eachScore: score3) {
            System.out.print(eachScore + " ");
        }
        System.out.println();
        
        System.out.println("Player 4 : ");
        for(int eachScore: score4){
            System.out.print(eachScore + " ");
        }
        System.out.println();
        
        game.createSession(players);
        game.createSession(players);
        game.createSession(players);
        game.decalerWinner(gameIndex);
        game.createSession(players);
        
        
    }
    
    private void testTaskPlanner() {
        User user1 = new User();
        User user2 = new User();
        Task task1 = user1.createTask(TaskType.FEATURE);
        Task task11 = user1.createTask(TaskType.BUG);
        Task task2 = user2.createTask(TaskType.BUG);
        Task task22 = user2.createTask("This is a task subtract");
        
        Sprint sprint1 = user1.createSprint(22, 33, "Sprint1");
        Sprint sprint2 = user2.createSprint(44, 55, "Sprint2");
    
        System.out.println(user1.changeStatus(task11, TaskStatus.IN_PROGRESS));//true
    
        System.out.println(user1.addToSprint(sprint1, task1));//true
        System.out.println(user1.addToSprint(sprint1, task2));//true
        System.out.println(user1.addToSprint(sprint2, task2));//false
        System.out.println(user1.removeFromSprint(sprint1, task1));//true
        System.out.println(user2.addToSprint(sprint1, task1));//false
        System.out.println(user2.removeFromSprint(sprint1, task2));//false
        System.out.println(user2.addToSprint(sprint2, task1));//true
        System.out.println(user2.addToSprint(sprint2, task2));//true
    
        sprint1.printDetails();
        user1.printAllTasks();
        user2.printAllTasks();
        
    }
    
    
    public void testTextEditor(){
        String message = "Hi My name is prince.\nI am a SDE\nI work at fleetx.";
        Notepad notepad = new Notepad(message);
        notepad.display(1, 3);
        System.out.println("******************************************************");
        notepad.insert(2, "1.");
        notepad.display();
        System.out.println("******************************************************");
        notepad.undo();
        notepad.display();
        System.out.println("******************************************************");
        notepad.redo();
        notepad.display();
        System.out.println("******************************************************");
        notepad.redo();
        System.out.println("******************************************************");
        notepad.delete(1);
        notepad.display();
        System.out.println("******************************************************");
        notepad.undo();
        notepad.display();
        System.out.println("******************************************************");
        System.out.println("******************************************************");
        System.out.println("******************************************************");
        System.out.println("******************************************************");
        
        
    }
    
    
    
    
    public void testMeetingScheduler() {
        Room room1 = new Room("Ganga");
        Room room2 = new Room("Yamuna");
        Room room3 = new Room("Saraswati");
    
        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
    
        Scheduler scheduler = new Scheduler(rooms);
    
        System.out.println(scheduler.book(1,2, 5)); //Ganga
        System.out.println(scheduler.book(1,5, 8)); //Ganga
        System.out.println(scheduler.book(1,4, 8)); //Yamuna
        System.out.println(scheduler.book(1,3, 6)); //Saraswati
        System.out.println(scheduler.book(1,7, 8)); //Saraswati
        System.out.println(scheduler.book(2,6, 9)); //Ganga
    }
    
    
    public void testRideSharingApp(){
        Rider rider1 = new Rider(1,"Lucifer");
        Driver driver1 = new Driver("Amenadiel");
        Driver driver2 = new Driver("Prince");
        Rider rider2 = new Rider(2, "Chloe");
        Rider rider3 = new Rider(3, "Maze");
    
        List<Rider> riders = new ArrayList<>();
        riders.add(rider1);
        riders.add(rider2);
        riders.add(rider3);
    
        App app = new App(2, riders);
    
        if(app.createRide(1, 1, 50, 60, 1)) {
            System.out.println(app.closeRide(1, 1));
            app.updateRide(1, 1, 50, 60, 2);
            System.out.println(app.closeRide(1, 1));
        }
    
        System.out.println("****************************************************************");
    
        if(app.createRide(1,1, 50, 60, 1)) {
            app.withdrawRide(1, 1);
            app.updateRide(1, 1, 50, 60, 2);
            System.out.println(app.closeRide(1, 1));
        }
        System.out.println("****************************************************************");
    
        if(app.createRide(1, 1, 50, 60, 1)) {
            app.updateRide(1, 1, 50, 60, 2);
            System.out.println(app.closeRide(1, 1));
        }
    }
}
