package taxiguider;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="Taxiassign_table")
public class Taxiassign {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String status; //호출,호출중,호출확정,호출취소
    private String taxiid;
    private String driver;
    private String drivertel;
    
    @PrePersist
    public void onPrePersist(){
    	System.out.println("==============Taxiassign================");


        //TaxiassignCompleted taxiassignCompleted = new TaxiassignCompleted();
        //BeanUtils.copyProperties(this, TaxiassignCompleted);
        //TaxiassignCompleted.publishAfterCommit();


        //TaxiassignCancelled taxiassignCancelled = new TaxiassignCancelled();
        //BeanUtils.copyProperties(this, TaxiassignCancelled);
        //TaxiassignCancelled.publishAfterCommit();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getTaxiid() {
		return taxiid;
	}

	public void setTaxiid(String taxiid) {
		this.taxiid = taxiid;
	}


	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}


	public String getDrivertel() {
		return drivertel;
	}

	public void setDrivertel(String drivertel) {
		this.drivertel = drivertel;
	}



}
