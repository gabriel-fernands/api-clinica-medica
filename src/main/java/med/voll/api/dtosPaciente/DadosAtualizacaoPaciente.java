package med.voll.api.dtosPaciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dtosMedico.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
