package za.co.entelect.training.domain.common;

import javax.persistence.*;

@MappedSuperclass
public class IdentifiableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    public Long getId() {
        return this.id;
    }

    public Long getVersion() {
        return this.version;
    }
}
