package tech.candra.service;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Sort;
import tech.candra.dto.UserAdminRequest;
import tech.candra.models.UserAdmin;
import tech.candra.templates.Template;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class UserAdminService {

    @Transactional
    public Template post(UserAdminRequest userAdminRequest) {
        System.out.println("Service");

        //mencari data berdasarkan username
        UserAdmin byUserAdmin = UserAdmin.findbyUsername(userAdminRequest.getUsername());
        //validasi username untuk username yang sudah digunakan
        if (byUserAdmin != null) {
            return new tech.candra.templates.Template(false, "username sudah digunakan", null);
        }

        //memanggil model useradmin
        UserAdmin userAdmin = new UserAdmin();
        //set data baru untuk useradmin
        userAdmin.setUsername(userAdminRequest.getUsername());
        userAdmin.setPassword(userAdminRequest.getPassword());
        userAdmin.setEmail(userAdminRequest.getEmail());
        userAdmin.setNamaLengkap(userAdminRequest.getNamaLengkap());
        userAdmin.setCreatedAt(LocalDateTime.now());
        System.out.println("End Setting User");
        //save data user admin
        UserAdmin.persist(userAdmin);
        System.out.println("save user");

        //return template response
        return new tech.candra.templates.Template(true, "succes", userAdmin);

    }

    @Transactional
    public Template editUserAdmin(UserAdminRequest userAdminRequest, long id) {
        System.out.println("Service");

        //mencari data berdasarkan id
        UserAdmin userAdminbyId = UserAdmin.findById(id);
        //validasi untuk id yang tidak valid
        if (userAdminbyId == null) {
            return new tech.candra.templates.Template(false, "user id tidak ditemukan", null);
        }

        //set data untuk useradmin (update)
        userAdminbyId.setUsername(userAdminRequest.getUsername());
        userAdminbyId.setPassword(userAdminRequest.getPassword());
        userAdminbyId.setEmail(userAdminRequest.getEmail());
        userAdminbyId.setNamaLengkap(userAdminRequest.getNamaLengkap());
        userAdminbyId.setUpdateAt(LocalDateTime.now());

        //save data (update)
        UserAdmin.persist(userAdminbyId);

        //return template succes
        return new tech.candra.templates.Template(true, "succes", userAdminbyId);

    }

    @Transactional
    public Template deleteUser(Long id) {
        //mencari data berdasarkan id
        PanacheEntityBase byId = UserAdmin.findById(id);

        //validasi data berdasarkan id yang akan dihapus
        if (byId == null) {
            //return untuk data yang id nya tidak ditemukan
            return new tech.candra.templates.Template(false, "id user tidak ditemukan", null);
        }

        //return succes data yang berhasil dihapus
        UserAdmin.deleteById(id);
        return new tech.candra.templates.Template(true, "succes", null);
    }

    public Template getUser(Long id) {

        //mencari data berdasarkan id
        UserAdmin byId = UserAdmin.findById(id);

        //validasi data berdasarkan id yang akan ditampilkan
        if (byId == null) {
            //return untuk data yang id nya tidak ditemukan
            return new tech.candra.templates.Template(false, "id user tidak ditemukan", null);
        }
        //membuat hashmap untuk mapping data tertentu (agar password tidak muncul di response)
        HashMap<Object, Object> map = new HashMap<>();
        map.put("id", byId.getId());
        map.put("fullname", byId.getNamaLengkap());
        map.put("username", byId.getUsername());
        map.put("email", byId.getEmail());

        //return template succes
        return new tech.candra.templates.Template(true, "succes", map);
    }

    public Template getUserAll() {

        //mencari data useradmin keseluruhan
        List<UserAdmin> userAdminList = UserAdmin.listAll(Sort.ascending("id"));

        //membuat variabel listuser
        ArrayList<Object> listUser = new ArrayList<>();
        //mapping data response menggunakan perulangan for
        for (UserAdmin userAdmin : userAdminList) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", userAdmin.getId());
            map.put("fullname", userAdmin.getNamaLengkap());
            map.put("username", userAdmin.getUsername());
            map.put("email", userAdmin.getEmail());

            //setting data map menjadi list baru
            listUser.add(map);

        }
        //return response succes
        return new tech.candra.templates.Template(true, "succes", listUser);
    }

}
