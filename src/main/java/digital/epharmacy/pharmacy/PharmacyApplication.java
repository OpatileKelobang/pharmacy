package digital.epharmacy.pharmacy;

import digital.epharmacy.pharmacy.config.MyIntercepter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.MappedInterceptor;

@SpringBootApplication
public class PharmacyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmacyApplication.class, args);
    }

    @Bean
    public MappedInterceptor myMappedInterceptor(){
        return new MappedInterceptor(new String[]{"/**"}, new MyIntercepter());
    }

}
