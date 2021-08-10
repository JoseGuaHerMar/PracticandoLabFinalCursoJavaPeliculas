package mx.com.gm.peliculas.servicio;


import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.gm.pelliculas.domain.Pelicula;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {
    
    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar= false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("ERROR DE ACCESO A DATOS");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for(var pelicula: peliculas){
                System.out.println("pelicula = " + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("ERROR DE ACCESO DATOS");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado= null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
            System.out.println("resultado = " + resultado);
        } catch (AccesoDatosEx ex) {
            System.out.println("ERROR ACCESO DATOS EN EL METODO BUSCAR");
            ex.printStackTrace(System.out);
        }
        
        
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                this.datos.borrar(NOMBRE_RECURSO);
                this.datos.crear(NOMBRE_RECURSO);
            }
            else{
                this.datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("ERROR AL INCIAR CATALO DE PELICULAS");
            ex.printStackTrace(System.out);
            }
        
    }
    
}
