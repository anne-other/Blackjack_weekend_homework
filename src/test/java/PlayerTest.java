import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlayerTest {
    Player player;
    Card card;
    boolean dealer;

    @Before
    public void before(){
        player = new Player("Anne", true);
        card = new Card(Suit.SPADES, Rank.ACE);
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
        assertEquals(1, player.getHandValue());
    }

    @Test
    public void playerCanBeDealer() {
        assertEquals(true, player.getDealer());
    }
}
