
public class Score {

    private int value;
    private String playerName;

    public Score(String aPlayerName) {
        this.value = 0;
        this.playerName = aPlayerName;
    }

    public boolean belongTo(String aPlayerName) {
        return playerName.equals(aPlayerName);
    }

    public void increment() {
        value++;
    }

    public boolean even(Score that) {
        return this.value == that.value;
    }

    public int getValue() {
        return value;
    }

    public String getPlayerName() {
        return playerName;
    }

}
