package com.unisys.annotations;

import java.lang.reflect.Field;
import java.util.List;

public class CsvAnnotationProcessor<T> {

	List<T> list;

	public void setDataAsList(List<T> people) {
		this.list = people;
	}

	public String produce() {
		StringBuffer sb = new StringBuffer(10000);
		for (var e : list) {

			Class cls = e.getClass();
			if (cls.getAnnotation(Csv.class) == null) {
				throw new RuntimeException("The class is missing @Csv annotation");
			}

			Field[] fields = cls.getFields();
			for (var f : fields) {
				f.setAccessible(true);
				if (f.getAnnotation(Include.class) != null) {
					try {
						sb.append(f.get(e)).append(",");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				f.setAccessible(false);
			}

			sb.append("\n");
		}
		return sb.toString();
	}

}
