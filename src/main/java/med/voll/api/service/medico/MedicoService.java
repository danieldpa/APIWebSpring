package med.voll.api.service.medico;

import med.voll.api.medico.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicoService implements IMedicoInterface{
    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public void cadastrarMedico(DadosCadastroMedico dados) {
        Medico medico = new Medico(dados); // Supondo que Medico tenha um construtor que aceite DadosCadastroMedico
        medicoRepository.save(medico);
    }

    @Override
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        // Transforma a Page<Medico> em Page<DadosListagemMedico>
        return medicoRepository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemMedico::new); // Supondo que DadosListagemMedico tenha um construtor que aceite Medico
    }

    @Override
    public void atualizar(@NotNull DadosAtualizacaoMedico dados) {
        Medico medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados); // Supondo que Medico tenha um método para atualizar suas informações
    }

    @Override
    public void excluir(Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.excluir(); // Supondo que Medico tenha um método para se marcar como inativo/excluído
    }
}
