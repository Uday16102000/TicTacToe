package com.tictactoe.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class GameLog {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int logId;

@ElementCollection
private List<String> move;
public int getLogId() {
	return logId;
}
public void setLogId(int logId) {
	this.logId = logId;
}
//public XoGame getGame() {
//	return game;
//}
//public void setGame(XoGame game) {
//	this.game = game;
//}
public List<String> getMove() {
	return move;
}
public void setMove(List<String> move) {
	this.move = move;
}
public GameLog( List<String> move) {
	super();

	this.move = move;
}
public GameLog() {
	super();
}


}
