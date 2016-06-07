package za.co.entelect.training.persistence;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import za.co.entelect.training.persistence.common.PersistenceTestBase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class SessionRepositoryTest extends PersistenceTestBase {

    @Autowired
    private SessionRepository repoUnderTest;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testReadViaRepository() {
        Assert.assertTrue("initial test data should include at least 1 session", repoUnderTest.count() > 0);
    }
}
