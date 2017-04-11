/**
 * 
 */
package com.appian.deckofcards.card;

import com.appian.deckofcards.util.CardSuit;
import com.appian.deckofcards.util.CardValue;

/**
 * Abstract class that can be extended by the four suits of cards.
 * 
 * Overrides the toString() and equals() methods.
 *
 */
public abstract class Card {

	public CardSuit suit;
	public CardValue value;
	
	public Card(CardSuit suit, CardValue value) {
		this.suit = suit;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return suit + "-" + value;
	}
	
	@Override
	public boolean equals(Object o) {
		System.out.println("Inside equals");
		if(this == o) {
			return true;
		}
		if(o == null) {
			return false;
		}
		if(getClass() != o.getClass()) {
			return false;
		}
		Card card = (Card)o;
		System.out.println("equals result is " + this.suit + " " + card.suit + " " +  this.value + " " +  card.value);
		return (this.suit == card.suit && this.value == card.value);
	}
}
