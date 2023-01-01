
package Candra.models.template;


// Parent Class
public class Animal {
    protected String nama;
    protected int jumlahKaki = 4;
    protected Boolean berdarahDingin = false;
    
        /* kostruktor */
        public Animal(String nama){
            this.nama = nama;
        }

        /* kostruktor */
        public Animal(){}

       
            public void setNama(String nama) {
                this.nama = nama;
            }

            public String getNama() {
                return nama;
            }

            public void setjumlahKaki(int jumlahKaki) {
                this.jumlahKaki = jumlahKaki;
            }

            public int getjumlahKaki() {
                return jumlahKaki;
            }

            public void setberdarahDingin(boolean berdarahDingin) {
                this.berdarahDingin = berdarahDingin;
            }

            public boolean getberdarahDingin() {
                return berdarahDingin;
            }

    }