package tech.candra.models;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "mugiwara")
public class Mugiwara extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public Long id;
    
        @NotBlank (message = "Nama Nakama Harus Ada!, ")
        public String name;
    
        @NotBlank (message = "Weapon Nakama Harus Ada!, ")
        public String weapon;
    
        @NotBlank (message = "Armor Nakama Harus Ada!, ")
        public String armor;
        
        @NotNull(message = "health Nakama harus ada!, ")
        @Min(message = "Health 100", value = 100)
        public Integer health;
    
        @NotNull(message = "Age Nakama harus diisi!, ")
        @Min(value = 0, message = "Age Nakama Terkecil 0")
        public Integer age;
        
        @NotNull(message = "Attack Nakama harus disi!, ")
        @Min(value = 0, message = "Attack Nakama Terkecil 0")
        public Double attack;
}
