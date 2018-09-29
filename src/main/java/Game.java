import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private Deck deck;
    private Dealer dealer;

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
        Player winner = this.players.get(0);
        for (Player player : this.players){
            if (player.getHandValue() > winner.getHandValue()){
                winner = player;
            }
        }
        return winner;
    }
}
