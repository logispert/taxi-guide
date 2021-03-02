package taxiguider;

import org.springframework.data.annotation.Id;

//@Entity
//@Table(name="Taxicall_table")
public class Taxicall {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    private String tel;
    private String location;
    private String status; //호출,호출중,호출확정,호출취소
    private Integer cost;
    
	
//    @PostPersist
//    public void onPostPersist(){
//        Taxicalled taxicalled = new Taxicalled();
//        BeanUtils.copyProperties(this, Taxicalled);
//        Taxicalled.publishAfterCommit();
    	
//    	System.out.println("tel " + getTel());
 //       System.out.println("location " + getLocation());
//        System.out.println("status " + getStatus());
//        System.out.println("cost " + getCost());
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.   	
//    	if(getTel() != null)
//		{
//   		System.out.println("SEND###############################" + getId());
//			Taximanage taximanage = new Taximanage();
//	        
//			taximanage.setOrderId(getId());
//	        taximanage.setTel(getTel());
//	        if(getLocation()!=null)
//	        	taximanage.setLocation(getLocation());
//	        if(getStatus()!=null)
//	        	taximanage.setStatus(getStatus());
//	        if(getCost()!=null)
//	        	taximanage.setCost(getCost());
//	        
//	        // mappings goes here
//	        TaxicallApplication.applicationContext.getBean(TaximanageService.class).TaximanageAssign(Taximanage);
//		}
    	
//        TaxicallCancelled taxicallCancelled = new TaxicallCancelled();
//        BeanUtils.copyProperties(this, TaxicallCancelled);
//        TaxicallCancelled.publishAfterCommit();
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
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
