package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Editora;
import app.repository.EditoraRepository;

@Service
public class EditoraService {
	@Autowired
	private EditoraRepository editoraRepository;

	public String save(Editora editora) {
		this.editoraRepository.save(editora);
		return editora.getNome()+ " salvo com sucesso";
	}

	public String update(long id, Editora editora) {
		editora.setId(id);
		this.editoraRepository.save(editora);
		return editora.getNome()+ " atualizado com sucesso";
	}

	public List<Editora> listAll(){
		return this.editoraRepository.findAll();
	}

	public Editora findById(long idEditora) {

		Editora editora = this.editoraRepository.findById(idEditora).get();
		return editora;

	}

	public String delete(long idEditora) {
		this.editoraRepository.deleteById(idEditora);
		return "Editora deletado com sucesso!";

	}

}
