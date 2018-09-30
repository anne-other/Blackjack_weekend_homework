import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlayerTest {
    Player player;
    Card card;
    Deck deck;

    @Before
    public void before(){
        player = new Player("Anne", true);
        card = new Card(Suit.SPADES, Rank.ACE);
        deck = new Deck();
    }

    @Test
    public void playerHasName() {
        assertEquals("Anne", player.getName());
    }

    @Test
    public void startsWithEmptyHand() {
        assertEquals(0, player.getHandCount());
    }

    @Test
    public void playerCanGetCard() {
        player.addToHand(card);
        assertEquals(1, player.getHandCount());
    }

    @Test
    public void canEmptyHand() {
        player.addToHand(card);
        assertEquals(1, player.getHandCount());
        player.emptyHand();
        assertEquals(0, player.getHandCount());
    }

    @Test
    public void hasHandValue() {
        player.addToHand(card);
        assertEquals(11, player.getHandValue());
    }

    @Test
    public void aceCanBeLow() {
        player.addToHand(card);
        player.addToHand(card);
        assertEquals(12, player.getHandValue());
    }

    @Test
    public void playerCanBeDealer() {
        assertEquals(true, player.getDealer());
    }

    @Test
    public void playerNotDealer() {
        Player player1 = new Player("Richard", false);
        assertEquals(false, player1.getDealer());
    }

    @Test
    public void playerDealerCanDeal() {
        Card card = player.deal(deck);
        assertNotNull(card);
        assertEquals(51, deck.cardCount());
    }

    @Test
    public void playerCanStick() {
        player.addToHand(card);
        Card card1 = new Card(Suit.HEARTS, Rank.QUEEN);
        player.addToHand(card1);
        assertEquals(false, player.play());
    }

    @Test
    public void playerCanTwist() {
        player.addToHand(card);
        Card card1 = new Card(Suit.HEARTS, Rank.TWO);
        player.addToHand(card1);
        assertEquals(true, player.play());
    }
}
