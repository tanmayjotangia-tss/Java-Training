package module;

public class Player {
    private static char mark;

    public Player(char mark){
        this.mark = mark;
    }

    public static char getPlayer(){
        return mark;
    }
}
