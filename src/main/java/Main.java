import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static BD bd = new BD();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        //Para que no aprezca el texto rojo
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        bd = new BD();

        int opc;

        do {
            System.out.println("""
                    Indique que desea hacer:
                    [1] Presenciar el nacimiento de un nuevo ciudadano
                    [2] Asistir a una boda
                    [3] Asistir a un funeral
                    [4] Divorciarte
                    [5] No quiero hacer nada, mejor me voy
                    """);
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    Nacimiento(1, 2, 3,"Carlos", "Matas");
                    break;
                case 2:
                    Matrimonio(1, 2, LocalDate.ofEpochDay(12 / 12 / 2012));
                    break;
                case 3:
                    Deceso(1, LocalDate.ofEpochDay(12/12/2012));
                    break;
                case 4:
                    Divorcio(1, LocalDate.ofEpochDay(13/12/2008));
                    break;
                case 5:
                    System.out.println("Bye bye~ 👋");
                    break;
                default:
                    System.out.println("Opcion no valida :[");
            }
        } while (opc != 5);
    }

    /**
     * Metodo que insertará un nuevo ciudadano
     */
    private static void Nacimiento(int id, int idPadre, int idMadre, String nombre, String apellidos) {

        Ciudadania ciudadano = bd.leerCiudadano(id);
        if (ciudadano.getId_Padre() == null || ciudadano.getId_Madre() == null) {
            System.out.println("Este bebe no tiene padres!");
        }else {
            bd.NacimientoCiudadano(new Ciudadania(id, idPadre, idMadre, nombre, apellidos, null, null, null, null, 0));
        }
    }

    /**
     * Método que insertará un nuevo matrimonio
     */
    private static void Matrimonio(int Conyuge1, int Conyuge2, LocalDate fecha) {
       Ciudadania ciudadania = bd.leerCiudadano(Conyuge1);
       Ciudadania ciudadania2 = bd.leerCiudadano(Conyuge2);

        if (ciudadania != null || ciudadania2 != null){
            bd.Matrimonio(new Matrimonios(1, Conyuge1, Conyuge2, fecha, null));
        } else if (ciudadania.getFecha_muerte() != null || ciudadania2.getFecha_muerte() != null) {
            System.out.println("Uno de los conyuges esta muerto!! Di no a la necrofilia");
        } else {
            System.out.println("Uno de los conyuges introducidos no existe");
        }
    }

    /**
     * Metodo que actualizará la tabla ciudadania
     */

    private static void Deceso(int id, LocalDate fecha) throws Exception {
        bd.abrir();
        Ciudadania ciudadano = bd.leerCiudadano(id);
        if (ciudadano != null) {
            ciudadano.setFecha_muerte(fecha);
            bd.cerrar();

            bd.NacimientoCiudadano(ciudadano);
        } else if (ciudadano.getFecha_muerte() != null) {
            System.out.println("Ya está muerto!");
        } else {
            System.out.println("El id del ciudadano no existe");
        }
    }

    /**
     * Metodo que actualizará la tabla Matrimonios
     */
    private static void Divorcio(int id, LocalDate fecha) throws Exception {
        bd.abrir();
        Matrimonios matrimonios = bd.leerMatrimonio(id);
        if (matrimonios != null) {
            matrimonios.setFecha_fin(fecha);
            bd.cerrar();

            bd.Matrimonio(matrimonios);

        } else if (matrimonios.getFecha_fin() != null) {
            System.out.println("Ya están divorciados");
        } else {
            System.out.println("El id del matrimonio no existe");
        }
    }




}
