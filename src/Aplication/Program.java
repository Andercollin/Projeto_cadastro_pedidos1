package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Cliente;
import Entities.ItensPedido;
import Entities.Pedido;
import Entities.Produto;
import Entities.enums.StatusPedido;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		System.out.println("Digite os dados do cliente:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Data de nascimento (dd/mm/aaaa): ");
		Date dataNascimento = sdf.parse(sc.next());
		
		Cliente cliente = new Cliente(nome, email, dataNascimento);
		
		System.out.println("Digite os dados do pedido:");
		System.out.print("Status: ");
		StatusPedido status = StatusPedido.valueOf(sc.next());
		
		Pedido pedido = new Pedido(new Date(), status, cliente);
		
		System.out.print("Quantos produtos possuem no pedido? ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.println("Digite os dados do produto #" + i);
			System.out.print("Produto: ");
			sc.next();
			String produtoNome = sc.nextLine();
			System.out.print("Preco: ");
			double produtoPreco = sc.nextDouble();
			System.out.print("Quantidade: ");
			int itensPedidoQuantidade = sc.nextInt();
			
			Produto produto = new Produto(produtoNome, produtoPreco);
			
			ItensPedido itensPedido = new ItensPedido(itensPedidoQuantidade, produtoPreco, produto);
			
			pedido.addItem(itensPedido);
		}
		
		System.out.println();
		System.out.println(pedido);
		
		sc.close();
	}

}
