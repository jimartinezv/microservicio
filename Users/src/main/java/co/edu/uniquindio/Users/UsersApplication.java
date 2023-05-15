package co.edu.uniquindio.Users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {
		System.out.println("pass "+ new BCryptPasswordEncoder().encode("asosap"));
		SpringApplication.run(UsersApplication.class, args);
	}

}
