package taxiguider;

public class 택시호출요청됨 extends AbstractEvent {

    private Long id;

    public 택시호출요청됨(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}