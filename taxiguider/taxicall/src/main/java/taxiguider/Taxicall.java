package taxiguider;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import taxiguider.external.Taximanage;
import taxiguider.external.TaximanageService;

@Entity
@Table(name="Taxicall_table")
public class Taxicall {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String tel;
    private String location;
    private String status; //호출,호출중,호출확정,호출취소
    private Integer cost;
    
	
    @PostPersist
    public void onPostPersist(){
//        Taxicalled taxicalled = new Taxicalled();
//        BeanUtils.copyProperties(this, Taxicalled);
//        Taxicalled.publishAfterCommit();
    	
    	System.out.println("tel " + getTel());
        System.out.println("location " + getLocation());
        System.out.println("status " + getStatus());
        System.out.println("cost " + getCost());
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.   	
    	if(getTel() != null)
		{
    		System.out.println("SEND###############################" + getId());
			Taximanage taximanage = new Taximanage();
			taximanage.setId(getId());
			taximanage.setOrderId(String.valueOf(getId()));
	        taximanage.setTel(getTel());
	        if(getLocation()!=null)
	        	taximanage.setLocation(getLocation());
	        if(getStatus()!=null) 
	        	taximanage.setStatus(getStatus());
	        if(getCost()!=null)
	        	taximanage.setCost(getCost());
	        
	        // mappings goes here
	        TaxicallApplication.applicationContext.getBean(TaximanageService.class).TaximanageAssign(Taximanage);
		}

    }

	@PreRemove
	public void onPreRemove(){
		TaxicallCancelled taxicallCancelled = new TaxicallCancelled();
		BeanUtils.copyProperties(this, TaxicallCancelled);
		TaxicallCancelled.publishAfterCommit();

		//Following code causes dependency to external APIs
		// it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

		//Taximanage taximanage = new Taximanage();
		// mappings goes here
		//taximanage.setId(getId());
		//taximanage.setOrderId(String.valueOf(getId()));
		//taximanage.setStatus("호출취소");
		//taximanage.setTel(getTel());
		
		// mappings goes here
		//TaxicallApplication.applicationContext.getBean(TaximanageService.class).TaximanageAssign(Taximanage);
	}


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
