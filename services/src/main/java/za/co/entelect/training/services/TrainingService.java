package za.co.entelect.training.services;

import za.co.entelect.training.domain.Course;
import za.co.entelect.training.domain.user.User;

import java.time.LocalDate;
import java.util.Set;

public interface TrainingService {
    Course addCourse(String name, LocalDate startDate, LocalDate endDate);
    User addTrainer(String firstName, String lastName, String email, String password);
    User addTrainee(String firstName, String lastName, String email, String password);

    Set<String> getCourses();
}
