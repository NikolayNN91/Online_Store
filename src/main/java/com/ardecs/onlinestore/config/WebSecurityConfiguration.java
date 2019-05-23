package com.ardecs.onlinestore.config;

import com.ardecs.onlinestore.entity.User;
import com.ardecs.onlinestore.repository.UserJpaRepository;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.util.*;


@Configuration
//@EnableWebMvc
@EnableWebSecurity
//@ComponentScan(basePackages = "com.ardecs.onlinestore.config")
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private CurrentUser currentUser;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

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
                .antMatchers("/admin/**").hasRole("1")
                .antMatchers("/myBasket", "/myBasket/**").hasRole("0")
                .antMatchers("/", "/home", "/registration", "/product", "/contacts", "/css/**").permitAll()
//                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()

                .formLogin()
                //.loginPage("/login")
                .loginPage("/authorization")
                .failureForwardUrl("/error")
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

//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return new BCryptPasswordEncoder();
    }


    @Component
    public class CustomUserDetailService implements UserDetailsService {

//        private User user;

        @Autowired
        UserJpaRepository userJpaRepository;

//        public User getCurrentUser() {
//            return user;
//        }

        @Override
        public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
            User user = userJpaRepository.findByLogin(login);
            if (user == null) {
                throw new UsernameNotFoundException("Not exist user with login: " + login);
            }
//            currentUser.setUser(user);
            String role = "ROLE_" + user.getIsAdmin();
            return new org.springframework.security.core.userdetails.User(
                    user.getLogin(),
                    user.getPassword(),
                    AuthorityUtils.commaSeparatedStringToAuthorityList(role)
            );
        }
    }

    @Component
//    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public class CurrentUser {

        public Object getUser() {
//            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//            if ( principal instanceof UserDetails) {
//                return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            } else {
//                throw new IllegalStateException("Principal is not UserDetails");
//            }
            return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
    }
}


