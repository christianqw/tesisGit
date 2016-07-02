package server;

import generadoresPackge.Estructura;
import java.util.*;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.awt.image.DataBufferByte;
import javax.imageio.ImageIO;
import java.io.InputStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;



@RestController
public class ActionController {
	// private final Mensaje2 m;
	//private final Estructura estruc;

	private Map<String, Estructura> framesEstructuras = new HashMap<String, Estructura>();;

/*  public ActionController() {
			System.out.println( "new al mapa inic <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			this.framesEstructuras = new HashMap<String, Estructura>();
  }
*/
	public Estructura getEstructura(String s, String jsonConfig) throws ParseException{
		System.out.println( "dentro de get estructura <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		if (this.framesEstructuras.containsKey(s)){
			System.out.println( ">>>>>> USADA");
			return (this.framesEstructuras.get(s));
		} else{
			System.out.println( ">>>>>> NUEVA ");
			Estructura e = new Estructura(jsonConfig);
			this.framesEstructuras.put(s, e);
			return e;
		}
	}


	@RequestMapping(value = "/actionVerificar", method = RequestMethod.POST)
	public ResponseEntity<List<Sentencia>> updateWithMultipleObjects(
			@RequestBody RequestWrapper requestWrapper) {

			System.out.println( "-----------XXXXXXX------------");
			//System.out.println( requestWrapper.toString() );
			System.out.println( ">>>>>>___________");
			System.out.println( "Estructura  Pre procesar");
			//System.out.println(  requestWrapper.getjsonConfig() );

			Estructura e =  null;
			try {
			 //The code you are trying to exception handle
			 e = getEstructura(requestWrapper.getnameIdFrame(), requestWrapper.getjsonConfig());

		 	}catch (Exception ex) {
			 //The handling for the code
		 		System.out.println( "ERROR PARSER ");
			};

			System.out.println( ">>>>>>____");
			System.out.println( "Estructura elemento seleccionada ");
			System.out.println( "Frame:" +requestWrapper.getnameIdFrame() + " Estructura: "+e.toString() );

			requestWrapper.ejecutar(e);

		return new ResponseEntity<List<Sentencia>>(requestWrapper.getListaSentencias(), HttpStatus.OK);
	}

}
