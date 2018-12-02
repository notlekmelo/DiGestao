import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DietaDAO implements DAO<Dieta, String>{
	public DietaDAO() {
		
	}
	
	@Override
	public void add(Dieta p) {
		Dieta d = p;
		try (BufferedWriter buffer_saida = new BufferedWriter(new FileWriter("dieta.txt"))){
			String separa = System.getProperty("line.separator");
			buffer_saida.write(d.getTipoDieta() + " ");
			buffer_saida.write(d.getMetaKg() + " ");
			buffer_saida.write(d.getDosagemAlimentos() + " ");
			buffer_saida.write(d.getTempoDietaMeses() + " ");
			buffer_saida.write(d.getTmb() + " ");
			buffer_saida.write(d.getKcal() + " ");
			buffer_saida.write(separa);
			buffer_saida.flush();
		} catch (Exception e) {
			System.out.println("ERRO AO GRAVAR A DIETA '" + d.getTipoDieta() + "' NO DISCO RÍGIDO");
			e.printStackTrace();
		}
	}
	
	@Override
	public Dieta get(String chave) {
		Dieta retorno = null;
		Dieta d = null;
		try(BufferedReader buffer_entrada = new BufferedReader(new FileReader("dieta.txt"))){
			String idSTR;
			while((idSTR = buffer_entrada.readLine()) != null) {
				d = new Dieta();
				d.setTipoDieta(idSTR);
				d.setMetaKg(Float.parseFloat(buffer_entrada.readLine()));
				//d.setDosagemAlimentos(buffer_entrada.readLine());
				d.setTempoDietaMeses(Integer.parseInt(buffer_entrada.readLine()));
				d.setTmb(Double.parseDouble(buffer_entrada.readLine()));
				d.setKcal(Double.parseDouble(buffer_entrada.readLine()));
				if(chave.equals(d.getTipoDieta())) {
					retorno = d;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("ERRO AO LER A DIETA '" + d.getTipoDieta() + "' NO DISCO RÍGIDO");
			e.printStackTrace();
		}
		return retorno;
	}
	
	@Override
	public List<Dieta> getAll(){
		List<Dieta> dietas = new ArrayList<Dieta>();
		Dieta d = null;
		try (BufferedReader buffer_entrada = new BufferedReader(new FileReader("dieta.txt"))){
			String idSTR;
			while((idSTR = buffer_entrada.readLine())!=null) {
				d = new Dieta();
				d.setTipoDieta(idSTR);
				d.setMetaKg(Float.parseFloat(buffer_entrada.readLine()));
				//d.setDosagemAlimentos(buffer_entrada.readLine());
				d.setTempoDietaMeses(Integer.parseInt(buffer_entrada.readLine()));
				d.setTmb(Double.parseDouble(buffer_entrada.readLine()));
				d.setKcal(Double.parseDouble(buffer_entrada.readLine()));
				dietas.add(d);
			}
		}catch(Exception e) {
			System.out.println("ERRO AO LER AS DIETAS DO DISCO RÍGIDO");
			e.printStackTrace();
		}
		return dietas;
	}
	
	@Override
	public void delete(Dieta p) {
		List<Dieta> dietas = getAll();
		int index = dietas.indexOf(p);
		if (index != -1) {
			dietas.remove(index);
		}
		saveToFile(dietas);
	}
	
	public void saveToFile(List<Dieta> dietas) {
		try(BufferedWriter buffer_saida = new BufferedWriter(new FileWriter("nutricionista.txt"))){
			String separa = System.getProperty("line.separator");
			for (Dieta d : dietas) {
				buffer_saida.write(d.getTipoDieta() + " ");
				buffer_saida.write(d.getMetaKg() + " ");
				buffer_saida.write(d.getDosagemAlimentos() + " ");
				buffer_saida.write(d.getTempoDietaMeses() + " ");
				buffer_saida.write(d.getTmb() + " ");
				buffer_saida.write(d.getKcal() + " ");
				buffer_saida.write(separa);
				buffer_saida.flush();
			}
		} catch (Exception e) {
			System.out.println("ERRO AO GRAVAR DIETAS NO DISCO");
			e.printStackTrace();
		}
	}
}

