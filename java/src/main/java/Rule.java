
public interface Rule {

    public boolean match(Score score1, Score score2);

    public String getScore(Score score1, Score score2);
}
