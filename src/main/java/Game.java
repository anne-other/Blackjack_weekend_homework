import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private Deck deck;
    private Player winner;
    private Player dealer;

    public Game(ArrayList<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
        this.dealer = findDealer();
    }

    public void start() {
        for (Player player : this.players) {
            Card card = dealer.deal(deck);
            player.addToHand(card);
        }
        if(dealer.getHandCount() < 2) {
            start();
        }
    }

    public Player checkWinner() {
        this.winner = this.players.get(0);
        for (Player player : this.players){
            if (player.getHandValue() > winner.getHandValue()){
                winner = player;
            }
        }
        if (checkDraw()){
            return null;
        }
        return winner;
    }

    private boolean checkDraw() {
        boolean draw = false;
        for (Player player : this.players){
            if (player != winner && player.getHandValue() == winner.getHandValue()){
                draw = true;
            }
        }
        return draw;
    }

    public Player findDealer() {
        for (Player player : players){
            if (player.getDealer()){
                return player;
            }
        }
        return null;
    }
}
