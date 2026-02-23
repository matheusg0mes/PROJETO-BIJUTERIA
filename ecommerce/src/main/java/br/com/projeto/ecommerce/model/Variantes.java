package br.com.projeto.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_variante_produto")
public class Variantes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_variante_produto")
	private Integer id;
	
	@Column(name="nome_variante_produto", length = 50)
	private String nome;
	
	@Column(name ="desc_variante_produto", columnDefinition = "TEXT")
	private String texto;
	
	@Column(name = "link_foto", length = 255)
	private String link_foto;
	
	@ManyToOne
	@JsonIgnoreProperties("variantes")
	@JoinColumn(name = "tbl_produto_id_produto")
	private Produtos produto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getLink_foto() {
		return link_foto;
	}

	public void setLink_foto(String link_foto) {
		this.link_foto = link_foto;
	}

	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}
	
	
}
