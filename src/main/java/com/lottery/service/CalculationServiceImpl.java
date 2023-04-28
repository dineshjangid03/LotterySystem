package com.lottery.service;

import java.util.HashSet;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService{
	
	@Autowired
	public WinnerService winnerService;

	@Override
	public void pushLotteryIds(int n, int minId, int maxId) {
	    HashSet<Integer> ids=new HashSet<>();
	    Random random=new Random();
	    while (ids.size()<n) {
	        int id=random.nextInt(maxId - minId + 1) + minId;
	        
	        ids.add(id);
	    }
        winnerService.addWinningNumbers(ids);
        
        System.out.println("new lottery ids added");
	}
	
	@Override
	@Scheduled(cron="0 0 0 * * *")
	public void schedulePushLottery() {
		
		System.out.println("Calculation service pushing new lottery ids");
		
		int n=(int)(Math.random() * 100000-100+1) + 100;
		
		int min=100;
		
		int max=n*min;
		
		pushLotteryIds(n, min, max);
		
	}

}
