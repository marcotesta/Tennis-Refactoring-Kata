

public class Even implements Expression {

    public boolean match(Count score1, Count score2) {
        return score1.even(score2);
    }

}
