package taxiguider;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="TaxiAssignment_table")
public class TaxiAssignment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @PrePersist
    public void onPrePersist(){
        호출수락함 호출수락함 = new 호출수락함();
        BeanUtils.copyProperties(this, 호출수락함);
        호출수락함.publishAfterCommit();


        택시호출취소됨 택시호출취소됨 = new 택시호출취소됨();
        BeanUtils.copyProperties(this, 택시호출취소됨);
        택시호출취소됨.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
