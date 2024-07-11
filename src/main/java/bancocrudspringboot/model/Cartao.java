package bancocrudspringboot.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Cartao", uniqueConstraints={@UniqueConstraint(columnNames={"numero"})})
public class Cartao {
    
    private long id;

    private String numero;
    private String nome_titular;
    private String validade;
    private int cvv;

    @Column(name = "usuario")
    private long usuario;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

}
