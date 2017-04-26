package net.ukr.dreamsicle.Lesson1Reflection.tester;

import java.lang.reflect.Method;

public class Tester {
	public static boolean test(Class<?>... ls) {
		try {
			for (Class<?> cls : ls) {
				Method[] methods = cls.getDeclaredMethods();// прохожусь по всем методам
				for (Method method : methods) {
					if (method.isAnnotationPresent(Test.class)) {
						Boolean b = (Boolean) method.invoke(null, new Object[] {});
						if ( ! b)
							return false;
					}
				}
			}
			
			return true;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
