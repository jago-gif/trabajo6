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



        
        System.out.println("Bienvenido a nuestra tienda escoja una opcion");


        do {
            System.out.println("[1]      agregar producto");
            System.out.println("[2]      agregar venta");
            System.out.println("[3]      ventas del dia");
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
                   System.out.println("escriba el id del producto que desea comprar");
                   id=opcionNum(scan);
                   for(int i=0; i<listaProductos.size();i++) {
                	   if(id==listaProductos.get(i).getIdProducto()) {

                		   nombre=listaProductos.get(i).getNombre();
                		   valor=listaProductos.get(i).getValor();
                		   stock=listaProductos.get(i).getStock();
                		   while(!bstock) {
                    		   System.out.println("cantidad de "+nombre+" necesita");
                			   cantidad=opcionNum(scan);
                			   if(cantidad>stock) {
                				   System.out.println("Lo sentimos no tenemos suficiente Stock");
                			   }else {
                				   stock= stock-cantidad;
                				   System.out.println("Escoja el medio de pago");
                				   System.out.println("Efectivo               [1]");
                				   System.out.println("Tarjeta de Credito     [2]");
                				   System.out.println("Tarjeta de Debito      [3]");
                				   while(!pagado) {
                					   submenu=opcionNum(scan);
                                       if (submenu==1){
                                           tipoVenta= "efectivo";
                                           System.out.println("su compra en"+ tipoVenta+ "a finalizado exitosamente");
                                           Producto modificadorStock = new Producto(id, nombre, valor,stock);
                            			   listaProductos.set(id, modificadorStock); 
                                           listaVenta.add(new Venta(id,nombre,valor,tipoVenta,cantidad));
                            			   bstock=true;
                            			   pagado=true;

                                       }else if (submenu==2){
                                           tipoVenta= "Tarjeta Debito";
                                           System.out.println("su compra en"+ tipoVenta+ "a finalizado exitosamente");
                                           Producto modificadorStock = new Producto(id, nombre, valor,stock);
                            			   listaProductos.set(id, modificadorStock); 
                                           listaVenta.add(new Venta(id,nombre,valor,tipoVenta,cantidad));
                                           bstock=true;
                            			   pagado=true;
                                       		}else if (submenu==3){
                                           tipoVenta= "Tarjeta Credito";
                                           System.out.println("su compra en"+ tipoVenta+ "a finalizado exitosamente");
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
                       System.out.println(listaVenta.get(i).mostrar()+" total pagado "+ listaVenta.get(i).getCantidad()*
                    		   listaVenta.get(i).getValor());
                   }

                   for (int i=0; i<listaVenta.size();i++){
                	   acumulador += listaVenta.get(i).getCantidad()*listaVenta.get(i).getValor();
                   }
                   System.out.println("el total de ventas del día es de "+acumulador);
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
		System.out.println("escriba el nombre del producto");
		   nombre=validarVacio(scan,ingresa);
		   System.out.println(nombre);
		   System.out.println("ingrese valor del producto");
		   valor=opcionNum(scan);
		   System.out.println(valor);
		   System.out.println("ingrese el stock del producto");
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
                System.out.println("debe ingresar algun dato");
            } else bandera = true;
        }
        return ingresa;
    }
}

