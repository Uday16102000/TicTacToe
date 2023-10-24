package com.tictactoe.controller;

import java.util.Scanner;



public class TicTacToeGame {


	
    public  char[][] xoBoard = new char[3][3];

    
    public  void startBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            	xoBoard[i][j] = ' ';
            }
        }
    }
        public  void showXoBoard() {
            System.out.println("  0 1 2");
            for (int i = 0; i < 3; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(xoBoard[i][j]);
                    if (j < 2) {
                        System.out.print("|");
                    }
                }
                System.out.println();
                if (i < 2) {
                    System.out.println("  -+-+-");
                }
            }
        }  
        
        public  int[] getPlayerMove(String currentPlayer) {
        	Scanner scanner = new Scanner(System.in);
            int[] move = new int[2];
            System.out.print("Player " + currentPlayer + ", enter your move in terms of row and column: ");
            move[0] = scanner.nextInt();
            move[1] = scanner.nextInt();
            return move;
        }
        
        public  boolean validMove(int row, int col) {
            return row >= 0 && row < 3 && col >= 0 && col < 3 && xoBoard[row][col] == ' ';
        }
        public  boolean checkWin(int row, int col,char currentPlayer) {
       
            return (xoBoard[row][0] == currentPlayer && xoBoard[row][1] == currentPlayer && xoBoard[row][2] == currentPlayer) ||
                   (xoBoard[0][col] == currentPlayer && xoBoard[1][col] == currentPlayer && xoBoard[2][col] == currentPlayer) ||
                   (row == col && xoBoard[0][0] == currentPlayer && xoBoard[1][1] == currentPlayer && xoBoard[2][2] == currentPlayer) ||
                   (row + col == 2 && xoBoard[0][2] == currentPlayer && xoBoard[1][1] == currentPlayer && xoBoard[2][0] == currentPlayer);
        }
    
    
//    public static void main(String[] args) {
//    	
//    	Scanner s= new Scanner(System.in);
//    	
//    	XoGame xoGame= new XoGame();
//    	
//    	System.out.println("Welcome to Game Board");
//    	
//    	Player p1= new Player();
//    	System.out.println("Enter the name of player1");
//    	String p1Name=s.nextLine();
//    	p1.setName(p1Name);
//    	System.out.println("Choose your symbol "+ p1Name);
//    	char symbol1=s.next().charAt(0);
//    	p1.setSymbol(symbol1);
//    	
//    	Player p2= new Player();
//    	System.out.println("Enter the name of player2");
//    	String p2Name=s.next();
//    	p2.setName(p2Name);
//    	System.out.println("Choose your symbol "+ p2Name);
//    	char symbol2=s.next().charAt(0);
//    	p1.setSymbol(symbol2);
//    	
//    	  String currentPlayer = p1Name;
//    	   String winnerName=null;
//    	
//    	int totalMoves=0;
//    	xoGame.startBoard();
//    	boolean won=false;
////    	showXoBoard();
//    	while(!won && totalMoves<9 )
//    	{
//    		xoGame.showXoBoard();
//    		int move[]=xoGame.getPlayerMove(currentPlayer);
//    		int row= move[0];
//    		int col=move[1];
//    		if(xoGame.validMove(row, col))
//    		{
//    			char symbol=symbol1;
//    			if(currentPlayer.equals(p2Name))
//    			{
//    				symbol=symbol2;
//    			}
//    			xoGame.xoBoard[row][col]=symbol;
//    			totalMoves=totalMoves+1;
//    			won=xoGame.checkWin(row, col,symbol);
//    			if(won)
//    			{
//    				winnerName=currentPlayer;
//    			}
//    			
//
//    			  currentPlayer = (currentPlayer.equals(p1.getName())) ? p2.getName() : p1.getName();
//    			
//    		}else {
//    			System.out.println("Please enter a valid move with respect to row and column");
//    		}
//    	
//    		
//    	}
//    	xoGame.showXoBoard();
//    	if(won)
//    	{   
//    		System.out.println("The winner is "+ winnerName  + "Congratulations ");
//    	}else {
//    		System.out.println("The match is drraw");
//    	}
//    	
//    	
//    	
//    	
//    	
//    
//    	
//		
//    	
//    	
//	}
    
    
    


}
