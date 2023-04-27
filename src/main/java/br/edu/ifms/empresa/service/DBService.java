package br.edu.ifms.empresa.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.empresa.model.Almoxarifado;
import br.edu.ifms.empresa.model.Equipamento;
import br.edu.ifms.empresa.model.Produtos;
import br.edu.ifms.empresa.model.Secoes;
import br.edu.ifms.empresa.repository.RepositoryAlmoxarifado;
import br.edu.ifms.empresa.repository.RepositoryEquipamento;
import br.edu.ifms.empresa.repository.RepositoryProdutos;
import br.edu.ifms.empresa.repository.RepositorySecoes;


@Service
public class DBService {
	@Autowired
	RepositoryAlmoxarifado repositoryAlmoxarifado;
	@Autowired
	RepositorySecoes repositorySecoes;
	@Autowired
	RepositoryProdutos repositoryProdutos;
	@Autowired
	RepositoryEquipamento repositoryEquipamento;
	
	
	

	public void instantiateTestDatabase() throws ParseException{
		
		
		Almoxarifado al1= new  Almoxarifado(null, "Almoxarifado superior");			
		Almoxarifado al2= new  Almoxarifado(null, "Almoxarifado inferior");
		Secoes sec1 =new Secoes(null, "eletrica", al1);
		Secoes sec2 =new Secoes(null, "moveis", al2);
		Secoes sec3 =new Secoes(null, "ferramentaria", al1);
		Produtos prud = new Produtos (null, "chave allen", "zata", sec1);
		Produtos prud1 = new Produtos (null, "eixo cardan", "catterpilar", sec2);
		Produtos prud2 = new Produtos (null, "chave fenda", "philipes", sec3);
		Equipamento equi1 = new Equipamento (null, "caminhão guindaste","caminhao", "caterpillar", "50tl");
		Equipamento equi2 = new Equipamento (null, "empilhadeira","maquina", "caterpillar", "25tl");
		Equipamento equi3 = new Equipamento (null, "munk","caminhao", "scania", "20tl");
		equi1.getProdutos().addAll(Arrays.asList(prud, prud1));
		equi2.getProdutos().addAll(Arrays.asList(prud1, prud2));
		equi3.getProdutos().addAll(Arrays.asList(prud1, prud, prud2));
		
		
		
		
		
		
		
		repositoryAlmoxarifado.saveAll(Arrays.asList(al1,al2));
		repositorySecoes.saveAll(Arrays.asList(sec1,sec2,sec3));
		repositoryProdutos.saveAll(Arrays.asList(prud,prud2,prud1));
		repositoryEquipamento.saveAll(Arrays.asList(equi1,equi2,equi3));
		
		
		
	}

}
