package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("medicos")
public class MedicoController {

    @PostMapping
    public void cadastro(@RequestBody DadosCadastroMedico dado){

        System.out.println(dado);

    }
}
