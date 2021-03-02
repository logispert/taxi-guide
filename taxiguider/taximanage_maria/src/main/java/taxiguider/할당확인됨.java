
package taxiguider;

public class 할당확인됨 extends AbstractEvent {

    private Long id;
    private String 할당상태; //호출,호출중,호출확정,호출취소
    private String 택시번호;
    private String 택시기사이름;
    private String 택시기사전화번호;
    
    private String 고객휴대폰번호;
    private String 호출위치;
    
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

	public String getTel() {
		return 고객휴대폰번호;
	}

	public void setTel(String 고객휴대폰번호) {
		this.고객휴대폰번호 = 고객휴대폰번호;
	}

	public String getLocation() {
		return 호출위치;
	}

	public void setLocation(String 호출위치) {
		this.호출위치 = 호출위치;
	}

}
