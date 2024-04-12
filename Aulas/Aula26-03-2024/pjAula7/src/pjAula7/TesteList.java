package pjAula7;

import java.util.ArrayList;
import java.util.List;

/**
 * Exemplo de Implementação de Estrutura de Dados List
 * @author Pedro H. L. Corrêa
 * @date 26/03/2024
 */
public class TesteList {
	public static void main(String[] args) {
		//Implementação de um elemento List
		List<Produto> lista = new ArrayList<Produto>();
		
		lista = Robo.gerarLista();
		
		System.out.println(lista.size());
		
		/*long limite = 24_116_400_000l;
		long inicio = System.currentTimeMillis();
		long acumula = 0l;
		
		for(long i=0; i< limite; i++) {
			acumula += i;
		}
		long fim = System.currentTimeMillis();
		System.out.println("Tempo " + (fim - inicio));
		
		for(Produto p: lista) {
			System.out.println("Código " + p.getCodigo());
			System.out.println("Descrição: " + p.getDescricao());
			System.out.println("Quantidade: " + p.getQuantidade());
			System.out.println(p.isStatus()?"Ativo":"Inativo");
		}*/
		
		//lista.stream().forEach(p -> System.out.println(p));
		
		lista.stream()
			.filter(p -> p.getDescricao().contains("33") 
					&& p.getCodigo() < 500)
			.forEach(p -> System.out.println(p));
;	}
}