package mx.shf6.STSHF6.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import mx.shf6.STSHF6.model.dao.CategoriaDAO;
import mx.shf6.STSHF6.model.dao.SolucionDAO;
import mx.shf6.STSHF6.model.dao.UsuarioDAO;

public class Ticket {
	
	//PROPIEDADES
	private ObjectProperty<Integer> sysPk;
	private StringProperty problema;
	private ObjectProperty<Date> fecha;
	private ObjectProperty<Image> adjunto;
	private StringProperty teamViewer;
	private StringProperty contrasenaTV;
	private ObjectProperty<Integer> prioridad;
	private ObjectProperty<Time> horaAtencion;
	private StringProperty diagnostico;
	private ObjectProperty<Time> tiempoAproxSolucion;
	private ObjectProperty<Integer> status;
	private ObjectProperty<Image> evidencia;
	private StringProperty notasSoporte;
	private ObjectProperty<Integer> usuarioFk;
	private ObjectProperty<Integer> ingenieroSoporteFk;
	private ObjectProperty<Integer> categoriaFk;
	private ObjectProperty<Integer> solucionFk;
	
	//CONSTANTES
	public static final int ENTREGADO = 0;
	public static final int REVISADO = 1;
	public static final int EN_PROCESO = 2;
	public static final int TERMINADO = 3;
	public static final int CANCELADO = 4;
	
	//CONSTRUCTOR SIN PARAMETROS
	public Ticket() {
		this(0,"",null,null,"","",0,null,"",null,0,null,"",0,0,0,0);
	}//FIN CONSTRUCTOR
	
	//CONSTRUCTOR CON PARAMETROS
	public Ticket(int sysPk, String problema, Date fecha, Image adjunto, String teamViewer, String contrasenaTV, int prioridad,
			Time horaAtencion, String diagnostico, Time tiempoAproxSolucion, int status, Image evidencia, String notasSoprte,
			int usuarioFk, int ingenieroSoporteFk, int categoriaFk, int solucionFk) {
		
		this.sysPk = new SimpleObjectProperty<Integer>(sysPk);
		this.problema = new SimpleStringProperty(problema);
		this.fecha = new SimpleObjectProperty<Date>(fecha);
		this.adjunto = new SimpleObjectProperty<Image>(adjunto);
		this.teamViewer = new SimpleStringProperty(teamViewer);
		this.contrasenaTV = new SimpleStringProperty(contrasenaTV);
		this.prioridad = new SimpleObjectProperty<Integer>(prioridad);
		this.horaAtencion = new SimpleObjectProperty<Time>(horaAtencion);
		this.diagnostico = new SimpleStringProperty(diagnostico);
		this.tiempoAproxSolucion = new SimpleObjectProperty<Time>(tiempoAproxSolucion);
		this.status = new SimpleObjectProperty<Integer>(status);
		this.evidencia = new SimpleObjectProperty<Image>(evidencia);
		this.notasSoporte = new SimpleStringProperty(notasSoprte);
		this.usuarioFk = new SimpleObjectProperty<Integer>(usuarioFk);
		this.ingenieroSoporteFk = new SimpleObjectProperty<Integer>(ingenieroSoporteFk);
		this.categoriaFk = new SimpleObjectProperty<Integer>(categoriaFk);
		this.solucionFk = new SimpleObjectProperty<Integer>(solucionFk);		
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
	//FIN METODOS "SYSPK"
	
	//METODOS DE ACCESO A "PROBLEMA"
	public void setProblema(String problema) {
		this.problema.set(problema);
	}//FIN METODO
	
	public String getProblema() {
		return this.problema.get();
	}//FIN METODO
	
	public StringProperty problemaProperty() {
		return this.problema;
	}//FIN METODO
	//FIN METODOS "PROBLEMA"
	
	//METODOS DE ACCESO A "FECHA"
	public void setFecha(Date fecha) {
		this.fecha.set(fecha);
	}//FIN METODO
	
	public Date getFecha() {
		return this.fecha.get();
	}//FIN METODO
	
	public ObjectProperty<Date> fechaProperty() {
		return this.fecha;
	}//FIN METODO
	//FIN METODOS "FECHA"
	
	//METODOS DE ACCESO A "ADJUNTO"
	public void setAdjunto(Image adjunto) {
		this.adjunto.set(adjunto);
	}//FIN METODO
	
	public Image getAdjunto() {
		return this.adjunto.get();
	}//FIN METODO
	
	public ObjectProperty<Image> adjuntoProperty() {
		return this.adjunto;
	}//FIN METODO
	//FIN METODOS DE ACCESO A "ADJUNTO"
	
	//METODOS DE ACCESO A "TEAMVIEWER"
	public void setTeamViewer(String teamViewer) {
		this.teamViewer.set(teamViewer);
	}//FIN METODO
	
	public String getTeamViewer() {
		return this.teamViewer.get();
	}//FIN METODO
	
	public StringProperty teamViewerProperty() {
		return this.teamViewer;
	}//FIN METODO
	//FIN METODOS DE ACCESO A "TEAMVIEWER"
	
	//METODOS DE ACCESO A "CONTRASENATV"
	public void setContrasenaTV(String contrasenaTV) {
		this.contrasenaTV.set(contrasenaTV);
	}//FIN METODO
	
	public String getContrasenaTV() {
		return this.contrasenaTV.get();
	}//FIN METODO
	
	public StringProperty contrasenaTVProperty() {
		return this.contrasenaTV;
	}//FIN METODO
	//FIN METODOS DE ACCESO A "CONTRASENATV"
	
	//METODOS DE ACCESO A "PRIORIDAD"
	public void setPrioridad(Integer prioridad) {
		this.prioridad.set(prioridad);
	}//FIN METODO
	
	public Integer getPrioridad() {
		return this.prioridad.get();
	}//FIN METODO
	
	public ObjectProperty<Integer> prioridadProperty() {
		return this.prioridad;
	}//FIN METODO	

	public String getDescripcionPrioridad() {
		switch (this.getPrioridad()) {
		case 0:
			return "No urgente";
		case 1:
			return "Urgente";
		}//FIN SWTITCH
		return "";
	}//FIN METODO
	
	public void setNumeroPrioridad(String prioridad) {
		switch (prioridad) {
		case "No urgente":
			this.setPrioridad(0);
			break;
		case "Urgente":
			this.setPrioridad(1);
			break;
		}//FIN SWTITCH
	}//FIN METODO
	
	public StringProperty descripcionPrioridadProperty() {
		switch (this.getPrioridad()) {
		case 0:
			return new SimpleStringProperty("No urgente");
		case 1:
			return new SimpleStringProperty("Urgente"); 
		}//FIN SWTITCH
		return new SimpleStringProperty();
	}//FIN METODO
	//FIN METODO "PRIORIDAD" 
	
	//METODOS DE ACCCESO A "HORAATENCION"
	public void setHoraAtencion(Time horaAtencion) {
		this.horaAtencion.set(horaAtencion);
	}//FIN METODO
	
	public Time getHoraAtencion() {
		return this.horaAtencion.get();
	}//FIN METODO
	
	public ObjectProperty<Time> horaAtencionProperty() {
		return this.horaAtencion;
	}//FIN METODO
	//FIN METODOS "HORAATENCION"
	
	//METODOS DE ACCESO A "DISGNOSTICO"
	public void setDiagnostico(String diagnostico) {
		this.diagnostico.set(diagnostico);
	}//FIN METODO
	
	public String getDiagnostico() {
		return this.diagnostico.get();
	}//FIN METODO
	
	public StringProperty diagnosticoProperty() {
		return this.diagnostico;
	}//FIN METODO
	//FIN METODOS DE ACCESO A "DISGNOSTICO"
	
	//METODOS DE ACCESO A "TIEMPO APROXIMADO DE SOLUCION"
	public void setTiempoAproxSolucion(Time tiempoAproxSolucion) {
		this.tiempoAproxSolucion.set(tiempoAproxSolucion);
	}//FIN METODO
	
	public Time getTiempoAproxSolucion() {
		return this.tiempoAproxSolucion.get();
	}//FIN METODO
	
	public ObjectProperty<Time> tiempoAproxSolucionProperty() {
		return this.tiempoAproxSolucion;
	}//FIN METODO
	//FIN METODOS "TIEMPO APROXIMADO DE SOLUCION"
	
	//METODOS DE ACCESO A "STATUS"
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
	//FIN METODOS DE ACCESO "STATUS"
	
	//METODOS DE ACCESO A "EVIDENCIA"
	public void setEvidencia(Image evidencia) {
		this.evidencia.set(evidencia);
	}//FIN METODO
	
	public Image getEvidencia() {
		return this.evidencia.get();
	}//FIN METODO
	
	public ObjectProperty<Image> evidenciaProperty() {
		return this.evidencia;
	}//FIN METODO
	//FIN METODOS DE ACCESO A "EVIDENCIA"
	
	//METODOS DE ACCESO A "NOTASSOPORTE"
	public void setNotasSoporte(String notasSoporte) {
		this.notasSoporte.set(notasSoporte);
	}//FIN METODO
	
	public String getNotasSoporte() {
		return this.notasSoporte.get();
	}//FIN METODO
	
	public StringProperty notasSoporteProperty() {
		return this.notasSoporte;
	}//FIN METODO
	//FIN METODOS DE ACCESO A "NOTASSOPORTE"
	
	//METODOS DE ACCESO A "USUARIO"
	public void setUsuarioFk(int usuario) {
		this.usuarioFk.set(usuario);
	}//FIN METODO

	public Integer getUsuarioFk() {
		return this.usuarioFk.get();
	}//FIN METODO

	public Usuario getUsuario(Connection connection) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = (Usuario) usuarioDAO.leer(connection, "SysPK", "" + this.getUsuarioFk()).get(0);
		return usuario;
	}//FIN METODO
	//FIN METODOS DE ACCESO A "USUARIO"
	
	//METODOS DE ACCESO A "INGENIERO SOPORTE"
	public void setIngenieroSoporteFk(int ingenieroSoporteFk) {
		this.ingenieroSoporteFk.set(ingenieroSoporteFk);
	}//FIN METODO

	public Integer getIngenieroSoporteFk() {
		return this.ingenieroSoporteFk.get();
	}//FIN METODO

	public Usuario getIngenieroSoporte(Connection connection) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario ingenieroSoporte = (Usuario) usuarioDAO.leer(connection, "SysPK", "" + this.getUsuarioFk()).get(0);
		return ingenieroSoporte;
	}//FIN METODO
	//FIN METODOS DE ACCESO A "INGENIERO SOPORTE"
	
	//METODOS DE ACCESO A "CATEGORIA"
	public void setCategoriaFk(int categoriaFk) {
		this.categoriaFk.set(categoriaFk);
	}//FIN METODO

	public Integer getCategoriaFk() {
		return this.categoriaFk.get();
	}//FIN METODO

	public Categoria getCategoria(Connection connection) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = (Categoria) categoriaDAO.leer(connection, "SysPK", "" + this.getUsuarioFk()).get(0);
		return categoria;
	}//FIN METODO
	//FIN METODOS DE ACCESO A "CATEGORIA"
	
	//METODOS DE ACCESO A "SOLUCION"
	public void setSolucionFk(int solucionFk) {
		this.solucionFk.set(solucionFk);
	}//FIN METODO

	public Integer getSolucionFk() {
		return this.solucionFk.get();
	}//FIN METODO

	public Solucion getSolucion(Connection connection) {
		SolucionDAO solucionDAO = new SolucionDAO();
		Solucion solucion = (Solucion) solucionDAO.leer(connection, "SysPK", "" + this.getUsuarioFk()).get(0);
		return solucion;
	}//FIN METODO
	//FIN METODOS DE ACCESO A "SOLUCION"
}//FIN CLASE