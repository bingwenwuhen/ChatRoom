package cn.com.utils;

import java.lang.reflect.ParameterizedType;

public class GenericClass {

	public static Class getGenericClass(Class clazz){
		ParameterizedType type=(ParameterizedType) clazz.getGenericSuperclass();
		Class enertityClass=(Class) type.getActualTypeArguments()[0];
		return enertityClass;
	}
}
