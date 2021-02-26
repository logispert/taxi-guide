package taxiguider;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import taxiguider.external.Pay;
import taxiguider.external.PayService;

@Entity
@Table(name="TaxiAssignment_table")
public class TaxiAssignment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @PrePersist
    public void onPrePersist(){
        택시할당상태갱신됨 택시할당상태갱신됨 = new 택시할당상태갱신됨();
        BeanUtils.copyProperties(this, 택시할당상태갱신됨);
        택시할당상태갱신됨.publishAfterCommit();


        택시할당취소됨 택시할당취소됨 = new 택시할당취소됨();
        BeanUtils.copyProperties(this, 택시할당취소됨);
        택시할당취소됨.publishAfterCommit();


        할당확인됨 할당확인됨 = new 할당확인됨();
        BeanUtils.copyProperties(this, 할당확인됨);
        할당확인됨.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        Pay pay = new Pay();
        // mappings goes here
        TaxiassignApplication.applicationContext.getBean(PayService.class)
            .요금결재(pay);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
