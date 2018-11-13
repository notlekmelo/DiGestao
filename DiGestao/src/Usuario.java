import java.io.Serializable;

import org.json.JSONObject;

public class Usuario extends Pessoa implements Serializable, JsonFormatter {

	private static final long serialVersionUID = 1L;
	private String atvFis, genero, meta,pesoKG ,alturaMetros;


	
	public Usuario(String nome, String login, String email, String senha, String  idade, String cpf, String genero) {
		super(nome, login, email, senha, idade, cpf);
		this.genero = genero;
		this.atvFis=null;
		this.alturaMetros =null;
		this.meta = null;
		this.pesoKG = null;
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
	
	public String getPesoKG() {
		return pesoKG;
	}

	public void setPesoKG(String pesoKG) {
		this.pesoKG = pesoKG;
	}

	public String getAlturaMetros() {
		return alturaMetros;
	}

	public void setAlturaMetros(String alturaMetros) {
		this.alturaMetros = alturaMetros;
	}

	public String consultaDados() {
		//abrir o arquivo e mostras os dados do usuario
		return "Nome: "+ getNome() +"\nLogin: "+ getLogin()+"\nIdade: " + getIdade()+"\nCPF: "+ getCpf() +"\nNível de atividade Física:"+ getAtvFis(); 
	}
	
	@Override
	public String toString() {
			return "nome=" + getNome() + ", login=" + getLogin() + ", email=" + getEmail() + ", senha=" + getSenha() + ", cpf=" + getCpf()
					+ ", idade=" + getIdade() + ", genero=" + genero;
	}

	public JSONObject toJson() {

        JSONObject obj = new JSONObject();
        obj.put("nome", getNome());
        obj.put("login", getLogin());
        obj.put("email", getEmail());
        obj.put("senha", getSenha());
        obj.put("idade", getIdade());
        obj.put("cpf", getCpf());
        obj.put("genero", getGenero());
        obj.put("altura", getAlturaMetros());
        obj.put("peso", getPesoKG());
        obj.put("atvFis", getAtvFis());
        obj.put("meta", getMeta());
        return obj;

    }
}
