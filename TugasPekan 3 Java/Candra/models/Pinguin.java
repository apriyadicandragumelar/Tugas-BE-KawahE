
package Candra.models;

import Candra.models.template.Animal;


// Child Class
public class Pinguin extends Animal{
	public int jumlahTelur = 0;

		/* Sub kostruktorClass Child*/
   		public Pinguin(){
        	super();
        	this.nama = " Rokubi";
        	this.jumlahKaki = 2;
        	
    	}
    	
    	/* Sub kostruktor Class Child*/
   		public Pinguin(String nama){
   			super(nama);
        	
			
		}
 		public int getTelur(){
 			return jumlahTelur;
 		}

		public void setTelur(int jumlahTelur) {
			this.jumlahTelur = jumlahTelur;	
		}

 		public void goToSleep() {
 			System.out.println(" Tidur kebablasan, telur hilang satu tinggal tersisa " + --jumlahTelur);
 		}

		public void protectTheEggs(){
			System.out.println(" sedang dijaga, jumlah telur sekarang adalah " + jumlahTelur );
		}
	}