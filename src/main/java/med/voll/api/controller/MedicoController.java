package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("medicos")
public class MedicoController {

    @Autowired // Injeta automaticamente uma instância de MedicoRepository gerenciada pelo Spring
    private MedicoRepository repository;

    @PostMapping // Mapeia requisições HTTP POST para este método
    @Transactional // Garante que todas as operações do método sejam executadas dentro de uma transação
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());

        medico.atualizarInformacoes(dados);
    }
}