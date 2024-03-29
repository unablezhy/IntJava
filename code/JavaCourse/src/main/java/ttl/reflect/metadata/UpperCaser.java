package ttl.reflect.metadata;

import java.lang.reflect.Field;

public class UpperCaser {

	public static void main(String [] args) throws IllegalArgumentException, IllegalAccessException {
		
		UpperCaser uCaser = new UpperCaser();
		Car car = new Car();
		car.setModelName("MyModel");
		
		uCaser.processUpperCaseAnnotation(car);
		
		System.out.println(car);
		
	}
	
	public void processUpperCaseAnnotation(Object target) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = target.getClass();
		
		Field [] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			field.setAccessible(true);
			if(field.isAnnotationPresent(UpperCase.class)) {
				UpperCase uc = (UpperCase)field.getAnnotation(UpperCase.class);
				
				//Get the old value
				String oldValue = (String)field.get(target);
				
				int length = uc.length();
				if(length < 0) {
					length = oldValue.length();
				}
				
				char [] chars = oldValue.toCharArray();
				
				StringBuilder newValue = new StringBuilder();
				for(int i = 0, j = 0; i < chars.length; i++, j++) {
					char c = chars[i];
					if(j < length) {
						c = Character.toUpperCase(chars[i]);
					}
					newValue.append(c);
				}
					
				//Set the new value
				field.set(target, newValue.toString());
			}
		}
	}
}
