package com.ankamma.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamWithMap {
	public static void main(String[] args) {
		List<Product> productsList = getProduct();
		List<String> filterproductsList = filterProductByName(productsList);
		printProduct(filterproductsList);
		System.out.println("first filter results:::");
		List<String> filterproductsMethodRef = filterProductByNameMethodRefExample(productsList);
		printProduct(filterproductsMethodRef);

		System.out.println("convertProductToModel:::");

		List<ProductModel> multipleProductNameSearch = convertProductToModel(productsList);
		printProductList(multipleProductNameSearch);

		System.out.println("map->convertProductToModel:::");

		List<ProductModel> mapProductNameSearch = convertProductToModelExample2(productsList);
		printProductList(mapProductNameSearch);

	}

	private static void printProductList(List<ProductModel> productsList) {

		productsList.stream().forEach(p -> {

			System.out.println("product id:" + p.getId());
			System.out.println("product name:" + p.getName());
			System.out.println("product price:" + p.getPrice());
		});
	}

	private static List<ProductModel> convertProductToModelExample2(List<Product> productsList) {
		List<ProductModel> list = new ArrayList<>();
		productsList.stream().forEach(p -> list.add(setProductModel(p)));
		return list;

	}

	private static ProductModel setProductModel(Product p) {
		ProductModel productModel = new ProductModel(p.getId(), p.getName(), p.getPrice());
		return productModel;
	}

	private static List<ProductModel> convertProductToModel(List<Product> productsList) {

		return productsList.stream().map(p -> {
			ProductModel productModel = new ProductModel(p.getId(), p.getName(), p.getPrice());
			return productModel;
		}).collect(Collectors.toList());
	}

	private static List<String> filterProductByNameMethodRefExample(List<Product> productsList) {

		return productsList.stream().filter(p -> p.getName().equals("Toyota")).map(Product::getName)
				.collect(Collectors.toList());
	}

	private static List<String> filterProductByName(List<Product> productsList) {

		return productsList.stream().filter(p -> p.getName().equals("Toyota")).map(p -> p.getName())
				.collect(Collectors.toList());
	}

	private static void printProduct(List<String> productsList) {

		productsList.stream().forEach(p -> {

			System.out.println("product Names:" + productsList);

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