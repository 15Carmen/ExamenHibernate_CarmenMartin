import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table (name = "Ciudadania")
public class Ciudadania implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private int ID;

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_madre")
    private Ciudadania id_Madre;

    @Column (name = "id_madre")
    private int id_madre;

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Padre")
    private Ciudadania id_Padre;

    @Column (name = "id_padre")
    private int id_padre;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "apellidos")
    private String apellidos;

    @Column (name = "sexo")
    private String sexo;

    @Column (name = "Fecha_nacimiento")
    private LocalDate Fecha_nacimiento;

    @Column (name = "Fecha_muerte")
    private LocalDate Fecha_muerte;

    @Column (name = "Pasta_favorita")
    private String Pasta_favorita;

    @Column (name = "KG_pasta")
    private int KG_pasta;

    public Ciudadania() {
    }

    public Ciudadania(int ID, int id_madre, int id_padre, String nombre, String apellidos,
                      String sexo, LocalDate fecha_nacimiento, LocalDate fecha_muerte, String pasta_favorita,
                      int KG_pasta) {
        setID(ID);
        setId_madre(id_madre);
        setId_padre(id_padre);
        setNombre(nombre);
        setApellidos(apellidos);
        setSexo(sexo);
        setFecha_nacimiento(fecha_nacimiento);
        setFecha_muerte(fecha_muerte);
        setPasta_favorita(pasta_favorita);
        setKG_pasta(KG_pasta);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Ciudadania getId_Madre() {
        return id_Madre;
    }

    public void setId_madre(Ciudadania id_Madre) {
        this.id_Madre = id_Madre;
    }

    public int getId_madre() {
        return id_madre;
    }

    public void setId_madre(int id_madre) {
        this.id_madre = id_madre;
    }

    public Ciudadania getId_Padre() {
        return id_Padre;
    }

    public void setId_padre(Ciudadania id_Padre) {
        this.id_Padre = id_Padre;
    }

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        Fecha_nacimiento = fecha_nacimiento;
    }

    public LocalDate getFecha_muerte() {
        return Fecha_muerte;
    }

    public void setFecha_muerte(LocalDate fecha_muerte) {
        Fecha_muerte = fecha_muerte;
    }

    public String getPasta_favorita() {
        return Pasta_favorita;
    }

    public void setPasta_favorita(String pasta_favorita) {
        Pasta_favorita = pasta_favorita;
    }

    public int getKG_pasta() {
        return KG_pasta;
    }

    public void setKG_pasta(int KG_pasta) {
        this.KG_pasta = KG_pasta;
    }




}
