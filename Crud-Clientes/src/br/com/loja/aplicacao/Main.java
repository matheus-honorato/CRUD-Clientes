package br.com.loja.aplicacao;

import java.util.Date;
import java.util.Scanner;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.model.Cliente;


public class Main {
	
	
	public static void main(String[] args) {
		int escolha;
		do {
			escolha = menu();
			switch(escolha) {
			case 1:
				dadosCadastro();
				break;
			case 2:
				apagarCliente();

			case 4:
				mostrarClientes();
				break;
			}
			
		} while (escolha != 5);
		if (escolha == 5) {
			System.out.println("Encerrando...");
		}

	}
	public static int menu() {
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
	

	
	public static void apagarCliente() {
		mostrarClientes();
		System.out.println("Digite o identificador do cliente: ");
		ClienteDAO cliente = new ClienteDAO();
		Scanner escolha = new Scanner(System.in);
		int n = escolha.nextInt();
		cliente.excluir(n);
		System.out.println("Apagado com sucesso! ");
	}
	public static void mostrarClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		
		for(Cliente c : clienteDAO.obterClientes()) {
			System.out.println("Identificador: " + c.getId());
			System.out.println("Nome: " + c.getNome() + " " + c.getSobrenome());
			System.out.println("Email: " + c.getEmail());
			System.out.println("Data Cadastro: " + c.getDataCadastro()+"\n");
			
		}
	}
	
	public static void dadosCadastro() {
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

		clienteDAO.cadastro(cliente);
		System.out.println("Cadastro realizado com sucesso");

		
	}
}
