package estem.gwt.tp2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "produit")
public class Product {
    @Id @Column(length = 30)
    private String ref ;
    @Column(name = "libelle", unique = true)
    private String label;
    private double price ;
    @ManyToOne @JoinColumn(name = "id_client")
    private Customer customer;
}
