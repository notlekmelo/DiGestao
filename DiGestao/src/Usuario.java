
public class Usuario extends Pessoa {
	private String atvFis,meta;
	private float pesoKG ,alturaMetros;

	public Usuario(String nome, String login, String senha, int idade, long cpf) {
		super(nome, login,senha,idade,cpf);
	}
	
	private void setAtvFis(String atvFis) {
		this.atvFis = atvFis;
	}

	public void enviaDuvida(String assunto,String mensagem) {
		
	}
	
	public void setMeta(String meta) {
		this.meta = meta;
	}
	
	public String getMeta() {
		return this.meta;
	}
		
	public String getAtvFis() {
		return atvFis;
	}
	
	private float getPesoKG() {
		return pesoKG;
	}

	private void setPesoKG(float pesoKG) {
		this.pesoKG = pesoKG;
	}

	private float getAlturaMetros() {
		return alturaMetros;
	}

	private void setAlturaMetros(float alturaMetros) {
		this.alturaMetros = alturaMetros;
	}
	
	public String consultaDados() {
		//abrir o arquivo e mostras os dados do usuario
		return "Nome: "+ getNome() +"\nLogin: "+ getLogin()+"\nIdade: " + getIdade()+"\nCPF: "+ getCpf() +"\nNível de atividade Física:"+ getAtvFis(); 
	}
}
