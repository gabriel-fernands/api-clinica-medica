package med.voll.api.medicoService;

import med.voll.api.domainMedico.medico.Medico;
import med.voll.api.dtosMedico.DadosAtualizacaoMedico;
import med.voll.api.dtosMedico.DadosCadastroMedico;
import med.voll.api.dtosMedico.DadosListagemMedico;
import med.voll.api.repositoryMedico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    @Transactional
    public Medico cadastrar(DadosCadastroMedico dados) {
        var medico = new Medico(dados);
        return repository.save(medico);
    }



    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @Transactional
    public Medico atualizar(DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return medico;
    }

    @Transactional
    public void excluir(Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

    public Medico detalhar(Long id) {
        return repository.getReferenceById(id);
    }
}