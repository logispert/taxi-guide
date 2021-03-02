
package taxiguider;

public class TaxiassignCompleted extends AbstractEvent {

    private Long id;
    private String status; //호출,호출중,호출확정,호출취소
    private String taxiid;
    private String driver;
    private String drivertel;
    
    private String tel;
    private String location;
    
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

}
