package server;

import generadoresPackge.Estructura;
import java.io.FileReader;
import java.io.FileNotFoundException;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Estructura estructura() throws IOException, ClassNotFoundException, ParseException, FileNotFoundException{ //ClassNotFoundException,
        Estructura e = new Estructura(new FileReader("GranjaConfigJSON.json"));
        return e;

    }


}
