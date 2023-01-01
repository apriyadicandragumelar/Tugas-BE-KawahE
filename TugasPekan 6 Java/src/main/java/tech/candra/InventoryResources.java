package tech.candra;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;

import tech.candra.models.Inventory;

@Path("/inventory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InventoryResources {

    @Inject
    EntityManager em;

    @GET
    public List<Inventory> getInventories() {
        List<Inventory> kumpulanInventory = new ArrayList<>();
        kumpulanInventory = em.createQuery("SELECT i FROM Inventory i", Inventory.class).getResultList();
        return kumpulanInventory;
    }

    @POST
    @Path("/insert")
    @Transactional
    public List<Inventory> insertInventory(@Valid Inventory inventory) {
        List<Inventory> kumpulanInventory = new ArrayList<>();
        em.persist(inventory);
        kumpulanInventory = 
        em.createQuery("SELECT i FROM Inventory i", Inventory.class)
        .getResultList();
        return kumpulanInventory;
    }

    @GET
    @Path("/{id}")
    public Inventory getInventory(@PathParam("id") Long id) {
        Inventory inventory = 
        em.createQuery("SELECT i FROM Inventory i WHERE i.id = :id", Inventory.class)
        .setParameter("id", id).getSingleResult();
        return inventory;
    }

    @DELETE
    @Path("{id}/delete")
    @Transactional
    public List<Inventory> deleteInventory(@PathParam("id") Long id) {
        List<Inventory> kumpulanInventory = new ArrayList<>();
        Inventory inventory = em.createQuery("SELECT i from Inventory i WHERE i.id = :id", Inventory.class).setParameter("id", id).getSingleResult();
        em.remove(inventory);
        kumpulanInventory = 
        em.createQuery("SELECT i FROM Inventory i", Inventory.class)
        .getResultList();
        return kumpulanInventory;
    }

    @PUT
    @Path("{id}/update")
    @Transactional
    public Inventory updateInventory(@PathParam("id") Long id, @Valid Inventory newInventory) {
        Inventory inventory = 
        em.createQuery("SELECT i FROM Inventory i WHERE i.id = :id", Inventory.class)
        .setParameter("id", id).getSingleResult();

        inventory.harga = newInventory.harga;
        inventory.jumlah = newInventory.jumlah;
        inventory.kode = newInventory.kode;
        inventory.nama = newInventory.nama;

        return inventory;
    }

    @DELETE
    @Path("/deletes")
    @Transactional
    public String deleteInventories() {
        em.createQuery("DELETE FROM Inventory").executeUpdate();
        return "Semua data dihapus";
    }
    
    
}