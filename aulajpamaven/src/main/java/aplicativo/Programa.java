package aplicativo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(null, "Joca Camargo", "joca@gmail.com");
		Pessoa p2 = new Pessoa(null, "Juliana Atlas", "juliana@gmail.com");
		Pessoa p3 = new Pessoa(null, "João Constantine", "joao@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		/*
		 * Pesquisa do banco de dados 
		 * Pessoa p = em.find(Pessoa.class, 2); Pegando o
		 * dado e convertendo para um tipo de objeto 
		 * System.out.println(p);
		 */
		
		/*Quando eu quero remover do banco de dados*/
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		

		System.out.println("Pronto");
		em.close();
		emf.close();
	}

}
