package com.ardecs.onlinestore.config;

import com.ardecs.onlinestore.entity.User;
import com.ardecs.onlinestore.repository.UserJpaRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.util.*;


@Configuration
@EnableWebSecurity
//@ComponentScan(basePackages = "com.ardecs.onlinestore.config")
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CurrentUser currentUser;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

//auth.authenticationProvider(authenticationProvider());
//        auth.
//        auth    .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select login, password"
//                                    +  "from users where login=?")
//                .authoritiesByUsernameQuery("select login, is_admin"
//                                       +  "from users where login=?")
//                .passwordEncoder(passwordEncoder());
//

//        auth.inMemoryAuthentication()
//                .withUser("login").password("password").roles("1");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/admin", "/home", "/registration", "/product", "/contacts", "/css/**", "/admin/**", "/myBasket", "/myBasket/**").permitAll()
//                .antMatchers("/admin/**").hasRole("1")
//                .antMatchers("/myBasket").hasAnyRole()
                .anyRequest().authenticated()
                .and()

                .formLogin()
                //.loginPage("/login")
//                .loginPage("/authorization")
//                .successForwardUrl("/home")
                .permitAll()
                .and()

                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/authorization")
                //.logoutSuccessHandler(logoutSuccessHandler)
                .invalidateHttpSession(true)     //true by default анулировать HttpSession
                //.addLogoutHandler(logoutHandler)
                //.deleteCookies(cookieNamesToClear)
                .permitAll();

    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Component
    public class CustomUserDetailService implements UserDetailsService {

        private User user;

        @Autowired
        UserJpaRepository userJpaRepository;

        public User getCurrentUser() {
            return user;
        }

        @Override
        public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
            user = userJpaRepository.findByLogin(login);
            if (user == null) {
                throw new RuntimeException("Not exist user with login: " + login);
            }
            currentUser.setUser(user);
            return new org.springframework.security.core.userdetails.User(
                    user.getLogin(),
                    user.getPassword(),
                    AuthorityUtils.commaSeparatedStringToAuthorityList("" + user.getIsAdmin())
            );
        }
    }

    @Component
    @Data
    public class CurrentUser {

        private User user;

    }
}


