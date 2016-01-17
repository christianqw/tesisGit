package demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;



@RestController
public class VehicleController {



// consumes = "application/json", produces = "application/json",
	@RequestMapping(value = "/carsandtrucks", method = RequestMethod.POST)
  //@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<RequestWrapper> updateWithMultipleObjects(
			@RequestBody RequestWrapper requestWrapper) {
			System.out.println( "pre add");
			requestWrapper.getCars().stream()
								.forEach(c -> c.setMiles(c.getMiles() + 100));
			System.out.println( "post add");
			//console.log( requestWrapper.toString());

			System.out.println( "post String print");
		// TODO: call persistence layer to update
		return new ResponseEntity<RequestWrapper>(requestWrapper, HttpStatus.OK);
	}







}
