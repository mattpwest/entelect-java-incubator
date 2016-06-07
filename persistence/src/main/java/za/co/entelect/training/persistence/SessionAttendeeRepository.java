package za.co.entelect.training.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import za.co.entelect.training.domain.SessionAttendee;

public interface SessionAttendeeRepository extends PagingAndSortingRepository<SessionAttendee, Long> {
}
