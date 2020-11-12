package digital.epharmacy.pharmacy;

import digital.epharmacy.pharmacy.config.MyIntercepter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

@SpringBootApplication
public class PharmacyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmacyApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200", "http://localhost:3000", "https://epharmacy-online.herokuapp.com", "https://amahlathini.github.io/admin-dashboard", "https://vibekonnect.tech/admin-dashboard");
            }
        };
    }

    @Bean
    public MappedInterceptor myMappedInterceptor(){
        return new MappedInterceptor(new String[]{"/**"}, new MyIntercepter());
    }

}
