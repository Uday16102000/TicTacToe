package com.tictactoe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.tictactoe.entity.GameLog;
import com.tictactoe.entity.Player;

public class GameLogCrud {
	public EntityManager getManager()
	{
	EntityManager manager=Persistence.createEntityManagerFactory("uday").createEntityManager();
	return manager;
	}

	public List<String> findLOgsById(int logId) {
		EntityManager m=getManager();
		GameLog logs=m.find(GameLog.class, logId);
	
	
		if(logs!=null)
		{
			return logs.getMove();
		}
		
		return 	null;
			
		
		
	}

}
