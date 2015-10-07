package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public @ResponseBody Greeting greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/musicando")
    public Musico create(@RequestBody Musico m) {

           return m;
       }



    /* ANDAAAAA
        @RequestMapping("/musicando")
        public @ResponseBody Musico musico(
              @RequestParam("nombre") String valueOne, @RequestParam("instrumento") String valuetwo) {
        	System.out.println("==== in musicando ====");
          return new Musico(valueOne, valuetwo);
        }*/



  /* NO ANDA
  @RequestMapping(value = "/musicando", method = RequestMethod.POST)
  public  @ResponseBody Musico musicalizador( @RequestParam("musico") Musico mu, @RequestParam("banda") Banda b)   {
      System.out.println("==== in musicando ====");
      return mu;
  }

  @RequestMapping("/musicando")
    public @ResponseBody Musico post( @RequestParam Musico m) {
      System.out.println("==== in musicando ====");
      return m;
    }



  @RequestMapping(value = "/musicando",
              method = RequestMethod.POST,
              headers = {"Content-type=application/json"})

  @ResponseBody
  public Musico POST(@RequestBody Musico m) {
    System.out.println("==== in musicando ====");
    return m;
  }

  @RequestMapping("/musicando")
    public @ResponseBody Musico post( @RequestBody Musico m) {
      System.out.println("==== in musicando ====");
      return m;
    }

*/

}
