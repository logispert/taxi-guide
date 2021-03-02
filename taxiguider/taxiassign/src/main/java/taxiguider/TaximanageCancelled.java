
package taxiguider;

public class TaximanageCancelled extends AbstractEvent {

    private Long id;
    private String tel;
    private String 고객위치;
    private String status; //호출,호출중,호출확정,호출취소
    private Integer cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String get고객위치() {
        return 고객위치;
    }

    public void set고객위치(String 고객위치) {
        this.고객위치 = 고객위치;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
