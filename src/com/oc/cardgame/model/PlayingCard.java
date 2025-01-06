package com.oc.cardgame.model;

public class PlayingCard {
	// attributes
	private Rank rank;
	private Suit suit;
	private boolean faceUp;
	
	// Getters
	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public boolean isFaceUp() {
		return faceUp;
	}
	
	// Constructor
	public PlayingCard(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	// Methods
	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
	}
	
}
