package za.co.entelect.training.domain;

import za.co.entelect.training.domain.common.IdentifiableEntity;
import za.co.entelect.training.domain.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Session extends IdentifiableEntity implements Serializable {

    public static final long serialVersionUID = 1L;

    private String name;

    @Column(columnDefinition = "DATE")
    private LocalDate date;

    @Column(columnDefinition = "TIME")
    private LocalTime start;

    @Column(columnDefinition = "TIME")
    private LocalTime end;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Course")
    private Course course;

    @ManyToMany
    @JoinTable(name = "SessionPresenters",
            joinColumns = {@JoinColumn(name = "Session", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "User", referencedColumnName = "id")})
    private Set<User> presenters = new LinkedHashSet<>();

    @OneToMany(mappedBy = "session")
    private Set<SessionAttendee> attendees = new LinkedHashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public Set<User> getPresenters() {
        return presenters;
    }

    public void setPresenters(Set<User> presenters) {
        this.presenters = presenters;
    }

    public Set<SessionAttendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<SessionAttendee> attendees) {
        this.attendees = attendees;
    }

    public void addPresenter(User trainer) {
        presenters.add(trainer);
    }

    protected SessionAttendee findOrCreateAttendee(User trainee) {
        SessionAttendee attendee = null;
        for (SessionAttendee anAttendee : attendees) {
            if (anAttendee.getTrainee().equals(trainee)) {
                attendee = anAttendee;
            }
        }

        if (attendee == null) {
            attendee = new SessionAttendee();
            attendee.setTrainee(trainee);
            attendees.add(attendee);
        }

        return attendee;
    }

    public void recordAttendance(User trainee) {
        SessionAttendee attendee = findOrCreateAttendee(trainee);

        attendee.setAttended(true);
    }

    public void recordFeedback(User trainee, Byte stars, String feedback) {
        SessionAttendee attendee = findOrCreateAttendee(trainee);

        attendee.setAttended(true);
        attendee.setStars(stars);
        attendee.setFeedback(feedback);
    }
}
