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
public class Course extends IdentifiableEntity implements Serializable {

    public static final long serialVersionUID = 1L;

    private String name;

    @Column(columnDefinition = "DATE")
    private LocalDate start;

    @Column(columnDefinition = "DATE")
    private LocalDate end;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<Session> sessions = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "CourseAttendee",
                joinColumns = {@JoinColumn(name = "Course", referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "User", referencedColumnName = "id")})
    private Set<User> trainees = new LinkedHashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    public Set<User> getTrainees() {
        return trainees;
    }

    public void setTrainees(Set<User> trainees) {
        this.trainees = trainees;
    }

    public Session addSession(String name, LocalTime start, LocalTime end) {
        Session session = new Session();
        session.setName(name);
        session.setStart(start);
        session.setEnd(end);

        sessions.add(session);

        return session;
    }

    public void addTrainee(User trainee) {
        trainees.add(trainee);
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        sb.append("# Course: ").append(name).append("\n");

        for (Session session : sessions) {
            sb.append("## Session: ").append(session.getName()).append("\n");

            Integer totalRating = 0;
            Integer countRaters = 0;
            for (SessionAttendee attendee : session.getAttendees()) {
                if (attendee.getStars() != null) {
                    totalRating += attendee.getStars();
                    countRaters++;
                }
            }

            sb.append("Attendance: ").append(session.getAttendees().size()).append(" / ") .append(getTrainees().size())
                    .append("\n");

            double avgRating = totalRating / (double) countRaters;
            sb.append("Avg. Rating: ").append(avgRating).append(" from ").append(countRaters).append(" raters")
                    .append("\n");

            sb.append("\n");
        }

        return sb.toString();
    }
}
