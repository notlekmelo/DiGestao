import java.io.Serializable;

public class Usuario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private String atvFis,genero,meta;
	private float pesoKG ,alturaMetros;

	
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
	
	public void setAtvFis(String atvFis) {
		this.atvFis = atvFis;
	}
	
	public String getMeta() {
		return this.meta;
	}
	
	public void setMeta(String meta) {
		this.meta = meta;
	}
	
	public float getPesoKG() {
		return pesoKG;
	}

	public void setPesoKG(float pesoKG) {
		this.pesoKG = pesoKG;
	}

	public float getAlturaMetros() {
		return alturaMetros;
	}

	public void setAlturaMetros(float alturaMetros) {
		this.alturaMetros = alturaMetros;
	}

	public String consultaDados() {
		//abrir o arquivo e mostras os dados do usuario
		return "Nome: "+ getNome() +"\nLogin: "+ getLogin()+"\nIdade: " + getIdade()+"\nCPF: "+ getCpf() +"\nN�vel de atividade F�sica:"+ getAtvFis(); 
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
