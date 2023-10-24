package com.tictactoe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.tictactoe.dao.GameLogCrud;
import com.tictactoe.dao.PlayerCrud;
import com.tictactoe.dao.XoGameCrud;
import com.tictactoe.entity.GameLog;
import com.tictactoe.entity.Player;
import com.tictactoe.entity.XoGame;

public class Controller {

	public static void main(String[] args) {
		
	
	Scanner  s = new Scanner(System.in);
	boolean check=true;
	TicTacToeGame ticTacToeGame = new TicTacToeGame();
	PlayerCrud playerCrud= new PlayerCrud();
	XoGameCrud  gameCrud = new XoGameCrud();
	GameLogCrud gameLogCrud = new GameLogCrud();
	
	
	
	
	
	do {
		System.out.println("Choose the option \n 1.Create Player \n 2. Create Game  \n 3."  );
		int choice =s.nextInt();
		switch(choice) {

		case 1:{
			System.out.println("PLease enter your unique id");
			int id=s.nextInt();
			Player p=playerCrud.fetchPlayerById(id);
			if(p!=null)
			{
				System.out.println("Player exist with this id, please choose some different id");
				break;
			}
			
	    	System.out.println("Enter the name of player1");
	    	String p1Name=s.next();
	    	
	    	System.out.println("Choose your symbol ");
	    	char symbol1=s.next().charAt(0);

	    		Player player= new Player(p1Name,symbol1);
		    	playerCrud.save(player);
		    	System.out.println("Player created with name " + player.getName() + "you unique Id is "+ player.getPlayerId());

	    
	    	
	    	
		}break;
		case 2:
		{
			
			System.out.println("Enter player1 uniqueId");
			int id= s.nextInt();
			Player p1=playerCrud.fetchPlayerById(id);
			if(p1==null)
			{
				System.out.println("Player not exist ,please create a new one");
				break;
				
			}
			System.out.println("Enter player2 uniqueId");
			id=s.nextInt();
		Player p2=playerCrud.fetchPlayerById(id);
		if(p2==null)
			{
				System.out.println("Player not exist ,please create a new one");
				break;
				
			}
			XoGame game= new XoGame(p1,p2);
	    	  String currentPlayer = p1.getName();
	    	   String winnerName=null;
	    	
	    	int totalMoves=0;
	    	ticTacToeGame.startBoard();
	    	boolean won=false;
	    	List<String> log = new ArrayList<String>();
	    	while(!won && totalMoves<9 )
	    	{
	    		ticTacToeGame.showXoBoard();
	    		int move[]= ticTacToeGame.getPlayerMove(currentPlayer);
	    		
//	    		int move[]=xoGame.getPlayerMove(currentPlayer);
	    		int row= move[0];
	    		int col=move[1];
	    		
	    		if(ticTacToeGame.validMove(row, col))
	    		{
	    			char symbol;
	    			if(currentPlayer.equals(p1.getName()))
	    			{
	    				symbol=p1.getSymbol();
	    			}else {
	    				symbol=p2.getSymbol();
	    			}
	    			ticTacToeGame.xoBoard[row][col]=symbol;
	    			ticTacToeGame.showXoBoard();
	    			System.out.println("===If you want to undo press 1  or press 2 to continue==");
	    			
	    			int undo= s.nextInt();
	    			switch(undo)
	    			{
	    			case 1:{
	    				ticTacToeGame.xoBoard[row][col]=' ';
	    			}break;
	    			case 2:{
	    				break;
	    			}
	    			}
	    			
	    			log.add(currentPlayer + " added  " +  symbol + " at " + row +  " "+ col );
	    			totalMoves=totalMoves+1;
	    			won=ticTacToeGame.checkWin(row, col,symbol);
	    			if(won)
	    			{
	    				winnerName=currentPlayer;
	    			}
	    			
	
	    			  currentPlayer = (currentPlayer.equals(p1.getName())) ? p2.getName() : p1.getName();
	    			
	    		}else {
	    			System.out.println("Please enter a valid move with respect to row and column");
	    		}
	    	
	    		
	    	}
	    	ticTacToeGame.showXoBoard();
	    	if(won)
	    	{   
	    		System.out.println("*******The winner is "+ winnerName  + "Congratulations *******");
	    	}else {
	    		System.out.println("xxxxxxxxxxxxx The match is draw xxxxxxxxxxx");
	    		playerCrud.updateDraw(p1.getPlayerId());
	    		playerCrud.updateDraw(p2.getPlayerId());
	    		break;
	    	}
	    	
			if(winnerName.equals(p1.getName()))
			{
				playerCrud.updateWin(p1.getPlayerId());
				playerCrud.updateLoss(p2.getPlayerId());
				
			}else {
				playerCrud.updateWin(p2.getPlayerId());
				playerCrud.updateLoss(p1.getPlayerId());
			}
			GameLog gameLog= new GameLog(log);
			XoGame xoGame= new XoGame(p1,p2,gameLog);
			gameCrud.saveGame(xoGame);
			System.out.println("For replay press 1 or else press 2");
			int x=s.nextInt();
			switch(x)
			{
			case 1:{
                int  logId= xoGame.getGameId();
				List<String> mo= gameLogCrud.findLOgsById(logId);
				   for(String m:mo)
				   {
					   System.out.println(m);
				   }
				  
				
			}break;
			case 2:{
				System.out.println("ThankYou");
				break;
			}
			}
			
			
			
			
		}break;
		default:{
			System.out.println("Invalid Input");
			break;
		
		}
		
		}
		
	}while(check);
	
}
}