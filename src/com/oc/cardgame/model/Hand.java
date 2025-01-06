package com.oc.cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	// attributes
	private List<PlayingCard> cards;
	
	
	// Constructor
	public Hand() {
		cards = new ArrayList<PlayingCard>();
	}
	
	// Methods 
	public PlayingCard getCard(int index) {
		return cards.get(index);
	}
	
	public void addCard(PlayingCard pc) {
		cards.add(pc);
	}
	
	public PlayingCard removeCard() {
		return cards.remove(0);
	}
	
	
	
}
