package za.co.entelect.training.persistence.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import za.co.entelect.training.domain.user.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
