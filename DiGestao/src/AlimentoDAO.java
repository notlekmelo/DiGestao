import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class AlimentoDAO implements DAO<Alimento, String>{
	public AlimentoDAO() {
		
	}
	
	@Override
	public void add(Alimento p) {
		Alimento a = p;
		try (BufferedWriter buffer_saida = new BufferedWriter(new FileWriter("alimento.txt"))){
			String separa = System.getProperty("line.separator");
			buffer_saida.write(a.getTipo() + " ");
			buffer_saida.write(a.getDosagem() + " ");
			buffer_saida.write(a.getCarboidratos() + " ");
			buffer_saida.write(a.getmanganes() + " ");
			buffer_saida.write(a.getpotassio() + " ");
			buffer_saida.write(a.getlipideos() + " ");
			buffer_saida.write(a.getGordurasTrans() + " ");
			buffer_saida.write(a.getGordurasTotais() + " ");
			buffer_saida.write(a.getGordurasSaturadas() + " ");
			buffer_saida.write(a.getProteinas() + " ");
			buffer_saida.write(a.getFibraAlimentar() + " ");
			buffer_saida.write(a.getCalcio() + " ");
			buffer_saida.write(a.getFerro() + " ");
			buffer_saida.write(a.getSodio() + " ");
			buffer_saida.write(a.getColesterol() + " ");
			buffer_saida.write(a.getValorEnergetico() + " ");
			buffer_saida.write(a.getPreco() + " ");
			buffer_saida.write(separa);
			buffer_saida.flush();
		} catch(Exception e) {
			System.out.println("ERRO AO GRAVAR O ALIMENTO'" + a.getTipo() + "' NO DISCO RÍGIDO");
			e.printStackTrace();
		}
	}
	
	@Override
	public Alimento get(String chave) {
		Alimento retorno = null;
		Alimento a = null;
		try(BufferedReader buffer_entrada = new BufferedReader(new FileReader("alimento.txt"))){
			String idSTR;
			while((idSTR = buffer_entrada.readLine()) != null) {
				a = new Alimento();
				a.setTipo(idSTR);
				a.setDosagem(buffer_entrada.readLine());
				a.setCarboidratos(buffer_entrada.readLine());
				a.setmanganes(buffer_entrada.readLine());
				a.setpotassio(buffer_entrada.readLine());
				a.setlipideos(buffer_entrada.readLine());
				a.setGordurasTrans(buffer_entrada.readLine());
				a.setGordurasTotais(buffer_entrada.readLine());
				a.setGordurasSaturadas(buffer_entrada.readLine());
				a.setProteinas(buffer_entrada.readLine());
				a.setFibraAlimentar(buffer_entrada.readLine());
				a.setCalcio(buffer_entrada.readLine());
				a.setFerro(buffer_entrada.readLine());
				a.setSodio(buffer_entrada.readLine());
				a.setColesterol(buffer_entrada.readLine());
				a.setValorEnergetico(buffer_entrada.readLine());
				a.setPreco(Float.parseFloat(buffer_entrada.readLine()));
				if(chave.equals(a.getTipo())) {
					retorno = a;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("ERRO AO LER O ALIMENTO '" + a.getTipo() + "' DO DISCO RÍGIDO");
			e.printStackTrace();
		}
		return retorno;
	}
	
	@Override
	public List<Alimento> getAll(){
		List<Alimento> alimentos = new ArrayList<Alimento>();
		Alimento a = null;
		try (BufferedReader buffer_entrada = new BufferedReader(new FileReader("usuario.txt"))){
			String idSTR;
			while((idSTR = buffer_entrada.readLine()) != null) {
				a = new Alimento();
				a.setTipo(idSTR);
				a.setDosagem(buffer_entrada.readLine());
				a.setCarboidratos(buffer_entrada.readLine());
				a.setmanganes(buffer_entrada.readLine());
				a.setpotassio(buffer_entrada.readLine());
				a.setlipideos(buffer_entrada.readLine());
				a.setGordurasTrans(buffer_entrada.readLine());
				a.setGordurasTotais(buffer_entrada.readLine());
				a.setGordurasSaturadas(buffer_entrada.readLine());
				a.setProteinas(buffer_entrada.readLine());
				a.setFibraAlimentar(buffer_entrada.readLine());
				a.setCalcio(buffer_entrada.readLine());
				a.setFerro(buffer_entrada.readLine());
				a.setSodio(buffer_entrada.readLine());
				a.setColesterol(buffer_entrada.readLine());
				a.setValorEnergetico(buffer_entrada.readLine());
				a.setPreco(Float.parseFloat(buffer_entrada.readLine()));
				alimentos.add(a);
			}
		} catch (Exception e) {
			System.out.println("ERRO AO LER OS ALIMENTOS DO DISCO RÍGIDO");
			e.printStackTrace();
		}
		return alimentos;
	}
	
	@Override
	public void delete(Alimento p) {
		List<Alimento> alimentos = getAll();
		int index = alimentos.indexOf(p);
		if (index != -1) {
			alimentos.remove(index);
		}
		saveToFile(alimentos);
	}
	
	public void saveToFile(List<Alimento> alimentos) {
		try (BufferedWriter buffer_saida = new BufferedWriter(new FileWriter("alimento.txt"))){
			String separa = System.getProperty("line.separator");
			for (Alimento a : alimentos) {
				buffer_saida.write(a.getTipo() + " ");
				buffer_saida.write(a.getDosagem() + " ");
				buffer_saida.write(a.getCarboidratos() + " ");
				buffer_saida.write(a.getmanganes() + " ");
				buffer_saida.write(a.getpotassio()+ " ");
				buffer_saida.write(a.getlipideos()+ " ");
				buffer_saida.write(a.getGordurasTrans() + " ");
				buffer_saida.write(a.getGordurasTotais() + " ");
				buffer_saida.write(a.getGordurasSaturadas() + " ");
				buffer_saida.write(a.getProteinas() + " ");
				buffer_saida.write(a.getFibraAlimentar() + " ");
				buffer_saida.write(a.getCalcio() + " ");
				buffer_saida.write(a.getFerro() + " ");
				buffer_saida.write(a.getSodio() + " ");
				buffer_saida.write(a.getColesterol() + " ");
				buffer_saida.write(a.getValorEnergetico() + " ");
				buffer_saida.write(a.getPreco() + " ");
				buffer_saida.write(separa);
				buffer_saida.flush();
			}
		} catch(Exception e) {
			System.out.println("ERRO AO GRAVAR OS ALIMENTOS NO DISCO RÍGIDO");
			e.printStackTrace();
		}
	}
}

