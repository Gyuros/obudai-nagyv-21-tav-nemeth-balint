package cookbook.persistence.entity;


import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityBase {

    @Id
    protected long id;

    public long getId() {
        return id;
    }
}
