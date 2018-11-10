package com.ankamma.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamWithForEach {

	public static void main(String[] args) {

		List<Product> productsList = getProduct();
		printProduct(productsList);

	}

	private static void printProduct(List<Product> productsList) {

		productsList.stream().forEach(p -> {

			System.out.println("product id:" + p.getId());
			System.out.println("product name:" + p.getName());
			System.out.println("product price:" + p.getPrice());
		});
	}

	private static List<Product> getProduct() {
		List<Product> productsList = new ArrayList<Product>();

		productsList.add(new Product(1, "Toyota", 25000f));
		productsList.add(new Product(2, "Renault-Nissan", 30000f));
		productsList.add(new Product(3, "Hyundai-Kia", 28000f));
		productsList.add(new Product(4, "General Motors", 28000f));
		productsList.add(new Product(5, "Ford", 90000f));
		productsList.add(new Product(6, "Honda", 80000f));

		return productsList;
	}

}
