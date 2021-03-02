package taxiguider;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Taxicallinfo_table")
public class Taxicallinfo {

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
