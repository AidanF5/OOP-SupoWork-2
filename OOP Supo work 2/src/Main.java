//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    IO.println(String.format("Hello and welcome tot he HIlo game!"));
    int repeat= 1;
    IO.println(String.format("What difficulty would you like?"));
    IO.println(String.format("Hard"));
    IO.println(String.format("Medium"));
    IO.println(String.format("Easy"));
    BufferedReader r = new BufferedReader(
            new InputStreamReader(System.in));
    String difficulty;
    try {
        difficulty = r.readLine().toLowerCase();
    }
    catch(Exception e){
        IO.println(String.format("Error occured"));
        difficulty = "easy";
    }
    Game game = new Game(difficulty);
    while (repeat == 1){
        game.reset();
        int guess = -1;
        IO.println(String.format("I have thought of a number between 1 and 100"));
        while(!game.takeGuess(guess) & game.checkLimit()){
            IO.println(String.format("Please enter a guess"));
            r = new BufferedReader(
                    new InputStreamReader(System.in));
            try {
                guess = Integer.parseInt(r.readLine());
            }
            catch(Exception e){

            }
            IO.println(String.format(game.returnBound(guess)));

        }
        if(game.checkLimit()) {
            IO.println(String.format("You guessed it on only " + game.getAttempts()));
        }
        else{
            IO.println(String.format("You ran out of attempts, but you can always get it next time!"));
        }
        game.AddPlayer();
        game.DisplayScores();
        IO.println(String.format("Press 1 to play again or any other number to exit"));

        try {


            repeat = Integer.parseInt(r.readLine());
        }
        catch(Exception e){
            repeat = 0;
        }
    }
    IO.println(String.format("Thanks for playing"));



}
