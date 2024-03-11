package med.voll.api.service.medico;

import med.voll.api.medico.DadosAtualizacaoMedico;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMedicoInterface {
    void cadastrarMedico(DadosCadastroMedico dados);

    Page<DadosListagemMedico> listar(Pageable paginacao);

    void atualizar(DadosAtualizacaoMedico dados);

    void excluir(Long id);
}
