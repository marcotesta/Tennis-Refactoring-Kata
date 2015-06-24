



public class SecondCountLessOrEqualThanForty implements Expression {

    public boolean match(Count score1, Count score2) {
        return score2.lessOrEqualThan(Count.FORTY);
    }

}
