package za.co.entelect.training.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Set;

public class CourseTest {

    @Test
    public void testAddSession() {
        Course course = new Course();
        Session session = course.addSession("test", LocalTime.MIDNIGHT, LocalTime.MIDNIGHT);
        Set<Session> sessions = course.getSessions();

        Assert.assertNotNull("new session should not be null", session);
        Assert.assertNotNull("course sessions should not be null", sessions);
        Assert.assertEquals("course sessions should contain 1 item", 1, sessions.size());
    }
}
