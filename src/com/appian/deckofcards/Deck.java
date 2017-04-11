package com.appian.deckofcards;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.appian.deckofcards.card.Card;
import com.appian.deckofcards.factory.CardFactory;
import com.appian.deckofcards.factory.ClubFactory;
import com.appian.deckofcards.factory.DiamondFactory;
import com.appian.deckofcards.factory.HeartFactory;
import com.appian.deckofcards.factory.SpadeFactory;
import com.appian.deckofcards.util.CardValue;
import com.appian.deckofcards.util.Constant;

/**
 * This class represents a deck of playing cards.
 * <p>
 * This is a singleton class. Singleton is enforced using Bill Pugh's implementation, which lazy loads 
 * the instance through an inner private class and it is thread safe.
 * <p>
 * The class offers methods to get the singleton instance, to shuffle the deck, and to deal a card from the deck.
 */
public class Deck {
	
	private Card deck[] = new Card[Constant.TOTAL_CARDS];
	private int deckIndex;
	private CardFactory clubFactory = new ClubFactory();
	private CardFactory diamondFactory = new DiamondFactory();
	private CardFactory heartFactory = new HeartFactory();
	private CardFactory spadeFactory = new SpadeFactory();
	
	//Private constructor to make the class Singleton.
	private Deck() {
		initialize();
	}
	
	/**
	 * Initializes the deck by calling corresponding factory for each suit. 
	 * <p>
	 * While this could've been a part of the constructor, separating it out helps with unit testing as 
	 * the deck needs to be re-initialized before each test since the class in Singleton.
	 * 
	 */
	public void initialize() {
		deckIndex = -1;
		for(CardValue value : CardValue.values()) {
			deck[++deckIndex] = clubFactory.createCard(value);
			deck[++deckIndex] = diamondFactory.createCard(value);
			deck[++deckIndex] = heartFactory.createCard(value);
			deck[++deckIndex] = spadeFactory.createCard(value);
		}
		System.out.println("Deck initialized with " + (deckIndex + 1) + " cards..");	
	}
	
	//Make it singleton so nobody else can sneak a card from another deck :)
	//Bill Pugh's Singleton pattern
	private static class DeckSingletonHelper {
		private static final Deck deckInstance = new Deck();
	}
	
	/**
	 * Static method to get the Singleton instance of this class. 
	 * <p>
	 * DeckSingletonHelper private class lazy initializes the instance, when this method is invoked.
	 * 
	 * @return the singleton instance of Deck.
	 */
	public static Deck getInstance() {
		return DeckSingletonHelper.deckInstance;
	}
	
	/**
	 * Shuffles the deck using Durstenfeld's variant of Fisher-Yates shuffling algorithm.
	 * 
	 * Time complexity is O(n).
	 */
	public void shuffle() {
		Random rand = ThreadLocalRandom.current();
		for(int i = deckIndex ; i > 0 ; i--) {
			int randIndex = rand.nextInt(i + 1);
			Card temp = deck[randIndex];
			deck[randIndex] = deck[i];
			deck[i] = temp;
		}
	}
	
	/**
	 * Deals a card from the deck.
	 * 
	 * @return the top card from the deck; null if no more cards left in the deck.
	 */
	public Card dealOneCard() {
		Card dealCard = null;
		if(deckIndex >= 0) {
			dealCard = deck[deckIndex--];
			System.out.println("Card @ the top of the deck is " + dealCard);
		} else {
			System.out.println("No more cards left to deal..");
		} 
		return dealCard;
	}
}
