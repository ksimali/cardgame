package com.oc.cardgame.games;

import com.oc.cardgame.controller.GameController;
import com.oc.cardgame.model.Deck;
import com.oc.cardgame.view.View;

public class Games {
	
	public static void main(String[] args) {
		GameController gc = new GameController(new Deck(), new View(),  new HighCardGameEvaluator());
		gc.run();
	}
}
