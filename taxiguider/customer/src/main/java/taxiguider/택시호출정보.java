package taxiguider;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="택시호출정보_table")
public class 택시호출정보 {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

}
