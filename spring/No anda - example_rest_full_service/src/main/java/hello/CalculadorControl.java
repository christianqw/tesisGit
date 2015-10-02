package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadorControl {

    //private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/calcular")
    public Calculador greeting(@RequestParam(value="var1", defaultValue="200") int _var1,
                            @RequestParam(value="var2", defaultValue="5") int _var2){
        return new Calculador(counter.incrementAndGet(), _var1, _var2);
    }
}
