package com.Rodrigo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Rodrigo.Conexion.ConexionBd;

public class ClsArchivos {

	public void guardararchivos(String nombre) {
		ConexionBd con = new ConexionBd();
		PreparedStatement stm;
		String consulta = "Insert into imagen(Nombrearchivo) values(?)";
		try {
			stm = con.RetornarConexion().prepareStatement(consulta);
			stm.setString(1, nombre);
			stm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public String seleccionararchivos() {
		ConexionBd con = new ConexionBd();
		String nombre = "";
		PreparedStatement stm;
		String consulta = "Select * from imagen";
		try {
			stm = con.RetornarConexion().prepareStatement(consulta);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
                nombre = rs.getString("Nombrearchivo");
            }
		} catch (Exception e) {
			System.out.println(e);
		}
		return nombre;
	}
	
}
