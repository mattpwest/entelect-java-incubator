package za.co.entelect.training.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import za.co.entelect.training.domain.Session;

public interface SessionRepository extends PagingAndSortingRepository<Session, Long> {
}
