import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private Deck deck;
    private Dealer dealer;
    private Player winner;

    public Game(ArrayList<Player> players, Deck deck, Dealer dealer) {
        this.players = players;
        this.deck = deck;
        this.dealer = dealer;
    }

    public void play() {
        for (Player player : this.players) {
            Card card = dealer.deal(deck);
            player.addToHand(card);
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
            if (player.getHandValue() == winner.getHandValue()){
                draw = true;
            } else {
                draw = false;
            }
        }
        return draw;
    }
}
