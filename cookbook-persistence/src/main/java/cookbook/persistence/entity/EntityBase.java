package cookbook.persistence.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    public long getId() {
        return id;
    }
}
