package com.ankamma.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamWithFilter {
	public static void main(String[] args) {
		List<Product> productsList = getProduct();
		List<Product> filterproductsList = filterProductByName(productsList);
		printProduct(filterproductsList);
		System.out.println("first filter results:::");
		List<Product> filterproductsListOne = filterProductById(productsList);
		printProduct(filterproductsListOne);

		System.out.println("second filter results:::");
		List<Product> multipleProductNameSearch = filterMultipleProductNameSearch(productsList);
		printProduct(multipleProductNameSearch);

	}

	private static List<Product> filterMultipleProductNameSearch(List<Product> productsList) {

		return productsList.stream().filter(p -> p.getPrice() > 30000f).collect(Collectors.toList());
	}

	private static List<Product> filterProductById(List<Product> productsList) {

		return productsList.stream().filter(p -> p.getId() > 3 && p.getId() < 5).collect(Collectors.toList());
	}

	private static List<Product> filterProductByName(List<Product> productsList) {

		return productsList.stream().filter(p -> p.getName().equals("Toyota")).collect(Collectors.toList());
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
