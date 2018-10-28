import java.awt.Desktop;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;

import org.simpleframework.http.Query;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

public class FORMServer implements Container {
	static Usuario userJsonPJava;
	
	public Usuario jsonParaJava(Usuario user) {
		
        Gson gson = new Gson();
        
        try {
 
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\lucca\\Desktop\\DiGestao\\dadosUsuario.json"));
 
            //Converte String JSON para objeto Java
            Usuario obj = gson.fromJson(br, Usuario.class);
            userJsonPJava = obj;
            
            // printa no console os dados lidos do form
            System.out.println("Nome: " + obj.getNome());
            System.out.println("User: " + obj.getLogin());
            System.out.println("Idade: " + obj.getIdade());
            System.out.println("Senha: " + obj.getSenha());
            System.out.println("Genero:" + obj.getGenero());
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userJsonPJava;
      
	}
	
	public String javaParaJson(Usuario obj) {
		
	    Gson gson = new Gson();
	  
	    // converte objetos Java para JSON e retorna JSON como String
	    String json = gson.toJson(obj);
	  
	    try {
	        //Escreve Json convertido em arquivo chamado "dadosUsuario.json"
	        FileWriter writer = new FileWriter("C:\\Users\\lucca\\Desktop\\DiGestao\\dadosUsuario.json");
	        writer.write(json);
	        writer.close();
	  
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	  
	    return json;

	    }
	
	public void handle(Request request, Response response) {
		try {
			
			Query query = request.getQuery();
			PrintStream body = response.getPrintStream();
			long time = System.currentTimeMillis();

			response.setValue("Content-Type", "text/plain");
			response.setValue("Server", "HelloWorld/1.0 (Simple 4.0)");
			response.setDate("Date", time);
			response.setDate("Last-Modified", time);
			
			// Testa o objeto Query, que recupera dados de formulário
			String nome = query.get("nome");
			int idade = query.getInteger("idade");
			String usuario = query.get("usuario");
			String email = query.get("email");
			String senha = query.get("senha");
			String cpf = query.get("cpf");
			long cpfLong = Long.parseLong(cpf);
			String genero = query.get("genero");
			
			// printa os dados do formulário numa página 
			body.println("Cadastro de Usuário - Formulário direto:");
			body.println("Nome: " + nome + "\nNome de usuário: " + usuario + "\nEmail: " + email + "\nIdade: " + idade +  
					"\nsenha: " + senha + "\nCPF: " + cpfLong + "\nGênero: " + genero);
			
			Usuario user = new Usuario(nome, usuario, email, senha, idade, cpfLong, genero);
			
			// passa dados do form para JSON
			String dadosForm = javaParaJson(user);
			body.println(" ");
			body.println("Dados do formulário como JSON: ");
			body.println(dadosForm);

			// passa dados JSON para Java e printa no browser
			Usuario userJava = jsonParaJava(user);
			body.println(" ");
			body.println("DADOS USER JSON PARA JAVA: ");
			body.println("Nome: " + userJava.getNome());
			body.println("User: " + userJava.getLogin());
			body.println("Email: " + userJava.getEmail());
			body.println("Idade: " + userJava.getIdade());
			body.println("Senha: " + userJava.getSenha());
			body.println("Gênero: " + userJava.getGenero());
			body.println("CPF: " + userJava.getCpf());
			
			body.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] list) throws Exception {
		// Se voc� receber uma mensagem
		// "Address already in use: bind error",
		// tente mudar a porta.

		int porta = 1337;

		// Configura uma conex�o soquete para o servidor HTTP.
		Container container = new FORMServer();
		ContainerSocketProcessor servidor = new ContainerSocketProcessor(container);
		Connection conexao = new SocketConnection(servidor);
		SocketAddress endereco = new InetSocketAddress(porta);
		conexao.connect(endereco);

		// Testa a conexão abrindo o navegador padr�o.
		File f = new File("C:/Users/lucca/Desktop/DiGestao/DiGestao/src/teste.html");
		URI uri = f.toURI();
		Desktop.getDesktop().browse(uri);

		System.out.println("Tecle ENTER para interromper o servidor...");
		System.in.read();

		conexao.close();
		servidor.stop();

	}
}