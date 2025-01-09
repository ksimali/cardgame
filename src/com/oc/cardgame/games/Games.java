package com.oc.cardgame.games;

import com.oc.cardgame.controller.GameController;
import com.oc.cardgame.model.Deck;
import com.oc.cardgame.view.CommandLineView;

public class Games {
	
	public static void main(String[] args) {
		GameController gc = new GameController(new Deck(), new CommandLineView(),  new HighCardGameEvaluator());
		//GameController gc = new GameController(new Deck(), new View(),  new LowCardGameEvaluator());
		gc.run();
	}
}
