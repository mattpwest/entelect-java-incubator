package za.co.entelect.training.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(
    basePackages = "za.co.entelect.training.services",
    includeFilters = @ComponentScan.Filter(Service.class)
)
public class ServicesConfig {
}
