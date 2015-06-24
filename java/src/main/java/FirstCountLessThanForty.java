
public class FirstCountLessThanForty implements Expression {

    public boolean match(Count score1, Count score2) {
        return score1.lessThan(Count.FORTY);
    }

}
