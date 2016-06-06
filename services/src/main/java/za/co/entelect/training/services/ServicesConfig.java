package za.co.entelect.training.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import za.co.entelect.training.persistence.JPAConfig;

@Configuration
@ComponentScan(
    basePackages = "za.co.entelect.training.services",
    includeFilters = @ComponentScan.Filter(Service.class)
)
@Import({
    JPAConfig.class
})
public class ServicesConfig {
}
