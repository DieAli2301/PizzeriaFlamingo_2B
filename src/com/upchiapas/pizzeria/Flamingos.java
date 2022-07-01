
package com.upchiapas.pizzeria;

import com.upchiapas.pizzeria.models.CatalogoPizza;
import com.upchiapas.pizzeria.models.ItemCompra;
import com.upchiapas.pizzeria.models.OrdenCompra;
import com.upchiapas.pizzeria.models.Pizza;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Flamingos{   	
	public static void main(String[] args) {	
		int idPizza = 0;
		int idCompra = 0;
		ArrayList<OrdenCompra> pedidos = new ArrayList<>();		
		ArrayList<Pizza> catalogo = new ArrayList<>();
		CatalogoPizza catalogoPizza = new CatalogoPizza(catalogo);
		
		boolean isExit = false;
		int opcion = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("¡¡Bienvenido!!");
			System.out.println("1) Agregar pizza al catalogo");
			System.out.println("2) Generar orden");
			System.out.println("3) Imprimir ventas");
			System.out.println("4) Ordenar nombres de pedidos");
			System.out.println("5) Salir");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				sc = new Scanner(System.in);
				Pizza pizza = new Pizza();
				pizza.setId(idPizza+"");
				idPizza++;
				System.out.println("Ingresa la especialidad de la pizza:");
				String especialidad;
				especialidad = sc.nextLine();
				pizza.setEspecialidad(especialidad);
				System.out.println("Ingresa el precio de la pizza:");
				double precio = sc.nextDouble();
				pizza.setPrecio(precio);
				catalogoPizza.getCatalogo().add(pizza);			
				break;
			case 2:
				sc = new Scanner(System.in);
				OrdenCompra orden = new OrdenCompra();
				orden.setId(idCompra+"");
				System.out.println("Ingresa el nombre del cliente:");
				String nombreCliente = sc.nextLine();
				orden.setNombreCliente(nombreCliente);
				boolean isAddPizza = false;
				do {
					System.out.println("Añadir pizza a la orden:");
					System.out.println("-1) Terminar orden");
					System.out.println(catalogoPizza.toString());
					int menuOpcion = sc.nextInt();
					if(menuOpcion != -1) {
						try {
							ItemCompra itemCompra = new ItemCompra();
							System.out.println("Cuantas desea añadir de " + catalogoPizza.getCatalogo().get(menuOpcion).getEspecialidad());
							itemCompra.setCantidad(sc.nextInt());
							itemCompra.setProducto(catalogoPizza.getCatalogo().get(menuOpcion));
							itemCompra.setSubtotal(itemCompra.getCantidad() * catalogoPizza.getCatalogo().get(menuOpcion).getPrecio());
							orden.getProductos().add(itemCompra);
						} catch (Exception e) {
							System.out.println("Seleccione una opción correcta");
						}
					}else {						
						isAddPizza = true;
						if(orden.getProductos().size() > 0) {
							pedidos.add(orden);
						}
					}
					System.out.println("Subtotal: " + orden.getTotal());
				}while(!isAddPizza);
				System.out.println("Subtotal: " + orden.getTotal());
				break;
			case 3:
				System.out.println("'Reporte de ventas'");
				for (Iterator iterator = pedidos.iterator(); iterator.hasNext();) {
					System.out.println("----------------------------------");
					OrdenCompra ordenReporte = (OrdenCompra) iterator.next();
					System.out.println("Nombre del cliente: " + ordenReporte.getNombreCliente());
					System.out.println("Productos: ");
					for (Iterator iterator2 = ordenReporte.getProductos().iterator(); iterator2.hasNext();) {
						ItemCompra itemCompra = (ItemCompra) iterator2.next();
						System.out.println("Especialidad: " + itemCompra.getProducto().getEspecialidad() + " - Cantidad: " + itemCompra.getCantidad() + " - Subtotal: " + itemCompra.getSubtotal());
					}
					System.out.println("Total: " + ordenReporte.getTotal());
				}
				break;
				case 4:
					String nombre[] = new String[pedidos.size()];
					for (int i=0; i<pedidos.size(); i++){
						nombre[i] = pedidos.get(i).getNombreCliente();
					}
					String auxiliar;
					for (int i=0; i< (nombre.length-1); i++){
						for (int j=0; j< (nombre.length-1); j++){
							if(nombre[j].compareTo(nombre[j+1]) > 0){
								auxiliar = nombre[j];
								nombre[j] = nombre[j+1];
								nombre[j+1] = auxiliar;
							}
						}
					}
					for (int i=0; i<nombre.length; i++){
						System.out.println("Nombres : " + nombre[i]);
					}
			case 5:
				System.out.println("Adios!!");
				isExit = true;
				break;
			default:
				System.out.println("Selecciona opción valida");
				break;
			}
			
		}while(!isExit);
	}
	
	
}