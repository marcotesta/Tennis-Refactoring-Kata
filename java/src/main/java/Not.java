
public class Not implements Expression {

    private final Expression expr;

    public Not(Expression expr) {
        super();
        this.expr = expr;
    }

    public boolean match(Count score1, Count score2) {
        return !expr.match(score1, score2);
    }

}
