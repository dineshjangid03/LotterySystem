package com.lottery.service;

import java.util.HashSet;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.lottery.exception.WinnerException;

@Service
public class WinnerServiceImpl implements WinnerService{
	
	private HashSet<Integer> lotteryIds=new HashSet<>();
	
    private boolean isServiceUp=true;

	@Override
	public void addWinningNumbers(HashSet<Integer> numbers) {
		clearWinningNumbers();
		lotteryIds=numbers;
	}

	@Override
	public boolean checkNumber(int num) throws WinnerException {
		if(!isServiceUp) {
			throw new WinnerException("service is currently down. Please try again later.");
		}
		return lotteryIds.contains(num);
	}

	@Override
	public void clearWinningNumbers() {
		System.out.println("clearing existing ids");
		lotteryIds.clear();
	}
	
	@Override
	@Scheduled(cron="0 0 6 * * *")
    public void stopWinnerService() {
		isServiceUp=false;
		System.out.println("Winner service is now down.");
    }

	@Override
    @Scheduled(cron="0 10 6 * * *")
    public void startWinnerService() {
    	isServiceUp=true;
    	System.out.println("Winner service is now up.");
    }

}
