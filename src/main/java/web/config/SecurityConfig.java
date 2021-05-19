package web.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder())
									.usersByUsernameQuery("select username, password, enabled from account where username=?")
									.authoritiesByUsernameQuery("select username, role_id from account where username=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").authenticated().antMatchers("/list").hasAuthority("1")
        .antMatchers("/report/new_join").hasAuthority("1")
        .antMatchers("/config").hasAuthority("1")
        .antMatchers("/report/paid").hasAuthority("1")
        .antMatchers("/report/revenue").hasAuthority("1")
        .and().formLogin().permitAll()
        .and().logout().logoutSuccessUrl("/").permitAll();
	}
}
