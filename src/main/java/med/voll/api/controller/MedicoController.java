package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("medicos")
public class MedicoController {

    @Autowired // Injeta automaticamente uma instância de MedicoRepository gerenciada pelo Spring
    private MedicoRepository repository;

    @Transactional // Garante que todas as operações do método sejam executadas dentro de uma transação
    @PostMapping // Mapeia requisições HTTP POST para este método
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }
}