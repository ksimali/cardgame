package com.oc.cardgame.model;

public class Player implements IPlayer{
	private String name;
	private Hand hand;
	
	// Getter
	public String getName() {
		return name;
	}
	
	// Constructor
	public Player(String name) {
		this.name = name;
		hand = new Hand();
		
	}
	
	// Methods pour passer ou enlever des cartes a la main
	public void addCardToHand(PlayingCard pc) {
		hand.addCard(pc);
	}
	
	public PlayingCard getCard(int index) {
		return hand.getCard(index);
	}
	
	public PlayingCard removeCard() {
		return hand.removeCard();
	}
}
