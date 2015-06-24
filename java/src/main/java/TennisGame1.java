import java.util.ArrayList;
import java.util.List;


public class TennisGame1 implements TennisGame {

    private Count count1;
    private Count count2;

    private final List<Rule> rules = new ArrayList<Rule>();


    public TennisGame1(String player1Name, String player2Name) {
        this.count1 = new Count(player1Name);
        this.count2 = new Count(player2Name);

        init();
    }

    private void init() {

        rules.add(new Rule(new And(new Even(), new FirstCountLessThanForty())) {

            @Override
            public String getScore(Count count1, Count count2) {
                return count1.toString() + "-All";
            }

        });


        rules.add(new Rule(new And(new And(new FirstCountLessOrEqualThanForty(), new SecondCountLessOrEqualThanForty()), new Not(new Even()))) {

            @Override
            public String getScore(Count count1, Count count2) {
                return count1.toString() + "-" + count2.toString();
            }
        });

        rules.add(new Rule(new And(new Even(), new FirstCountGreaterOrEqualForty())) {

            @Override
            public String getScore(Count count1, Count count2) {
                return "Deuce";
            }

        });

        rules.add(new Rule(new And(new Or(new FirstCountGreaterThanForty(), new SecondCountGreaterThanForty()), new DifferByOne())) {

            @Override
            public String getScore(Count count1, Count count2) {
                return "Advantage " + count1.max(count2).getPlayerName();
            }

        });

        rules.add(new Rule(new And(new Or(new FirstCountGreaterThanForty(), new SecondCountGreaterThanForty()), new DifferMoreThanOne())) {

            @Override
            public String getScore(Count count1, Count count2) {
                return "Win for " + count1.max(count2).getPlayerName();
            }
        });
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

}
