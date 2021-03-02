package taxiguider.external;

public class 택시관리 {
	private String 고객휴대폰번호;
    private String 호출위치;
    private String 호출상태; //호출,호출중,호출확정,호출취소
    private Integer 예상요금;
    private String orderId;
    
    private String 택시기사휴대폰번호;
    private String 택시번호;
    private String 택시기사이름;
    
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
	public String get호출상태() {
		return 호출상태;
	}
	public void set호출상태(String 호출상태) {
		this.호출상태 = 호출상태;
	}
	public Integer getCost() {
		return 예상요금;
	}
	public void setCost(Integer 예상요금) {
		this.예상요금 = 예상요금;
	}
	public String get택시기사휴대폰번호() {
		return 택시기사휴대폰번호;
	}
	public void set택시기사휴대폰번호(String 택시기사휴대폰번호) {
		this.택시기사휴대폰번호 = 택시기사휴대폰번호;
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
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
