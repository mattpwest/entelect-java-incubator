package za.co.entelect.training.persistence.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import za.co.entelect.training.domain.user.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("SELECT CONCAT(u.firstName, ' ', u.lastName) FROM User u WHERE u.id = :id")
    String getFullName(@Param("id") Long id);
}
