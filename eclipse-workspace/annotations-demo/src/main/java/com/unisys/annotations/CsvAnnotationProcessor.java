package com.unisys.annotations;

import java.lang.reflect.Field;
import java.util.List;

public class CsvAnnotationProcessor<T> {

	List<T> list;

	public void setDataAsList(List<T> people) {
		this.list = people;
	}

	public String produce() {

		if (list.isEmpty()) {
			return "";
		}
		StringBuffer sb = new StringBuffer(10000);

		T firstElem = list.get(0);

		Class<?> cls = firstElem.getClass();
		Csv ann = cls.getAnnotation(Csv.class);
		
		if (ann == null) {
			throw new RuntimeException("The class is missing @Csv annotation");
		}

		if (ann.usePropertyNamesAsHeader()) {
			var declaredFields = firstElem.getClass().getDeclaredFields();
			for (var df : declaredFields) {
				if (df.getAnnotation(Include.class) != null) {
					sb.append(df.getName()).append(",");
				}
			}
			sb.append("\n");
		}

		for (var e : list) {

			// Field[] fields = cls.getFields(); // doesn't work

			// The getDeclaredField method has to return a new object each time, exactly
			// because this object has the mutable accessible flag. So there is no need to
			// reset the flag.
			Field[] fields = cls.getDeclaredFields();

			for (var f : fields) {
				if (f.getAnnotation(Include.class) != null) {
					try {
						f.setAccessible(true);
						sb.append(f.get(e)).append(",");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
