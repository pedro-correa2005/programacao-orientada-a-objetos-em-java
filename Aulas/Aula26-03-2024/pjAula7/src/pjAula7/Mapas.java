package pjAula7;

import java.util.HashMap;
import java.util.Map;

public class Mapas {
	public static void main(String[] args) {
		Map<Integer, Produto> mapa = new HashMap<Integer, Produto>();
		
		for(Produto p: Robo.gerarLista()) {
			mapa.put(p.getCodigo(), p);
		}
		
		System.out.println(mapa.get(12) != null?"Sim " + mapa.get(12):"Não localizado");
	}
}
