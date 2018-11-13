import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

public class NutricionistaService {

    //Cadastro de nutricionista

    public Nutricionista cadastroNutric(Request request) {
        Query query = request.getQuery();
        Nutricionista user = new Nutricionista(query.get("nome"), query.get("login"), query.get("email"), query.get("senha"), query.get("idade"), 
        		query.get("cpf"),query.get("crn"), query.get("escolaridade"));

        return user;
    }
    
    public String[] leituraNutri(Request request) {
    	Query query = request.getQuery();
    	String[] vet = new String[3];
    	vet[0] = query.get("email");
    	vet[1] = query.get("senha");
    	vet[2] = query.get("tipo");
    	return vet;
    }
}