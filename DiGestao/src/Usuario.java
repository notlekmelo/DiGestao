
public class Usuario extends Pessoa {
	private String atvFis;
	
	public Usuario(String nome, String login, String senha, int idade, long cpf, String atvFis) {
		super(nome, login,senha,idade,cpf);
		this.atvFis = atvFis;
	}
	
	public void enviaDuvida(String assunto,String mensagem) {
		
	}
	
	public String getAtvFis() {
		return atvFis;
	}
	
	public String consultaDados() {
		//abrir o arquivo e mostras os dados do usuario
		return "Nome: "+ getNome() +"\nLogin: "+ getLogin()+"\nIdade: " + getIdade()+"\nCPF: "+ getCpf() +"\nNível de atividade Física:"+ getAtvFis(); 
	}
}
