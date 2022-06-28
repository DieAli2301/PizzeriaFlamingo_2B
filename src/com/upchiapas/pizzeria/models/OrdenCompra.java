
package com.upchiapas.pizzeria.models;

import java.util.ArrayList;
import java.util.Iterator;

public class OrdenCompra {
	private String id;
	private ArrayList<ItemCompra> productos;
	private double total;
	private String nombreCliente;
    
    public OrdenCompra(){      
        productos = new ArrayList();
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<ItemCompra> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ItemCompra> productos) {
		this.productos = productos;
	}

	public double getTotal() {
		total = 0;
		for (Iterator iterator = productos.iterator(); iterator.hasNext();) {
			ItemCompra itemCompra = (ItemCompra) iterator.next();
			total += itemCompra.getSubtotal();
		}
		return total;
	}

	
	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
    
}