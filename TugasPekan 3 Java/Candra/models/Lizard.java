
package Candra.models;

import Candra.models.template.Animal;


// Child Class
public class Lizard extends Animal{
	

		/* Sub kostruktor Class Child */
   		public Lizard(){
   			super();
   			this.berdarahDingin = true;
   			this.nama = " Hachibi";
    	}

    	/* SUb kostruktor Class Child */
	   	public Lizard(String nama){
	        super(nama);
			
		}

		public void findMyFamily() {
			System.out.println(" Saudara Ditemukan Didinding");
				
		}

		public void warna(){
			System.out.println(" Berwarna Cokelat");
		}


	}