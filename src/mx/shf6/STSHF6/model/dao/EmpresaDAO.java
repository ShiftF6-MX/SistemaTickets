package mx.shf6.STSHF6.model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mx.shf6.STSHF6.model.Empresa;
import mx.shf6.STSHF6.utilities.Notificacion;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmpresaDAO implements ObjectDAO {
	
	//METODO PARA HACER CREATE EN LA TABLA INSTITUCIONES
	@Override
	public boolean crear(Connection connection, Object Empresa){	
		Empresa empresa = (Empresa)Empresa;
		String query="INSERT INTO empresas (razonSocial, telefono, status, domicilio)"
		        + " values (?, ?, ?, ?)";
		try {			
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setString(1, empresa.getRazonSocial());
			preparedStatement.setString(2, empresa.getTelefono());
			preparedStatement.setInt(3, empresa.getStatus());
			preparedStatement.setInt(4, empresa.getDomicilioFk());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
			return false;
		}//FIN TRY/CATCH
	}//FIN METODO	
	
	//METODO PARA HACER SELECT EN LA TABLA INSTITUCIONES
	@Override
	public ArrayList<Object> leer(Connection connection, String campoBusqueda, String valorBusqueda) {
		String query ="";
		Empresa empresa = new Empresa();
		ArrayList<Object> listaEmpresa = new ArrayList<Object>();
		if (campoBusqueda.isEmpty() && valorBusqueda.isEmpty()) {
			query="SELECT * FROM empresas ORDER BY razonSocial;";
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					empresa = new Empresa();
					empresa.setSysPk(resultSet.getInt(1));
					empresa.setRazonSocial(resultSet.getString(2));
					empresa.setTelefono(resultSet.getString(3));
					empresa.setStatus(resultSet.getInt(4));
					empresa.setDomicilioFk(resultSet.getInt(5));
					listaEmpresa.add(empresa);
				}//FIN WHILE
			} catch (SQLException ex) {
				Notificacion.dialogoException(ex);
			}//FIN TRY/CATCH
		} else if (campoBusqueda.isEmpty()) {
				query="SELECT * FROM empresas WHERE razonSocial like '%" + valorBusqueda + "' ORDER BY razonSocial;";
				try {
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(query);
					while (resultSet.next()) {
						empresa = new Empresa();
						empresa.setSysPk(resultSet.getInt(1));
						empresa.setRazonSocial(resultSet.getString(2));
						empresa.setTelefono(resultSet.getString(3));
						empresa.setStatus(resultSet.getInt(4));
						empresa.setDomicilioFk(resultSet.getInt(5));
						listaEmpresa.add(empresa);
					}//FIN WHILE
				} catch (SQLException ex) {
					Notificacion.dialogoException(ex);
				}//FIN TRY/CATCH			
			} else {
				query="SELECT * FROM empresas WHERE " + campoBusqueda + " = ? ORDER BY razonSocial;";			
				try {
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, valorBusqueda);
					ResultSet resultSet=preparedStatement.executeQuery();
					while (resultSet.next()) {
						empresa = new Empresa();
						empresa.setSysPk(resultSet.getInt(1));
						empresa.setRazonSocial(resultSet.getString(2));
						empresa.setTelefono(resultSet.getString(3));
						empresa.setStatus(resultSet.getInt(4));
						empresa.setDomicilioFk(resultSet.getInt(5));
						listaEmpresa.add(empresa);
					}//FIN WHILE
				} catch (SQLException ex) {
					Notificacion.dialogoException(ex);
				}//FIN TRY/CATCH		
			}//FIN IF/ELSE
		return listaEmpresa;
	}//FIN METODO	
	
	//METODO PARA HACER UPDATE EN LA TABLA INSTITUCIONES
	@Override
	public boolean modificar(Connection connection, Object Empresa){
		Empresa empresa = (Empresa) Empresa;
		String query="UPDATE empresas "
					+ "SET razonSocial = ?, telefono = ?, status = ?, domicilio = ? "
					+ "WHERE sysPK = ?;";				
		try {				
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setString(1, empresa.getRazonSocial());
			preparedStatement.setString(2, empresa.getTelefono());
			preparedStatement.setInt(3, empresa.getStatus());
			preparedStatement.setInt(4, empresa.getDomicilioFk());
			preparedStatement.setInt(5, empresa.getSysPk());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
			return false;
		}//FIN TRY/CATCH
	}//FIN METODO	
	
	//METODO PARA HACER DELETE EN LA TABLA INSTITUCIONES
	@Override
	public boolean eliminar(Connection connection, Object Empresa) {
		String query1 = "DELETE FROM empresas WHERE sysPK = ?";
		String query2 = "DELETE FROM domicilios WHERE sysPk = ?";		
		Empresa empresa = (Empresa) Empresa;
		try {	
			PreparedStatement preparedStatement1 = (PreparedStatement) connection.prepareStatement(query1);
			preparedStatement1.setInt(1, empresa.getSysPk());
			preparedStatement1.execute();
			PreparedStatement preparedStatement2 = (PreparedStatement) connection.prepareStatement(query2);
			preparedStatement2.setInt(1, empresa.getDomicilioFk());
			preparedStatement2.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
			return false;
		}//FIN TRY/CATCH
	}//FIN METODO
	
	//METODO PARA CONVERTIR UNA ARRAYLIST A OBSERVABLELIST
	public ObservableList<Empresa> toObservableList(ArrayList<Object> arrayList) {
		ObservableList<Empresa> empresaData = FXCollections.observableArrayList();         
     	for(Object empresa : arrayList) {
     		empresaData.add((Empresa) empresa);
     	}//FIN FOR
     	return empresaData;
	}//FIN METODO
		
	//METODO PARA OBTENER EL ULTIMO SYSPK AGREGADO A LA TABLA 
	public int ultimoSysPk(Connection connection) {
		String query="SELECT sysPK FROM empresa order by sysPK asc";
		int ultimoSysPk = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				ultimoSysPk = resultSet.getInt(1);
			}//FIN WHILE
			return ultimoSysPk;
		}catch (SQLException e) {
			e.printStackTrace();
		}//FIN TRY/CATCH
		return ultimoSysPk;
	}//FIN METODO	
}//FIN CLASE