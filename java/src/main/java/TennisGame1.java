

public class TennisGame1 implements TennisGame {

    private Score score;


    public TennisGame1(String player1Name, String player2Name) {

        this.score = createScore(player1Name, player2Name);
    }

    private Score createScore(String player1Name, String player2Name) {

        Score score = new Score(player1Name, player2Name);
        score.addRule(new Rule(new And(new Even(), new FirstCountLessThanForty())) {

            @Override
            public String getScore(Count count1, Count count2) {
                return count1.toString() + "-All";
            }
        });

        score.addRule(new Rule(new And(new And(new FirstCountLessOrEqualThanForty(), new SecondCountLessOrEqualThanForty()), new Not(new Even()))) {

            @Override
            public String getScore(Count count1, Count count2) {
                return count1.toString() + "-" + count2.toString();
            }
        });

        score.addRule(new Rule(new And(new Even(), new FirstCountGreaterOrEqualForty())) {

            @Override
            public String getScore(Count count1, Count count2) {
                return "Deuce";
            }

        });

        score.addRule(new Rule(new And(new Or(new FirstCountGreaterThanForty(), new SecondCountGreaterThanForty()), new DifferByOne())) {

            @Override
            public String getScore(Count count1, Count count2) {
                return "Advantage " + count1.max(count2).getPlayerName();
            }

        });

        score.addRule(new Rule(new And(new Or(new FirstCountGreaterThanForty(), new SecondCountGreaterThanForty()), new DifferMoreThanOne())) {

            @Override
            public String getScore(Count count1, Count count2) {
                return "Win for " + count1.max(count2).getPlayerName();
            }
        });

        return score;
    }

    public void wonPoint(String playerName) {
        score.wonPoint(playerName);
    }

    public String getScore() {
        return score.getScore();
    }

}
