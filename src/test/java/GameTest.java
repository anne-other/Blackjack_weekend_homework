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

    @Test
    public void canStartGame() {
        game.start();
        assertEquals(48, deck.cardCount());
        assertEquals(2, player1.getHandCount());
        assertEquals(2, player2.getHandCount());
    }

    @Test
    public void player1Wins() {
        player1.addToHand(new Card(Suit.SPADES, Rank.EIGHT));
        player1.addToHand(new Card(Suit.DIAMONDS, Rank.TEN));
        player2.addToHand(new Card(Suit.SPADES, Rank.FIVE));
        player2.addToHand(new Card(Suit.SPADES,Rank.TEN));
        assertEquals(player1, game.checkWinner());
       }

    @Test
    public void drawReturnsNull() {
        player1.addToHand(new Card(Suit.SPADES, Rank.EIGHT));
        player1.addToHand(new Card(Suit.HEARTS, Rank.QUEEN));
        player2.addToHand(new Card(Suit.HEARTS, Rank.EIGHT));
        player2.addToHand(new Card(Suit.SPADES, Rank.QUEEN));
        assertNull(game.checkWinner());
    }

    @Test
    public void gameCanPlay() {
        player1.addToHand(new Card(Suit.SPADES, Rank.EIGHT));
        player1.addToHand(new Card(Suit.DIAMONDS, Rank.TEN));
        player2.addToHand(new Card(Suit.SPADES, Rank.FIVE));
        player2.addToHand(new Card(Suit.SPADES,Rank.TEN));
        game.play();
        assertEquals(51, deck.cardCount());
        assertEquals(2, player1.getHandCount());
        assertEquals(3, player2.getHandCount());
    }

    @Test
    public void gameContinuesUntilAllPlayersStick() {
        player1.addToHand(new Card(Suit.SPADES, Rank.EIGHT));
        player1.addToHand(new Card(Suit.DIAMONDS, Rank.TEN));
        player2.addToHand(new Card(Suit.SPADES, Rank.TWO));
        player2.addToHand(new Card(Suit.SPADES,Rank.TWO));
        game.play();
        assertEquals(true, deck.cardCount() < 51);
        assertEquals(2, player1.getHandCount());
        assertEquals(true, player2.getHandCount() > 3);
    }
}

