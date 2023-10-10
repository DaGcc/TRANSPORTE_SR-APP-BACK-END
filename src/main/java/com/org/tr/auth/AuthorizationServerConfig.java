package com.org.tr.auth;

//este se encarga del proceso de autenticacion por el lado de oauth2 con el token jwt
//desde el proceso de login y crear el token y validarlo

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer 
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    @Qualifier("authenticationManager")//qualifier es un calificador
    private AuthenticationManager authenticationManager;
    
    
    @Autowired
    private InfoAdicionalToken infoAdicionalToken;
    
    
    /**
     * aqui se configura los permiso de nuestros endpoints del authorizationServer 
     * que se encarga del proceso de autenticacion con el username y password.
     *
     * @param endpoints
     * @throws java.lang.Exception */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //recuperamos los datos adicionales que agregamos 
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken,accessTokenConverter()));
        
        endpoints.authenticationManager(authenticationManager) 
        .tokenStore(tokenStore()) 
        .accessTokenConverter(accessTokenConverter())
        .tokenEnhancer(tokenEnhancerChain);
        super.configure(endpoints);
    }
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        
        clients.inMemory().withClient("tr")  
                .secret(passwordEncoder.encode("12345"))
                .scopes("read","write") 
                .authorizedGrantTypes("password","refresh_token") 
                .accessTokenValiditySeconds(3800) 
                .refreshTokenValiditySeconds(3800);
    }
    
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()") //le damos permiso a cualquier usuario ya sea anonimo o no para que pueda autenticarse, y generar TOKEN
                .checkTokenAccess("isAuthenticated()");//darl permiso al endpoint para VALIDAR TOKEN  
    }
      
   
    @Bean   
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVADA); //EL QUE FIRMA EL TOKEN
        jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLICA);//EL QUE VALIDA QUE EL TOKEN SEA VALIDO Y NO MODIFICADO   
        return jwtAccessTokenConverter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter()); 
    }
   
   
}
