import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.Status;

public class NutricionistaService {

    //Cadastro de nutricionista

    public static Nutricionista cadastroNutric(Request request) {
        Query query = request.getQuery();
        Nutricionista user = new Nutricionista(query.get("nome"), query.get("email"), query.get("senha"), query.get("idade"), 
        		query.get("cpf"),query.get("crn"), query.get("escolaridade"));

        return user;
    }
    
    public static void trataCadastro(Request request, Response response) {
    	JSONObject obj = new JSONObject();
    	Nutricionista nutri;
    	NutricionistaDAO arq = new NutricionistaDAO();
		try {
			nutri = cadastroNutric(request);
			NutricionistaCole.adicionaLista(nutri);
			obj.put("status", 1);
			obj.put("message", "Cadastro Feito com sucesso");
			arq.add(nutri);
		} catch (Exception e) {
			obj.put("status", 0);
			obj.put("type", e.getClass());
			obj.put("stackTrace", e.getStackTrace());
			obj.put("message", e.getMessage());
		}
		try {
		HTMLlink.enviaResposta(Status.CREATED, response, obj.toString());
		}
		catch (Exception e){
			System.out.println("Erro no tratamento da request");
		}
    }
    
    public static void login(String[] vetorUser,Response response) {
		JSONObject obj = new JSONObject();
    	try {
			String email = vetorUser[0];
			String senha = vetorUser[1];
			System.out.println("email: " + email);
			System.out.println("senha: " + senha);
			
			String arqNutricionista = "C:/Users/kelto/Documents/puc/Tis_2/DiGestao/DiGestao/nutricionista.txt";
			FileReader arq = new FileReader(arqNutricionista);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			
			while (linha != null) {
				System.out.println(linha); // printa o arquivo todo
				if (linha.contains(email) & (linha.contains(senha)))
					System.out.println("Usuário logado! Email: " + email + " Senha: " + senha);
				linha = lerArq.readLine();
			}
			
			obj.put("status", 1);
			obj.put("message", "Dados atualizados com sucesso");
			arq.close();
		} 
		 catch (Exception e) {
			obj.put("status", 0);
			obj.put("type", e.getClass());
			obj.put("stackTrace", e.getStackTrace());
			obj.put("message", e.getMessage());
			System.out.println("Erro na abertura do arquivo nutricionistas.");
			System.out.println(e.getMessage());
		}
    	try {
		HTMLlink.enviaResposta(Status.CREATED, response, obj.toString());
    	} catch (Exception e) {
    		System.out.println("Erro ao tratar login");
    	}
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