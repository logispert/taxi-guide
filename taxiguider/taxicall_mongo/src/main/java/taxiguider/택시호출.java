package taxiguider;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
//@Table(name="택시호출_table")
@Document
public class 택시호출 {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String 휴대폰번호;
    private String 호출위치;
    private String 호출상태; //호출,호출중,호출확정,호출취소
    private Integer 예상요금;
    
//    @PrePersist
//    public void onPrePersist(){
//        택시호출요청됨 택시호출요청됨 = new 택시호출요청됨();
//        BeanUtils.copyProperties(this, 택시호출요청됨);
//        택시호출요청됨.publishAfterCommit();
//
//        //Following code causes dependency to external APIs
//        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.
//
//        .external.택시관리 택시관리 = new .external.택시관리();
//        // mappings goes here
//        Application.applicationContext.getBean(.external.택시관리Service.class)
//            .택시할당요청(택시관리);
//
//
//        호출취소됨 호출취소됨 = new 호출취소됨();
//        BeanUtils.copyProperties(this, 호출취소됨);
//        호출취소됨.publishAfterCommit();
//
//
//    }


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
