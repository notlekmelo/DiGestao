import javax.swing.JOptionPane;

public class TelaCadastro {

	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Digite o nome: ");
		String usuario = JOptionPane.showInputDialog("Escolhe o usuário: ");
		String senha = JOptionPane.showInputDialog("Digite sua senha: ");
		String confirma = JOptionPane.showInputDialog("Confirme sua senha: ");
		String atvFis = JOptionPane.showInputDialog("Qual seu nível de atividade física: ");
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade: "));
		long cpf = Long.parseLong(JOptionPane.showInputDialog("Digite seu cpf: "));
		//ValidaUsuario(usuario);
		ValidaSenha(senha,confirma);
		Usuario novo = new Usuario(nome, usuario, senha,idade, cpf ,atvFis);
		//coloca novo no arquivo.
	}
	
	//public static void ValidaUsuario(String nome) {
	//	confere se não tem no arquivo
	//}
	
	public static void ValidaSenha(String senha, String confirma) {
		while (!senha.equals(confirma)) {
			JOptionPane.showMessageDialog(null,"As senhas digitadas não batem. Favor digitar novamente.");
			senha = JOptionPane.showInputDialog("Digite sua senha: ");
			confirma = JOptionPane.showInputDialog("Confirme sua senha: ");
		}
	}
}
