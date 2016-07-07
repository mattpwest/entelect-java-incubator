package za.co.entelect.training.config;

        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.Import;
        import za.co.entelect.training.services.ServicesConfig;

@Configuration
@Import({ServicesConfig.class})
public class RootConfig {
}
