import java.util.ArrayList;
import java.util.List;


public class TennisGame1 implements TennisGame {

    private Count player1Score;
    private Count player2Score;

    private final List<Rule> rules = new ArrayList<Rule>();


    public TennisGame1(String player1Name, String player2Name) {
        this.player1Score = new Count(player1Name);
        this.player2Score = new Count(player2Name);

        init();
    }

    private void init() {

        rules.add(new Rule() {

            public boolean match(Count score1, Count score2) {
                return player1Score.even(player2Score) && player1Score.lessThan(Count.FORTY);
            }

            public String getScore(Count score1, Count score2) {
                return player1Score.toString() + "-All";
            }

        });

        rules.add(new Rule() {

            public boolean match(Count score1, Count score2) {
                return player1Score.lessOrEqualThan(Count.FORTY) && player2Score.lessOrEqualThan(Count.FORTY) && !player1Score.even(player2Score);
            }

            public String getScore(Count score1, Count score2) {
                return player1Score.toString() + "-" + player2Score.toString();
            }
        });

        rules.add(new Rule() {

            public boolean match(Count score1, Count score2) {
                return player1Score.even(player2Score) && player1Score.greaterOrEqual(Count.FORTY);
            }

            public String getScore(Count score1, Count score2) {
                return "Deuce";
            }

        });

        rules.add(new Rule() {

            public boolean match(Count score1, Count score2) {
                return (player1Score.greaterThan(Count.FORTY) || player2Score.greaterThan(Count.FORTY)) && player1Score.difference(player2Score) == 1;
            }

            public String getScore(Count score1, Count score2) {
                return "Advantage " + player1Score.max(player2Score).getPlayerName();
            }

        });

        rules.add(new Rule() {

            public boolean match(Count score1, Count score2) {
                return (player1Score.greaterThan(Count.FORTY) || player2Score.greaterThan(Count.FORTY)) && player1Score.difference(player2Score) >= 2;
            }

            public String getScore(Count score1, Count score2) {
                return "Win for " + player1Score.max(player2Score).getPlayerName();
            }
        });
    }

    public void wonPoint(String playerName) {
        if (player1Score.belongTo(playerName))
            player1Score.increment();
        else
            player2Score.increment();
    }

    public String getScore() {

        for (Rule rule : rules) {
            if (rule.match(player1Score, player2Score)) {
                return rule.getScore(player1Score, player2Score);
            }
        }

        return "";
    }

}
