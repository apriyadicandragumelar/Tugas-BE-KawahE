package Candra.main;

import java.util.Scanner;
import Candra.models.Pinguin;
import Candra.models.Lizard;
import Candra.models.template.Animal;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;



public class ProgramUtama{

    public static void main(String[] args) {

        Animal kyubi = new Animal("kyubi");
        Lizard hachibi = new Lizard();
        Pinguin rokubi = new Pinguin();

        System.out.println("\n Nama Hewan " + kyubi.getNama());
        System.out.println(" Berjumlah kaki " + kyubi.getjumlahKaki());
        System.out.println(" Hewan ini Berdarah Dingin " + kyubi.getberdarahDingin());
    
        System.out.println("\n Nama Pinguin" + rokubi.getNama());
        System.out.println(" Berjumlah kaki " + rokubi.getjumlahKaki());
        System.out.println(" Hewan ini Berdarah Dingin " + rokubi.getberdarahDingin());
        rokubi.setTelur(20);
        rokubi.protectTheEggs();
        rokubi.goToSleep();
        rokubi.protectTheEggs();
        rokubi.goToSleep();

        System.out.println("\n Nama Lizard" + hachibi.getNama());
        System.out.println(" Berjumlah kaki " + hachibi.getjumlahKaki());
        System.out.println(" Hewan ini Berdarah Dingin " + hachibi.getberdarahDingin());
        hachibi.findMyFamily();
        hachibi.warna(); 
       
    }
}
      
      
     

      
     
