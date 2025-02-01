package com.giovana.desafio1;

import com.giovana.desafio1.entity.Order;
import com.giovana.desafio1.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {

	@Autowired
	OderService orderService;


	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner scan = new Scanner(System.in);

		System.out.printf("Digite o código do pedido: ");
		int codigo = scan.nextInt();
		System.out.printf("Digite o valor basico do pedido: ");
		double basico = scan.nextDouble();
		System.out.printf("Digite a porcentagem de desconto do pedido: ");
		double porcentagem = scan.nextDouble();

		Order order = new Order(codigo, basico, porcentagem);

		System.out.println("Pedido código "+order.getCode());
		System.out.printf("Valor total: R$%.2f%n", orderService.total(order));

		scan.close();
	}
}
