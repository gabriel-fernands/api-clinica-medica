package med.voll.api.dtosMedico;

import med.voll.api.enus.Especialidade;
import med.voll.api.domainMedico.medico.Medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
