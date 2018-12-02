
public abstract class Pessoa {

	private String nome, email, senha,cpf,idade;

	public Pessoa() {}

	public Pessoa(String nome, String email, String senha,String idade, String cpf) {
		this.nome = nome;
		this.email= email;
		setSenha(senha);
		setIdade(idade);
		setCpf(cpf);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	private void setSenha(String senha) {
		//colocar tamanho mínimo talvez
		this.senha = senha;
	}

	private void setIdade(String idade) {
		if (Integer.parseInt(idade)>=14)
			this.idade = idade;
		//possivel lançamento de erro para certificar que o menor de 14 anos pode usar a aplicação
	}
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}

//	private boolean setCpf(String cpf) {
//	if(Long.parseLong(cpf) > 11111111111 && Long.parseLong(cpf) < 99999999999) 
//		return true;
//	else return false;
//}


}
