package taxiguider;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import taxiguider.external.TaxiAssignment;
import taxiguider.external.TaxiAssignmentService;

@Entity
@Table(name="TaxiManagement_table")
public class TaxiManagement {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @PrePersist
    public void onPrePersist(){
        택시호출요청됨 택시호출요청됨 = new 택시호출요청됨();
        BeanUtils.copyProperties(this, 택시호출요청됨);
        택시호출요청됨.publishAfterCommit();


        택시호출요청취소됨 택시호출요청취소됨 = new 택시호출요청취소됨();
        BeanUtils.copyProperties(this, 택시호출요청취소됨);
        택시호출요청취소됨.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        TaxiAssignment taxiAssignment = new TaxiAssignment();
        // mappings goes here
        TaximanagementApplication.applicationContext.getBean(TaxiAssignmentService.class)
            .택시호출취소(taxiAssignment);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
