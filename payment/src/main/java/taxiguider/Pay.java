package taxiguider;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Pay_table")
public class Pay {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @PrePersist
    public void onPrePersist(){
        요금결재됨 요금결재됨 = new 요금결재됨();
        BeanUtils.copyProperties(this, 요금결재됨);
        요금결재됨.publishAfterCommit();


        요금결재취소됨 요금결재취소됨 = new 요금결재취소됨();
        BeanUtils.copyProperties(this, 요금결재취소됨);
        요금결재취소됨.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
