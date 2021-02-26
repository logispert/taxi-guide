package taxiguider;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

import taxiguider.external.Pay;
import taxiguider.external.PayService;

@Entity
@Table(name="TaxiCall_table")
public class TaxiCall {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @PrePersist
    public void onPrePersist(){
        택시호출됨 택시호출됨 = new 택시호출됨();
        BeanUtils.copyProperties(this, 택시호출됨);
        택시호출됨.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.
		
		//external...
        Pay pay = new Pay();
        // mappings goes here
        TaxicallApplication.applicationContext.getBean(PayService.class).요금결재(pay);


        호출취소됨 호출취소됨 = new 호출취소됨();
        BeanUtils.copyProperties(this, 호출취소됨);
        호출취소됨.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
