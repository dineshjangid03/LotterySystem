package com.lottery.service;

import java.util.HashSet;

import com.lottery.exception.WinnerException;

public interface WinnerService {
	
	public void addWinningNumbers(HashSet<Integer> numbers);
	
	public boolean checkNumber(int num)throws WinnerException;
	
	public void clearWinningNumbers();
	
	public void stopWinnerService();
	
	public void startWinnerService();

}
