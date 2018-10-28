import java.io.Serializable;

import org.json.JSONObject;

public class Usuario extends Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String atvFis;
	private String genero;
	
	public Usuario(String nome, String login, String email, String senha, int idade, long cpf, String genero) {
		super(nome, login, email, senha, idade, cpf);
		this.genero = genero;
	}
	
	public void enviaDuvida(String assunto,String mensagem) {
		
	}
	
	public String getAtvFis() {
		return this.atvFis;
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public String consultaDados() {
		//abrir o arquivo e mostras os dados do usuario
		return "Nome: "+ getNome() +"\nLogin: "+ getLogin()+"\nIdade: " + getIdade()+"\nCPF: "+ getCpf() +"\nNível de atividade Física:"+ getAtvFis(); 
	}
	
	/*
	@Override
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("nome", this.getNome());
		obj.put("senha", this.getSenha());
		obj.put("idade", this.getIdade());
		obj.put("genero", this.getGenero());
		return obj;
	}
	*/
}
