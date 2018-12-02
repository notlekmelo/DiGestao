import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.Query;


public class AlimentoService {
	
	public static void adicionaAlimento(Request request, Response response) {
		Query query = request.getQuery();
		Alimento add = new Alimento(query.get("tipo"), query.get("dosagem"), query.get("carboidratos"), query.get("manganes"), query.get("potassio"), query.get("lipideos"),
				query.get("gordurasTrans"), query.get("gordurasTotais"), query.get("gordurasSaturadas"), query.get("proteinas"), query.get("fibraAlimentar"), query.get("calcio"),
				query.get("ferro"), query.get("sodio"), query.get("colesterol"), query.get("valorEnergetico"), 0.0F);
		AlimentosCole.adicionaLista(add);
	}

	public static void removeAlimento() {
		AlimentosCole.removeUltimo();
	}

	public static void finalizaDieta() {
		double[] vet = new double[14];
		vet = AlimentosCole.Calculo();
		System.out.println("Você consumiu: "+vet[0]+" carboidratos \n" +vet[1]+" "+vet[2]+" manganês \n"+vet[3]+" proteínas \n"+vet[4]+" lipídeos \n"+vet[5]+" Gorduras Trans \n"+
				vet[6]+" Gorduras Totais \n"+vet[7]+" Gorturas saturadas \n"+vet[8]+" proteínas \n"+vet[9]+" fibras alimentares \n"+vet[10]+" cálcio \n"+vet[11]+" sódio \n"+vet[12]+" colesterol \n"+vet[13]+" Valor Energético.");
	}

}
