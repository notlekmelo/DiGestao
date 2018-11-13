import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;

import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.Status;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;



public class HTMLlink implements Container {

	//Dados estaticos
	static final int limiteUsers = 150;
	static NutricionistaService nutricionista = new NutricionistaService();
	static UsuarioService usuario = new UsuarioService();
	static Usuario user;
	static Nutricionista nutri;
	static Nutricionista[] listaNutri = new Nutricionista[limiteUsers];
	static Usuario[] listaUser = new Usuario[limiteUsers];
	
	// cadastra nutricionista na lista em java
    public void cadastroListaNutri(Nutricionista nutri) {
    	for (int i = 0; i < listaNutri.length; i++) {
    		if (listaNutri[i] == null) {
    			listaNutri[i] = nutri;
    			break;
    		}
    	}
    }
    
    // cadastra usuario na lista em java
    public void cadastroListaUser(Usuario user) {
    	for (int i = 0; i < listaUser.length; i++) {
    		if (listaUser[i] == null) {
    			listaUser[i] = user;
    			break;
    		}
    	}
    }

	public void handle(Request request, Response response) {
		try {
			// Recupera a URL e o método utilizado.

			String path = request.getPath().getPath();
			// Verifica qual ação está sendo chamada

			if (path.startsWith("/cadastro-nutricionista")) {
				JSONObject obj = new JSONObject();
				try {
					nutri = nutricionista.cadastroNutric(request);
					cadastroListaNutri(nutri);
					obj.put("status", 1);
					obj.put("message", "Cadastro Feito com sucesso");
					try(FileWriter arqNut = new FileWriter("ArquivoNutricionistas", true);
							BufferedWriter bw = new BufferedWriter(arqNut);
							PrintWriter escreve = new PrintWriter(bw))
					{
						escreve.println(nutri);
					} catch (IOException e) {
						System.out.println("Deu ruim no arquivo");
					}
				} catch (Exception e) {
					obj.put("status", 0);
					obj.put("type", e.getClass());
					obj.put("stackTrace", e.getStackTrace());
					obj.put("message", e.getMessage());
				}

				this.enviaResposta(Status.CREATED, response, obj.toString());
			}

			if (path.startsWith("/cadastro-pessoa")) {
				JSONObject obj = new JSONObject();
				try {
					user = usuario.cadastroUser(request);
					cadastroListaUser(user);
					obj.put("status", 1);
					obj.put("message", "Cadastro feito com sucesso");
					try(FileWriter arqUser = new FileWriter("ArquivoUsuarios", true);
							BufferedWriter bw = new BufferedWriter(arqUser);
							PrintWriter escreve = new PrintWriter(bw))
					{
						escreve.println(user);
					} catch (IOException e) {
						System.out.println("Deu ruim no arquivo");
					}
				} catch (Exception e) {
					obj.put("status", 0);
					obj.put("type", e.getClass());
					obj.put("stackTrace", e.getStackTrace());
					obj.put("message", e.getMessage());
					System.out.println(e.getMessage());
				}
				this.enviaResposta(Status.CREATED, response, obj.toString());
			}
			
			if (path.startsWith("/index")) {
				JSONObject obj = new JSONObject();
				try(FileWriter arqUser = new FileWriter("ArquivoUsuarios", true);
						BufferedWriter bw = new BufferedWriter(arqUser);
						PrintWriter escreve = new PrintWriter(bw))
				{
					escreve.println(usuario.setDados(request));
					obj.put("status", 1);
					obj.put("message", "Dados atualizados com sucesso");
					} 
				 catch (Exception e) {
					obj.put("status", 0);
					obj.put("type", e.getClass());
					obj.put("stackTrace", e.getStackTrace());
					obj.put("message", e.getMessage());
					System.out.println(e.getMessage());
				}
				this.enviaResposta(Status.CREATED, response, obj.toString());
			}

			if (path.startsWith("/logar")) {
				JSONObject obj = new JSONObject();
				try {
					String[] vetorUser = usuario.leituraUser(request);
					System.out.println("Vetor user 0: " + vetorUser[0]); // email
					System.out.println("vetor user 1: " + vetorUser[1]); // senha
					System.out.println("vetor user 2: " + vetorUser[2]); // tipo
					/*
					for (int i = 0; i < listaNutri.length; i++) {
						if (listaNutri[i].getEmail().equals(vetorUser[0]))
					}*/
					
					if (vetorUser[2].equals("nutricionista")) {
						try {
							String email = vetorUser[0];
							String senha = vetorUser[1];
							System.out.println("email: " + email);
							System.out.println("senha: " + senha);
							
							String arqNutricionista = "C:/Users/kelto/Documents/puc/Tis_2/DiGestao/DiGestao/ArquivoNutricionistas";
							FileReader arq = new FileReader(arqNutricionista);
							BufferedReader lerArq = new BufferedReader(arq);
							String linha = lerArq.readLine();
							
							while (linha != null) {
								System.out.println(linha); // printa o arquivo todo
								if (linha.contains("email=" + email) & (linha.contains("senha=" + senha)))
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
						this.enviaResposta(Status.CREATED, response, obj.toString());
					}
					
					if (vetorUser[2].equals("pessoa")) {
						try {
					
							String email = vetorUser[0];
							String senha = vetorUser[1];
							System.out.println("email: " + email);
							System.out.println("senha: " + senha);
							
							String arqUsuarios = "C:/Users/kelto/Documents/puc/Tis_2/DiGestao/DiGestao/ArquivoUsuarios";
							FileReader arq = new FileReader(arqUsuarios);
							BufferedReader lerArq = new BufferedReader(arq);
							String linha = lerArq.readLine();
							
							while (linha != null) {
								System.out.println(linha); // printa o arquivo todo
								if (linha.contains("email=" + email) & (linha.contains("senha=" + senha)))
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
							System.out.println("Erro na abertura do arquivo usu�rios .");
							System.out.println(e.getMessage());
						}
						this.enviaResposta(Status.CREATED, response, obj.toString());
					}
				} catch (Exception e) {
					obj.put("status", 0);
					obj.put("type", e.getClass());
					obj.put("stackTrace", e.getStackTrace());
					obj.put("message", e.getMessage());
					System.out.println("Erro na abertura do m�todo logar.");
					System.out.println(e.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void enviaResposta(Status status, Response response, String str) throws Exception {
		PrintStream body = response.getPrintStream();
		long time = System.currentTimeMillis();
		response.setValue("Content-Type", "application/json");
		response.setValue("Server", "Gestão de nutricionistas (1.0)");
		response.setValue("Access-Control-Allow-Origin", "null");
		response.setDate("Date", time);
		response.setDate("Last-Modified", time);
		response.setStatus(status);
		if (str != null)
			body.println(str);
		body.close();
	}
	public static void main(String args[]) throws IOException {
		int porta = 7200;
		// Configura uma conexão soquete para o servidor HTTP.
		Container container = new HTMLlink();
		ContainerSocketProcessor servidor = new ContainerSocketProcessor(container);
		Connection conexao = new SocketConnection(servidor);
		SocketAddress endereco = new InetSocketAddress(porta);
		conexao.connect(endereco);
		System.out.println("Tecle ENTER para interromper o servidor...");
		System.in.read();
		conexao.close();
		servidor.stop();
	}
}