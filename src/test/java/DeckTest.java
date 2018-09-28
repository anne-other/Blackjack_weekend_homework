import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeckTest {
    Deck deck;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void deckStartsEmpty() {
        assertEquals(0, deck.cardCount());
    }

    @Test
    public void deckCanBePolulate() {
        deck.populateDeck();
        assertEquals(52, deck.cardCount());
    }

    @Test
    public void deckCanDealCard() {
        deck.populateDeck();
        Card card = deck.deal();
        assertNotNull(card);
        assertEquals(51, deck.cardCount());
    }
}
