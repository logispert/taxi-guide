package taxiguider;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="TaxiAssign_table")
public class TaxiAssign {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @PrePersist
    public void onPrePersist(){
        TaxiassignCompleted taxiassignCompleted = new TaxiassignCompleted();
        BeanUtils.copyProperties(this, TaxiassignCompleted);
        TaxiassignCompleted.publishAfterCommit();


        TaxiassignCancelled taxiassignCancelled = new TaxiassignCancelled();
        BeanUtils.copyProperties(this, TaxiassignCancelled);
        TaxiassignCancelled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
