package mx.shf6.STSHF6.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Domicilio {

	//PROPIEDADES
	private ObjectProperty<Integer> sysPk;
	private StringProperty calle;
	private StringProperty numeroInterior;
	private StringProperty numeroExterior;
	private StringProperty colonia;
	private StringProperty localidad;
	private StringProperty municipio;
	private StringProperty estado;
	private StringProperty codigoPostal;
	
	//CONSTRUCTOR SIN PARAMETROS
	public Domicilio() {
		this(0,"","","","","","","","");
	}//FIN CONSTRUCTO
	
	//CONSTRUCTOR CON PARAMETROS
	public Domicilio(Integer sysPk, String calle, String numeroInterior, String numeroExterior, String colonia, String localidad,
			String municipio, String estado, String codigoPostal) {
		this.sysPk = new SimpleObjectProperty<Integer>(sysPk);
		this.calle = new SimpleStringProperty(calle);
		this.numeroInterior = new SimpleStringProperty(numeroInterior);
		this.numeroExterior = new SimpleStringProperty(numeroExterior);
		this.colonia = new SimpleStringProperty(colonia);
		this.localidad = new SimpleStringProperty(localidad);
		this.municipio = new SimpleStringProperty(municipio);
		this.estado = new SimpleStringProperty(estado);
		this.codigoPostal = new SimpleStringProperty(codigoPostal);
	}//FIN CONSTRUCTOR
	
	//METODOS PARA ACCESO A "SYSPK"
	public void setSysPk(Integer sysPk) {
		this.sysPk.set(sysPk);
	}//FIN METODO
	
	public Integer getSysPk() {
		return this.sysPk.get();
	}//FIN METODO
	
	public ObjectProperty<Integer> sysPkProperty() {
		return this.sysPk;
	}//FIN METODO
	//FIN METODOS "SYSPK"
	
	//METODOS PARA ACCESO A "CALLE"
	public void setCalle(String calle) {
		this.calle.set(calle);
	}//FIN METODO
	
	public String getCalle() {
		return this.calle.get();
	}//FIN METODO
	
	public StringProperty registroCalle() {
		return this.calle;
	}//FIN METODO
	//FIN METODOS "CALLE"
	
	//METODOS PARA ACCESO A "NUMERO INTERIOR"
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior.set(numeroInterior);
	}//FIN METODO
	
	public String getNumeroInterior() {
		return this.numeroInterior.get();
	}//FIN METODO
	
	public StringProperty numeroInteriorProperty() {
		return this.numeroInterior;
	}//FIN METODO
	//FIN METODOS "NUMERO INTERIOR"
	
	//METODOS PARA ACCESO A "NUMERO EXTERIOR"
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior.set(numeroExterior);
	}//FIN METODO
	
	public String getNumeroExterior() {
		return this.numeroExterior.get();
	}//FIN METODO
	
	public StringProperty numeroExteriorProperty() {
		return this.numeroExterior;
	}//FIN METODO
	//FIN METODOS "NUMERO EXTERIOR"
	
	//METODOS PARA ACCESO A "COLONIA"
	public void setColonia(String colonia) {
		this.colonia.set(colonia);
	}//FIN METODO
	
	public String getColonia() {
		return this.colonia.get();
	}//FIN METODO
	
	public StringProperty coloniaProperty() {
		return this.colonia;
	}//FIN METODO
	//FIN METODOS "COLONIA"
	
	//METODOS PARA ACCESO A "LOCALIDAD"
	public void setLocalidad(String localidad) {
		this.localidad.set(localidad);
	}//FIN METODO
	
	public String getLocalidad() {
		return this.localidad.get();
	}//FIN METODO
	
	public StringProperty localidadProperty() {
		return this.localidad;
	}//FIN METODO
	//FIN METODOS "LOCALIDAD"
	
	//METODOS PARA ACCESO A "MUNICIPIO"
	public void setMunicipio(String municipio) {
		this.municipio.set(municipio);
	}//FIN METODO
	
	public String getMunicipio() {
		return this.municipio.get();
	}//FIN METODO
	
	public StringProperty municipioProperty() {
		return this.municipio;
	}//FIN METODO
	//FIN METODOS "MUNICIPIO"
	
	//METODOS PARA ACCESO A "ESTADO"
	public void setEstado(String estado) {
		this.estado.set(estado);
	}//FIN METODO
	
	public String getEstado() {
		return this.estado.get();
	}//FIN METODO
	
	public StringProperty estadoProperty() {
		return this.estado;
	}//FIN METODO
	//FIN METODOS "ESTADO"
	
	//METODOS PARA ACCESO A "CODIGO POSTAL"
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal.set(codigoPostal);
	}//FIN METODO
	
	public String getCodigoPostal() {
		return this.codigoPostal.get();
	}//FIN METODO
	
	public StringProperty codigoPostalProperty() {
		return this.codigoPostal;
	}//FIN METODO
	//FIN METODOS "CODIGO POSTAL"
	
	public String showInformacion() {
		String informacionDomicilio ="INFORMACION DE DOMICILIO\nSysPk: " + this.getSysPk() + "\n"
				+ "Calle: " + this.getCalle() + " #Interior: " + this.getNumeroInterior() + " #Exterior: " + this.getNumeroExterior() + "\n"
						+ "Colonia: " + this.getColonia() + " Localidad: " + this.getLocalidad() + " Municipio: " + this.getMunicipio() + "\n"
								+ "Estado: " + this.getEstado() + " CodigoPostal: " + this.getCodigoPostal();
		return informacionDomicilio;
	}//FIN METODO
	
}//FIN CLASE
