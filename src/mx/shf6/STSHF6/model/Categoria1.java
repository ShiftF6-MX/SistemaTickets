package mx.shf6.STSHF6.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Categoria1 {
	//PROPIEDADES
	private ObjectProperty<Integer> sysPk; 
	private StringProperty nombre;
	private StringProperty descripcion;

	//CONSTRUCTOR SIN PARAMETROS
	public Categoria1 () {
		 this (0,"","");
	}//FIN CONSTRUCTOR
	
	//CONSTRUCTOR CON PARAMETROS
	public Categoria1 (Integer sysPk, String nombre, String descripcion) { 
		this.sysPk = new SimpleObjectProperty<Integer>(sysPk);
		this.nombre = new SimpleStringProperty(nombre);
		this.descripcion = new SimpleStringProperty(descripcion);
	}//FIN CONSTRUCTOR
	
	//METODOS DE ACCESO A SYSPK
	public void setSysPK (Integer sysPk) {
		this.sysPk.set(sysPk);
	}//FIN METODO
	
	public Integer getSysPk() {
		return this.sysPk.get();
	}//FIN METODO
	
	public ObjectProperty<Integer> sysPkProperty(){
		return this.sysPk;
	}//FIN DE METODO
	//FIN METODO DE ACCESO A SYSPK
	
	//METODOS DE ACCESO NOMBRE
	public void setNombre (String nombre) {
		this.nombre.set(nombre);
	}//FIN METODO 
	
	public String getNombre() {
		return this.nombre.get();
	}//FIN METODO
	
	public StringProperty nombreProperty() {
		return this.nombre;
	}//FIN METODO
	//FIN METODO ACCESO A NOMBRE
	
	//METODOS DE ACCESO A DESCRIPCION
	public void setDescripcion (String descripcion) {
		this.descripcion.set(descripcion);
	}//FIN METODO
	
	public String getDescripcion() {
		return this.descripcion.get();
	}//FIN METODO
	
	public StringProperty descripcionProperty() {
		return this.descripcion;
	}//FIN METODO
	//FIN METODO ACCESO A DESCRIPCION
	
}//FIN CLASE
