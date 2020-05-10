package info.revenberg.uploader;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
//import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// http://localhost:8099/invokejob
// http://localhost:8099/restart
// mvn spring-boot:run

//@SpringBootApplication
@EnableAutoConfiguration // Spring Boot Auto Configuration
@EnableBatchProcessing

@SpringBootApplication(scanBasePackages = { "info.revenberg.uploader" })
@ComponentScan(basePackages = { "info.revenberg" } )
//@ConfigurationPropertiesScan("info.revenberg.uploader.properties")
@EnableJpaRepositories( { "info.revenberg.uploader.objects" } ) 
@EntityScan(basePackages = { "info.revenberg.uploader.objects" })


public class SpringBatchLoaderApplication {

//	private static ConfigurableApplicationContext context;	
	public static void main(String[] args) {
        //context = 
         SpringApplication.run(SpringBatchLoaderApplication.class, args);
	}

/*	public static void restart() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);
 
        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(SpringBatchLoaderApplication.class, args.getSourceArgs());
        });
 
        thread.setDaemon(false);
        thread.start();
    }
 */
}