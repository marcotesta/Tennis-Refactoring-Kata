
public interface Rule {

    public boolean match(Count score1, Count score2);

    public String getScore(Count score1, Count score2);
}
