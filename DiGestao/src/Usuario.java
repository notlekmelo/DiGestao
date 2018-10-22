
public class Usuario extends Pessoa {
	private String atvFis,meta;
	private float pesoKG ,alturaMetros;

	public Usuario(String nome, String login, String senha, int idade, long cpf) {
		super(nome, login,senha,idade,cpf);
	}
	
	public String getAtvFis() {
		return atvFis;
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
		return "Nome: "+ getNome() +"\nLogin: "+ getLogin()+"\nIdade: " + getIdade()+"\nCPF: "+ getCpf() +"\nNível de atividade Física:"+ getAtvFis(); 
	}
	
	public void enviaDuvida(String assunto,String mensagem) {
		
	}
	
}


