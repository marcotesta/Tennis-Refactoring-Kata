import java.util.ArrayList;
import java.util.List;


public class Score {

    private Count count1;
    private Count count2;

    private final List<Rule> rules = new ArrayList<Rule>();

    public Score(String player1Name, String player2Name) {
        this.count1 = new Count(player1Name);
        this.count2 = new Count(player2Name);
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void wonPoint(String playerName) {
        if (count1.belongTo(playerName))
            count1.increment();
        else
            count2.increment();
    }

    public String getScore() {

        for (Rule rule : rules) {
            if (rule.match(count1, count2)) {
                return rule.getScore(count1, count2);
            }
        }

        return "";
    }

    public void setConverter(Converter converter) {
        count1.setConverter(converter);
        count2.setConverter(converter);
    }

}
