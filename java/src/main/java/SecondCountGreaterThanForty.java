
public class SecondCountGreaterThanForty implements Expression {

    public boolean match(Count count1, Count count2) {
        return count2.greaterThan(Count.FORTY);
    }

}
