package com.appian.deckofcards;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

import com.appian.deckofcards.card.Card;
import com.appian.deckofcards.util.Constant;

public class TestDeck {

	@Test
	public void testDealACard() {
		Deck deck = Deck.getInstance();
		deck.initialize();
		assertNotNull("Received a card from the deck.", deck.dealOneCard());
	}

	@Test
	public void testNoCardIsDealtAfter52() {
		Deck deck = Deck.getInstance();
		deck.initialize();
		for(int i = 0; i < Constant.TOTAL_CARDS; ++i) {
			deck.dealOneCard();
		}
		assertNull("Received no card from the deck.", deck.dealOneCard());
	}
	
	@Test
	public void testDeckIsSingleton() {
		Deck deck1 = Deck.getInstance();
		Deck deck2 = Deck.getInstance();
		assertSame("Same instance of Deck, therefore Singleton.", deck1, deck2);
	}
	
	@Test
	public void testDeckIsShuffled() {
		Deck deck = Deck.getInstance();
		deck.initialize();
		Card[] cardsBeforeShuffle = getCardsFromDeck(deck);
		
		deck.initialize();
		deck.shuffle();
		Card[] cardsAfterShuffle = getCardsFromDeck(deck);
		
		assertFalse(Arrays.equals(cardsBeforeShuffle, cardsAfterShuffle));
	}

	@Test
	public void testTotalNumberOfCardsIs52() {
		Deck deck = Deck.getInstance();
		deck.initialize();
		int totalCards = 0;
		Card card = null;
		while(true) {
			card = deck.dealOneCard();
			if (card == null) {
				break;
			}
			totalCards++;
		}
		assertEquals("Total # of cards is 52.", Constant.TOTAL_CARDS, totalCards);
	}	
	
	
	private Card[] getCardsFromDeck(final Deck deck) {
		Card[] cards = new Card[Constant.TOTAL_CARDS];
		int cardIndex = 0;
		
		for(int i = 0; i < Constant.TOTAL_CARDS; ++i) {
			cards[cardIndex++] = deck.dealOneCard();
		}
		return cards;
	}
		
}
