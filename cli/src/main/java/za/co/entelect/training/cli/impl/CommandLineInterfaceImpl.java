package za.co.entelect.training.cli.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.entelect.training.cli.CommandLineInterface;
import za.co.entelect.training.domain.Course;
import za.co.entelect.training.domain.Session;
import za.co.entelect.training.domain.user.User;
import za.co.entelect.training.services.TrainingService;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class CommandLineInterfaceImpl implements CommandLineInterface {

    private TrainingService trainingService;

    @Autowired
    public CommandLineInterfaceImpl(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @Override
    public void execute() {
        System.out.println("### Entelect Training Feedback ###");

        User trainer1 = trainingService.addTrainer("Matt", "Van Der Westhuizen", "matt@example.com", "test123");

        User trainee1 = trainingService.addTrainee("Christoff", "Smith", "christoff.smith@example.com", "test123");
        User trainee2 = trainingService.addTrainee("Yageshrin", "Govender", "yageshrin.govender@example.com", "test123");
        User trainee3 = trainingService.addTrainee("Ulrich", "Matthiae", "ulrich.matthiae@example.com", "test123");
        User trainee4 = trainingService.addTrainee("Pierre", "Roux", "pierre.roux@example.com", "test123");

        Course course = trainingService.addCourse("Java Forum: JPA", LocalDate.of(2016, 5, 31), LocalDate.of(2016, 5, 31));
        course.addTrainee(trainee1);
        course.addTrainee(trainee2);
        course.addTrainee(trainee3);
        course.addTrainee(trainee4);

        Session session = course.addSession("Only session", LocalTime.of(17,0), LocalTime.of(19,0));
        session.addPresenter(trainer1);

        session.recordFeedback(trainee1, (byte) 4, "Good stuff!");
        session.recordAttendance(trainee2);
        session.recordFeedback(trainee3, (byte) 1, "Has no idea what he's talking about!");

        System.out.println(course.getReport());
    }
}
