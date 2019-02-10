package tw.game.com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

import tw.game.com.shared.GameConstant;

import tw.game.com.bean.Board;
import tw.game.com.bean.Hotel;
import tw.game.com.bean.Player;
import tw.game.com.repo.BookedHotelRepo;
import tw.game.com.services.PlayGame;

public class Main {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
     PlayGame playGame = new PlayGame();
     int player1Total = 0,player2Total=0,player3Total = 0;
     int player1Assets = 0,player2Assets=0,player3Assets = 0;
      
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	  HashMap<Integer,String> cell = new HashMap<Integer,String>();
	  
		for(int i =0 ; i< GameConstant.GridSize; i++) {
			System.out.println("Enter the cell type : " +"\n");
		    //String type =bf.readLine(); 		
			cell.put(i, "H");
		}
	//	board.setCell(cell);
		Board.cell = cell;

		System.out.println("Enter the totel dice turn : ");
	    int turn =Integer.parseInt(bf.readLine());
	     
	    Player player1 = new Player();
	    Player player2 = new Player();
	    Player player3 = new Player();
	    
		for(int i =0 ; i< turn; i++) {
			 int output;
		   	 System.out.println("Enter the dice output: ");
		     output =Integer.parseInt(bf.readLine());
		     player1.setPosition(output);
		     playGame.startGame(player1);			     
		}	
		
		HashMap<Integer,Hotel> bookedHotelMap = new HashMap<Integer,Hotel>();
		//bookedHotelMap = bookedHotelRepo.getBookedHotelMap();
		bookedHotelMap = BookedHotelRepo.bookedHotelMap;
		player1Total = player1Total + player1.getCash();	
		player2Total = player2Total + player2.getCash();	
		player3Total = player3Total + player3.getCash();	
 
		  for(Entry<Integer, Hotel> bookedHotel:bookedHotelMap.entrySet())  
		  {  
			  Player player =new Player();
			  player =  bookedHotel.getValue().getOwner();
			  
			 if(player.equals(player1)) {
				player1Assets =  calculateAssetValue( bookedHotel.getValue().getHotelType() ,player1Assets );
			 }
			 if(player.equals(player2)) { 
					player2Assets =  calculateAssetValue( bookedHotel.getValue().getHotelType() ,player2Assets );	 
			 }
			 if(player.equals(player3)) {
				player3Assets =  calculateAssetValue( bookedHotel.getValue().getHotelType() ,player3Assets );    }  
		  }  
		  
		  System.out.println("player1 " + player1Total+"Assets "+player1Assets);  
		  System.out.println("player2 " + player2Total+"Assets "+player2Assets);  
		  System.out.println("player3 " + player3Total+"Assets "+player3Assets);  
	}

	public static int calculateAssetValue(String type, int playerAsset) {
		 if(type== GameConstant.HOTEL_SILVER) {
			 playerAsset = playerAsset + GameConstant.VALUE_SILVER;
		 }

		 if(type == GameConstant.HOTEL_PLATINUM) {
			 playerAsset = playerAsset + GameConstant.VALUE_PLATINUM;	 
		 }

		 if(type== GameConstant.HOTEL_GOLD) {
			 playerAsset = playerAsset + GameConstant.VALUE_GOLD;
		 }
     	return playerAsset;
			
			
	}
}
