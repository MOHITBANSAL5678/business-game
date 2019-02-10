package tw.game.com.services;

import java.util.HashMap;
import tw.game.com.bean.Board;
import tw.game.com.bean.Hotel;
import tw.game.com.bean.Player;
import tw.game.com.repo.BookedHotelRepo;
import tw.game.com.shared.Calculation;
import tw.game.com.shared.GameConstant;

public class PlayGame {
	
	   Calculation calculation = new Calculation();
	   
	   public void startGame(Player player) {
		   
		int position = player.getPosition();
		HashMap<Integer,String> grid = Board.cell;
		
		if(grid.get(position).equals(GameConstant.Celltpye.H.toString())) {
			 playerAtHotel(player, position );
		}
		
		if(grid.get(position) == GameConstant.Celltpye.J.toString()) {
			Jail.fineDeduction(player);	
		}

		if(grid.get(position) == GameConstant.Celltpye.L.toString()) {
            Lottery.giveLottery(player);	         	
		}
	}
	
	public void playerAtHotel(Player player, int position ) {
				HashMap<Integer,Hotel> bookedHotels =	BookedHotelRepo.bookedHotelMap;
			
			     if(!bookedHotels.isEmpty() && bookedHotels.containsKey(position)){
			    	Hotel hotel = new Hotel(); 
			    	hotel = bookedHotels.get(position);
			    	
			    	if(hotel.getOwner().equals(player) ) {
			    		
			    	   if(hotel.getHotelType() == GameConstant.HOTEL_SILVER) {
			    		   calculation.updateHotelType(player,hotel ,position ,GameConstant.HOTEL_GOLD, GameConstant.RENT_GOLD, GameConstant.VALUE_GOLD );
			    		   }
			    	   else if(hotel.getHotelType() == GameConstant.HOTEL_GOLD) {
			    		   calculation.updateHotelType(player,hotel ,position ,GameConstant.HOTEL_PLATINUM, GameConstant.RENT_PLATINUM, GameConstant.VALUE_PLATINUM );
			    	   }	    		
			    	}else{
			    		Player ownedPlayer = new Player();
			    		ownedPlayer = hotel.getOwner();
			    		 ownedPlayer.setCash(ownedPlayer.getCash() + hotel.getRent());
			    		 player.setCash(player.getCash() - hotel.getRent());		    		
			    	} 	
				}else {
				   Hotel hotel = new Hotel ();
				   hotel.setHotelType(GameConstant.HOTEL_SILVER);
				   hotel.setOwner(player);
	               hotel.setRent(GameConstant.RENT_SILVER);
	               BookedHotelRepo.bookedHotelMap.put(position, hotel);
	               calculation.settleMoney(player , GameConstant.VALUE_SILVER);
					
				}    	
		  }
	
}
