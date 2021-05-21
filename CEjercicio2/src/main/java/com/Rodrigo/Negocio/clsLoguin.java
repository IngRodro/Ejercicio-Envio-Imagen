package com.Rodrigo.Negocio;

import com.Rodrigo.DAO.ClsUsuario;
import com.Rodrigo.Entidades.Loguin;

public class clsLoguin {

	
	public int acceso(Loguin log) {
		int acceso = 0;
		if(log.getUser().equals("Rodrigo") && log.getPass().equals("123")) {
			acceso = 1;
			
		}
		else {
			
		}
		return acceso;
	}
	
	public int accesoUsuarioBD(Loguin log) {
		ClsUsuario clsUser = new  ClsUsuario();
		int acceso = 0;
		if(clsUser.LoguinUsuario(log.getUser(), log.getPass())) {
			acceso = 1;
			
		}
		else {
			
		}
		return acceso;
	}
	
	public int TipoUsuario(Loguin log) {
		ClsUsuario clsUser = new  ClsUsuario();
		int acceso = 2;
		if(clsUser.TipoUser(log.getUser()).equals("1")) {
			acceso = 1;	
		}
		else {
			
		}
		return acceso;
	}
}
