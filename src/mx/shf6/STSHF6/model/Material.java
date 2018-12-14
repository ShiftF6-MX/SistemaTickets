package mx.shf6.STSHF6.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Material {
	
	//PROPIEDADES
	private ObjectProperty<Integer> sysPk;
	private StringProperty codigo;
	private StringProperty nombre;
	private ObjectProperty<Integer> cantidad;
	private StringProperty descripcion;
	
	//CONSTRUCTOR SIN PARAMETROS
	public Material() {
		this(0,"","",0,"");
	}//FIN CONSTRUCTOR
	
	//CONSTRUCTOR CON PARAMETROS
	public Material(Integer sysPk, String codigo, String nombre, Integer cantidad, String descripcion) {
		this.sysPk = new SimpleObjectProperty<Integer>(sysPk);
		this.codigo = new SimpleStringProperty(codigo);
		this.nombre = new SimpleStringProperty(nombre);
		this.cantidad = new SimpleObjectProperty<Integer>(cantidad);
		this.descripcion = new SimpleStringProperty(descripcion);
	}//FIN CONSTRUCTOR
	
	//METODOS DE ACCESO A "SYSPK"
	public void setSysPk(Integer sysPk) {
		this.sysPk.set(sysPk);
	}//FIN METODO
	
	public Integer getSysPk() {
		return this.sysPk.get();
	}//FIN METODO
	
	public ObjectProperty<Integer> sysPkProperty() {
		return this.sysPk;
	}//FIN METODO
	//FIN METODOS ACCESO A "SYSPK"
	
	//METODOS DE ACCESO A "CODIGO"
	public void setCodigo(String codigo) {
		this.codigo.set(codigo);
	}//FIN METODO
	
	public String getCodigo() {
		return this.codigo.get();
	}//FIN METODO
	
	public StringProperty codigoProperty() {
		return this.codigo;
	}//FIN METODO
	//FIN METODOS DE ACCESO A "CODIGO"
	
	//METODOS DE ACCESO A "NOMBRE"
	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}//FIN METODO
		
	public String getNombre() {
		return this.nombre.get();
	}//FIN METODO
		
	public StringProperty nombreProperty() {
		return this.nombre;
	}//FIN METODO
	//FIN METODOS DE ACCESO A "NOMBRE"
	
	//METODOS DE ACCESO A "CANTIDAD"
	public void setCantidad(Integer cantidad) {
		this.cantidad.set(cantidad);
	}//FIN METODO
		
	public Integer getCantidad() {
		return this.cantidad.get();
	}//FIN METODO
		
	public ObjectProperty<Integer> cantidadProperty() {
		return this.cantidad;
	}//FIN METODO
	//FIN METODOS ACCESO A "CANTIDAD"
	
	//METODOS DE ACCESO A "DESCRIPCION"
	public void setDescripcion(String descripcion) {
		this.descripcion.set(descripcion);
	}//FIN METODO
			
	public String getDescripcion() {
		return this.descripcion.get();
	}//FIN METODO
			
	public StringProperty descripcionProperty() {
		return this.descripcion;
	}//FIN METODO
	//FIN METODOS DE ACCESO A "DESCRIPCION"
}//FIN CLASE