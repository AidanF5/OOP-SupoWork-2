import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Game {

    private Random rnd = new Random();
    private String difficulty;
    private int limit;
    private int target;
    private int attempts;
    private ScoreBoard scores;

    public Game(String diff){
        difficulty = diff;
        attempts = -1;
        target = rnd.nextInt(0, 101);
        scores = new ScoreBoard();
        if(diff.equals("easy")){
            limit = 30;
        }
        else if(diff.equals("medium")){
            limit = 12;
        }
        else{
            limit = 7;
        }
    }
    public void reset(){
        attempts=-1;
        target = rnd.nextInt(0, 101);
    }
    public boolean takeGuess(int guess){
        attempts++;
        if(target == guess){
            return true;
        }
        return false;
    }

    public int getAttempts(){
        return attempts;
    }
    public String returnBound(int guess){
        if(target == guess){
            return "Correct";
        }
        else if(guess < target){
            return "Higher";
        }
        else{
            return "Lower";
        }
    }
    public boolean checkLimit(){
        if(attempts<limit){
            return true;
        }
        return false;
    }
    public void DisplayScores(){
        scores.DisplayScore();
    }
    public void AddPlayer(){
        IO.println(String.format("Please enter your name"));
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name;
        try {
            name = r.readLine();
        }
        catch(Exception e){
            name = "Anonymous";
        }
        Player p = new Player(attempts, name, difficulty);
        scores.AddScore(p);
    }
}
