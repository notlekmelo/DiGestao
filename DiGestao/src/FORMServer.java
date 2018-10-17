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

public class FORMServer implements Container {
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
			// pode ser testado com a URL: http://127.0.0.1:880/?nome=Ze;idade=32
			String nome = query.get("nome");
			int idade = query.getInteger("idade");
			
			
			body.println("Teste de requisição com dados de formulário.");
			body.println("NOME: " + nome + "\nIDADE: " + idade + "");
			
			
			body.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] list) throws Exception {
		// Se você receber uma mensagem
		// "Address already in use: bind error",
		// tente mudar a porta.

		int porta = 880;

		// Configura uma conexão soquete para o servidor HTTP.
		Container container = new FORMServer();
		ContainerSocketProcessor servidor = new ContainerSocketProcessor(container);
		Connection conexao = new SocketConnection(servidor);
		SocketAddress endereco = new InetSocketAddress(porta);
		conexao.connect(endereco);

		// Testa a conexão abrindo o navegador padrão.
		Desktop.getDesktop().browse(new URI("http://127.0.0.1:" + porta));

		System.out.println("Tecle ENTER para interromper o servidor...");
		System.in.read();

		conexao.close();
		servidor.stop();

	}
}