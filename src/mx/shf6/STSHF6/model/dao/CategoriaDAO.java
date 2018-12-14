package mx.shf6.STSHF6.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.shf6.STSHF6.model.Categoria;
import mx.shf6.STSHF6.utilities.Notificacion;

public class CategoriaDAO implements ObjectDAO{

	//METODO PARA HACER UPDATE EN TABLA CATEGORIAS
	@Override
	public boolean crear(Connection connection, Object Categoria) {	
		Categoria categoria = (Categoria)Categoria;
		String query=" INSERT INTO categorias (nombre, descripcion) values ( ?, ?)";
		try {	
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setString(1, categoria.getNombre());
			preparedStatement.setString(2, categoria.getDescripcion());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
			return false;
		}		
	}//FIN METODO	
	
	//METODO PARA HACER SELECT EN LA TABLA CATEGORIAS
	@Override
	public ArrayList<Object> leer(Connection connection, String campoBusqueda, String valorBusqueda) {
		String query ="";
		ArrayList<Object> listaCategorias = new ArrayList<Object>();
		if(campoBusqueda.isEmpty() || valorBusqueda.isEmpty()) {
			query="SELECT * FROM categorias ORDER BY nombre;";
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				Categoria categoria = null;
				while (resultSet.next()) {	
					categoria = new Categoria();
					categoria.setSysPk(resultSet.getInt(1));
					categoria.setNombre(resultSet.getString(2));
					categoria.setDescripcion(resultSet.getString(3));
					listaCategorias.add(categoria);
				}
			}catch (SQLException ex) {
				Notificacion.dialogoException(ex);
			}
		}else {
			query="SELECT * FROM categorias WHERE "+campoBusqueda+" = ? ORDER BY nombre;";
				try {
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, valorBusqueda);
					ResultSet resultSet=preparedStatement.executeQuery();
					Categoria categoria = null;
					while (resultSet.next()) {
						categoria = new Categoria();
						categoria.setSysPk(resultSet.getInt(1));
						categoria.setNombre(resultSet.getString(2));
						categoria.setDescripcion(resultSet.getString(3));
						listaCategorias.add(categoria);
					}
				}catch (SQLException ex) {
					Notificacion.dialogoException(ex);
				}
		}
		return listaCategorias;
	}//FIN METODO	
	
	//METODO PARA HACER UPDATE EN LA TABLA CATEGORIAS
	@Override
	public boolean modificar(Connection connection, Object Categoria) {
		String query="UPDATE categorias SET nombre = ?, descripcion= ? WHERE sysPK= ?;";
		try {
			Categoria categoria = (Categoria)Categoria;
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setString(1, categoria.getNombre());
			preparedStatement.setString(2, categoria.getDescripcion());	
			preparedStatement.setInt(3, categoria.getSysPk());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
			return false;
		}		
	}//FIN METODO
	
	
	//METODO PARA HACER DELETE EN LA TABLA CATEGORIAS
	@Override
	public boolean eliminar(Connection connection, Object Categoria) {
		String query=" DELETE FROM categorias WHERE sysPK= ?";
		try {		
			Categoria categoria = (Categoria)Categoria;
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setInt(1, categoria.getSysPk());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
			return false;
		}	
	}//FIN METODO
}//FIN CLASE