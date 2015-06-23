
public class Score {

    public static final Score FORTY = new Score(3);

    private int value;
    private String playerName;

    public Score(String aPlayerName) {
        this.value = 0;
        this.playerName = aPlayerName;
    }

    private Score(int aValue) {
        this.value = aValue;
        this.playerName = "";
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

    public boolean greaterThan(Score that) {
        return this.value > that.value;
    }

    public boolean greaterOrEqual(Score that) {
        return this.greaterThan(that) || this.even(that);
    }

    public boolean lessThan(Score that) {
        return !this.greaterOrEqual(that);
    }

    public boolean lessOrEqualThan(Score that) {
        return !this.greaterThan(that);
    }

    public int getValue() {
        return value;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int difference(Score that) {
        return Math.abs(this.value - that.value);
    }


    public Score max(Score that) {
        if (this.value >= that.value) {
            return this;
        } else {
            return that;
        }
    }

    @Override
    public String toString() {
        switch(value)
        {
            case 0:
                 return "Love";
            case 1:
                 return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }



}
