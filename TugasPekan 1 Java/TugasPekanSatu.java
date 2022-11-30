import java.util.Scanner;

public class TugasPekanSatu {
    public static void main(String[] args) {
        int pilih, angka1, angka2, jumlah;

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Menampilkan tugas kelayar");
            System.out.println("\n 1. Identias\n 2. Kalkulator\n 3. Perbandingan\n 99. Exit\n");
            System.out.print("Silahkan pilih menu dengan ketik angka : ");
    
            pilih = input.nextInt();
    
            if (pilih == 1) {
                System.out.println("Menu Identitas\n");
                System.out.println("Nama : April\nTTL  : xx-xx-xxxx\n");
            } else if (pilih == 2) {
                System.out.println("Menu Kalkulator\n");
                System.out.println("\n 1. Penjumlahan\n 2. Pengurangan\n 3. Perkalian\n 4. Pembagian\n 5. Sisa Bagi\n");
    
                System.out.print("Masukan pilihan dengan ketik angka : ");
                pilih = input.nextInt();
    
                System.out.print("Masukan angka pertama : ");
                angka1 = input.nextInt();
                System.out.print("Masukan angka kedua : ");
                angka2 = input.nextInt();
    
                switch (pilih) {
                    case 1 :
                        jumlah = angka1 + angka2;
                        System.out.println("Hasil Penjumlaha dari : " + angka1 + " + " + angka2 + " = " + jumlah);
                        break;
                    case 2 :
                        jumlah = angka1 - angka2;
                        System.out.println("Hasil Pengurangan dari : " + angka1 + " - " + angka2 + " = " + jumlah);
                        break;
                    case 3 :
                        jumlah = angka1 * angka2;
                        System.out.println("Hasil Perkalian dari : " + angka1 + " x " + angka2 + " = " + jumlah);
                        break;
                    case 4 :
                        jumlah = angka1 / angka2;
                        System.out.println("Hasil Pembagian dari : " + angka1 + " / " + angka2 + " = " + jumlah);
                        break;
                    case 5 :
                        jumlah = angka1 % angka2;
                        System.out.println("Hasil Sisa Bagi dari : " + angka1 + " % " + angka2 + " = " + jumlah);
                        break;
                }
            
            } else if (pilih == 3) {
                System.out.println("Menu Perbandingan");
                System.out.print("Masukan angka pertama : ");
                angka1 = input.nextInt();
                System.out.print("Masukan angka kedua : ");
                angka2 = input.nextInt();
    
                if (angka1 > angka2) {
                    System.out.print(angka1 + " Lebih besar dari " + angka2);
                } else if (angka1 < angka2) {
                    System.out.print(angka1 + " Lebih kecil dari " + angka2);
                } else {
                    System.out.println(" Kedua bilangan sama ");
                }
            }
            
        } while ( pilih != 99 );
    }
}