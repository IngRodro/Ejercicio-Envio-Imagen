package com.Rodrigo.Negocio;

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
}
