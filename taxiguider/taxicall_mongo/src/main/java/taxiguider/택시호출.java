package taxiguider;

import org.springframework.data.annotation.Id;

//@Entity
//@Table(name="Taxicall_table")
public class 택시호출 {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    private String 휴대폰번호;
    private String 호출위치;
    private String 호출상태; //호출,호출중,호출확정,호출취소
    private Integer 예상요금;
    
	
//    @PostPersist
//    public void onPostPersist(){
//        택시호출요청됨 택시호출요청됨 = new 택시호출요청됨();
//        BeanUtils.copyProperties(this, 택시호출요청됨);
//        택시호출요청됨.publishAfterCommit();
    	
//    	System.out.println("휴대폰번호 " + get휴대폰번호());
 //       System.out.println("호출위치 " + getLocation());
//        System.out.println("호출상태 " + get호출상태());
//        System.out.println("예상요금 " + getCost());
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.   	
//    	if(get휴대폰번호() != null)
//		{
//   		System.out.println("SEND###############################" + getId());
//			택시관리 택시관리 = new 택시관리();
//	        
//			택시관리.setOrderId(getId());
//	        택시관리.setTel(get휴대폰번호());
//	        if(getLocation()!=null)
//	        	택시관리.setLocation(getLocation());
//	        if(get호출상태()!=null) 
//	        	택시관리.set호출상태(get호출상태());
//	        if(getCost()!=null)
//	        	택시관리.setCost(getCost());
//	        
//	        // mappings goes here
//	        TaxicallApplication.applicationContext.getBean(택시관리Service.class).택시할당요청(택시관리);
//		}
    	
//        호출취소됨 호출취소됨 = new 호출취소됨();
//        BeanUtils.copyProperties(this, 호출취소됨);
//        호출취소됨.publishAfterCommit();
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


	public String get휴대폰번호() {
		return 휴대폰번호;
	}


	public void set휴대폰번호(String 휴대폰번호) {
		this.휴대폰번호 = 휴대폰번호;
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


}
