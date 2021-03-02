package taxiguider;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name="Taximanage_table")
public class Taximanage {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String orderId;
    private String tel;
    private String location;
    private String status; //호출,호출중,호출확정,호출취소
    private Integer cost;
    
    private String taxiid;
    private String driver;
    private String drivertel;
    
    @PrePersist
    public void onPrePersist(){
    	System.out.println("###############################=================================");

//    	TaximanageAssigned taximanageAssigned = new TaximanageAssigned();
//        BeanUtils.copyProperties(this, TaximanageAssigned);
//        TaximanageAssigned.publishAfterCommit();
        System.out.println("tel " + tel);
        System.out.println("location " + location);
        System.out.println("status " + status);
        System.out.println("cost " + cost);
    	
        System.out.println("orderId " + orderId);
        System.out.println("id " + getId());
        //System.out.println("location " + location);
        //System.out.println("status " + status);
        //System.out.println("cost " + cost);
    	
        
        if("호출취소".equals(status)){
			TaximanageCancelled taximanageCancelled = new TaximanageCancelled();
            BeanUtils.copyProperties(this, TaximanageCancelled);
            TaximanageCancelled.publish();

        }else{
//            결제승인됨 결제승인됨 = new 결제승인됨();
//            BeanUtils.copyProperties(this, 결제승인됨);
//
//            //바로 이벤트를 보내버리면 주문정보가 커밋되기도 전에 배송발송됨 이벤트가 발송되어 주문테이블의 상태가 바뀌지 않을 수 있다.
//            // TX 리스너는 커밋이 완료된 후에 이벤트를 발생하도록 만들어준다.
//            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
//                @Override
//                public void beforeCommit(boolean readOnly) {
//                    결제승인됨.publish();
//                }
//            });
        	
//        	taxiid = "";
//            driver = "";
//            drivertel = "";
//            orderId = "1";
//            tel = "";
//            location = "";
//            status = ""; //호출,호출중,호출확정,호출취소
//            cost = 0;
            
        	status = "호출중";
        	TaximanageAssigned taximanageAssigned = new TaximanageAssigned();
        	TaximanageAssigned.setId(Long.valueOf(orderId));
        	
        	TaximanageAssigned.set고객위치(location);
        	TaximanageAssigned.setTel(tel);
        	TaximanageAssigned.setCost(cost);
        	TaximanageAssigned.setStatus(status);
            BeanUtils.copyProperties(this, TaximanageAssigned);
            TaximanageAssigned.publishAfterCommit();
            
            
            // 테스트 코드~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//            try {
//                Thread.currentThread().sleep((long) (400 + Math.random() * 220));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }    
    }
    
    
//    @PostPersist
//    public void onPostPersist(){
//    	System.out.println("###############################=================================");
//
////    	TaximanageAssigned taximanageAssigned = new TaximanageAssigned();
////        BeanUtils.copyProperties(this, TaximanageAssigned);
////        TaximanageAssigned.publishAfterCommit();
//        System.out.println("tel " + tel);
//        System.out.println("location " + location);
//        System.out.println("status " + status);
//        System.out.println("cost " + cost);
//    	
//        System.out.println("orderId " + orderId);
//        System.out.println("id " + getId());
//        //System.out.println("location " + location);
//        //System.out.println("status " + status);
//        //System.out.println("cost " + cost);
//    	
//        
//        if("호출취소".equals(status)){
////            결제취소됨 결제취소됨 = new 결제취소됨();
////            BeanUtils.copyProperties(this, 결제취소됨);
////            결제취소됨.publish();
////        	TaximanageCancelled taximanageCancelled = new TaximanageCancelled();
////            BeanUtils.copyProperties(this, TaximanageCancelled);
////            TaximanageCancelled.publish();
//
//        }else{
////            결제승인됨 결제승인됨 = new 결제승인됨();
////            BeanUtils.copyProperties(this, 결제승인됨);
////
////            //바로 이벤트를 보내버리면 주문정보가 커밋되기도 전에 배송발송됨 이벤트가 발송되어 주문테이블의 상태가 바뀌지 않을 수 있다.
////            // TX 리스너는 커밋이 완료된 후에 이벤트를 발생하도록 만들어준다.
////            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
////                @Override
////                public void beforeCommit(boolean readOnly) {
////                    결제승인됨.publish();
////                }
////            });
//        	
////        	taxiid = "";
////            driver = "";
////            drivertel = "";
////            orderId = "1";
////            tel = "";
////            location = "";
////            status = ""; //호출,호출중,호출확정,호출취소
////            cost = 0;
//            
//        	status = "호출중";
//        	TaximanageAssigned taximanageAssigned = new TaximanageAssigned();
//        	TaximanageAssigned.setId(Long.valueOf(orderId));
//        	
//        	TaximanageAssigned.set고객위치(location);
//        	TaximanageAssigned.setTel(tel);
//        	TaximanageAssigned.setCost(cost);
//        	TaximanageAssigned.setStatus(status);
//            BeanUtils.copyProperties(this, TaximanageAssigned);
//            TaximanageAssigned.publishAfterCommit();
//            
//            
//            // 테스트 코드~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
////            try {
////                Thread.currentThread().sleep((long) (400 + Math.random() * 220));
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//        }     
//    }


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


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}




}
