import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ScoreBoard {

    ArrayList<Player> board = new ArrayList<Player>();

    public ScoreBoard(){

    }

    public void AddScore(Player p){
        board.add(p);
        Collections.sort(board);
        if(board.size() > 5){
            board.removeLast();
        }
    }
    public void DisplayScore(){
        IO.println(String.format("Scores:"));
        for (int i = 0; i < board.size(); i++) {
            board.get(i).Display();
        }
    }
}
