package com.Rodrigo.Controladores;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.Rodrigo.DAO.ClsArchivos;

/**
 * Servlet implementation class ControllerFiles
 */
@MultipartConfig
public class ControllerFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerFiles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Part archivo = request.getPart("archivo");
		String nombreimg = archivo.getSubmittedFileName();
		String ruta = "C:\\Users\\Usuario\\eclipse-workspace\\CEjercicio2\\src\\main\\webapp\\Files\\"+nombreimg;
		
		try {
			FileOutputStream fileoutput = new FileOutputStream(ruta);
			InputStream stream = archivo.getInputStream();
			
			byte[] datos = new byte[stream.available()];
			stream.read(datos);
			fileoutput.write(datos);
			fileoutput.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		ClsArchivos files = new ClsArchivos();
		files.guardararchivos(nombreimg);
		
	}

}
