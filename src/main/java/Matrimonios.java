import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table (name = "Matrimonios")
public class Matrimonios implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private int ID;

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID")
    private Ciudadania IdConyuge1;

    @Column (name = "IDConyuge1")
    private int IDConyuge1;

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID")
    private Ciudadania IdConyuge2;

    @Column (name = "IDConyuge2")
    private int IDConyuge2;

    @Column (name = "Fecha_matrimonio")
    private LocalDate Fecha_matrimonio;

    @Column (name = "Fecha_fin")
    private LocalDate Fecha_fin;

    public Matrimonios() {
    }

    public Matrimonios(int ID, int IDConyuge1, int IDConyuge2, LocalDate fecha_matrimonio, LocalDate fecha_fin) {
        setID(ID);
        setIDConyuge1(IDConyuge1);
        setIDConyuge2(IDConyuge2);
        setFecha_matrimonio(fecha_matrimonio);
        setFecha_fin(fecha_fin);
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }


    public Ciudadania getIDConyuge1() {
        return IdConyuge1;
    }
    public void setIDConyuge1(Ciudadania IDConyuge1) {
        this.IdConyuge1 = IDConyuge1;
    }
    public void setIDConyuge1(int IDConyuge1) {
        this.IDConyuge1 = IDConyuge1;
    }

    public Ciudadania getIDConyuge2() {
        return IdConyuge2;
    }
    public void setIDConyuge2(Ciudadania IDConyuge2) {
        this.IdConyuge2 = IDConyuge2;
    }
    public void setIDConyuge2(int IDConyuge2) {
        this.IDConyuge2 = IDConyuge2;
    }

    public LocalDate getFecha_matrimonio() {
        return Fecha_matrimonio;
    }
    public void setFecha_matrimonio(LocalDate fecha_matrimonio) {
        Fecha_matrimonio = fecha_matrimonio;
    }


    public LocalDate getFecha_fin() {
        return Fecha_fin;
    }
    public void setFecha_fin(LocalDate fecha_fin) {
        Fecha_fin = fecha_fin;
    }
}
