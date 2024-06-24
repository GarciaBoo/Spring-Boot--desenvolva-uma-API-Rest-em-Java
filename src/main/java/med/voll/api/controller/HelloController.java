package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/hello") // Mapeia requisições HTTP para o caminho "/hello"
public class HelloController {

    @GetMapping // Mapeia requisições HTTP GET para o método olaMundo
    public String olaMundo() {
        return "Hello, World!";
    }
}