import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class NutricionistaDAO implements DAO<Nutricionista, String>{
	
	public NutricionistaDAO() {
		
	}
	
	@Override
	public void add(Nutricionista p) {
		Nutricionista n = p;
		try (BufferedWriter buffer_saida = new BufferedWriter(new FileWriter("nutricionista.txt"))){
			String separa = System.getProperty("line.separator");
			buffer_saida.write(n.getNome() + " ");
			buffer_saida.write(n.getCpf() + " ");
			buffer_saida.write(n.getEmail() + " ");
			buffer_saida.write(n.getCrn() + " ");
			buffer_saida.write(n.getEscolaridade() + " ");
			buffer_saida.write(n.getIdade() + " ");
			buffer_saida.write(n.getSenha() + " ");
			buffer_saida.write(separa);
			buffer_saida.flush();
		} catch (Exception e) {
			System.out.println("ERRO AO GRAVAR O NUTRICIONISTA '" + n.getNome() + "' NO DISCO RÍGIDO");
			e.printStackTrace();
		}
	}
	
	@Override
	public Nutricionista get(String chave) {
		Nutricionista retorno = null;
		Nutricionista n = null;
		try(BufferedReader buffer_entrada = new BufferedReader(new FileReader("nutricionista.txt"))){
			String idSTR;
			while((idSTR = buffer_entrada.readLine()) != null) {
				n = new Nutricionista();
				//trocar nome por email
				n.setNome(idSTR);
				n.setEmail(buffer_entrada.readLine());
				if (chave.equals(n.getNome())) {
					retorno = n;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("ERRO AO LER O NUTRICIONISTA '" + n.getNome() + "' NO DISCO RÍGIDO");
			e.printStackTrace();
		}
		return retorno;
	}
	
	@Override
	public List<Nutricionista> getAll(){
		List<Nutricionista> nutricionistas = new ArrayList<Nutricionista>();
		Nutricionista n = null;
		try (BufferedReader buffer_entrada = new BufferedReader(new FileReader("nutricionista.txt"))){
			String idSTR;
			while((idSTR = buffer_entrada.readLine())!=null) {
				n = new Nutricionista();
				n.setNome(idSTR);
				n.setEmail(buffer_entrada.readLine());
				nutricionistas.add(n);
			}
			
		} catch (Exception e) {
			System.out.println("ERRO AO LER OS NUTRICIONISTAS DO DISCO RÍGIDO");
			e.printStackTrace();
		}
		return nutricionistas;
	}
	
	@Override
	public void delete(Nutricionista p) {
		List<Nutricionista> nutricionistas = getAll();
		int index = nutricionistas.indexOf(p);
		if (index != -1) {
			nutricionistas.remove(index);
		}
		saveToFile(nutricionistas);
	}
	
	public void saveToFile(List<Nutricionista> nutricionistas) {
		try(BufferedWriter buffer_saida = new BufferedWriter(new FileWriter("nutricionista.txt"))){
			String separa = System.getProperty("line.separator");
			for (Nutricionista n : nutricionistas) {
				buffer_saida.write(n.getNome() + " ");
				buffer_saida.write(n.getCpf() + " ");
				buffer_saida.write(n.getEmail() + " ");
				buffer_saida.write(n.getCrn() + " ");
				buffer_saida.write(n.getEscolaridade() + " ");
				buffer_saida.write(n.getIdade() + " ");
				buffer_saida.write(n.getSenha() + " ");
				buffer_saida.write(separa);
				buffer_saida.flush();
			}
		} catch (Exception e) {
			System.out.println("ERRO AO GRAVAR NUTRICIONISTAS NO DISCO");
			e.printStackTrace();
		}
	}
	
}
