
public abstract class Pessoa {
	private String nome, login, email, senha;
	private int idade;
	private String cpf;

	public Pessoa(String nome, String login, String email, String senha, int idade, String cpf) {
		this.nome = nome;
		setLogin(login);
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

	public int getIdade() {
		return idade;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	private void setLogin(String login) {
		this.login = login;
	}

	private void setSenha(String senha) {
		//colocar tamanho mínimo talvez
		this.senha = senha;
	}

	private void setIdade(int idade) {
		if (idade > 14)
			this.idade = idade;
		//possivel lançamento de erro para certificar que o menor de 14 anos pode usar a aplicação
	}
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/*
	private boolean setCpf(long cpf){
		long resto,multresult,nummult,soma=0,dig1,inicial,dig2;
		boolean certo = false;
		inicial = cpf/100;
		nummult = 9;
		dig2 = cpf%10;
		dig1 = cpf%100 - dig2;
		while (cpf>=1){
			resto=cpf%10;
			cpf=cpf/10;
			multresult=resto*nummult;
			soma=soma+multresult;
			nummult=nummult-1;
		}
		if(dig1 == soma%11) {
			cpf = (inicial*10)+dig1;
			nummult=9;
			soma=0;
			while (cpf>0){
				resto=cpf%10;
				cpf=cpf/10;
				multresult=resto*nummult;
				soma=soma+multresult;
				nummult=nummult-1;
			}
			if (dig2 == soma%11) {
				certo = true;
			}

		}
		return certo;
	}
	*/

}
