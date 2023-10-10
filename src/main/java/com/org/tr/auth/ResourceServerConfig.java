
package com.org.tr.auth;
//se encarga de dar acceso a los clientes a los recursos de nuestra aplicacion siempre y cuando el token enviado en la 
//cabecera sea valido
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer//con esto habilitamos el servidor de recursos
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/generos/**").permitAll()
                .antMatchers("/roles-familia/**").permitAll()
                .antMatchers("/usuarios/**").permitAll()
                .antMatchers("/menus/**").authenticated()
                /*.antMatchers(HttpMethod.GET,"/pacientes/{id}").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.POST,"/pacientes").hasRole("ADMIN")
                .antMatchers("/pacientes/**").hasRole("ADMIN") NOTA: OTRA  FORMA CON ANOTACIONES EN EL CONTROLLER*/
                .anyRequest().authenticated(); //siempre al final
    }
    
    
    
}
