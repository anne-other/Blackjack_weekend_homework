import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {
    Game game;
    Dealer dealer;
    Player player1;
    Player player2;
    Deck deck;
    ArrayList<Player> players;

    @Before
    public void before(){
        player1 = new Player("Anne");
        player2 = new Player("Richard");
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        dealer = new Dealer();
        deck = new Deck();
        game = new Game(players, deck, dealer);
    }

    @Test
    public void canPlay() {
        game.play();
        assertEquals(50, deck.cardCount());
        assertEquals(1, player1.getHandCount());
        assertEquals(1, player2.getHandCount());
    }

//        @Test
//        public void player1Wins() {
//            dealer.addPlayer(player1);
//            dealer.addPlayer(player2);
//            player1.addToHand(new Card(Suit.SPADES, Rank.EIGHT));
//            player2.addToHand(new Card(Suit.SPADES, Rank.FIVE));
//            assertEquals(player1, dealer.checkWinner());
//        }
//    }

}
