package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Autor;
import app.repository.AutorRepository;

@Service
public class AutorService {
	@Autowired
	private AutorRepository autorRepository;

	public String save(Autor autor) {
		this.autorRepository.save(autor);
		return autor.getNome()+ " salvo com sucesso";
	}

	public String update(long id, Autor autor) {
		autor.setId(id);
		this.autorRepository.save(autor);
		return autor.getNome()+ " atualizado com sucesso";
	}

	public List<Autor> listAll(){
		return this.autorRepository.findAll();
	}

	public Autor findById(long idAutor) {

		Autor autor = this.autorRepository.findById(idAutor).get();
		return autor;

	}

	public String delete(long idAutor) {
		this.autorRepository.deleteById(idAutor);
		return "Autor deletado com sucesso!";

	}
}
