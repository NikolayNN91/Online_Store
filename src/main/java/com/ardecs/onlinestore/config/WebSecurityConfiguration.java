package com.ardecs.onlinestore.config;

import com.ardecs.onlinestore.entity.User;
import com.ardecs.onlinestore.repository.UserJpaRepository;
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

//    @Autowired
//    private DataSource dataSource;


    @Autowired
    protected void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {

//        auth.userDetailsService(userDetailsService);

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

        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER");
//                .and()
//                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    //.csrf().disable()
                .authorizeRequests()
                .antMatchers("/home", "/registration", "/product", "/contacts").permitAll()
                .antMatchers("/admin/**").hasRole("1")
                //.antMatchers("/myBasket").hasRole("0")
                .anyRequest().authenticated()
                .and()

                .formLogin()
                .loginPage("/authorization")
                .successForwardUrl("/home")
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

//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider
//                = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
////        authProvider.setPasswordEncoder(encoder());
//        return authProvider;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //
//    @Component
//    public class CustomUserDetailService implements UserDetailsService {
//
//        @Autowired
//        UserJpaRepository userJpaRepository;
//
//        @Override
//        public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//            User user = userJpaRepository.findByLogin(login);
//            if (user == null) {
//                throw new RuntimeException("Not exist user with login: " + login);
//            }
//            return new org.springframework.security.core.userdetails.User(
//                    user.getLogin(),
//                    user.getPassword(),
//                    AuthorityUtils.commaSeparatedStringToAuthorityList("" + user.getIsAdmin())
//            );
////                return new CustomUserDetails(user);
//
//        }
//    }

//    @Service
//    public class CustomUserDetails extends User implements UserDetails {
//
//        public CustomUserDetails(User user) {
//            super(user.getLogin(), user.getPassword(), user.getName(), user.getIsAdmin());
//        }
//
//        @Override
//        @Bean
//        public Collection<GrantedAuthority> getAuthorities() {
//            String roles = "" + getIsAdmin();
//            return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
//        }
//
//        @Override
//        public String getUsername() {
//            return super.getLogin();
//        }
//
//        @Override
//        public boolean isAccountNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isAccountNonLocked() {
//            return true;
//        }
//
//        @Override
//        public boolean isCredentialsNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isEnabled() {
//            return true;
//        }
//
//    }
}

