package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Application {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.println("Name:");
		String name = sc.next();
		System.out.println("Email");
		String email = sc.next();
		System.out.println("Birth date:");
		Date birth = sdf.parse(sc.next());
		
		System.out.println("Enter order status:");
		String status = sc.next();
		
		System.out.println("How many itens for this order?");
		int numberOfItens = sc.nextInt();
		
		Client c1 = new Client(name, email, birth);
		
		Order o = new Order(new Date(), OrderStatus.valueOf(status), c1);
		
		for (int i = 1; i <= numberOfItens; i++) {
			System.out.println("Enter #"+i+" data:");
			System.out.println("Product name:");
			String productName = sc.next();
			System.out.println("Product price:");
			double productPrice = sc.nextDouble();
			System.out.println("Quantity:");
			int productQuantity = sc.nextInt();
			
			Product p = new Product(productName, productPrice);
			OrderItem it = new OrderItem(productQuantity, productPrice, p);
			
			o.addItem(it);
			
		}
		
		
		System.out.println(o);
		sc.close();
	}
}
