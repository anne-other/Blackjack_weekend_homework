import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private Boolean dealer;

    public Player(String name, Boolean dealer) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.dealer = dealer;
    }

    public String getName() {
        return name;
    }

    public Boolean getDealer() {
        return dealer;
    }

    public int getHandCount() {
        return hand.size();
    }

    public void addToHand(Card card) {
        this.hand.add(card);
    }


    public void emptyHand() {
        this.hand.clear();
    }

    public int getHandValue() {
        int total = 0;
        for (Card card : this.hand){
            total += card.getValue();
        }
        return total;
    }

    public Card deal(Deck deck) {
        if (getDealer()) {
            return deck.deal();
        }
        return null;
    }
}
