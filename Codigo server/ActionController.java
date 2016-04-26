package server;

import generadoresPackge.Estructura;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

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

	private final Map<String, Estructura> framesEstructuras;

	@Autowired
  public ActionController() {
      this.framesEstructuras = new HashMap<String, Estructura>();
  }

	public Estructura getEstructura(String s, String jsonConfig) throws ParseException{
		if (this.framesEstructuras.containsKey(s)){
			return (this.framesEstructuras.get(s));
		} else{
			Estructura e = new Estructura(jsonConfig);
			this.framesEstructuras.put(s, e);
			return e;
		}
	}

  //consumes = "application/json", produces = "application/json",
	@RequestMapping(value = "/action", method = RequestMethod.POST)
  //@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<RequestWrapper> updateWithMultipleObjectsViejo(
			@RequestBody RequestWrapper requestWrapper) {
			System.out.println( "Dentro del Action Estructura cargada: ");
			//System.out.println( this.e );
			//System.out.println( "RW:  ");
			//System.out.println( requestWrapper.toString() );
			//System.out.println( "");System.out.println( "");

//requestWrapper.ejecutar(this.e);

			/*requestWrapper.getCars().stream()
								.forEach(c -> c.setMiles(c.getMiles() + 100));
			System.out.println( "post add");
			//console.log( requestWrapper.toString());

			System.out.println( "post String print");
		// TODO: call persistence layer to update
*/
		return new ResponseEntity<RequestWrapper>(requestWrapper, HttpStatus.OK);
	}

	@RequestMapping(value = "/actionVerificar", method = RequestMethod.POST)
	public ResponseEntity<RequestWrapper> updateWithMultipleObjects(
			@RequestBody RequestWrapper asd) {
			System.out.println( "Dentro de action Test");
			System.out.println( "toString");
			System.out.println( asd.toString() );

			//Estructura e = getEstructura(asd.getnameIdFrame(), asd.getjsonConfig());

			System.out.println( "Estructura Pre procesar");
	//		System.out.println( e.toString() );

		return new ResponseEntity<RequestWrapper>(asd, HttpStatus.OK);
	}

/*
	@RequestMapping(value = "/siguiente1", method = RequestMethod.POST)
	public ResponseEntity<String> upload(MultipartHttpServletRequest request) {

		System.out.println( "Dentro siguiente !: ");

		System.out.println( "request: " +  request.getFileMap().size());
		System.out.println( "----- ");
		System.out.println( request.getFileMap().toString());
		Iterator<String> itr =  request.getFileNames();
		MultipartFile mpf = request.getFile(itr.next());
		System.out.println(mpf.getOriginalFilename() +" uploaded!");

				try {
									 //just temporary save file info into ufile
					// ufile.length = mpf.getBytes().length;
					// ufile.bytes= mpf.getBytes();
					// ufile.type = mpf.getContentType();
					// ufile.name = mpf.getOriginalFilename();

			 } catch (IOException e) {
					 // TODO Auto-generated catch block
					 e.printStackTrace();
			 }
		return new ResponseEntity<String>(" >>>> FIN <<<<", HttpStatus.OK);

 }

	*/


}
