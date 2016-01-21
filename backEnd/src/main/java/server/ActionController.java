package server;

import java.util.List;
import mensajeautomatico.*;

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


@RestController
public class ActionController {
	private final Mensaje2 m;
	private final mensaje m1;

	@Autowired
  public ActionController(Mensaje m1) {
      this.m1 = m1;
  }

// consumes = "application/json", produces = "application/json",
	@RequestMapping(value = "/act", method = RequestMethod.POST)
  //@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<RequestWrapper> updateWithMultipleObjects(
			@RequestBody RequestWrapper requestWrapper) {
			System.out.println( "Dentro del Action");
			System.out.println( this.m1 );

			/*requestWrapper.getCars().stream()
								.forEach(c -> c.setMiles(c.getMiles() + 100));
			System.out.println( "post add");
			//console.log( requestWrapper.toString());

			System.out.println( "post String print");
		// TODO: call persistence layer to update
*/
		return new ResponseEntity<RequestWrapper>(requestWrapper, HttpStatus.OK);
	}







}
