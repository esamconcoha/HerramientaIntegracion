package com.react.Utils;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthorizeUtil {

    private static final Log LOGGER = LogFactory.getLog(AuthorizeUtil.class);
    private static String rolesAllow[];


    @Autowired
    private HttpServletRequest request;
    @Value("${user.seguridad}")
    private String userProp;

    @Value("${password.seguridad}")
    private String passwordProp;

    private static String user;
    private static String password;


    @PostConstruct
    public void init() {
        user = userProp;
        password = passwordProp;
    }


    public void validCredentials() throws RuntimeException {

        System.out.println("entra al metodo validCredentials");
        String cred[] = RequestUtil.extraerCredenciales(request.getHeader("Authorization"));

        if (cred == null) {
            LOGGER.info("No ingreso credenciales");
            throw new  RuntimeException("No ingreso credenciales");
        }

        String user = cred[0];
        String password = cred[1];
        LOGGER.info("Usuario: " + user + " Password: " + password + " User: " + this.user + " Password: " + this.password);
        if (user.equals(this.user) && password.equals(this.password)) {
        } else {
            LOGGER.info("Credenciales invalidas");
            throw new RuntimeException("Credenciales invalidas");
        }

    }

}
