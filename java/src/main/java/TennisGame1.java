
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
        int tempScore=0;
        if (player1Score.even(player2Score)  )
        {
            switch (player1Score.getValue())
            {
                case 0:
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                default:
                        score = "Deuce";
                    break;

            }
        }
        else if (player1Score.getValue()>=4 || player2Score.getValue() >=4)
        {
            int minusResult = player1Score.getValue() - player2Score.getValue();
            if (minusResult==1) score ="Advantage " + player1Score.getPlayerName();
            else if (minusResult ==-1) score ="Advantage " + player2Score.getPlayerName();
            else if (minusResult>=2) score = "Win for " + player1Score.getPlayerName();
            else score ="Win for " + player2Score.getPlayerName();
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1Score.getValue();
                else { score+="-"; tempScore = player2Score.getValue();}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }
}
