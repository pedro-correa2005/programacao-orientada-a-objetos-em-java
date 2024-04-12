package pjAula8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TesteReflection {
	public static void main(String[] args) {
		List<String> listaNegra = new ArrayList<String>();
		listaNegra.add("teste");
		listaNegra.add("agoraVai");
		listaNegra.add("zueira");
		listaNegra.add("metodoDesespero");
		
		Field[] campos = NotaFiscal.class.getDeclaredFields();
		
		for(Field f: campos) {
			System.out.println(f.getType() + " " + f.getName());
			if(f.getName().length() < 6) {
				System.err.println("Não atende ao padrão");
			}
		}
		
		Method[] metodos = NotaFiscal.class.getDeclaredMethods();
		for(Method m: metodos) {
			System.out.println(m.getName() + " " + m.getReturnType());
			if(listaNegra.contains(m.getName())) {
				System.err.println("Não é um nome de método válido");
			}
		}
		
	}
}
