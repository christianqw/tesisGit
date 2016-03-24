package server;

import generadoresPackge.Estructura;
import java.util.*;

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
	private final Estructura e;

	@Autowired
  public ActionController(Estructura e) {
      this.e = e;
  }

// consumes = "application/json", produces = "application/json",
	@RequestMapping(value = "/action", method = RequestMethod.POST)
  //@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<RequestWrapper> updateWithMultipleObjects(
			@RequestBody RequestWrapper requestWrapper) {
			System.out.println( "Dentro del Action Estructura cargada: ");
			//System.out.println( this.e );
			//System.out.println( "RW:  ");
			//System.out.println( requestWrapper.toString() );
			//System.out.println( "");System.out.println( "");
			requestWrapper.ejecutar(this.e);

			/*requestWrapper.getCars().stream()
								.forEach(c -> c.setMiles(c.getMiles() + 100));
			System.out.println( "post add");
			//console.log( requestWrapper.toString());

			System.out.println( "post String print");
		// TODO: call persistence layer to update
*/
		return new ResponseEntity<RequestWrapper>(requestWrapper, HttpStatus.OK);
	}

	@RequestMapping(value = "/siguiente1", method = RequestMethod.POST)
    public ResponseEntity<String> uploadMultipleFileHandler(@RequestParam("inputNameModel") String nameModelo,
            @RequestParam("filePaso1") MultipartFile[] files) {

      /*  if (files.length != names.length)
            return "Mandatory information missing";
 */
 				String[] names = {"modelIcon.png", "Fondo.png", "Mascara.png"};

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = names[i];

            try {
                byte[] imageInByte = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles"+ File.separator + nameModelo);
                if (!dir.exists()){
								//	System.out.println( "Ruta de las magenes: ");
								//	System.out.println( rootPath + File.separator + "tmpFiles" + File.separator + nameModelo);
									dir.mkdirs();
								}

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(imageInByte);
                stream.close();

                //logger.info("Server File Location="
                //        + serverFile.getAbsolutePath());

                System.out.println( "You successfully uploaded file=" + name);
            } catch (Exception e) {
								return new ResponseEntity<String>("You failed to upload " + name + " => " + e.getMessage(), HttpStatus.OK);
            }
        }
				String[] colors = null;
				//if ( files.length = 3){
					System.out.println( "Si tenemos cargado mascara ...");
					try {
						MultipartFile f = files[2];
						byte[] imageInByte = f.getBytes();
						InputStream in = new ByteArrayInputStream(imageInByte);
						BufferedImage image = ImageIO.read(in);
						colors = convertTo2DWithoutUsingGetRGB(image);
					} catch (Exception e) {
							return new ResponseEntity<String>("Error al generar la lista de colores => " + e.getMessage(), HttpStatus.OK);
					}
				//}
      	return new ResponseEntity<String>(" >>>> FIN <<<<", HttpStatus.OK);
    }

		private static String[] convertTo2DWithoutUsingGetRGB(BufferedImage image) {

				System.out.println( "DEntro de Static getClores ...");
		     final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		     final boolean hasAlphaChannel = image.getAlphaRaster() != null;
				 final Set<String> colores = new HashSet<String>();
		     if (hasAlphaChannel) {
		        final int pixelLength = 4;
		        for (int pixel = 0; pixel < pixels.length; pixel += pixelLength) {
		           int argb = 0;
		           argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
		           argb += ((int) pixels[pixel + 1] & 0xff); // blue
		           argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
		           argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
		           colores.add(Integer.toString(argb));
		        }
		     } else {
		        final int pixelLength = 3;
		        for (int pixel = 0; pixel < pixels.length; pixel += pixelLength) {
		           int argb = 0;
		           argb += -16777216; // 255 alpha
		           argb += ((int) pixels[pixel] & 0xff); // blue
		           argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
		           argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
		           colores.add(Integer.toString(argb));
		        }
		     }
				System.out.println( "Colores en el Conjunto: ");
				System.out.println( colores.toString() );

		    return colores.toArray(new String[colores.size()]);
		  }


/*
	@RequestMapping(value = "/siguiente1", method = RequestMethod.POST)
	public ResponseEntity<String> clickSiguiente() {
			System.out.println( "Dentro siguiente !: ");
			return new ResponseEntity<String>("Este es el string", HttpStatus.OK);
	}
*/
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
