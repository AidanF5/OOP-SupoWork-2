public class Player implements Comparable<Player>{

    String name;
    int score;
    String diff;
    public Player(int score, String name, String difficulty){
        this.name = name;
        this.score = score;
        this.diff=difficulty;
    }
    public int GetScore(){
        return score;
    }
    public String GetName(){
        return name;
    }

    @Override
    public int compareTo(Player p){
        return score-p.score;

    }
    public void Display(){
        IO.println(String.format(name +"  "+score+"  "+diff));
    }
}
