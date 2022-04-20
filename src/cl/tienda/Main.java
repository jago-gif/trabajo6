package cl.tienda;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int menu;
        String ingresa = null;
        ArrayList<Producto>listaProductos = new ArrayList<>();
        ArrayList<Venta>listaVenta = new ArrayList<>();
		  listaProductos.add(new Producto("MORTADELA", 5000, 32)) ;
		  listaProductos.add(new Producto("QUESO", 6000, 25)) ;



        
        System.out.println("Bienvenido a nuestra tienda, seleccione una opcion:");


        do {
            System.out.println("[1]      Agregar producto");
            System.out.println("[2]      Agregar venta");
            System.out.println("[3]      Ventas del dia");
            System.out.println("[0]      Salir");
            menu = opcionNum(scan);
           switch (menu){
               case OPCION_MENU_AGREGAR_PRODUCTO -> {
                   String nombre;
                   int valor;
                   int stock;
                   verProductos(listaProductos);
                   llamada_agregar_producto(scan, ingresa, listaProductos);

                   break;
               }case OPCION_MENU_AGREGAR_VENTA -> {
                   int id;
                   int cantidad = 0;
                   String nombre = null;
                   int valor = 0;
                   int stock = 0;
                   String tipoVenta;
                   int submenu=0;
                   boolean bstock = false;
                   boolean pagado = false;
                   verProductos(listaProductos);
                   System.out.println("Escriba el ID del producto que desea comprar");
                   id=opcionNum(scan);
                   for(int i=0; i<listaProductos.size();i++) {
                	   if(id==listaProductos.get(i).getIdProducto()) {

                		   nombre=listaProductos.get(i).getNombre();
                		   valor=listaProductos.get(i).getValor();
                		   stock=listaProductos.get(i).getStock();
                		   while(!bstock) {
                    		   System.out.println("Cantidad de "+nombre+" que necesita");
                			   cantidad=opcionNum(scan);
                			   if(cantidad>stock) {
                				   System.out.println("Lo sentimos, no tenemos suficiente stock");
                			   }else {
                				   stock= stock-cantidad;
                				   System.out.println("Seleccione el medio de pago");
                				   System.out.println("Efectivo               [1]");
                				   System.out.println("Tarjeta de Debito      [2]");
                				   System.out.println("Tarjeta de Credito     [3]");
                				   while(!pagado) {
                					   submenu=opcionNum(scan);
                                       if (submenu==1){
                                           tipoVenta= "Efectivo";
                                           System.out.println("Su compra en "+ tipoVenta+ " ha finalizado exitosamente");
                                           Producto modificadorStock = new Producto(id, nombre, valor,stock);
                            			   listaProductos.set(id, modificadorStock); 
                                           listaVenta.add(new Venta(id,nombre,valor,tipoVenta,cantidad));
                            			   bstock=true;
                            			   pagado=true;

                                       }else if (submenu==2){
                                           tipoVenta= "Tarjeta de debito";
                                           System.out.println("Su compra en "+ tipoVenta+ " ha finalizado exitosamente");
                                           Producto modificadorStock = new Producto(id, nombre, valor,stock);
                            			   listaProductos.set(id, modificadorStock); 
                                           listaVenta.add(new Venta(id,nombre,valor,tipoVenta,cantidad));
                                           bstock=true;
                            			   pagado=true;
                                       		}else if (submenu==3){
                                           tipoVenta= "Tarjeta de credito";
                                           System.out.println("Su compra en "+ tipoVenta+ " ha finalizado exitosamente");
                                           Producto modificadorStock = new Producto(id, nombre, valor,stock);
                            			   listaProductos.set(id, modificadorStock); 
                                           listaVenta.add(new Venta(id,nombre,valor,tipoVenta,cantidad));
                                           bstock=true;
                            			   pagado=true;
                                       }
                				   }

                				       
                			   }
                			   
                		   }
                		
                	   }else {
                	   }
                	

                   }
                                      
                   break;
               }
               case OPCION_MENU_VER_VENTAS -> {
            	   int acumulador=0;
                   for (int i=0; i<listaVenta.size();i++){
                       System.out.println(listaVenta.get(i).mostrar()+" Total pagado: "+ listaVenta.get(i).getCantidad()*
                    		   listaVenta.get(i).getValor());
                   }

                   for (int i=0; i<listaVenta.size();i++){
                	   acumulador += listaVenta.get(i).getCantidad()*listaVenta.get(i).getValor();
                   }
                   System.out.println("El total de ventas del día es de "+acumulador);
                   System.out.println("---------------------------------------");
               }
           }
       }while (menu !=OPCION_MENU_SALIR);



    }
	private static void verProductos(ArrayList<Producto> listaProductos) {
		for(Object vista: listaProductos) {
			   System.out.println(vista);
		   }
	}
	private static void llamada_agregar_producto(Scanner scan, String ingresa, ArrayList<Producto> listaProductos) {
		String nombre;
		int valor;
		int stock;
		System.out.println("Escriba el nombre del producto");
		   nombre=validarVacio(scan,ingresa);
		   System.out.println(nombre);
		   System.out.println("Ingrese el valor del producto");
		   valor=opcionNum(scan);
		   System.out.println(valor);
		   System.out.println("Ingrese el stock del producto");
		   stock=opcionNum(scan);
		   System.out.println(stock);
		   listaProductos.add(new Producto(nombre, valor, stock)) ;
	}
    public static final int OPCION_MENU_AGREGAR_PRODUCTO =1;
    public static final int OPCION_MENU_AGREGAR_VENTA =2;
    public static final int OPCION_MENU_VER_VENTAS =3;
    public static final int OPCION_MENU_SALIR = 0;


    private static int opcionNum(Scanner scan) {
        String ingresa;
        int menu;
        ingresa=scan.nextLine();
        try {
            menu = Integer.parseInt(ingresa);
        } catch (NumberFormatException ex) {
            System.out.println("Error !"+ ex.getMessage()+" No es un numero");
            menu = 100;
        }
        return menu;
    }
    private static String  validarVacio(Scanner scan,String ingresa) {
        boolean bandera=false;
        while (!bandera){
            ingresa = scan.nextLine().toUpperCase();
            if (ingresa == "") {
                System.out.println("Debe ingresar algun dato");
            } else bandera = true;
        }
        return ingresa;
    }
}

