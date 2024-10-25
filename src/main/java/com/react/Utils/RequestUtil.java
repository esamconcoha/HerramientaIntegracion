package com.react.Utils;

import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class RequestUtil {

    /**
     * Metodo para obtener usuario y contrasenia del encabezado de la peticion
     * @param pAuthHeader
     * @return
     */
    public static String[] extraerCredenciales(String pAuthHeader) {
        if (pAuthHeader == null)
            return null;
        String authHeader = pAuthHeader.trim();
        authHeader = StringUtils.delete(pAuthHeader, "Basic ");
        if (StringUtils.isEmpty(authHeader))
            return null;
        try {
            byte[] decodeBytes = Base64.getDecoder().decode(authHeader);
            authHeader = new String(decodeBytes, "UTF-8");
            String[] split = authHeader.split(":");
            if (StringUtils.isEmpty(split[0]) || StringUtils.isEmpty(split[1]))
                return null;
            return split;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }

}
