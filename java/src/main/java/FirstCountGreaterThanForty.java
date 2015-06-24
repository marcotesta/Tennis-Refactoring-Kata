
public class FirstCountGreaterThanForty implements Expression {

    public boolean match(Count count1, Count count2) {
        return count1.greaterThan(Count.FORTY);
    }

}
