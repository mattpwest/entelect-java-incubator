package za.co.entelect.training;

import za.co.entelect.training.domain.Course;
import za.co.entelect.training.domain.Session;
import za.co.entelect.training.domain.user.Trainee;
import za.co.entelect.training.domain.user.Trainer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    private Set<Course> courses = new LinkedHashSet<>();
    private Set<Trainer> trainers = new LinkedHashSet<>();
    private Set<Trainee> trainees = new LinkedHashSet<>();

    private Main() {
        System.out.println("### Entelect Training Feedback ###");

        Trainer trainer1 = addTrainer("Matt", "Van Der Westhuizen", "matt@example.com", "test123");

        Trainee trainee1 = addTrainee("Christoff", "Smith", "christoff.smith@example.com", "test123");
        Trainee trainee2 = addTrainee("Yageshrin", "Govender", "yageshrin.govender@example.com", "test123");
        Trainee trainee3 = addTrainee("Ulrich", "Matthiae", "ulrich.matthiae@example.com", "test123");
        Trainee trainee4 = addTrainee("Pierre", "Roux", "pierre.roux@example.com", "test123");

        Course course = addCourse("Java Forum: JPA", LocalDate.of(2016, 5, 31), LocalDate.of(2016, 5, 31));
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

    private Course addCourse(String name, LocalDate start, LocalDate end) {
        Course course = new Course();
        course.setName(name);
        course.setStart(start);
        course.setEnd(end);

        courses.add(course);

        return course;
    }

    private Trainee addTrainee(String firstName, String lastName, String email, String password) {
        Trainee trainee = new Trainee();
        trainee.setFirstName(firstName);
        trainee.setLastName(lastName);
        trainee.setEmail(email);
        trainee.setPassword(password);

        trainees.add(trainee);

        return trainee;
    }

    private Trainer addTrainer(String firstName, String lastName, String email, String password) {
        Trainer trainer = new Trainer();
        trainer.setFirstName(firstName);
        trainer.setLastName(lastName);
        trainer.setEmail(email);
        trainer.setPassword(password);

        trainers.add(trainer);

        return trainer;
    }
}
