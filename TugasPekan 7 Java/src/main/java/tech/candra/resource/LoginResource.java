package tech.candra.resource;

import org.eclipse.microprofile.openapi.annotations.Operation;
import tech.candra.dto.LoginRequest;
import tech.candra.service.LoginService;
import tech.candra.templates.Template;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/auth/login")
public class LoginResource {
    @Inject
    LoginService loginService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Login", description = "Silahkan masukan username dan password")
    public Template login(LoginRequest loginRequest) {

        Template response = loginService.login(loginRequest);
        return response;

    }
}
