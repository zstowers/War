package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

import war.Deck;
import war.GameLog;
import war.Hand;
import war.Main;
import war.Player;
import war.Rank;
import war.Suit;
import war.ThreePlayerVariation;
import war.TwoPlayerClassic;
import war.TwoPlayerVariation;

public class warTest {
	ArrayList<Player> players = new ArrayList<Player>();
	
	public void tearDown(){
		players.clear();
	}
	
	@Test
	public void testPlayersCreated() {
		Player sane = new Player(22);
		Player boby = new Player(32);
		Player tim = new Player(21);
		players.add(sane);
		players.add(boby);
		players.add(tim);
		assertEquals(players.size(), 3);
	}
	
	@Test
	public void nextCardDeck() {
		Deck deck = new Deck();
		deck.getNextCard(2);
	}
	/**
	public void testHand() {
		Player sane = new Player(22);
		Deck deck = new Deck();
		Hand hand = new Hand(sane, deck, 1);
		hand.printHand(hand);
		
	}
	**/
	
	

}
