import java.util.ArrayList;
import java.util.List;

public class AlimentosCole {
	private static List<Alimento> alimentoList = new ArrayList<Alimento>();
	static int indice = 0;

	public static void adicionaLista(Alimento a){
		alimentoList.add(a);
		indice++;
	}

	public static void removeUltimo(){
		alimentoList.remove(indice-1);
		indice--;
	}

	public static double[] Calculo() {
		double[] vet = new double[14];
		int carb=0, mang=0, pot=0, lip=0, gtrans=0, gtotais=0, gsat=0,prot=0,fibre=0,cal=0,ferro=0,sodio=0,col=0,valEner=0;
		for(Alimento al : alimentoList) {
			carb += Double.parseDouble(al.carboidratos);
			mang += Double.parseDouble(al.manganes);
			pot	+= Double.parseDouble(al.potassio);
			lip	+= Double.parseDouble(al.lipideos);
			gtrans += Double.parseDouble(al.gordurasTrans);
			gtotais	+= Double.parseDouble(al.gordurasTotais);
			gsat += Double.parseDouble(al.gordurasSaturadas);
			prot += Double.parseDouble(al.proteinas);
			fibre += Double.parseDouble(al.fibraAlimentar);
			cal	+= Double.parseDouble(al.calcio);
			ferro += Double.parseDouble(al.ferro);
			sodio += Double.parseDouble(al.sodio);
			col	+= Double.parseDouble(al.colesterol);
			valEner	+= Double.parseDouble(al.valorEnergetico);
		}
		vet[0] = carb;
		vet[1] = mang;
		vet[2] = pot;
		vet[3] = lip;
		vet[4] = gtrans;
		vet[5] = gtotais;
		vet[6] = gsat;
		vet[7] = prot;
		vet[8] = fibre;
		vet[9] = cal;
		vet[10] = ferro;
		vet[11] = sodio;
		vet[12] = col;
		vet[13] = valEner;
		return vet;
	}
}