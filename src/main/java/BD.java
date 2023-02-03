import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class BD {
    private SessionFactory sf;
    private Session sesion;
    private Transaction transaction;

    protected void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // por defecto: hibernate.cfg.xml
                .build();
        try {
            sf = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public void abrir() throws Exception {
        setUp();
        sesion=sf.openSession();
        transaction = sesion.beginTransaction();
    }

    public void cerrar(){
        try {
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }
        sf.close();
    }

    public Object guardar(Object cosa) {
        return sesion.save(cosa);
    }

    //Metodos leer

    public Ciudadania leerCiudadano(int idCiudadano){
        Ciudadania ciudadano = null;
        try {
            ciudadano = sesion.get(Ciudadania.class, idCiudadano);
        }catch (Exception e){
            System.out.println("Error al leer al ciudadano!");
        }

        return ciudadano;
    }

    public Matrimonios leerMatrimonio(int idMatrimonio){
        Matrimonios matrimonios = null;
        try {
            matrimonios = sesion.get(Matrimonios.class, idMatrimonio);
        }catch (Exception e){
            System.out.println("Error al leer el matrimonio!");
        }

        return matrimonios;
    }

    /**
     * Metodo que usaremos para insertar un nuevo ciudadano
     * @param ciudadano
     */

    public void NacimientoCiudadano(Ciudadania ciudadano){
        try {
            abrir();
            sesion.persist(ciudadano);
            cerrar();
        }catch (Exception e){
            System.out.println("Lo sentimos, ha habido un fallo al insertar el ciudadano");
        }
    }


    /**
     * Metodo que usaremos para insertar un nuevo matrimonio
     * @param matrimonios
     */
    public void Matrimonio(Matrimonios matrimonios){
        try{
            abrir();
            sesion.persist(matrimonios);
            cerrar();
        }catch (Exception e){
            System.out.println("Lo sentimos, ha habido un fallo al insertar el matrimonio");
        }
    }

    public void listaPasta() {
        try {
            abrir();
            List<Pastas > listaPasta = sesion.getNamedQuery("listaPasta").getResultList();

            for (int i = 0; i < listaPasta.size(); i++) {
                System.out.println(listaPasta.get(i).getNombrePasta());
            }

            cerrar();
        } catch (Exception e) {
            System.out.println("Error al leer las pastas!");
        }
    }

}
