package za.co.entelect.training.domain;

import za.co.entelect.training.domain.user.Trainee;
import za.co.entelect.training.domain.user.Trainer;

import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

public class Session {

    private String name;

    private LocalTime start;

    private LocalTime end;

    private Set<Trainer> presenters = new LinkedHashSet<>();

    private Set<SessionAttendee> attendees = new LinkedHashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Trainer> getPresenters() {
        return presenters;
    }

    public void setPresenters(Set<Trainer> presenters) {
        this.presenters = presenters;
    }

    public Set<SessionAttendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<SessionAttendee> attendees) {
        this.attendees = attendees;
    }

    public void addPresenter(Trainer trainer) {
        presenters.add(trainer);
    }

    protected SessionAttendee findOrCreateAttendee(Trainee trainee) {
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

    public void recordAttendance(Trainee trainee) {
        SessionAttendee attendee = findOrCreateAttendee(trainee);

        attendee.setAttended(true);
    }

    public void recordFeedback(Trainee trainee, Byte stars, String feedback) {
        SessionAttendee attendee = findOrCreateAttendee(trainee);

        attendee.setAttended(true);
        attendee.setStars(stars);
        attendee.setFeedback(feedback);
    }
}
