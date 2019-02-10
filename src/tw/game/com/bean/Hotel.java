package tw.game.com.bean;

public class Hotel {
	
	private int  rent ;
	private Player owner;
	private String hotelType ;
	
	
	public int getRent() {
		return rent;
	}
	public Player getOwner() {
		return owner;
	}
	public String getHotelType() {
		return hotelType;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}
	
}
