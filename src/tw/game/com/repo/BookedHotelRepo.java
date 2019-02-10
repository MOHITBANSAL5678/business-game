package tw.game.com.repo;

import java.util.HashMap;

import tw.game.com.bean.Hotel;

public class BookedHotelRepo {

	
	public static HashMap<Integer,Hotel> bookedHotelMap = new HashMap<Integer,Hotel>();

	public HashMap<Integer, Hotel> getBookedHotelMap() {
		return bookedHotelMap;
	}

	public void setBookedHotelMap(HashMap<Integer, Hotel> bookedHotelMap) {
		this.bookedHotelMap = bookedHotelMap;
	}
	  
	  
	  
	  
}
