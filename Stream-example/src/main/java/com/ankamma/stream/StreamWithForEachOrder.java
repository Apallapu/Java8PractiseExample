package com.ankamma.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamWithForEachOrder {
	public static void main(String[] args) {
		List<Product> productsList = getProduct();
		System.out.println("stream with oderlistprint below:::::::::::::::::");
		printProductList(productsList);

		System.out.println("parallel stream with unoderlistprint below:::::::::::::::::");
		printProductListWithParallel(productsList);

		System.out.println("parallel stream with foreachOrder oderlistprint below:::::::::::::::::");
		printProductListWithParallelWithForEachOrder(productsList);

	}

	private static void printProductListWithParallelWithForEachOrder(List<Product> productsList) {
		productsList.parallelStream().forEachOrdered(p -> {

			System.out.println("product id:" + p.getId());
			System.out.println("product name:" + p.getName());
			System.out.println("product price:" + p.getPrice());
		});

	}

	private static void printProductList(List<Product> productsList) {
		productsList.stream().forEach(p -> {

			System.out.println("product id:" + p.getId());
			System.out.println("product name:" + p.getName());
			System.out.println("product price:" + p.getPrice());
		});

	}

	private static void printProductListWithParallel(List<Product> productsList) {
		productsList.parallelStream().forEach(p -> {

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
