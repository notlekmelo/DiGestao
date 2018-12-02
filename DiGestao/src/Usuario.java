import java.io.Serializable;

import org.json.JSONObject;

public class Usuario extends Pessoa implements Serializable, JsonFormatter {

	private static final long serialVersionUID = 1L;
	private String atvFis, genero, meta;
	private float pesoKG ,alturaMetros;


	
	public Usuario(String nome, String email, String senha, String  idade, String cpf, String genero) {
		super(nome, email, senha, idade, cpf);
		this.genero = genero;
		this.atvFis=null;
		this.alturaMetros =0.0F;
		this.meta = null;
		this.pesoKG = 0.0F;
	}
	
	public Usuario() {
		
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

	public void setPesoKG(float f) {
		this.pesoKG = f;
	}

	public float getAlturaMetros() {
		return alturaMetros;
	}

	public void setAlturaMetros(float f) {
		this.alturaMetros = f;
	}

	public String consultaDados() {
		//abrir o arquivo e mostras os dados do usuario
		return "Nome: "+ getNome() +"\nIdade: " + getIdade()+"\nCPF: "+ getCpf() +"\nNível de atividade Física:"+ getAtvFis(); 
	}
	
	@Override
	public String toString() {
			return "nome=" + getNome() + ", email=" + getEmail() + ", senha=" + getSenha() + ", cpf=" + getCpf()
					+ ", idade=" + getIdade() + ", genero=" + genero;
	}

	public JSONObject toJson() {

        JSONObject obj = new JSONObject();
        obj.put("nome", getNome());
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
