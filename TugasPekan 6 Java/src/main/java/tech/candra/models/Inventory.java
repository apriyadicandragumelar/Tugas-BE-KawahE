package tech.candra.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "kumpulan_inventori")
public class Inventory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(readOnly = true)
    public Long id;

    @NotBlank(message = "Tidak boleh kosong!")
    public String nama;

    @NotBlank(message = "Tidak boleh kosong!")
    public String kode;

    @Column(name = "data_harga", nullable = false)
    @NotNull(message = "Tidak boleh kosong!")
    @Min(value = 0, message = "Tidak boleh kurang dari 0!")
    public Double harga;

    @NotNull(message = "Tidak boleh kosong!")
    @Min(value = 0, message = "Tidak boleh kurang dari 0!")
    public Integer jumlah;
    
    //Constructor framework
    public Inventory() {

    } 

}

