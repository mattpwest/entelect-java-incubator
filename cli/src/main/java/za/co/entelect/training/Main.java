package za.co.entelect.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import za.co.entelect.training.cli.CommandLineInterface;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(CLIConfig.class);
        CommandLineInterface cli = ctx.getBean(CommandLineInterface.class);
        cli.execute();
    }
}
