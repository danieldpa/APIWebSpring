package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import med.voll.api.service.medico.IMedicoInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    private final IMedicoInterface medicoService;

    public MedicoController(IMedicoInterface medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping //DTO -> record
    @Transactional // Apenas para POST, DELETE, PUT
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){ /* Para o Spring, a ordem dos campos do JSON é indiferente, sendo que apenas os nomes é que devem ser iguais aos que foram declarados no DTO. */

        medicoService.cadastrarMedico(dados);
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return medicoService.listar(paginacao);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        medicoService.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        medicoService.excluir(id);
    }
}
