package br.univel.dao;

import java.util.ArrayList;

import br.univel.bicho.Bicho;

public interface bichoDao {

	Bicho criar(Bicho bicho);
	
	void deletar(Bicho bicho);
	
	Bicho editar(Bicho bicho);
	
	Bicho pegarPorID(int id);

	ArrayList<Bicho> pegarTodos();
	
}
