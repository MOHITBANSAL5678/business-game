package tw.game.com.shared;

import tw.game.com.bean.Bank;
import tw.game.com.bean.Hotel;
import tw.game.com.bean.Player;
import tw.game.com.repo.BookedHotelRepo;

public class Calculation {
	
	 public void settleMoney(Player player, int price ) {
		   Bank.bankCash = Bank.bankCash + price;
		   player.setCash(player.getCash() - price);	    	
		  }
		 
 	 public void updateHotelType(Player player, Hotel hotel , int position ,String Hoteltype, int rent, int value ) {
			   hotel.setHotelType(Hoteltype);
			   hotel.setRent(rent);
			   BookedHotelRepo.bookedHotelMap.put(position, hotel);
			   settleMoney(player,value);	    	
		  }

}
