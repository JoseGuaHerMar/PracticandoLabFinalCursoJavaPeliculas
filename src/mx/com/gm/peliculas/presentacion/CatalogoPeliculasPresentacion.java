package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;
import mx.com.gm.peliculas.servicio.*;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo =  new CatalogoPeliculasImpl();
        
        
        while(opcion != 0){
            System.out.println("Elige una opcion: \n"
                    + "1. Iniciar catalogo peliculas\n"
                    + "2. Agregar peliculas\n"
                    + "3. Listar peliculas\n"
                    + "4. Buscar peliculas\n"
                    + "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());
         
            switch(opcion){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                    
                case 2:
                    System.out.println("Ingresa el nombre de la pelixula");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                    
                case 3:
                    catalogo.listarPeliculas();
                    break;
                    
                case 4:
                    System.out.println("Introduce pelicula a buscar");
                    var buscar=scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                    
                case 0:
                    System.out.println("ADIOS");
                    break;
                    
                default:
                    System.out.println("OPCION NO RECONOCIDA");
                    break;
            }   
        }
    }
    
}
