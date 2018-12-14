package mx.shf6.STSHF6.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.shf6.STSHF6.model.Solucion;
import mx.shf6.STSHF6.utilities.Notificacion;

public class SolucionDAO implements ObjectDAO{

	//METODO PARA HACER INSET EN LA TABLA SOLUCION
	@Override
	public boolean crear(Connection connection, Object Solucion) {	
		Solucion solucion = (Solucion)Solucion;
		String query=" INSERT INTO soluciones (solucion, proceso) values ( ?, ?)";
		try {	
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setString(1, solucion.getSolucion());
			preparedStatement.setString(2, solucion.getProceso());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
			return false;
		}		
	}//FIN METODO
	
	
	//METODO PARA HACER SELECT EN LA TABLA SOLUCION
	@Override
	public ArrayList<Object> leer(Connection connection, String campoBusqueda, String valorBusqueda) {
		String query ="";
		ArrayList<Object> listaCategorias = new ArrayList<Object>();
		if(campoBusqueda.isEmpty() || valorBusqueda.isEmpty()) {
			query="SELECT * FROM soluciones ORDER BY solucion;";
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				Solucion solucion = null;
				while (resultSet.next()) {	
					solucion = new Solucion();
					solucion.setSysPk(resultSet.getInt(1));
					solucion.setSolucion(resultSet.getString(2));
					solucion.setProceso(resultSet.getString(3));
					listaCategorias.add(solucion);
				}
			}catch (SQLException ex) {
				Notificacion.dialogoException(ex);
			}
		}else {
			query="SELECT * FROM soluciones WHERE "+campoBusqueda+" = ? ORDER BY solucion;";
				try {
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, valorBusqueda);
					ResultSet resultSet=preparedStatement.executeQuery();
					Solucion solucion = null;
					while (resultSet.next()) {	
						solucion = new Solucion();
						solucion.setSysPk(resultSet.getInt(1));
						solucion.setSolucion(resultSet.getString(2));
						solucion.setProceso(resultSet.getString(3));
						listaCategorias.add(solucion);
					}
				}catch (SQLException ex) {
					Notificacion.dialogoException(ex);
				}
		}
		return listaCategorias;
	}//FIN METODO
	
	
	//METODO PARA HACER UPDATE EN LA TABLA SOLUCION
	@Override
	public boolean modificar(Connection connection, Object Solucion) {
		String query="UPDATE categorias SET solucion = ?, proceso = ? WHERE sysPK= ?;";
		try {
			Solucion solucion=(Solucion)Solucion;
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setString(1, solucion.getSolucion());
			preparedStatement.setString(2, solucion.getProceso());	
			preparedStatement.setInt(3, solucion.getSysPk());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
			return false;
		}		
	}//FIN METODO
	
	
	//METODO PARA HACER DELETE EN LA TABLA SOLUCION
	@Override
	public boolean eliminar(Connection connection, Object Solucion) {
		String query="DELETE FROM categorias WHERE sysPK= ?";
		try {		
			Solucion solucion = (Solucion)Solucion;
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setInt(1, solucion.getSysPk());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
			return false;
		}	
	}//FIN METODO

}
