package com.Rodrigo.Entidades;

public class usuario extends tipoUsuarios{

	int idUsuario;
    String Usuario;
    String Password;
    String TipoUser;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

	public String getTipoUser() {
		return TipoUser;
	}

	public void setTipoUser(String tipoUser) {
		TipoUser = tipoUser;
	}


    
    
}
