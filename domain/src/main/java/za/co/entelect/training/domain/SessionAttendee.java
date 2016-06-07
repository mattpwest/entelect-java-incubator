package za.co.entelect.training.domain;

import za.co.entelect.training.domain.common.IdentifiableEntity;
import za.co.entelect.training.domain.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class SessionAttendee extends IdentifiableEntity implements Serializable {

    public static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Session")
    private Session session;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Trainee")
    private User trainee;

    private Boolean attended = false;

    @Column(nullable = true)
    private Byte stars = null;

    @Column(nullable = true)
    private String feedback;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public User getTrainee() {
        return trainee;
    }

    public void setTrainee(User trainee) {
        this.trainee = trainee;
    }

    public Boolean getAttended() {
        return attended;
    }

    public void setAttended(Boolean attended) {
        this.attended = attended;
    }

    public Byte getStars() {
        return stars;
    }

    public void setStars(Byte stars) {
        this.stars = stars;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
