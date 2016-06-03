package za.co.entelect.training;

import za.co.entelect.training.domain.Course;
import za.co.entelect.training.domain.Session;
import za.co.entelect.training.domain.user.Trainee;
import za.co.entelect.training.domain.user.Trainer;
import za.co.entelect.training.services.TrainingService;
import za.co.entelect.training.services.impl.TrainingServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        TrainingService trainingService = new TrainingServiceImpl();
        Main main = new Main(trainingService);
        main.execute();
    }

    private TrainingService trainingService;

    Main(TrainingService injectedTrainingService) {
        this.trainingService = injectedTrainingService;
    }

    void execute() {
        System.out.println("### Entelect Training Feedback ###");

        Trainer trainer1 = trainingService.addTrainer("Matt", "Van Der Westhuizen", "matt@example.com", "test123");

        Trainee trainee1 = trainingService.addTrainee("Christoff", "Smith", "christoff.smith@example.com", "test123");
        Trainee trainee2 = trainingService.addTrainee("Yageshrin", "Govender", "yageshrin.govender@example.com", "test123");
        Trainee trainee3 = trainingService.addTrainee("Ulrich", "Matthiae", "ulrich.matthiae@example.com", "test123");
        Trainee trainee4 = trainingService.addTrainee("Pierre", "Roux", "pierre.roux@example.com", "test123");

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
