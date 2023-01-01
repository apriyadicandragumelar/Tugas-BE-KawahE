package tech.candra;

import tech.candra.models.Mugiwara;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.*;


@Path("mugiwara")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class MugiwaraResource {
    
    public MugiwaraResource() {
    }
    @Inject 
    EntityManager en;

    @GET  //Menampilkan daftar objek secara keseluruhan
    @Operation(summary = "Get All Mugiwara", description = "Access to all mugiwara data")
    public List<Mugiwara> getMugiwara(){
        return en.createNamedQuery("Mugiwara.getAllMugiwara", Mugiwara.class).getResultList();
    }

    @GET  // Menampilkan Objek dengan id tertentu
    @Path ("{id}")
    @Operation(summary = "Access Mugiwara", description = "Access a specific mugiwara using an ID number")
    public Mugiwara getMugiwaraById(@PathParam("id") Long kataKunci){
        Mugiwara mugiwaraDenganIdTertentu = en.find(Mugiwara.class, kataKunci);
        return mugiwaraDenganIdTertentu;
    }

    @POST //Menambahkan data objek baru
    @Transactional 
    @Operation(summary = "Add an Mugiwara", description = "Create/add an mugiwara at a time and ID number will generated automatically")
    public Mugiwara addMugiwara(@Valid Mugiwara kaizokuMugiwara){
        en.persist(kaizokuMugiwara);
        return kaizokuMugiwara;
    }

    @PUT //Update data objek baru dengan id tertentu
    @Path("{id}")
    @Transactional
    @Operation(summary = "Update an Mugiwara", description = "Update an mugiwara at a time using an ID number")
    public Mugiwara updateMugiwara(@PathParam("id") Long id, @Valid Mugiwara kaizokMugiwara) {
        Mugiwara mugiwara = en.find(Mugiwara.class, id);
        mugiwara.name = kaizokMugiwara.name;
        mugiwara.weapon = kaizokMugiwara.weapon;
        mugiwara.armor = kaizokMugiwara.armor;
        mugiwara.health = kaizokMugiwara.health;
        mugiwara.age = kaizokMugiwara.age;
        mugiwara.attack = kaizokMugiwara.attack;
        return mugiwara;
    }

    @DELETE //Delete data objek dengan id tertentu
    @Path("{id}")
    @Transactional
    @Operation(summary = "Delete an Mugiwara", description = "Delete an mugiwara at a time using an ID number")
    public Mugiwara deleteMugiwara(@PathParam("id") Long id) {
        Mugiwara kaizokuMugiwara = en.find(Mugiwara.class, id);
        en.remove(kaizokuMugiwara);
        return kaizokuMugiwara;  
    }    
}
