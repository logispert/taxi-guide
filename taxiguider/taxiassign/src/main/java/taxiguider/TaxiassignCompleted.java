
package taxiguider;

public class 할당취소됨 extends AbstractEvent {

    private Long id;
    private String 할당상태; //호출,호출중,호출확정,호출취소
    private String 택시번호;
    private String 택시기사이름;
    private String 택시기사전화번호;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String get할당상태() {
        return 할당상태;
    }

    public void set할당상태(String 할당상태) {
        this.할당상태 = 할당상태;
    }

    public String getTaxiid() {
        return 택시번호;
    }

    public void setTaxiid(String 택시번호) {
        this.택시번호 = 택시번호;
    }

    public String getDriver() {
        return 택시기사이름;
    }

    public void setDriver(String 택시기사이름) {
        this.택시기사이름 = 택시기사이름;
    }

    public String getDrivertel() {
        return 택시기사전화번호;
    }

    public void setDrivertel(String 택시기사전화번호) {
        this.택시기사전화번호 = 택시기사전화번호;
    }

}
