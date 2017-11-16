package transport.mangement.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author SAIKUMAR 
 * 
 * Main CLass for running the Servlet Container.
 *
 */
@SpringBootApplication
public class TransportationApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TransportationApplication.class, args);
	}

}
