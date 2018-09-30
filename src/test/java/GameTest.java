import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GameTest {
    Game game;
    Player player1;
    Player player2;
    Deck deck;
    ArrayList<Player> players;

    @Before
    public void before(){
        player1 = new Player("Anne", true);
        player2 = new Player("Richard", false);
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        deck = new Deck();
        game = new Game(players, deck);
    }

    @Test
    public void findDealer() {
        assertEquals(player1, game.findDealer());
    }

    //    @Test
//    public void canStartGame() {
//        game.start();
//        assertEquals(48, deck.cardCount());
//        assertEquals(2, player1.getHandCount());
//        assertEquals(2, player2.getHandCount());
//    }

//    @Test
//    public void player1Wins() {
//        player1.addToHand(new Card(Suit.SPADES, Rank.EIGHT));
//        player2.addToHand(new Card(Suit.SPADES, Rank.FIVE));
//        assertEquals(player1, game.checkWinner());
//       }
//
//    @Test
//    public void drawReturnsNull() {
//        player1.addToHand(new Card(Suit.SPADES, Rank.EIGHT));
//        player2.addToHand(new Card(Suit.HEARTS, Rank.EIGHT));
//        assertNull(game.checkWinner());
//    }
}

