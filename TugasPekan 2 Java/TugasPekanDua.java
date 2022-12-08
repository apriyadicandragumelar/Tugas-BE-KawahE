

public class TugasPekanDua {
    public static void main(String[] args) {
       System.out.println("Nilai Absolute = " + nilaiMutlak(-45));

       int[] angkaList = {20,50,2000,-4,152,-27,-92};
       System.out.println("Nilat terbesarnya = " + nilaiTerbesar(angkaList));
       
       System.out.println("Nilai pangkat = "  + pangkat(80,2));

    }

        // Mencari nilai Absolute
        public static int nilaiMutlak(int i) {
            if (i >= 0) {
                return i;
            } else {
                return i * -1;
            }
        }

        // Mencari nilai terbesar menggunakan array
        public static int nilaiTerbesar(int [] arr) {
            if (arr.length == 0) {
                return 0;
            } 
                int max = arr[0];
                for (int a = 0; a < arr.length; a++){
                    if (arr[a] > max) {
                        max = arr[a];
                    }
                }
                return max;
            }

        // output dari hasil perpangkatan
        public static double pangkat (int basis, int eksponen) {
            if(eksponen >= 0) {
                int hasil = 1;
                for(int x = 0; x < eksponen; x++) {
                    hasil = hasil * basis;
                }
                return hasil;
            } else { 
                int hasil = 1;
                for(int x = 0; x < eksponen; x++) {
                    hasil = hasil / basis;
                }
                return hasil;
            }
        }
    }

