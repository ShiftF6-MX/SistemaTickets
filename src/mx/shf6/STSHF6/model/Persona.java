package mx.shf6.STSHF6.model;

import java.sql.Connection;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mx.shf6.STSHF6.model.dao.DomicilioDAO;
import mx.shf6.STSHF6.model.dao.EmpresaDAO;
import mx.shf6.STSHF6.model.dao.UsuarioDAO;

public class Persona {

	//PROPIEDADES
	private ObjectProperty<Integer> sysPk;
	private StringProperty titulo;
	private StringProperty primerNombre;
	private StringProperty segundoNombre;
	private StringProperty apellidoPaterno;
	private StringProperty apellidoMaterno;
	private ObjectProperty<Integer> domicilioFk;
	private ObjectProperty<Integer> puesto;
	private ObjectProperty<Integer> area;
	private StringProperty telefono;
	private ObjectProperty<Integer> empresaFk;
	private ObjectProperty<Integer> usuarioFk;
	private BooleanProperty seleccionado;
	
	//CONSTANTES PARA "SEXO"
	public static final int HOMBRE = 0;
	public static final int MUJER = 1;
	
	//CONSTANTES PARA "PUESTO"
	public static final int REPRESENTANTE = 0;
	public static final int DIRECTOR = 1;
	public static final int COORDINADOR = 2;
	public static final int ANALISTA = 3;
	public static final int AUXILIAR = 4;
	
	//CONSTANTES PARA "AREA"
	public static final int ADMINISTRATIVO = 0;
	public static final int PRODUCCION = 1;
	public static final int ALMACEN = 2;
	
	//CONSTRUCTOR SIN PARAMETROS
	public Persona() {
		this(0, "", "", "", "", "", 0, 0, 0, "", 0, 0, false);
	}//FIN CONSTRUCTOR
	
	//CONSTRUCTOR CON PARAMETROS
	public Persona(Integer sysPk, String titulo, String primerNombre, String segundoNombre, String apellidoPaterno,
			String apellidoMaterno, int domicilioFk, int puesto, int area, String telefono, int empresaFk, int usuarioFk, boolean seleccionado) {
		this.sysPk = new SimpleObjectProperty<Integer>(sysPk);
		this.titulo = new SimpleStringProperty(titulo);
		this.primerNombre = new SimpleStringProperty(primerNombre);
		this.segundoNombre = new SimpleStringProperty(segundoNombre);
		this.apellidoPaterno = new SimpleStringProperty(apellidoPaterno);
		this.apellidoMaterno = new SimpleStringProperty(apellidoMaterno);
		this.domicilioFk = new SimpleObjectProperty<Integer>(domicilioFk);
		this.puesto = new SimpleObjectProperty<Integer>(puesto);
		this.puesto = new SimpleObjectProperty<Integer>(area);
		this.telefono = new SimpleStringProperty(telefono);
		this.empresaFk = new SimpleObjectProperty<Integer>(empresaFk);
		this.usuarioFk = new SimpleObjectProperty<Integer>(usuarioFk);
		this.seleccionado = new SimpleBooleanProperty(seleccionado);
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
	
	//METODOS PARA ACCESO A "TITULO"
	public void setTitulo(String titulo) {
		this.titulo.set(titulo);
	}//FIN METODO
	
	public String getTitulo() {
		return this.titulo.get();
	}//FIN METODO
	
	public StringProperty tituloProperty() {
		return this.titulo;
	}//FIN METODO
	//FIN METODOS "TITULO"
	
	//METODOS PARA ACCESO A "PRIMER NOMBRE"
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre.set(primerNombre);
	}//FIN METODO
	
	public String getPrimerNombre() {
		return this.primerNombre.get();
	}//FIN METODO
	
	public StringProperty primerNombreProperty() {
		return this.primerNombre;
	}//FIN METODO
	//FIN METODOS "PRIMER NOMBRE"
	
	//METODOS PARA ACCESO A "SEGUNDO NOMBRE"
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre.set(segundoNombre);
	}//FIN METODO
	
	public String getSegundoNombre() {
		return this.segundoNombre.get();
	}//FIN METODO
	
	public StringProperty segundoNombreProperty() {
		return this.segundoNombre;
	}//FIN METODO
	//FIN METODOS "SEGUNDO NOMBRE"
	
	//METODOS PARA ACCESO A "APELLIDO PATERNO"
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno.set(apellidoPaterno);
	}//FIN METODO
	
	public String getApellidoPaterno() {
		return this.apellidoPaterno.get();
	}//FIN METODO
	
	public StringProperty apellidoPaternoProperty() {
		return this.apellidoPaterno;
	}//FIN METODO
	//FIN METODOS "APELLIDO PATERNO"
	
	//METODOS PARA ACCESO A "APELLIDO MATERNO"
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno.set(apellidoMaterno);
	}//FIN METODO
	
	public String getApellidoMaterno() {
		return this.apellidoMaterno.get();
	}//FIN METODO
	
	public StringProperty apellidoMaternoProperty() {
		return this.apellidoMaterno;
	}//FIN METODO
	//FIN METODOS "APELLIDO MATERNO"
	
	//METODOS PARA ACCESO A "DOMICILIO"
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
	//FIN METODOS "DOMICILIO"
	
	//METODOS PARA ACCESO A "PUESTO"
	public void setPuesto(Integer puesto) {
		this.puesto.set(puesto);
	}//FIN METODO
	
	public Integer getPuesto() {
		return this.puesto.get();
	}//FIN METODO
	
	public ObjectProperty<Integer> puestoProperty() {
		return this.puesto;
	}//FIN METODO
	
	public String getDescripcionPuesto() {
		switch (this.getPuesto()) {
		case 0:
			return "Representante";
		case 1:
			return "Director";
		case 2:
			return "Coordinador";
		case 3:
			return "Analista";
		case 4:
			return "Auxiliar";
		}//FIN WTITCH
		return "";
	}//FIN METODO
	
	public void setNumeroStatus(String puesto) {
		switch (puesto) {
		case "Representante":
			this.setPuesto(0);
			break;
		case "Coordinador":
			this.setPuesto(1);
			break;
		case "Director":
			this.setPuesto(2);
			break;
		case "Analista":
			this.setPuesto(3);
			break;
		case "Auxiliar":
			this.setPuesto(4);
			break;
		}//FIN WTITCH
	}//FIN METODO
	//FIN METODOS "PUESTO"
	
	//METODOS PARA ACCESO A "AREA"
	public void setArea(Integer area) {
		this.area.set(area);
	}//FIN METODO
	
	public Integer getArea() {
		return this.area.get();
	}//FIN METODO
	
	public ObjectProperty<Integer> areaProperty() {
		return this.area;
	}//FIN METODO
	
	public String getDescripcionArea() {
		switch (this.getPuesto()) {
		case 0:
			return "Administrativo";
		case 1:
			return "Produccion";
		case 2:
			return "Almacen";
		}//FIN WTITCH
		return "";
	}//FIN METODO
	
	public void setNumeroArea(String puesto) {
		switch (puesto) {
		case "Administrativo":
			this.setPuesto(0);
			break;
		case "Produccion":
			this.setPuesto(1);
			break;
		case "Almacen":
			this.setPuesto(2);
			break;
		}//FIN WTITCH
	}//FIN METODO
	//FIN METODOS "AREA"
	
	//METODOS PARA ACCESO A "TELEFONO"
	public void setTelefono(String telefono) {
		this.telefono.set(telefono);
	}//FIN METODO
	
	public String getTelefono() {
		return this.telefono.get();
	}//FIN METODO
	
	public StringProperty telefonoProperty() {
		return this.telefono;
	}//FIN METODO
	//FIN METODOS "TELEFONO"
	
	//METODOS DE ACCESOS A "EMPRESA"
	public void setEmpresaFk(Integer empresaFk) {
		this.empresaFk.set(empresaFk);
	}//FIN METODO
	
	public Integer getEmpresaFk() {
		return this.empresaFk.get();
	}//FIN METODO
	
	public Empresa getEmpresa(Connection connection) {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Empresa empresa = (Empresa) empresaDAO.leer(connection, "SysPK", "" + this.getEmpresaFk()).get(0);
		return empresa;
	}//FIN METODO
	//FIN METODOS ACCESO
	
	//METODOS PARA ACCESO A "USUARIO"
	public void setUsuarioFk(Integer usuarioFk) {
		this.usuarioFk.set(usuarioFk);
	}//FIN METODO
	
	public Integer getUsuarioFk() {
		return this.usuarioFk.get();
	}//FIN METODO
	
	public Usuario getUsuario(Connection connection) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = (Usuario) usuarioDAO.leer(connection, "SysPK", "" + this.getUsuarioFk()).get(0);
		return usuario;
	}//FIN METODO
	//FIN METODOS "USUARIO"

	//METODOS DE ACCESO A SELECCIONADO
	public BooleanProperty seleccionadoProperty() {
		return this.seleccionado;
	}//FIN METODO	

	public boolean isSeleccionado() {
		return this.seleccionadoProperty().get();
	}//FIN METODO	

	public void setSeleccionado(final boolean seleccionado) {
		this.seleccionadoProperty().set(seleccionado);
	}//FIN METODO
	//FIN METODO DE ACCESO 
	
	public String showInformacion(Connection connection) {
		String informacionPersona = "INFORMACIÖN DE PERSONA\nSysPk: " + this.getSysPk() + "\n"
				+ "Título: " + this.getTitulo() + "\n"
						+ "Nombre Completo: " + this.getPrimerNombre() + " " + this.getSegundoNombre() + " " + this.getApellidoPaterno() + " " + this.getApellidoMaterno() + "\n"
								+ "Domicilio: " + this.getDomicilio(connection).showInformacion() + "\n"
										+ "Puesto: " + this.getPuesto() + " Teléfono: " + this.getTelefono() + "\n"
												+ "Usuario: " + this.getUsuario(connection).showInformacion();
		return informacionPersona;
	}//FIN METODO
	
	public String getNombreCompleto() {
		if (getSegundoNombre() == null) {
			String nombreCompleto = this.getPrimerNombre()  + " " + this.getApellidoPaterno() + " " + this.getApellidoMaterno();
			return nombreCompleto;
		}else {
			String nombreCompleto = this.getPrimerNombre() + " " + this.getSegundoNombre() + " " + this.getApellidoPaterno() + " " + this.getApellidoMaterno();
			return nombreCompleto;
		}//FIN IF-ELSE			
	}//FIN METODO
	
	public StringProperty nombreCompletoProperty() {
		if (getSegundoNombre() == null) {
			String nombreCompleto = this.getPrimerNombre()  + " " + this.getApellidoPaterno() + " " + this.getApellidoMaterno();
			return new SimpleStringProperty(nombreCompleto);
		}else {
			String nombreCompleto = this.getPrimerNombre() + " " + this.getSegundoNombre() + " " + this.getApellidoPaterno() + " " + this.getApellidoMaterno();
			return new SimpleStringProperty(nombreCompleto);
		}//FIN IF-ELSE			
	}//FIN METODO
	
}//FIN CLASE
