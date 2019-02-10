package tw.game.com.main;

import java.util.HashMap;

public class test {
	
static	 HashMap<Integer,String> hm=new HashMap<Integer,String>();    

	      
	public static void main(String[] args) {

	      hm.put(100,"Amit"); 		
	      
	     String s = "Amit";
	     
	     if(hm.get(100) == s) {
	    	 System.out.println("1");
	     }else if (hm.get(100).equals(s)) {
			System.out.println("2");
		}else {
			System.out.println("3");
		}

	}

}
