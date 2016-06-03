package za.co.entelect.training.services.impl;

import org.springframework.stereotype.Service;
import za.co.entelect.training.domain.Course;
import za.co.entelect.training.domain.user.Trainee;
import za.co.entelect.training.domain.user.Trainer;
import za.co.entelect.training.services.TrainingService;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class TrainingServiceImpl implements TrainingService {

    private Set<Course> courses = new LinkedHashSet<>();
    private Set<Trainer> trainers = new LinkedHashSet<>();
    private Set<Trainee> trainees = new LinkedHashSet<>();

    public Course addCourse(String name, LocalDate start, LocalDate end) {
        Course course = new Course();
        course.setName(name);
        course.setStart(start);
        course.setEnd(end);

        courses.add(course);

        return course;
    }

    public Trainee addTrainee(String firstName, String lastName, String email, String password) {
        Trainee trainee = new Trainee();
        trainee.setFirstName(firstName);
        trainee.setLastName(lastName);
        trainee.setEmail(email);
        trainee.setPassword(password);

        trainees.add(trainee);

        return trainee;
    }

    public Trainer addTrainer(String firstName, String lastName, String email, String password) {
        Trainer trainer = new Trainer();
        trainer.setFirstName(firstName);
        trainer.setLastName(lastName);
        trainer.setEmail(email);
        trainer.setPassword(password);

        trainers.add(trainer);

        return trainer;
    }

    public Set<String> getCourses() {
        Set<String> courseNames = new LinkedHashSet<>();
        for (Course course : courses) {
            courseNames.add(course.getName());
        }

        return courseNames;
    }
}
