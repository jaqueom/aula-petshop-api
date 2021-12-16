package br.com.tt.petshop.service;

import br.com.tt.petshop.client.petshop.CaoApiClient;
import br.com.tt.petshop.dto.Animais;
import br.com.tt.petshop.dto.AnimalCriacao;
import br.com.tt.petshop.dto.TipoAnimal;
import br.com.tt.petshop.exception.NaoExisteException;
import br.com.tt.petshop.exception.NegocioException;
import br.com.tt.petshop.factory.AnimaisFactory;
import br.com.tt.petshop.repository.AnimaisRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AnimaisService {
/*
    private final AnimaisRepository animaisRepository;
    private final CaoApiClient caoApiClient;

    public List<Animais> listar(String nome){
        List<Animais> animais;
        if (nome == null){
            animais = animaisRepository.findAll();
        }else{
            animais = animaisRepository.findByNomeContaining(nome);
        }
        return animais;
    }

    public Animais buscarPorId(Long id){
        return null;
        //animaisRepository.findById(id);
    }

    public Long criar(Animais animais) {

        String urlFoto;
        if (animais.getTipo() == TipoAnimal.CAO){
            urlFoto = caoApiClient.obterUrlFotoCao();
        }else if (animais.getTipo() == TipoAnimal.GATO){
            urlFoto = "teste";
        }else {
            throw new NegocioException("Animal inválido!");
        }

        log.info("URLFoto: {}", urlFoto);

        AnimalCriacao a = AnimaisFactory.criarAnimais(animais);
        //AnimalCriacao animalSalvo = animaisRepository.save(a);

        return a.getId();
    }

    public void apagar(Long id) {
        animaisRepository.deleteById(id);
    }

    public void atualizar(Long id, Animais animal) {
        Animais animalAtualizado = new Animais(id
                , animal.getTipo()
                , animal.getNome()
                , animal.getNascimento()
                , animal.getFoto());

        animaisRepository.save(animalAtualizado);

    }
*/
}
