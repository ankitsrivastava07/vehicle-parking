package carparking.security_config;
import carparking.security_config.authentication_provider.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity(debug=true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired UserDetailsService userDetailsService;
    @Autowired CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
      httpSecurity.csrf().disable().cors().disable().authorizeRequests()
        .antMatchers("/dashboard/*","/admin","/admin/*","/","/easyparking","/sign-in","/sign-up","/health","/info","/Beans","/api/v1/user/*")

        .permitAll().antMatchers("/api/v1/admin/*").permitAll()
              .anyRequest().authenticated()
         .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /*@Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService);
    }
*/
    @Override
     public void configure(WebSecurity webSecurity){
        webSecurity.ignoring().antMatchers("/assets/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
       authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider);
    }

}
