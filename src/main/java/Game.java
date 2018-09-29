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

//
//
//    public int playerCount() {
//        return this.players.size();
//    }
//
//    public void addPlayer(Player player) {
//        this.players.add(player);
//    }
//
//    public void removePlayers() {
//        this.players.clear();
//    }
//
//    public void deal(Deck deck) {
//        for (Player player : this.players) {
//            Card card = deck.deal();
//            player.addToHand(card);
//        }
//    }
//
//    public Player checkWinner() {
//        Player winner = this.players.get(0);
//        for (Player player : this.players){
//            if (player.getHandValue() > winner.getHandValue()){
//                winner = player;
//            }
//        }
//        return winner;
//    }
}
