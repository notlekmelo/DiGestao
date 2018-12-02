import org.json.JSONObject;

public class Nutricionista extends Pessoa implements JsonFormatter{
	private String escolaridade,crn;
	
	public Nutricionista(String nome, String email, String senha, String idade, String cpf, String crn, String escolaridade) {
		super(nome, email, senha,idade,cpf);
		this.escolaridade= escolaridade;
		if(verificaCrn(crn)) {
			this.crn=crn;
		}
	}

	public Nutricionista() {
		// TODO Auto-generated constructor stub
	}

	private boolean verificaCrn(String crn) {
		boolean certo = true;
		return certo;
	}

	public String getCrn() {
		return crn;
	}

	public String getEscolaridade() {
		return escolaridade;
	}
	
	@Override
	public String toString() {
			return "nome=" + getNome() + ", email=" + getEmail() + ", senha=" + getSenha() + ", cpf=" + getCpf()
					+ ", idade=" + getIdade() + " escolaridade =" + escolaridade + ", crn=" + crn;
	}

	public JSONObject toJson() {

        JSONObject obj = new JSONObject();
        obj.put("nome", getNome());
        obj.put("email", getEmail());
        obj.put("senha", getSenha());
        obj.put("idade", getIdade());
        obj.put("cpf", getCpf());
        obj.put("crn", getCrn());
        obj.put("escolaridade", getEscolaridade());
        
        return obj;

    }
}
