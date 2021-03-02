
package taxiguider;

public class 호출취소됨 extends AbstractEvent {

    private Long id;
    private String 할당상태; //호출취소
    private String 고객휴대폰번호;

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

    public String getTel() {
        return 고객휴대폰번호;
    }

    public void setTel(String 고객휴대폰번호) {
        this.고객휴대폰번호 = 고객휴대폰번호;
    }
}
