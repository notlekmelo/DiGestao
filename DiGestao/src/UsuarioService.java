import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

public class UsuarioService {
	Usuario user;
	public Usuario cadastroUser(Request request) {
        Query query = request.getQuery();
        user = new Usuario(query.get("nome"), query.get("login"), query.get("email"), query.get("senha"), query.get("idade"), 
        		query.get("cpf"), query.get("genero"));

        return user;
    }
	
	public String[] leituraUser(Request request) {
    	Query query = request.getQuery();
    	String[] vet = new String[3];
    	vet[0] = query.get("email");
    	vet[1] = query.get("senha");
    	vet[2] = query.get("tipo");
    	return vet;
    }
	
	public Usuario setDados(Request request) {
		Query query = request.getQuery();
		user.setAlturaMetros(query.get("altura"));
		user.setAtvFis(query.get("atvFis"));
		user.setMeta(query.get("meta"));
		user.setPesoKG(query.get("pesoKg"));
		return user;
	}
}
