package taxiguider;

public class Taxicalled extends AbstractEvent {

    private Long id;

    public Taxicalled(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}