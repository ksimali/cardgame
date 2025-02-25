package com.oc.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Deck {
	// attributes
	protected List<PlayingCard> cards;
	
	// Getter
	public List<PlayingCard> getCards(){
		return cards;
	}
	
	// method pour mélanger les cartes
	public void shuffle() {
		Random random = new Random();
		for (int i=0; i < cards.size(); ++i) {
			Collections.swap(cards, i, random.nextInt(cards.size()));
		}
	}
	
	// methodes pour tirer la carte du deck et remettre la carte dans le deck
	public PlayingCard removeTopCard() {
		return cards.remove(0);
	}
	
	public void returnCardToDeck(PlayingCard pc) {
		cards.add(pc);
	}
}
