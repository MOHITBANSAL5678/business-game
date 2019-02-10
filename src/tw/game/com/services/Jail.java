package tw.game.com.services;

import tw.game.com.bean.Bank;
import tw.game.com.bean.Player;
import tw.game.com.shared.GameConstant;

public class Jail {
  
	private static int fine = GameConstant.JAIL_FINE;	
	public static void fineDeduction(Player player) {
		Bank.setBankCash(Bank.getBankCash() + fine);
		player.setCash(player.getCash() - fine);
	}
	
}
