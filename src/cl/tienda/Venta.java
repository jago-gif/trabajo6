package cl.tienda;

public class Venta extends Producto {

        private int cantidad;
        private String tipoVenta;


        public Venta(int idProducto, String nombre, int valor, String tipoVenta, int cantidad) {
                super(idProducto, nombre, valor);
                this.tipoVenta = tipoVenta;
                this.cantidad=cantidad;
        }

        public String getTipoVenta() {
                return tipoVenta;
        }

        public int getCantidad() {
                return cantidad;
        }

        public void setTipoVenta(String tipoVenta) {
                this.tipoVenta = tipoVenta;
        }

        public void setCantidad(int cantidad) {
                this.cantidad = cantidad;
        }

        @Override
        public String toString() {
                return "Venta{" +
                        "cantidad=" + cantidad +
                        ", tipoVenta='" + tipoVenta + '\'' +
                        '}';
        }

        @Override
        public String mostrar() {
                return "se vendio la cantidad de  "+cantidad+" productos y se cancelo por medio de "
                		+ ""+tipoVenta+" "+super.mostrar();
        }
}

