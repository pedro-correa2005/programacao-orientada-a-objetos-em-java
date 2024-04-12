package pjAula8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Acesso {
	public static void retornarFields(Object obj) {
		Field[] atributos = obj.getClass().getDeclaredFields();
		
	}
	
	public static void retornarMetodos(Object obj) {
		Method[] metodos = obj.getClass().getMethods();
		
		for(Method e: metodos) {
			System.out.println(e.getName());
		}
	}
	
	public static void invadirValores(Object obj) {
		for (Field e: obj.getClass().getDeclaredFields()) {
			e.setAccessible(true);
			try {
				if(e.getType() == String.class)
					e.set(obj, "Teste");
			}catch(IllegalArgumentException | IllegalAccessException el) {
				el.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		for(Method m: Acesso.class.getMethods()) {
			//if(m.getName())
		}
	}
}
