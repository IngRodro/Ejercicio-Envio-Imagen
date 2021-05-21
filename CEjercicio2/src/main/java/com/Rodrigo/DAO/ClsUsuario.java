package com.Rodrigo.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.Rodrigo.Conexion.ConexionBd;
import com.Rodrigo.Entidades.usuario;

public class ClsUsuario {
	ConexionBd conexion = new ConexionBd();
    Connection con = conexion.RetornarConexion();
    
	public ArrayList<usuario> ListadoUSUARIOS() {
        ArrayList<usuario> Lista = new ArrayList<>();

        try {

            CallableStatement consulta = con.prepareCall("select u.idUsuario, u.Usuario, u.password,t.TipoUser from usuario as u inner join tipousuario as t where u.tipoUsuario = t.id;");
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                usuario user = new usuario();
                user.setIdUsuario(rs.getInt("u.idUsuario"));
                user.setUsuario(rs.getString("u.Usuario"));
                user.setPassword(rs.getString("u.password"));
                user.setTipoUser(rs.getString("t.TipoUser"));
                Lista.add(user);
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Ha ocurrido un error en: \n\n\n\n" + e);
        }

        return Lista;
    }
	
	public void Eliminar (usuario user) {
		try {
			CallableStatement consulta = con.prepareCall("call SP_D_USER(?)");
			consulta.setInt("pIdUsuario", user.getIdUsuario());
			consulta.executeQuery();
			System.out.println("Exito");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void Actualizar (usuario user) {
		try {
			CallableStatement consulta = con.prepareCall("call SP_U_USUARIO(?,?,?)");
			consulta.setString("PUsuario", user.getUsuario());
			consulta.setString("PPass", user.getPassword());
			consulta.setInt("PidUsuario", user.getIdUsuario());
			consulta.executeQuery();
			System.out.println("Exito");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void Agregar (usuario user) {
		try {
			CallableStatement consulta = con.prepareCall("call SP_I_USUARIO(?,?,?)");
			consulta.setString("PUsuario", user.getUsuario());
			consulta.setString("PPass", user.getPassword());
			consulta.setString("PTipoUsuario", user.getTipoUser());
			consulta.executeQuery();
			System.out.println("Exito");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean LoguinUsuario(String usuario, String Pass) {
        ArrayList<usuario> ListaUsuarios = new ArrayList<>();
        ArrayList<usuario> ListarContra = new ArrayList<>();
        try {
            CallableStatement st = con.prepareCall("call SP_S_LOGUINUSUARIO(?,?)");
            st.setString("pusuario", usuario);
            st.setString("ppass", Pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
            	usuario Us = new usuario();
                Us.setUsuario(rs.getNString("Usuario"));
                Us.setPassword(rs.getNString("PassWord"));
                Us.setId(rs.getInt("tipoUsuario"));
                ListaUsuarios.add(Us);
            }
            String usuariodebasedatos = null;
            String passdebasededatos = null;
            int tipouserbasededatos = 0;
            for (var iterador : ListaUsuarios) {
                usuariodebasedatos = iterador.getUsuario();
                passdebasededatos = iterador.getPassword();
                tipouserbasededatos = iterador.getId();

            }

            CallableStatement st2 = con.prepareCall("call SP_S_CRIPMD5(?)");
            st2.setString("PcripPass", Pass);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
            	usuario escrip = new usuario();

                escrip.setPassword(rs2.getNString("crip"));
                ListarContra.add(escrip);
            }

            String passcrip = null;
            for (var iterador : ListarContra) {

                passcrip = iterador.getPassword();

                Pass = passcrip;

            }
           
            
            if(usuariodebasedatos!=null &&passdebasededatos!=null ){
            if (usuariodebasedatos.equals(usuario) && passdebasededatos.equals(Pass)){
                return true;
            }
            }
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
	
	 public String TipoUser(String usuario) {
	        String Tipo = "0";
	        usuario user = new usuario();
	        try {
	            CallableStatement Statement = con.prepareCall("Call SP_S_1Usuario(?)");
	            Statement.setString("PUsuario", usuario);
	            ResultSet rs = Statement.executeQuery();
	            while (rs.next()) {
	            user.setTipoUser(rs.getString("TipoUsuario"));
	            }
	        } catch (Exception e) {
	        }
	        Tipo = user.getTipoUser();
	        return Tipo;

	    }
	
}
