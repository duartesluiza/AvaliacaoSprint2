package questao1.modelo;

public class Produto {
	
	private int id;
	private String nome;
	private String descricao;
	private String desconto;
	private String dataInicio;
	private String dataFim;
	
	
	
	public Produto(String nome, String descricao, String desconto, String dataInicio, String dataFim) {
		
		this.nome = nome;
		this.descricao = descricao;
		this.desconto = desconto;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
	
	
	public Produto() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDesconto() {
		return desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	

	
}
