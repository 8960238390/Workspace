package privateConstructorWithReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		initConfiguration();
	}
	
	public static void initConfiguration() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Constructor<ServerConfiguration> declaredConstructor = ServerConfiguration.class.getDeclaredConstructor(int.class,String.class);
		
		declaredConstructor.setAccessible(true);
		declaredConstructor.newInstance(8080,"Good Day");
	}
}
