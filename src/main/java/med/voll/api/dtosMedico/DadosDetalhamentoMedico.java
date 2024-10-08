package med.voll.api.dtosMedico;

import med.voll.api.domainMedico.endereco.Endereco;
import med.voll.api.enus.Especialidade;
import med.voll.api.domainMedico.medico.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
