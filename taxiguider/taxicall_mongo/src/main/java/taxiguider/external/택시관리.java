package taxiguider.external;

public class 택시관리 {
	
	private String 휴대폰번호;
    private String 호출위치;
    private String 호출상태; //호출,호출중,호출확정,호출취소
    private Integer 예상요금;
	
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
	public String get휴대폰번호() {
		return 휴대폰번호;
	}
	public void set휴대폰번호(String 휴대폰번호) {
		this.휴대폰번호 = 휴대폰번호;
	}
	public String get호출위치() {
		return 호출위치;
	}
	public void set호출위치(String 호출위치) {
		this.호출위치 = 호출위치;
	}
	public String get호출상태() {
		return 호출상태;
	}
	public void set호출상태(String 호출상태) {
		this.호출상태 = 호출상태;
	}
	public Integer get예상요금() {
		return 예상요금;
	}
	public void set예상요금(Integer 예상요금) {
		this.예상요금 = 예상요금;
	}

}
