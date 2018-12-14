package mx.shf6.STSHF6.model;

import java.sql.Connection;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mx.shf6.STSHF6.model.dao.DomicilioDAO;

public class Empresa {

	//PROPIEDADES
	private ObjectProperty<Integer> sysPk;
	private StringProperty razonSocial;
	private StringProperty telefono;
	private ObjectProperty<Integer> status;
	private ObjectProperty<Integer> domicilioFk;
	
	//CONSTANTES PARA "STATUS"
	public static final int BLOQUEADO = 0;
	public static final int ACTIVO = 1;
	public static final int BAJA = 2;
	
	//CONSTRUCTOR SIN PARAMETROS
	public Empresa() {
		this(0,"","",0,0);
	}//FIN CONSTRUCTOR
	
	//CONSTRUCTOR CON PARAMETROS
	public Empresa(Integer sysPk, String razonSocial, String telefono, Integer status, Integer domicilioFk) {
		this.sysPk = new SimpleObjectProperty<Integer>(sysPk);
		this.razonSocial = new SimpleStringProperty(razonSocial);
		this.telefono = new SimpleStringProperty(telefono);
		this.status = new SimpleObjectProperty<Integer>(status);
		this.domicilioFk = new SimpleObjectProperty<Integer>(domicilioFk);
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
	//FIN METODOS ACCESO
	
	//METODOS DE ACCESO A "RAZON SOCIAL"
	public void setRazonSocial(String razonSocial) {
		this.razonSocial.set(razonSocial);
	}//FIN METODO
	
	public String getRazonSocial() {
		return this.razonSocial.get();
	}//FIN METODO
	
	public StringProperty razonSocialProperty() {
		return this.razonSocial;
	}//FIN METODO
	//FIN METODOS ACCESO
	
	
	//METODOS DE ACCESO A "TELEFONO"
	public void setTelefono(String telefono) {
		this.telefono.set(telefono);
	}//FIN METODO
	
	public String getTelefono() {
		return this.telefono.get();
	}//FIN METODO
	
	public StringProperty telefonoProperty() {
		return this.telefono;
	}//FIN METODO
	//FIN METODOS ACCESO
	
	//METODOS DE ACCESO A "STATUS"
	public void setStatus(Integer status) {
		this.status.set(status);
	}//FIN METODO
	
	public Integer getStatus() {
		return this.status.get();
	}//FIN METODO
	
	public String getDescripcionStatus() {
		switch (this.getStatus()) {
		case 0:
			return "Bloqueado";
		case 1:
			return "Activo";
		case 2:
			return "Baja";
		}//FIN WTITCH
		return "";
	}//FIN METODO
	
	public void setNumeroStatus(String status) {
		switch (status) {
		case "Bloqueado":
			this.setStatus(0);
			break;
		case "Activo":
			this.setStatus(1);
			break;
		case "Baja":
			this.setStatus(2);
			break;
		}//FIN WTITCH
	}//FIN METODO
	
	public StringProperty descripcionStatusProperty() {
		switch (this.getStatus()) {
		case 0:
			return new SimpleStringProperty("Bloqueado");
		case 1:
			return new SimpleStringProperty("Activo");
		case 2:
			return new SimpleStringProperty("Baja");
		}//FIN WTITCH
		return new SimpleStringProperty();
	}//FIN METODO
	
	public ObjectProperty<Integer> statusProperty() {
		return this.status;
	}//FIN METODO
	//FIN METODOS ACCESO
	
	//METODOS DE ACCESO A "DOMICILIO"
	public void setDomicilioFk(Integer domicilioFk) {
		this.domicilioFk.set(domicilioFk);
	}//FIN METODO
	
	public Integer getDomicilioFk() {
		return this.domicilioFk.get();
	}//FIN METODO
	
	public Domicilio getDomicilio(Connection connection) {
		DomicilioDAO domicilioDAO = new DomicilioDAO();
		Domicilio domicilio = (Domicilio) domicilioDAO.leer(connection, "SysPK", "" + this.getDomicilioFk()).get(0);
		return domicilio;
	}//FIN METODO
	//FIN METODOS ACCESO
		
	public String showInformacion() {
		String informacionInstitucion = "INFORMACIÓN DE LA INSTITUCIÓN \nSysPk: " + this.getSysPk() + "\n"
				+ "Razón Social: " + this.getRazonSocial() + "\n"
						+ "Teléfono: " + this.getTelefono() + "\n"
								+ "Status: " + this.getStatus() + "\n";
		return informacionInstitucion;
	}//FIN METODO
	
}//FIN CLASE
