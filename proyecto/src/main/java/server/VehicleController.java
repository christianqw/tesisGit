package server;

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
public class ActionController {

	@RequestMapping(value = "/action", method = RequestMethod.POST)
	public ResponseEntity<RequestWrapper> updateWithMultipleObjects(
			@RequestBody RequestWrapper requestWrapper) {
/*
		requestWrapper.getCars().stream()
				.forEach(c -> c.setMiles(c.getMiles() + 100));
*/
		// TODO: call persistence layer to update
		return new ResponseEntity<RequestWrapper>(requestWrapper, HttpStatus.OK);
	}
}
