package br.com.loja.aplicacao;

import java.util.Date;
import java.util.Scanner;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.model.Cliente;


public class Main {
	
	
	public static void main(String[] args) {
		int escolha;
		do {
			escolha = Menu();
			switch(escolha) {
			case 1:
				DadosCadastro();
				break;
			}
		} while (escolha != 5);
		if (escolha == 5) {
			System.out.println("Encerrando...");
		}

	}
	
	public static void DadosCadastro() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		Scanner dadosCadastro = new Scanner(System.in);
		System.out.println("Por favor, informe os dados: ");
		
		System.out.println("Nome: ");
		String nome = dadosCadastro.next();
		cliente.setNome(nome);
		
		System.out.println("Sobrenome: ");
		String sobrenome = dadosCadastro.next();
		System.out.println(sobrenome);
		cliente.setSobrenome(sobrenome);

		cliente.setDataCadastro(new Date());
		
		System.out.println("Senha: ");
		String senha = dadosCadastro.next();
		cliente.setSenha(senha);
		
		System.out.println("E-mail: ");
		String email = dadosCadastro.next();
		cliente.setEmail(email);

		clienteDAO.Cadastro(cliente);
		System.out.println("Cadastro realizado com sucesso");

		
	}
	
	public static int Menu() {
		Scanner escolha = new Scanner(System.in);
		
		System.out.println("Escolha o que você deseja: ");
		System.out.println("(1) Cadastrar cliente");
		System.out.println("(2) Apagar cliente");
		System.out.println("(3) Alterar cliente");
		System.out.println("(4) Exibir clientes");
		System.out.println("(5) Sair");
		
		int n = escolha.nextInt();
		return n;
	}

}
