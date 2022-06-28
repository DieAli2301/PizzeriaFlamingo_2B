
package com.upchiapas.pizzeria.models;

public class ItemCompra {
    private int cantidad;
    private Pizza producto;
    private double subtotal;
    
    
	public ItemCompra() {
		
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Pizza getProducto() {
		return producto;
	}
	public void setProducto(Pizza producto) {
		this.producto = producto;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
    
    
	
}
