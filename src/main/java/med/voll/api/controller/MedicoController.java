package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired //Injecao de dependencia
    private MedicoRepository repository;

    @PostMapping //DTO -> record
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){ /* Para o Spring, a ordem dos campos do JSON é indiferente, sendo que apenas os nomes é que devem ser iguais aos que foram declarados no DTO. */
        repository.save(new Medico(dados));
    }
}
