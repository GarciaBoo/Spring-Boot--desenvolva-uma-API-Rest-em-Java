package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos") // Define o nome da tabela no banco de dados como "medico"
@Entity(name = "Medico") // Define que esta classe é uma entidade JPA mapeada para a tabela "medico"
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id // Indica que o campo "id" é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor da chave primária será gerado automaticamente
    private Long id;

    private String nome, email, telefone, crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded // Indica que o campo "endereco" é um componente embutido e seus campos serão mapeados para a tabela "medico"
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
        this.telefone = dados.telefone() != null ? dados.telefone() : this.telefone;
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }
}