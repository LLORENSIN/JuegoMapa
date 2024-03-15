import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainUbicacion {
    private Map<Integer, Ubicacion> ubicaciones;

    public MainUbicacion() {
        ubicaciones = new HashMap<>();
        ubicaciones.put(0, new Ubicacion(0, "Estás sentado en la clase de programación"));
        ubicaciones.put(1, new Ubicacion(1, "Estás en la cima de una montaña"));
        ubicaciones.put(2, new Ubicacion(2, "Estás bañándote en la playa"));
        ubicaciones.put(3, new Ubicacion(3, "Estás dentro de un edificio muy alto"));
        ubicaciones.put(4, new Ubicacion(4, "Estás de pie en un puente"));
        ubicaciones.put(5, new Ubicacion(5, "Estás en un bosque"));

        ubicaciones.get(1).addExit("N", 5);
        ubicaciones.get(1).addExit("S", 2);
        ubicaciones.get(1).addExit("E", 3);
        ubicaciones.get(1).addExit("O", 4);
        ubicaciones.get(1).addExit("Q", 0);

        ubicaciones.get(2).addExit("N", 1);
        ubicaciones.get(2).addExit("Q", 0);

        ubicaciones.get(3).addExit("O", 1);
        ubicaciones.get(3).addExit("Q", 0);

        ubicaciones.get(4).addExit("E", 1);
        ubicaciones.get(4).addExit("Q", 0);

        ubicaciones.get(5).addExit("S", 1);
        ubicaciones.get(5).addExit("Q", 0);
    }
    public void jugar(){
        Scanner scanner = new Scanner(System.in);
        int ubicacionActual = 1;

        while(true){
            Ubicacion ubicacion = ubicaciones.get(ubicacionActual);
            System.out.println(ubicacion.getDescripcion());

            System.out.print("Tus salidas válidas son ");
            for (String direccion : ubicacion.getExits().keySet()) {
                System.out.print(direccion + ", ");
            }
            System.out.println("Q");

            System.out.print("INPUT: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("Q")) {
                System.out.println("¡Adiós!");
                break;
            }
            if (!ubicacion.getExits().containsKey(input)) {
                System.out.println("No puede ir en esa dirección.");
                continue;
            }

            ubicacionActual = ubicacion.getExits().get(input);
        }
    }

    public static void main(String[] args) {
        MainUbicacion juego = new MainUbicacion();
        juego.jugar();
    }
}



