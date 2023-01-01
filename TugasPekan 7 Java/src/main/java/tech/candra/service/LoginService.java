package tech.candra.service;

import tech.candra.dto.LoginRequest;
import tech.candra.models.UserAdmin;
import tech.candra.templates.Template;
import tech.candra.util.JwtUtil;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LoginService {
    public Template login(LoginRequest loginRequest){
        UserAdmin byUserAdmin = UserAdmin.findbyUsername(loginRequest.getUsername());
        if (byUserAdmin==null){
            return new tech.candra.templates.Template(false, "gagal login", null);
        }
        if(!loginRequest.getPassword().equals(byUserAdmin.getPassword())){
            return new tech.candra.templates.Template(false, "gagal login", null);
        }
        System.out.println("create token");
        String token = JwtUtil.generateToken(byUserAdmin);
        return new tech.candra.templates.Template(true, "succes", token);
    }
}
