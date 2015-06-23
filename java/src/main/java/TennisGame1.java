import java.util.ArrayList;
import java.util.List;


public class TennisGame1 implements TennisGame {

    private Score player1Score;
    private Score player2Score;

    private final List<Rule> rules = new ArrayList<Rule>();


    public TennisGame1(String player1Name, String player2Name) {
        this.player1Score = new Score(player1Name);
        this.player2Score = new Score(player2Name);

        init();
    }

    private void init() {

        rules.add(new Rule() {

            public boolean match(Score score1, Score score2) {
                return player1Score.even(player2Score) && player1Score.lessThan(Score.FORTY);
            }

            public String getScore(Score score1, Score score2) {
                return player1Score.toString() + "-All";
            }

        });

        rules.add(new Rule() {

            public boolean match(Score score1, Score score2) {
                return player1Score.lessOrEqualThan(Score.FORTY) && player2Score.lessOrEqualThan(Score.FORTY) && !player1Score.even(player2Score);
            }

            public String getScore(Score score1, Score score2) {
                return player1Score.toString() + "-" + player2Score.toString();
            }
        });

        rules.add(new Rule() {

            public boolean match(Score score1, Score score2) {
                return player1Score.even(player2Score) && player1Score.greaterOrEqual(Score.FORTY);
            }

            public String getScore(Score score1, Score score2) {
                return "Deuce";
            }

        });

        rules.add(new Rule() {

            public boolean match(Score score1, Score score2) {
                return (player1Score.greaterThan(Score.FORTY) || player2Score.greaterThan(Score.FORTY)) && player1Score.difference(player2Score) == 1;
            }

            public String getScore(Score score1, Score score2) {
                return "Advantage " + player1Score.max(player2Score).getPlayerName();
            }

        });

        rules.add(new Rule() {

            public boolean match(Score score1, Score score2) {
                return (player1Score.greaterThan(Score.FORTY) || player2Score.greaterThan(Score.FORTY)) && player1Score.difference(player2Score) >= 2;
            }

            public String getScore(Score score1, Score score2) {
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
