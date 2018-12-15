package mx.shf6.STSHF6.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.shf6.STSHF6.model.Categoria1;
import mx.shf6.STSHF6.utilities.Notificacion;

public class Categoria1DAO implements ObjectDAO {
//METODO PARA HACER UPDATE EN LA TABLA CATEGORIAS
	@Override
	public boolean crear(Connection connection, Object objeto) {
		Categoria1 categoria1 = (Categoria1) objeto;
		String query = "INSERT INTO categorias (nombre,descripcion) VALUES (?, ?)";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setString(1, categoria1.getNombre());
			preparedStatement.setString(2, categoria1.getDescripcion()); 
			preparedStatement.execute(); 
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
			return false;
		}//FIN TRY-CATCH
	}//FIN METODO

	@Override
	public ArrayList<Object> leer(Connection connection, String campoBusqueda, String valorBusqueda) {
		String query = "";
		ArrayList<Object> listaCategorias = new ArrayList<Object> ();
		if (campoBusqueda.isEmpty() || valorBusqueda.isEmpty()) {
			query = "SELECT * FROM categorias ORDER BY nombre";
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				Categoria1 categoria1 = null;
				while (resultSet.next()) {
					categoria1 = new Categoria1 ();
					categoria1.setSysPK(resultSet.getInt(1));
					categoria1.setNombre(resultSet.getString(2));
					categoria1.setDescripcion(resultSet.getString(3));
					listaCategorias.add(categoria1);
				}//FIN WHILE
			} catch (SQLException ex) {
				Notificacion.dialogoException(ex);
			}//FIN TRY-CATCH
		} else {
			query = "SELECT * FROM categorias WHERE " + campoBusqueda + " = ? ORDER BY nombre";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, valorBusqueda);
				ResultSet resultSet = preparedStatement.executeQuery();
				Categoria1 categoria1 = null;
				while (resultSet.next()) {
					categoria1 = new Categoria1 ();
					categoria1.setSysPK(resultSet.getInt(1));
					categoria1.setNombre(resultSet.getString(2));
					categoria1.setDescripcion(resultSet.getString(3));
					listaCategorias.add(categoria1);
				}//FIN WHILE 	
			} catch (SQLException ex) {
				Notificacion.dialogoException(ex);
			}//FIN TRY-CATCH
		}//FIN IF-ELSE
		return listaCategorias;
	}//FIN METODO 

	@Override
	public boolean modificar(Connection connection, Object objeto) {
		String query = "UPDATE categorias SET nombre = ?, descripcion = ? WHERE sysPk = ?";
		try { 
			Categoria1 categoria1 = (Categoria1) objeto;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, categoria1.getNombre());
			preparedStatement.setString(2, categoria1.getDescripcion());
			preparedStatement.setInt(3, categoria1.getSysPk());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
			return false;
		}//FIN TRY-CATCH
	}//FIN METODO

	@Override
	public boolean eliminar(Connection connection, Object objeto) {
		String query = "DELETE FROM categorias WHERE sysPk = ?";
		Categoria1 categoria1 = (Categoria1) objeto;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, categoria1.getSysPk());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			//Notificacion.dialogoException(ex);
			System.out.println(ex);
			return false;
		}//FIN TRY-CATCH
	}//FIN METODO
}//FIN CLASE
