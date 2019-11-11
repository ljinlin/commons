package com.mingri.langhuan.cabinet.tool;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassTool {
	
	private ClassTool() {}
	
	/**
	 * 获取非私有、非静态的函数(包含（非Object）父类的)
	 * 
	 * @param clazz
	 * @return
	 */
	public static List<Method> getDecararedMethods(Class<?> clazz, boolean getFinal) {
		List<Method> methods = new ArrayList<>();
		Class<?> nextClass = clazz;
		while (nextClass != null && nextClass != Object.class) {
			Method[] mary = nextClass.getDeclaredMethods();
			for (Method m : mary) {
				int modifiers = m.getModifiers();
				if (Modifier.isPrivate(modifiers) || Modifier.isStatic(modifiers))
					continue;
				if (Modifier.isFinal(modifiers) && getFinal)
					continue;
				methods.add(m);
			}
			nextClass = nextClass.getSuperclass();
		}
		return methods;
	}

	/**
	 * 获取非私有、非静态的字段(包含（非Object）父类的)
	 * 
	 * @param clazz
	 * @return
	 */
	public static List<Field> getDecararedFields(Class<?> clazz, boolean getFinal) {
		List<Field> fields = new ArrayList<>();
		Class<?> nextClass = clazz;
		while (nextClass != null && nextClass != Object.class) {
			Field[] fary = nextClass.getDeclaredFields();
			for (Field f : fary) {
				int modifiers = f.getModifiers();
				if (Modifier.isStatic(modifiers))
					continue;
				if (Modifier.isFinal(modifiers) && getFinal)
					continue;
				fields.add(f);
			}
			nextClass = nextClass.getSuperclass();
		}
		return fields;
	}

	/**
	 * 获取非私有、非静态的字段(包含（非Object）父类的)
	 * 
	 * @param clazz
	 * @param getFinal 是否获取常量字段
	 * @return
	 */
	public static Map<String, Field> getDecararedFieldsMap(Class<?> clazz, boolean getFinal) {
		Map<String, Field> fields = new HashMap<>();
		Class<?> nextClass = clazz;
		while (nextClass != null && nextClass != Object.class) {
			Field[] fary = nextClass.getDeclaredFields();
			for (Field f : fary) {
				int modifiers = f.getModifiers();
				if (Modifier.isStatic(modifiers))
					continue;
				if (Modifier.isFinal(modifiers) && getFinal)
					continue;
				fields.put(f.getName(), f);
			}
			nextClass = nextClass.getSuperclass();
		}
		return fields;
	}

	/**
	 * 是否含有非私有、非静态的函数(不包含父类的)
	 * 
	 * @param clazz
	 * @return
	 */
	public static boolean isExistSelfDeclaredMethod(Class<?> clazz) {
		Method[] mary = clazz.getDeclaredMethods();
		for (Method m : mary) {
			int modifiers = m.getModifiers();
			if (Modifier.isPrivate(modifiers) || Modifier.isStatic(modifiers)) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

	
	

}
