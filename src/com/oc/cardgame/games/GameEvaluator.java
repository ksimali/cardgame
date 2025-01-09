package com.oc.cardgame.games;

import java.util.List;

import com.oc.cardgame.model.Player;
import com.oc.cardgame.model.PlayingCard;

public interface GameEvaluator {
	public Player evaluateWinner(List<Player> players);
	
}
