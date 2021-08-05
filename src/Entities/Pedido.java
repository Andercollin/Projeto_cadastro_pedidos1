package Entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entities.enums.StatusPedido;

public class Pedido {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date agora;
	private StatusPedido status;
	
	private Cliente cliente;
	private List<ItensPedido> itens = new ArrayList<>();

	public Pedido() {
	}

	public Pedido(Date agora, StatusPedido status, Cliente cliente) {
		this.agora = agora;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getAgora() {
		return agora;
	}

	public void setAgora(Date agora) {
		this.agora = agora;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItensPedido> getItens() {
		return itens;
	}

	public void addItem(ItensPedido item) {
		itens.add(item);
	}
	
	public void removeItem(ItensPedido item) {
		itens.remove(item);
	}
	
	public Double total() {
		double soma = 0.0;
		for(ItensPedido item: itens) {
			soma += item.subTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Data e horário do pedido: "); 
			sb.append(sdf.format(agora));
			sb.append("%n");
			sb.append("Status do pedido: ");
			sb.append(status);
			sb.append("%n");
			sb.append(cliente);
			sb.append("%n");
			sb.append("Itens do pedido: ");
				for(ItensPedido Item: itens) {
					sb.append(Item);
					sb.append("%n");
				}
			sb.append("Preço total: $ ");
			sb.append(String.format("%.2f", total()));
			
			return sb.toString();			
	}
}
