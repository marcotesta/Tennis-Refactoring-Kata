
public class DifferMoreThanOne implements Expression {

    public boolean match(Count count1, Count count2) {
        return count1.difference(count2) >= 2;
    }

}
