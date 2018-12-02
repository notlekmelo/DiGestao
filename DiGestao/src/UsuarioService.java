import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.Status;

public class UsuarioService {
	static Usuario user;
	public static Usuario cadastroUser(Request request) {
        Query query = request.getQuery();
        user = new Usuario(query.get("nome"), query.get("email"), query.get("senha"), query.get("idade"), 
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
	
	public static void trataCadastro(Request request, Response response) {
		JSONObject obj = new JSONObject();
		Usuario pessoa = new Usuario();
		UsuarioDAO arq = new UsuarioDAO();
		try {
			pessoa = cadastroUser(request);
			UsuarioCole.adicionaLista(user);
			obj.put("status", 1);
			obj.put("message", "Cadastro feito com sucesso");
			arq.add(pessoa);
		} catch (Exception e) {
			obj.put("status", 0);
			obj.put("type", e.getClass());
			obj.put("stackTrace", e.getStackTrace());
			obj.put("message", e.getMessage());
			System.out.println(e.getMessage());
		}
		try {
		HTMLlink.enviaResposta(Status.CREATED, response, obj.toString());
		}
		catch(Exception e) {
			System.out.println("Falha ao tratar cadastro de usuário");
		}
	}
	public static void login(String[] vetorUser, Response response) {
		JSONObject obj = new JSONObject();
		try {
			String email = vetorUser[0];
			String senha = vetorUser[1];
			System.out.println("email: " + email);
			System.out.println("senha: " + senha);
			String arqUsuarios = "C:/Users/kelto/Documents/puc/Tis_2/DiGestao/DiGestao/usuario.txt";
			FileReader arq = new FileReader(arqUsuarios);
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
			
		} catch (Exception e) {
			obj.put("status", 0);
			obj.put("type", e.getClass());
			obj.put("stackTrace", e.getStackTrace());
			obj.put("message", e.getMessage());
			System.out.println("Erro na abertura do arquivo usuários .");
			System.out.println(e.getMessage());
		}
		try {
		HTMLlink.enviaResposta(Status.CREATED, response, obj.toString());
		} catch (Exception e) {
			System.out.println("Falha no tratamento de login");
		}
	}
	
	public Usuario setDados(Request request) {
		Query query = request.getQuery();
		user.setAlturaMetros(Float.parseFloat(query.get("altura")));
		user.setAtvFis(query.get("atvFis"));
		user.setMeta(query.get("meta"));
		user.setPesoKG(Float.parseFloat(query.get("pesoKg")));
		return user;
	}
}

