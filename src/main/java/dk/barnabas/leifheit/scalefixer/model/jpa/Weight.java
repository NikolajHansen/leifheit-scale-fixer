package dk.barnabas.leifheit.scalefixer.model.jpa;

import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "weights")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String data;

    private Date createdDate;

}
