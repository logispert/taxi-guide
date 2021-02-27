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
        택시할당요청됨 택시할당요청됨 = new 택시할당요청됨();
        BeanUtils.copyProperties(this, 택시할당요청됨);
        택시할당요청됨.publishAfterCommit();


        택시할당취소됨 택시할당취소됨 = new 택시할당취소됨();
        BeanUtils.copyProperties(this, 택시할당취소됨);
        택시할당취소됨.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
