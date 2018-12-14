package mx.shf6.STSHF6.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Solucion {
	
	//PROPIEDADES
	public ObjectProperty<Integer> sysPk;
	public StringProperty solucion;
	public StringProperty proceso;
	
	//CONSTRUCTOR SIN PARAMETROS
	public Solucion() {
		this(0,"","");
	}//FIN CONSTRUCTOR
	
	//CONSTRUCTOR CON PARAMETROS
	public Solucion(Integer sysPk, String solucion, String proceso) {
		this.sysPk = new SimpleObjectProperty<Integer>(sysPk);
		this.solucion = new SimpleStringProperty(solucion);
		this.proceso = new SimpleStringProperty(proceso);
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
	
	//METODOS DE ACCESO A "SOLUCION"
	public void setSolucion(String solucion) {
		this.solucion.set(solucion);
	}//FIN METODO
		
	public String getSolucion() {
		return this.solucion.get();
	}//FIN METODO
	
	public StringProperty solucionProperty() {
		return this.solucion;
	}//FIN METODO
	//FIN METODOS ACCESO A "SOLUCION"
	
	//METODOS DE ACCESO A "PROCESO"
	public void setProceso(String proceso) {
		this.proceso.set(proceso);
	}//FIN METODO
			
	public String getProceso() {
		return this.proceso.get();
	}//FIN METODO
		
	public StringProperty procesoProperty() {
		return this.proceso;
	}//FIN METODO
	//FIN METODOS ACCESO A "PROCESO"
}//FIN CLASE