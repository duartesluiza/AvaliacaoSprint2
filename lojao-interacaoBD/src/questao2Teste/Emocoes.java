package questao2Teste;

import java.util.Scanner;

public class Emocoes {

	public static void main(String[] args) {

		try (Scanner leitor = new Scanner(System.in)) {
			String caractere = "";
//		String A, B;
			String frase = "";
			String chateado = ":-(";
			String divertido = ":-)";
			int cont = 0;
			int diver = 0;
			int chate = 0;

			do {
				System.out.println("\nComo você se sente nesse momento?");
				System.out.println(
						"Digite a letra correspondente ao caractere que expressa seu sentimento:  :-)  ou   :-( ");
				frase = leitor.nextLine();
			} while (frase.isEmpty());

				diver = verificaQuantidade(frase, divertido);
				chate = verificaQuantidade(frase, chateado);

			if (diver > chate) {
				System.out.println("\n\nIhh...tô CHATEADES :-( ");

				} else if (chate > diver) {
					System.out.println("\n\nYupe!Tô DIVERTIDES!  :-) ");

					} else
						System.out.println("\nTô que nem detergente líquido...tô NEUTRO!");

		}

	}

	public static int verificaQuantidade(String sequencia, String fluxo) {
		// TODO Auto-generated method stub
		int contador = 0;
		int posicao = 0;

		posicao = fluxo.indexOf(sequencia);

		while (posicao != -1) {
			contador++;

			posicao = fluxo.indexOf(sequencia, posicao + 1);

		}

		return contador;
	}
}
	


