package com.lottery.service;

public interface CalculationService {
	
	public void pushLotteryIds(int n, int minId, int maxId);
	
	public void schedulePushLottery();

}
