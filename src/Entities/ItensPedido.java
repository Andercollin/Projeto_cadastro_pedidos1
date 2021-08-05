package Entities;

public class ItensPedido {
	
	private Integer quantidade;
	private Double preco;
	
	private Produto produto;
	
	public ItensPedido() {
	}

	public ItensPedido(Integer quantidade, Double preco, Produto produto) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Double subTotal() {
		return quantidade * preco;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(produto.getNome()); 
		sb.append(", $");
		sb.append(String.format("%.2f", preco));
		sb.append(", Quantidade: ");
		sb.append(quantidade);
		sb.append(", Subtotal: $");
		sb.append(String.format("%.2f", subTotal()));
				
		return sb.toString();
	}
}
