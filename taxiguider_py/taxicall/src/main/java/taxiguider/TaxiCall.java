package taxiguider;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="TaxiCall_table")
public class TaxiCall {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @PrePersist
    public void onPrePersist(){
        Taxicalled taxicalled = new Taxicalled();
        BeanUtils.copyProperties(this, Taxicalled);
        Taxicalled.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        .external.TaxiManagement taxiManagement = new .external.TaxiManagement();
        // mappings goes here
        Application.applicationContext.getBean(.external.TaxiManagementService.class)
            .TaximanageAssign(taxiManagement);


        TaxicallCancelled taxicallCancelled = new TaxicallCancelled();
        BeanUtils.copyProperties(this, TaxicallCancelled);
        TaxicallCancelled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
