import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        populateDeck();
    }

    public int cardCount() {
        return cards.size();
    }

    public void populateDeck() {
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
        shuffleDeck();
    }

    public void shuffleDeck(){
        Collections.shuffle(this.cards);
    }

    public Card deal() {
        return cards.remove(0);
    }
}
