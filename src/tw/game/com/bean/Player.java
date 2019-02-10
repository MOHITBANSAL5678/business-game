package tw.game.com.bean;

import java.util.List;

import tw.game.com.shared.GameConstant;

public class Player {
	
private	int cash;
private	List<Hotel> hotels;
private	int position;
	
	public Player() {
		cash = GameConstant.PLAYER_INITIAL_MONEY;
		position = 0;
	}
	
	
	public int getCash() {
		return cash;
	}
	
	public List<Hotel> getHotels() {
		return hotels;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
	
	public void setPosition(int position) {
		
		int movePosition=position+this.position; 
		if (movePosition > GameConstant.GridSize) {
			this.position = movePosition - GameConstant.GridSize;
		}else {
			this.position = position;	
		}
	}
	

}
