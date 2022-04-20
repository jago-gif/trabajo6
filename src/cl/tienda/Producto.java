package cl.tienda;

/** @author camila marcela javier y sebastian.
 *
 *
 *
 */

public class Producto {
    private int idProducto;
    private String nombre;
    private int valor;
    private int stock;

    public Producto(String nombre, int valor, int stock) {
        idProducto = sum++;
        this.nombre = nombre;
        this.valor = valor;
        this.stock = stock;
    }

    public Producto(int idProducto, String nombre, int valor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.valor = valor;
    }
    public Producto(int idProducto,String nombre, int valor, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.valor = valor;
        this.stock = stock;

    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", valor=" + valor +
                ", stock=" + stock +
                '}';
    }

    public static int sum = 0;
    public String mostrar(){
        return "nombre "+nombre+" valor "+valor;
    }

}
