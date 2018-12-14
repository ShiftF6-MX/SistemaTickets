package mx.shf6.STSHF6.testing;

import mx.shf6.STSHF6.model.Categoria;
import mx.shf6.STSHF6.model.Domicilio;
import mx.shf6.STSHF6.model.Empresa;
import mx.shf6.STSHF6.model.Solucion;
import mx.shf6.STSHF6.model.dao.CategoriaDAO;
import mx.shf6.STSHF6.model.dao.DomicilioDAO;
import mx.shf6.STSHF6.model.dao.EmpresaDAO;
import mx.shf6.STSHF6.model.dao.SolucionDAO;
import mx.shf6.STSHF6.utilities.ConnectionDB;

public class JoelTest {
	
	static ConnectionDB connectionDB =  new ConnectionDB("sistematickets", "192.168.0.216", "conn01", "Simons83Mx");
	//Empresa empresa = (Empresa) categoriaDAO.leer(connectionDB.conectarMySQL(), "SysPK", "" + this.getEmpresaFk()).get(0);
	//PROPIEDADES
	public static Categoria categoria;
	public static Domicilio domicilio;
	public static Empresa empresa;
	public static Solucion solucion;
	public static EmpresaDAO empresaDAO;
	public static CategoriaDAO categoriaDAO;
	public static DomicilioDAO domicilioDAO;
	public static SolucionDAO solucionDAO;
	
	
	public static void testCrearCategoria() {
		categoria = new Categoria();
		categoria.setNombre("Mantenimiento de Software");
		categoria.setDescripcion("Mantenimiento preventivo de software");
		categoriaDAO.crear(connectionDB.conectarMySQL(), categoria);
	}//FIN METODO
	
	public static void tesLeerCategoria() {
		categoria = (Categoria) categoriaDAO.leer(connectionDB.conectarMySQL(), "sysPk", "1").get(0);
		System.out.println(categoria.getNombre());
		System.out.println(categoria.getDescripcion());
	}//FIN METODO
	
	public static void testModificarCategoria() {
		categoria = (Categoria) categoriaDAO.leer(connectionDB.conectarMySQL(), "sysPk", "1").get(0);
		categoria.setDescripcion("Descripción modificada");
		categoriaDAO.modificar(connectionDB.conectarMySQL(), categoria);
	}//FIN METODO
	
	public static void testEliminarCategoria() {
		categoria = (Categoria) categoriaDAO.leer(connectionDB.conectarMySQL(), "sysPk", "1").get(0);
		categoriaDAO.eliminar(connectionDB.conectarMySQL(), categoria);
	}//FIN METODO
	//FIN METODOS DAO TABLA CATEGORIA
	
	public static void testCrearDomicilio() {
		domicilio = new Domicilio();
		domicilio.setCalle("Felipe Angeles");
		domicilio.setNumeroExterior("56");
		domicilio.setColonia("Centro");
		domicilio.setLocalidad("Emiliano Zapata");
		domicilio.setMunicipio("Emiliano Zapata");
		domicilio.setEstado("Hidalgo");
		domicilio.setCodigoPostal("43960");
		if (domicilioDAO.crear(connectionDB.conectarMySQL(), domicilio))
			System.out.println("Creado correctamente");
	}//FIN METODO
	
	public static void testModificarDomicilio() {
		domicilio = (Domicilio) domicilioDAO.leer(connectionDB.conectarMySQL(), "", "").get(0);
		domicilio.setColonia("Loma Bonita");
		if (domicilioDAO.modificar(connectionDB.conectarMySQL(), domicilio))
			System.out.println("Modificado correctamente");
	}//FIN METODO
	
	public static void testEliminarDomicilio() {
		domicilio = (Domicilio) domicilioDAO.leer(connectionDB.conectarMySQL(), "", "").get(0);
		domicilioDAO.eliminar(connectionDB.conectarMySQL(), domicilio);
	}//FIN METODO
	//FIN METODOS DAO DOMICILIO
	
	public static void testCrearEmpresa() {
		empresa = new Empresa();
		empresa.setRazonSocial("Shift F6");
		empresa.setTelefono("54646465");
		empresa.setStatus(1);
		empresa.setDomicilioFk(1);
		empresaDAO.crear(connectionDB.conectarMySQL(), empresa);
	}//FIN METODO
	
	public static void testModificarEmpresa() {
		empresa = (Empresa) empresaDAO.leer(connectionDB.conectarMySQL(), "sysPk", "1").get(0);
		empresa.setRazonSocial("Shift F6");
		empresaDAO.modificar(connectionDB.conectarMySQL(), empresa);
	}//FIN METODO
	
	public static void testEliminarEmpresa() {
		empresa = (Empresa) empresaDAO.leer(connectionDB.conectarMySQL(), "", "").get(0);
		empresaDAO.eliminar(connectionDB.conectarMySQL(), empresa);
	}//FIN METODO
	
	public static void testCrearSolucion() {
		solucion = new Solucion();
		solucion.setSolucion("Limpieza de cabezal");
		solucion.setProceso("1. Desarmar la impresora");
		solucionDAO.crear(connectionDB.conectarMySQL(), solucion);
	}//FIN METODO
	public static void main(String[] args) throws Exception{		
		categoriaDAO = new CategoriaDAO();
		domicilioDAO = new DomicilioDAO();
		empresaDAO = new EmpresaDAO();
		solucionDAO = new SolucionDAO();
		
		testCrearSolucion();
    }//FIN METODO	
}//FIN CLASE