package tech.candra.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "jenis_rokok")
public class JenisRoko {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(readOnly = true)
    public long id;

    @NotBlank (message = "Nama Roko Harus Ada!, ")
    public String nama;
    
    @NotNull(message = "Tidak boleh kosong!")
    @Min(value = 0, message = "Jumlah Terbawah 0")
    @Max(value = 100, message = "Jumlah Teringgi 100, ")
    public Integer jumlah;

    @Column(name = "data_harga", nullable = false)
    @NotNull(message = "Tidak boleh kosong!")
    @Min(value = 1000, message = "Harga Terbawah 1000")
    public Integer harga;

    @NotNull(message = "Tidak boleh kosong!")
    @Min(value = 0, message = "Nikotin Terbawah 0")
    @Max(value = 3, message = "Nikotin Teringgi 3, ")
    public Integer nikotin;


    public JenisRoko() {

    }


    public JenisRoko(String nama, Integer jumlah, Integer harga, Integer nikotin) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
        this.nikotin = nikotin;
    }

}