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
        할당확인됨 할당확인됨 = new 할당확인됨();
        BeanUtils.copyProperties(this, 할당확인됨);
        할당확인됨.publishAfterCommit();


        할당취소됨 할당취소됨 = new 할당취소됨();
        BeanUtils.copyProperties(this, 할당취소됨);
        할당취소됨.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
