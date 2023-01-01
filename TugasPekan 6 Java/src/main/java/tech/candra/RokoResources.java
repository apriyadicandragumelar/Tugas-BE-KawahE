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
 
import tech.candra.models.JenisRoko;
 
@Path("roko")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RokoResources {
 
   @Inject
   EntityManager em;
 
   @GET
   public List<JenisRoko> geRokos() {
       List<JenisRoko> kumpulanJenisRoko = new ArrayList<>();
       kumpulanJenisRoko = em.createQuery("SELECT i FROM JenisRoko i", JenisRoko.class).getResultList();
       return kumpulanJenisRoko;
   }
 
   @POST
   @Path("/insert")
   @Transactional
   public List<JenisRoko> insertRoko(@Valid JenisRoko roko) {
       List<JenisRoko> kumpulanJenisRoko = new ArrayList<>();
       em.persist(roko);
       kumpulanJenisRoko =
       em.createQuery("SELECT i FROM JenisRoko i", JenisRoko.class)
       .getResultList();
       return kumpulanJenisRoko;
   }
 
    @GET
  @Path("{id}")
  public JenisRoko getJenisRoko(@PathParam("id") Long id) {
      JenisRoko roko =
      em.createQuery("SELECT i FROM JenisRoko i WHERE i.id = :id", JenisRoko.class)
      .setParameter("id", id).getSingleResult();
      return roko;
  }
 
 
   @DELETE
   @Path("{id}/delet")
   @Transactional
   public List<JenisRoko> deletRoko(@PathParam("id") Long id) {
       List<JenisRoko> kumpulanJenisRoko = new ArrayList<>();
       JenisRoko roko = em.createQuery("SELECT i FROM JenisRoko i WHERE i.id = :id", JenisRoko.class).setParameter("id", id).getSingleResult();
       em.remove(roko);
       kumpulanJenisRoko =
       em.createQuery("SELECT i FROM JenisRoko i", JenisRoko.class)
       .getResultList();
       return kumpulanJenisRoko;
   }
 
   @PUT
   @Path("/update/{id}")
   @Transactional
   public JenisRoko updateJenisRokos(@PathParam("id") Long id, @Valid JenisRoko roko) {
       JenisRoko rokoLama =
       em.createQuery("SELECT i FROM JenisRoko i WHERE i.id = :id", JenisRoko.class)
       .setParameter("id", id).getSingleResult();
 
       rokoLama.nama = roko.nama;
       rokoLama.jumlah = roko.jumlah;
       rokoLama.harga = roko.harga;
       rokoLama.nikotin = roko.nikotin;
 
       return rokoLama;
   }
 
   @DELETE
   @Path("/deletes")
   @Transactional
   public String deleteJenisRoko() {
    em.createQuery("DELETE FROM JenisRoko").executeUpdate();
    return "Semua data JenisRoko terhapus";
   }
     
}
  
