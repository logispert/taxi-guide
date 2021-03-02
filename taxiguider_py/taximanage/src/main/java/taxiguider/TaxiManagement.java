package taxiguider;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="TaxiManagement_table")
public class TaxiManagement {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @PrePersist
    public void onPrePersist(){
        TaximanageAssigned taximanageAssigned = new TaximanageAssigned();
        BeanUtils.copyProperties(this, TaximanageAssigned);
        TaximanageAssigned.publishAfterCommit();


        TaximanageCancelled taximanageCancelled = new TaximanageCancelled();
        BeanUtils.copyProperties(this, TaximanageCancelled);
        TaximanageCancelled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
