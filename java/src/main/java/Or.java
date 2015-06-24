
public class Or implements Expression {

    private Expression expr1;
    private Expression expr2;


    public Or(Expression expr1, Expression expr2) {
        super();
        this.expr1 = expr1;
        this.expr2 = expr2;
    }


    public boolean match(Count count1, Count count2) {
        return expr1.match(count1, count2) || expr2.match(count1, count2);
    }

}
