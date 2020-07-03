package com.unisys.programs;

import java.util.Arrays;
import java.util.List;

import com.unisys.annotations.CsvAnnotationProcessor;
import com.unisys.entity.Person;
import com.unisys.entity.Product;

public class ProduceCsvOutput {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Vinod", "vinod@vinod.co", "9731424784"),
				new Person("Shyam", "shyam@exmaple.com", "7731424784"));

		List<Product> products = Arrays.asList(new Product(1, "Chai", 18.7, 120), new Product(2, "Chang", 12.7, 20),
				new Product(3, "Anyseed Syryp", 217.0, 10));

		CsvAnnotationProcessor<Person> processor1 = new CsvAnnotationProcessor<Person>();
		processor1.setDataAsList(people);
		String csv = processor1.produce();
		System.out.println(csv);
		System.out.println("-----------");

		CsvAnnotationProcessor<Product> processor2 = new CsvAnnotationProcessor<Product>();
		processor2.setDataAsList(products);
		csv = processor2.produce();
		System.out.println(csv);
	}

}
