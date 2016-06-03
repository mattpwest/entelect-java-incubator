package za.co.entelect.training.services;

import za.co.entelect.training.domain.Course;
import za.co.entelect.training.domain.user.Trainee;
import za.co.entelect.training.domain.user.Trainer;

import java.time.LocalDate;
import java.util.Set;

public interface TrainingService {
    Course addCourse(String name, LocalDate startDate, LocalDate endDate);
    Trainer addTrainer(String firstName, String lastName, String email, String password);
    Trainee addTrainee(String firstName, String lastName, String email, String password);

    Set<String> getCourses();
}
