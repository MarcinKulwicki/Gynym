//package pl.coderslab.security;
//
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class WebSecurity extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
////                .withUser("user1").password("qwerty").roles("USER")
////                .and()
//                .withUser("admin").password("admin").roles("ADMIN");
//
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//       //http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//        http.authorizeRequests()//.antMatchers("/admin/**").hasRole("ADMIN")
//                .regexMatchers("/admin.*").hasRole("ADMIN")
//                .anyRequest().permitAll()
//                .and()
//                .httpBasic();
//    }
//
//}
