package ma.enset.patientmvc.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //spring security utilise par défaut BCrypt
    /*
    * 2 sol:
    * 1- {noop}directement auprés pwd
    * 2- utiliser BCryptPasswordEncoder*/
    @Override //pour spécifier ou sont les utilisateurs==> en BDD, en mem, en file txt
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
        //pour spécifier d'une manière statique qui sont les users d'app
        auth.inMemoryAuthentication().withUser("admin").password(bcpe.encode("123")).roles("ADMIN","USER");
        auth.inMemoryAuthentication().withUser("user").password("{noop}123").roles("USER");
        auth.inMemoryAuthentication().passwordEncoder(bcpe);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}
