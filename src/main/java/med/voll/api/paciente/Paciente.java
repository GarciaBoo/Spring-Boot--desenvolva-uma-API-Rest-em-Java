package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import med.voll.api.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter  // Gera métodos getters automáticos para todos os campos
@NoArgsConstructor  // Gera um construtor sem argumentos
@AllArgsConstructor  // Gera um construtor que inicializa todos os campos
@EqualsAndHashCode(of = "id")  // Gera métodos equals() e hashCode() baseados no campo 'id'
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome,email, cpf, telefone;
    private boolean ativo;

    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformações(DadosAtualizacaoPaciente dados) {
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
        this.telefone = dados.telefone() != null ? dados.telefone() : this.telefone;
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void inativar(){
        this.ativo = false;
    }
}
