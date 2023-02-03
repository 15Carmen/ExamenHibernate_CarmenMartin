import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Pastas")
@NamedQuery(name = "listaPasta", query = "from Pastas")
public class Pastas implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Pasta_favorita")
    private Ciudadania nombrePasta;

    @Column (name = "NombrePasta")
    private int NombrePasta;

    public Pastas() {
    }

    public Pastas(Ciudadania pasta_favorita) {
        setPasta_favorita(pasta_favorita);
    }


    public Ciudadania getPasta_favorita() {
        return nombrePasta;
    }

    public void setPasta_favorita(Ciudadania pasta_favorita) {
        nombrePasta = pasta_favorita;
    }

    public int getNombrePasta() {
        return NombrePasta;
    }

    public void setNombrePasta(int nombrePasta) {
        NombrePasta = nombrePasta;
    }
}
