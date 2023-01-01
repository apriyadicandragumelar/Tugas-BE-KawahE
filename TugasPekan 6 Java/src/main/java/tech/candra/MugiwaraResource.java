package tech.candra;

import tech.candra.models.Mugiwara;
import tech.candra.templates.Template;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;


@Path("mugiwaras")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MugiwaraResource {

    @GET
    @Operation(summary = "Get all mugiwara", description = "Akses semua data")
    public Template getMugiwaras() {
        return new Template (true, "Berhasil", Mugiwara.listAll());
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Access mugiwara", description = "Akses spesifik data by id")
    public Template getMugiwaraById(Long id) {
        return new Template(true, "Berhasil", Mugiwara.findById(id));
    }

    @POST
    @Transactional
    @Operation(summary = "Add mugiwara", description = "Create/add data objek dan id akan terbuat otomatis")
    public Template addMugiwara(@Valid Mugiwara mugiwara) {
        mugiwara.persist();
        return new Template(true, "Berhasil", mugiwara);
    }

    @PUT
    @Path("{id}")
    @Transactional
    @Operation(summary = "Update mugiwara", description = "Update data objek dengan Id tertentu")
    public Template updateMugiwara(@PathParam("id") Long id, @Valid Mugiwara newMugiwara) {
        Mugiwara oldMugiwara = Mugiwara.findById(id);
        oldMugiwara.name = newMugiwara.name;
        oldMugiwara.weapon = newMugiwara.weapon;
        oldMugiwara.armor = newMugiwara.armor;
        oldMugiwara.health = newMugiwara.health;
        oldMugiwara.age = newMugiwara.age;
        oldMugiwara.attack = newMugiwara.attack;
        return new Template(true, "Berhasil", oldMugiwara);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "Delete mugiwara", description = "Delete data objek dengan id tertentu")
    public Template deleteMugiwara(@PathParam("id") Long id) {
        Mugiwara mugiwara = Mugiwara.findById(id);
        Mugiwara.deleteById(id);
        return new Template(true, "Berhasil", mugiwara);
    }

    @DELETE
    @Transactional
    @Operation(summary = "Delete all mugiwara", description = "Delete semua data")
    public Template deleteAllMugiwara() {
        return new Template(true, "Berhasil", Mugiwara.deleteAll());
    }
}