
public class FirstCountGreaterOrEqualForty implements Expression {

    public boolean match(Count count1, Count count2) {
        return count1.greaterOrEqual(Count.FORTY);
    }

}
