package questao1;

import java.sql.SQLException;
import java.util.Scanner;

import questao1.dao.ProdutoDAO;
import questao1.modelo.Produto;

public class Menu {

	ProdutoDAO produtoDao;

	public Menu(ProdutoDAO produtoDao) throws SQLException {

		this.produtoDao = produtoDao;

		int escolha;

		try (Scanner teclado = new Scanner(System.in)) {
			
			do {
				System.out.println("\n------------------------");
				System.out.printf("       MENU \n");
				System.out.println("Escolha uma opção:");
				System.out.println("1- Cadastrar");
				System.out.println("2- Atualizar");
				System.out.println("3- Excluir");
				System.out.println("4- PARA SAIR APERTE 0");

				escolha = teclado.nextInt();

				switch (escolha) {

				case 1:
					cadastrarProduto(teclado);

					break;

				case 2:
					atualizarProduto(teclado);
					break;

				case 3:
					deletarProduto(teclado);
					break;

				case 4:
					break;

				case 0:
					System.out.println("\nSaindo...");
					break;

				default:
					System.err.print("\nEscolha inválida!");
					break;
				}

			} while (escolha != 0);
		}
	}

	private void deletarProduto(Scanner scanner) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Deletar oferta");
		System.out.println("PARA SAIR APERTE ZERO");
		Integer produtoId = scanner.nextInt();
		
		
		
		

		produtoDao.deletarProduto(produtoId);

	}

	private void atualizarProduto(Scanner scanner) throws SQLException {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Iniciando UPDATE de produto... \n");

			

			System.out.println("\nInforme o nome do Produto que deseja atualizar: ");
			String nomeProduto = scanner.next();
			
			System.out.println("\nInforme a descriçao do produto: ");
			String descricaoProduto = scanner.next();
			
			System.out.println("\nInforme o desconto do produto: ");
			String descontoProduto = scanner.next();
			
			System.out.println("\nInforme a data de inicio da promoção do produto: ");
			String dataInicioProduto = scanner.next();
			
			System.out.println("\nInforme a data de fim da promoção do produto: ");
			String dataFimProduto = scanner.next();
			
			
			Produto produto = new Produto(nomeProduto, descricaoProduto, descontoProduto, dataInicioProduto,
					dataFimProduto);
			
			produtoDao.editarProduto(produto);
		}
	}

	public void cadastrarProduto(Scanner scanner) throws SQLException {

		System.out.println("Iniciando cadastro de produto... \n");


		System.out.println("Nome do Produto informado: \n");
		String nomeProduto = scanner.next();
		
		System.out.println("Informe a descriçao do produto: \n");
		String descricaoProduto = scanner.next();
		
		System.out.println("Informe o desconto do produto: \n");
		String descontoProduto = scanner.next();
		
		System.out.println("Informe a data de inicio da promoção do produto: \n");
		String dataInicioProduto = scanner.next();
		
		System.out.println("Informe a data de fim da promoção do produto: \n");
		String dataFimProduto = scanner.next();

		Produto produto = new Produto(nomeProduto, descricaoProduto, descontoProduto, dataInicioProduto,
				dataFimProduto);

		produtoDao.salvarProduto(produto);

	}

}
	
		
//		String nomeProduto = scanner.next();
//		System.out.println("Nome do Produto informado \n");
//		String descricaoProduto = scanner.next();
//		System.out.println("Informe a descriçao do produto \n");
//		System.out.println("Informe a data de inicio da promoção do produto \n");
//		String dataInicioProduto = scanner.next();
//		System.out.println("Informe a data de fim da promoção do produto");
//		String dataFimProduto = scanner.next();
//		
		
//		String descricaoProduto = scanner.next();
//		System.out.println("Informe o desconto do produto \n");
//		String descontoProduto = scanner.next();
//		System.out.println("Informe a data de inicio da promoção do produto \n");
//		String dataInicioProduto = scanner.next();
//		System.out.println("Informe a data de fim da promoção do produto");
//		String dataFimProduto = scanner.next();
//		
		
		
		
		
		
//		String nomeProduto = scanner.nextLine();
//		System.out.println("Nome do Produto informado ");
//		System.out.println("Informe a descriçao do produto");
//		String descricaoProduto = scanner.next();
//		System.out.println("Informe o desconto do produto");
//		String descontoProduto = scanner.next();
//		System.out.println("Informe a data de inicio da promoção do produto");
//		String dataInicioProduto = scanner.next();
//		System.out.println("Informe a data de fim da promoção do produto");
//		String dataFimProduto = scanner.next();
//		
//		Produto produto = new Produto(nomeProduto, descricaoProduto, descontoProduto, dataInicioProduto, dataFimProduto);
//		
//		produtoDao.salvarProduto(produto);
//		
//	}
//	
//	
//
//}


