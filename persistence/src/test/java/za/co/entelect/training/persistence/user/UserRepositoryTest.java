package za.co.entelect.training.persistence.user;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import za.co.entelect.training.domain.user.User;
import za.co.entelect.training.persistence.common.PersistenceTestBase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class UserRepositoryTest extends PersistenceTestBase {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testReadViaRepository() {
        Assert.assertTrue("initial test data should include at least 1 user", userRepository.count() > 0);
    }

    @Test
    public void testReadViaEntityManager() {
        Long count = countUsers();

        Assert.assertTrue("initial test data should include at least 1 user readable by entityManager", count > 0L);
    }

    @Test
    public void testInsertion() {
        // Given
        Long initialCount = countUsers();

        // When
        User user = new User();
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmail("test@example.com");
        user.setPassword("test123");
        userRepository.save(user);

        // Then
        Long countAfterInsert = countUsers();
        Assert.assertTrue("user count should increase after insertion", countAfterInsert > initialCount);
    }

    @Test
    public void testGetFullName() {
        String fullName = userRepository.getFullName(1L);

        Assert.assertEquals("should return first name space last name", "Ser Admin", fullName);
    }

    private Long countUsers() {
        Query query = entityManager.createQuery("SELECT COUNT(u.id) FROM User u");
        Long count = (Long) query.getSingleResult();
        return count;
    }
}
