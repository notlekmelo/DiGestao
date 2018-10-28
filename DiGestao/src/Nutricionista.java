
public class Nutricionista extends Pessoa{
	private long crn;
	private String escolaridade;
	
	public Nutricionista(String nome, String login, String email, String senha, int idade, long cpf, long crn, String escolaridade) {
		super(nome, login, email, senha,idade,cpf);
		this.escolaridade= escolaridade;
		if(verificaCrn(crn)) {
			this.crn=crn;
		}
	}

	private boolean verificaCrn(long crn) {
		boolean certo = false;
		return certo;
	}

	public long getCrn() {
		return crn;
	}

	public String getEscolaridade() {
		return escolaridade;
	}
	
	public void respondePergunta(String mensagem) {
		
	}
}
