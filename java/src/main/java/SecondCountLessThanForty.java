
public class SecondCountLessThanForty implements Expression {

    public boolean match(Count score1, Count score2) {
        return score2.lessThan(Count.FORTY);
    }

}
