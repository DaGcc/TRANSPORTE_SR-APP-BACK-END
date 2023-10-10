package com.org.tr.auth;



import com.org.tr.model.Usuario;
import com.org.tr.service.IUsuarioService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

@Component                                
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired 
    private IUsuarioService usuarioService;
    
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accesToken, OAuth2Authentication authentication) {
        Usuario usuario = usuarioService.findByEmail(authentication.getName());
        
        Map<String, Object> info = new HashMap<>();
        info.put("info_adicional", "Hola que tal!: ".concat(authentication.getName()));
        info.put("id_usuario", usuario.getIdUsuario());
        info.put("email", usuario.getEmail());
        info.put("fecha_creacion", usuario.getFechaCreacion().toString());
        
        ((DefaultOAuth2AccessToken) accesToken).setAdditionalInformation(info);
        
        return accesToken;
    }

}
