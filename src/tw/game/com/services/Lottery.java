package tw.game.com.services;

import tw.game.com.bean.Bank;
import tw.game.com.bean.Player;
import tw.game.com.shared.GameConstant;

public class Lottery {

	private static int lotteryPrice = GameConstant.LOTTERY_PRICE;
	public static void giveLottery(Player player) {
		player.setCash(player.getCash() + lotteryPrice);
 		Bank.setBankCash(Bank.getBankCash() - lotteryPrice);
	}
}


