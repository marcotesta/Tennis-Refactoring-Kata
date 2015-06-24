

public abstract class Rule {

    private final Expression expr;

    public Rule(Expression expr) {
        super();
        this.expr = expr;
    }

    public final boolean match(Count score1, Count score2) {
        return expr.match(score1, score2);
    }

    public abstract String getScore(Count score1, Count score2);
}
