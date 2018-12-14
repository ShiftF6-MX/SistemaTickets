package mx.shf6.STSHF6.model;

import java.sql.Connection;
import java.sql.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mx.shf6.STSHF6.model.dao.GrupoUsuarioDAO;

public class Usuario {
	
	//PROPIEDADES
	private ObjectProperty<Integer> sysPk;
	private StringProperty usuario;
	private StringProperty contrasena;
	private StringProperty correoElectronico;
	private ObjectProperty<Date> fechaRegistro;
	private ObjectProperty<Date> fechaBloqueo;
	private ObjectProperty<Integer> status;
	private ObjectProperty<Integer> grupoUsuarioFk;
	
	//CONSTANTES
	public static final int BLOQUEADO = 0;
	public static final int ACTIVO = 1;
	public static final int BAJA = 2;
	
	//CONSTRUCTOR SIN PARAMETROS	
	public Usuario() {
		this(0,"","",null,null,0,0);
	}//FIN CONSTRUCTOR
	
	//CONSTRUCTOR CON PARAMETROS
	public Usuario(Integer sysPk, String correoElectronico, String contrasena, Date fechaRegistro, Date fechaBloqueo,
			Integer status, Integer grupoUsuarioFk) {
		this.sysPk = new SimpleObjectProperty<Integer>(sysPk);
		this.correoElectronico = new SimpleStringProperty(correoElectronico);
		this.contrasena = new SimpleStringProperty(contrasena);		
		this.fechaRegistro = new SimpleObjectProperty<Date>(fechaRegistro);
		this.fechaBloqueo = new SimpleObjectProperty<Date>(fechaBloqueo);
		this.status = new SimpleObjectProperty<Integer>(status);
		this.grupoUsuarioFk = new SimpleObjectProperty<Integer>(grupoUsuarioFk);
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
	//FINT METODOS "SYSPK"
	
	//METODOS PARA ACCESO A "NOMBRE"
	public void setUsuario(String usuario) {
		this.usuario.set(usuario);
	}//FIN METODO
	
	public String getUsuario() {
		return this.usuario.get();
	}//FIN METODO
	
	public StringProperty usuarioProperty() {
		return this.usuario;
	}//FIN METODO
	//FIN METODOS "NOMBRE"
	
	//METODOS PARA ACCESO A "CONTRASE�A"
	public void setContrasena(String contrasena) {
		this.contrasena.set(contrasena);
	}//FIN METODO
	
	public String getContrasena() {
		return this.contrasena.get();
	}//FIN METODO
	
	public StringProperty contrasenaProperty() {
		return this.contrasena;
	}//FIN METODO
	//FIN METODOS "CONTRASENA"
	
	//METODOS PARA ACCESO A "CORREO ELECTRONICO"
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico.set(correoElectronico);
	}//FIN METODO
	
	public String getCorreoElectronico( ) {
		return this.correoElectronico.get();
	}//FIN METODO
	
	public StringProperty correoElectronicoProperty() {
		return this.correoElectronico;
	}//FIN METODO
	//FIN METODOS "CORREO ELECTRONICO"
	
	//METODOS PARA ACCESO A "FECHA REGISTRO"
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro.set(fechaRegistro);
	}//FIN METODO
	
	public Date getFechaRegistro() {
		if (this.fechaRegistro.get() == null)
			return Date.valueOf("1999-01-01");
		else
			return this.fechaRegistro.get();
	}//FIN METODO
	
	public ObjectProperty<Date> fechaRegistroProperty() {
		return this.fechaRegistro;
	}//END METODO
	//END METODOS "FECHA REGISTRO"
	
	//METODOS PARA ACCESO A "FECHA BLOQUEO"
	public void setFechaBloqueo(Date fechaBloqueo) {
		this.fechaBloqueo.set(fechaBloqueo);
	}//FIN METODO
	
	public Date getFechaBloqueo() {
		if (this.fechaBloqueo.get() == null)
			return Date.valueOf("1999-01-01");
		else
			return this.fechaBloqueo.get();
	}//FIN METODO
	
	public ObjectProperty<Date> fechaBloqueProperty() {
		return this.fechaBloqueo;
	}//FIN METODO
	//FIN METODOS "FECHA BLOQUEO"
	
	//METODOS PARA ACCESO A "STATUS"
	public void setStatus(Integer status) {
		this.status.set(status);
	}//FIN METODO
	
	public Integer getStatus() {
		return this.status.get();
	}//FIN METODO
	
	public ObjectProperty<Integer> statusProperty() {
		return this.status;
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
	//FIN METODO "STATUS"
	
	//METODOS PARA ACCESO A "GRUPO USUARIO"
	public void setGrupoUsuarioFk(Integer grupoUsuarioFk) {
		this.grupoUsuarioFk.set(grupoUsuarioFk);
	}//FIN METODO
	
	public Integer getGrupoUsuarioFk() {
		return this.grupoUsuarioFk.get();
	}//FIN METODO
	
	public GrupoUsuario getGrupoUsuario(Connection connection) {
		GrupoUsuarioDAO grupoUsuarioDAO = new GrupoUsuarioDAO();
		GrupoUsuario grupoUsuario = (GrupoUsuario) grupoUsuarioDAO.leer(connection, "SysPk", "" + this.getGrupoUsuarioFk()).get(0);
		return grupoUsuario;
	}//FIN METODO
	//FIN METODOS "GRUPO USUARIO"
	
	public String showInformacion() {
		String informacionUsuario = "INFORMACI�N DEL USUARIO \nSysPk: " + this.getSysPk() + "\n"
				+ "Nombre: " + this.getUsuario() + "\n"
						+ "Contrase�a: " + this.getContrasena() + "\n"
								+ "Correo Electr�nico: " + this.getCorreoElectronico() + "\n"
										+ "Fecha Registro: " + this.getFechaRegistro().toString() + "\n"
												+ "Fecha Bloqueo: " + this.getFechaBloqueo().toString() + "\n"
														+ "Status: " + this.getStatus() + "\n";
		return informacionUsuario;
	}//FIN METODO

}//FIN CLASE
