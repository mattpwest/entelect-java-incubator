package za.co.entelect.training;

import org.junit.Before;
import org.junit.Test;
import za.co.entelect.training.domain.Course;
import za.co.entelect.training.domain.Session;
import za.co.entelect.training.domain.user.Trainee;
import za.co.entelect.training.domain.user.Trainer;
import za.co.entelect.training.services.TrainingService;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class MainTest {

    private TrainingService trainingServiceMock = mock(TrainingService.class);
    private Course courseMock = mock(Course.class);
    private Session sessionMock = mock(Session.class);
    private Main classUnderTest = new Main(trainingServiceMock);

    @Before
    public void setUp() {
        reset(trainingServiceMock);
        reset(courseMock);
        reset(sessionMock);

        when(trainingServiceMock.addCourse(any(String.class), any(LocalDate.class), any(LocalDate.class)))
                .thenReturn(courseMock);

        when(trainingServiceMock.addTrainee(any(String.class), any(String.class), any(String.class), any(String.class)))
                .thenReturn(mock(Trainee.class));

        when(courseMock.addSession(any(String.class), any(LocalTime.class), any(LocalTime.class)))
                .thenReturn(sessionMock);

        when(courseMock.getReport())
                .thenReturn("Mock report!");
    }

    @Test
    public void testAddsTrainer() {
        classUnderTest.execute();

        verify(trainingServiceMock, times(1))
                .addTrainer(any(String.class), any(String.class), any(String.class), any(String.class));
    }

    @Test
    public void testAddsTrainees() {
        classUnderTest.execute();

        verify(trainingServiceMock, times(4))
                .addTrainee(any(String.class), any(String.class), any(String.class), any(String.class));
    }

    @Test
    public void testAddsTraineesToCourse() {
        classUnderTest.execute();

        verify(courseMock, times(4))
                .addTrainee(any(Trainee.class));
    }

    @Test
    public void testAddsSessionToCourse() {
        classUnderTest.execute();

        verify(courseMock, times(1))
                .addSession(any(String.class), any(LocalTime.class), any(LocalTime.class));
    }

    @Test
    public void testAddsPresenterToSession() {
        classUnderTest.execute();

        verify(sessionMock, times(1))
                .addPresenter(any(Trainer.class));
    }

    @Test
    public void testSessionFeedbackRecorded() {
        classUnderTest.execute();

        verify(sessionMock, times(2))
                .recordFeedback(any(Trainee.class), any(Byte.class), any(String.class));
    }

    @Test
    public void testSessionAttendanceRecorded() {
        classUnderTest.execute();

        verify(sessionMock, times(1))
                .recordAttendance(any(Trainee.class));
    }
}
