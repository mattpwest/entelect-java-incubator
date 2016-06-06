package za.co.entelect.training.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.training.domain.Course;
import za.co.entelect.training.domain.user.User;
import za.co.entelect.training.persistence.user.UserRepository;
import za.co.entelect.training.services.TrainingService;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class TrainingServiceImpl implements TrainingService {

    private Set<Course> courses = new LinkedHashSet<>();
    private UserRepository userRepository;

    @Autowired
    public TrainingServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Course addCourse(String name, LocalDate start, LocalDate end) {
        Course course = new Course();
        course.setName(name);
        course.setStart(start);
        course.setEnd(end);

        courses.add(course);

        return course;
    }

    @Transactional
    public User addTrainee(String firstName, String lastName, String email, String password) {
        User trainee = new User();
        trainee.setFirstName(firstName);
        trainee.setLastName(lastName);
        trainee.setEmail(email);
        trainee.setPassword(password);

        userRepository.save(trainee);

        return trainee;
    }

    @Transactional
    public User addTrainer(String firstName, String lastName, String email, String password) {
        User trainer = new User();
        trainer.setFirstName(firstName);
        trainer.setLastName(lastName);
        trainer.setEmail(email);
        trainer.setPassword(password);

        userRepository.save(trainer);

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
