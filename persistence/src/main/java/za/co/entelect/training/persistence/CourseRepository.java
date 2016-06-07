package za.co.entelect.training.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import za.co.entelect.training.domain.Course;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}
