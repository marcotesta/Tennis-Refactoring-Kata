
public class TennisGame1 implements TennisGame {

    private Score player1Score;
    private Score player2Score;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Score = new Score(player1Name);
        this.player2Score = new Score(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1Score.belongTo(playerName))
            player1Score.increment();
        else
            player2Score.increment();
    }

    public String getScore() {
        String score = "";
        if (player1Score.even(player2Score)  )
        {
            if (player1Score.lessThan(Score.FORTY)) {
                score = player1Score.toString() + "-All";
            } else if (player1Score.greaterOrEqual(Score.FORTY)) {
                score = "Deuce";
            }
        }
        else if (player1Score.greaterThan(Score.FORTY) || player2Score.greaterThan(Score.FORTY))
        {
            if (player1Score.difference(player2Score) == 1) {
                score ="Advantage " + player1Score.max(player2Score).getPlayerName();
            } else if (player1Score.difference(player2Score) >= 2) {
                score ="Win for " + player1Score.max(player2Score).getPlayerName();
            }
        }
        else
        {
            score = player1Score.toString() + "-" + player2Score.toString();
        }
        return score;
    }

}
