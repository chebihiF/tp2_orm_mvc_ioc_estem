package estem.gwt.tp2.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NonNull
    private String name ;
    private String email ;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Product> products;
}
