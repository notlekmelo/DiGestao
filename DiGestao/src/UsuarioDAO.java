import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class UsuarioDAO implements DAO<Usuario, String>{

	public UsuarioDAO() {
		
	}
	
	@Override
	public void add(Usuario p) {
		Usuario u = p;
		try (BufferedWriter buffer_saida = new BufferedWriter(new FileWriter("usuario.txt", true))){
			String separa = System.getProperty("line.separator");
			buffer_saida.write(u.getNome() + " ");
			buffer_saida.write(u.getCpf() + " ");
			buffer_saida.write(u.getEmail() + " ");
			buffer_saida.write(u.getGenero() + " ");
			buffer_saida.write(u.getAtvFis() + " ");
			buffer_saida.write(u.getIdade() + " ");
			buffer_saida.write(u.getMeta() + " ");
			buffer_saida.write(u.getSenha() + " ");
			buffer_saida.write(u.getAlturaMetros() + " ");
			buffer_saida.write(u.getPesoKG() + " ");
			buffer_saida.write(separa);
			buffer_saida.flush();
		} catch (Exception e) {
			System.out.println("ERRO AO GRAVAR O USUÁRIO '" + u.getNome() + "' no disco!");
			e.printStackTrace();
		}
	}
	
	@Override
	public Usuario get(String chave) {
		Usuario retorno = null;
		Usuario u = null;
		try (BufferedReader buffer_entrada = new BufferedReader(new FileReader("usuario.txt"))){
			String idSTR;
			while((idSTR = buffer_entrada.readLine()) != null) {
				u = new Usuario();
				u.setNome(idSTR);
				u.setEmail(buffer_entrada.readLine());
				u.setMeta(buffer_entrada.readLine());
				u.setPesoKG(Float.parseFloat(buffer_entrada.readLine()));
				u.setAlturaMetros(Float.parseFloat(buffer_entrada.readLine()));
				u.setAtvFis(buffer_entrada.readLine());
				if(chave.equals(u.getNome())) {
					retorno = u;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("ERRO AO LER O USUARIO'" + u.getNome() + "' DO DISCO RÍDIGO!");
			e.printStackTrace();
		}
		return retorno;
	}
	
	@Override
	public List<Usuario> getAll(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario u = null;
		try (BufferedReader buffer_entrada = new BufferedReader(new FileReader("usuario.txt"))){
			String idSTR;
			while((idSTR = buffer_entrada.readLine()) != null) {
				u = new Usuario();
				u.setNome(idSTR);
				u.setEmail(buffer_entrada.readLine());
				u.setMeta(buffer_entrada.readLine());
				u.setPesoKG(Float.parseFloat(buffer_entrada.readLine()));
				u.setAlturaMetros(Float.parseFloat(buffer_entrada.readLine()));
				u.setAtvFis(buffer_entrada.readLine());
				usuarios.add(u);
			}
		} catch (Exception e) {
			System.out.println("ERRO AO LER OS USUÁRIOS DO DISCO RÍGIDO");
			e.printStackTrace();
		}
		return usuarios;
	}
	
	@Override
	public void delete(Usuario p) {
		List<Usuario> usuarios = getAll();
		int index = usuarios.indexOf(p);
		if (index != -1) {
			usuarios.remove(index);
		}
		saveToFile(usuarios);
	}
	
	private void saveToFile(List<Usuario> usuarios) {
		try (BufferedWriter buffer_saida = new BufferedWriter(new FileWriter("usuario.txt"))){
			String separa = System.getProperty("line.separator");
			for (Usuario u : usuarios) {
				buffer_saida.write(u.getNome() + " ");
				buffer_saida.write(u.getCpf() + " ");
				buffer_saida.write(u.getEmail() + " ");
				buffer_saida.write(u.getGenero() + " ");
				buffer_saida.write(u.getIdade() + " ");
				buffer_saida.write(u.getSenha() + " ");
				buffer_saida.write(separa);
				buffer_saida.flush();
			}
		} catch (Exception e) {
			System.out.println("ERRO AO GRAVAR USUÁRIOS NO DISCO");
			e.printStackTrace();
		}
	}
	
}
