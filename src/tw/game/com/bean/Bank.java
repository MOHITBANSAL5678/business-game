package tw.game.com.bean;

import tw.game.com.shared.GameConstant;

public class Bank {

	  public static int bankCash = GameConstant.BANK_INITIAL_MONEY;

	public static int getBankCash() {
		return bankCash;
	}

	public static void setBankCash(int bankCash) {
		Bank.bankCash = bankCash;
	}  	  
	  
}
