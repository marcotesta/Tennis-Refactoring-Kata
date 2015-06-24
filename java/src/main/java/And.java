
public class And implements Expression {

    private Expression expr1;
    private Expression expr2;

    public And(Expression expr1, Expression expr2) {
        super();
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public boolean match(Count score1, Count score2) {
        return expr1.match(score1, score2) && expr2.match(score1, score2);
    }

}
