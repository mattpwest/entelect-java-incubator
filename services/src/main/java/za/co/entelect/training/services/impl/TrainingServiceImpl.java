package za.co.entelect.training.services.impl;

import org.springframework.stereotype.Service;
import za.co.entelect.training.domain.Course;
import za.co.entelect.training.domain.user.User;
import za.co.entelect.training.services.TrainingService;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class TrainingServiceImpl implements TrainingService {

    private Set<Course> courses = new LinkedHashSet<>();
    private Set<User> trainers = new LinkedHashSet<>();
    private Set<User> trainees = new LinkedHashSet<>();

    public Course addCourse(String name, LocalDate start, LocalDate end) {
        Course course = new Course();
        course.setName(name);
        course.setStart(start);
        course.setEnd(end);

        courses.add(course);

        return course;
    }

    public User addTrainee(String firstName, String lastName, String email, String password) {
        User trainee = new User();
        trainee.setFirstName(firstName);
        trainee.setLastName(lastName);
        trainee.setEmail(email);
        trainee.setPassword(password);

        trainees.add(trainee);

        return trainee;
    }

    public User addTrainer(String firstName, String lastName, String email, String password) {
        User trainer = new User();
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
