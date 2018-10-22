
public class CriarDieta {
	private String tipoDieta;
	private float metaKg;
	private String[] dosagemAlimentos = new String[15];
	private int tempoDietaMeses;

	public void historicoUsuario() {

	}

	public void preencherAlimentosHist() {
		//Neste método o usuário preencherá o que comeu e haverá o calculo do que falta comer.
	}

	public void consultaParametros(Usuario anonimo) {
		String[] vet = new String[15];
		if(anonimo.getAtvFis().equals("Sedentário")) {
			if(anonimo.getMeta().equals("Emagrecer")) {
				
				inicializar("Emagrecer",vet,3 ,74 );
			}
			if(anonimo.getMeta().equals("Engordar")) {

			}
			if(anonimo.getMeta().equals("Manter")) {

			}
		}
		if(anonimo.getAtvFis().equals("Ativo")) {
			if(anonimo.getMeta().equals("Emagrecer")) {

			}
			if(anonimo.getMeta().equals("Engordar")) {

			}
			if(anonimo.getMeta().equals("Manter")) {

			}
		}
		if(anonimo.getAtvFis().equals("Atleta")) {
			if(anonimo.getMeta().equals("Emagrecer")) {

			}
			if(anonimo.getMeta().equals("Engordar")) {

			}
			if(anonimo.getMeta().equals("Manter")) {

			}
		}
	}

	//Por enquanto a dieta não recebe qual alimento deve comer, somente as quantidades de cada tipo de nutriente. A Meta definida vai ser comparada
	//com o peso que ela alcançou. a dosagem e um vetor q define qtd de cada tipo de nutriente.
	public void inicializar(String tipoDieta, String[] dosagemAlimentos, int tempoDieta, float meta) {
		this.tipoDieta= tipoDieta;
		this.dosagemAlimentos = dosagemAlimentos;
		this.tempoDietaMeses = tempoDieta;
		this.metaKg = meta;
	}

	private String getTipoDieta() {
		return tipoDieta;
	}

	private float getMetaKg() {
		return metaKg;
	}

	private String[] getDosagemAlimentos() {
		return dosagemAlimentos;
	}

	private int getTempoDietaMeses() {
		return tempoDietaMeses;
	}
}
