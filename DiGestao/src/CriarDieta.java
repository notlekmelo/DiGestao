
public class CriarDieta {
	private String tipoDieta, meta;
	private String[] dosagemAlimentos = new String[15];
	private int tempoDieta;
	
	public void historicoUsuario() {
		
	}
	
	public void preencherAlimentosHist() {
		//Neste m�todo o usu�rio preencher� o que comeu e haver� o calculo do que falta comer.
	}
	
	//Por enquanto a dieta n�o recebe qual alimento deve comer, somente as quantidades de cada tipo de nutriente. A Meta definida vai ser comparada
	//com o peso que ela alcan�ou. a dosagem e um vetor q define qtd de cada tipo de nutriente.
	public void inicializar(String tipoDieta, String[] dosagemAlimentos, int tempoDieta, String meta) {
		this.tipoDieta = tipoDieta;
		this.dosagemAlimentos = dosagemAlimentos;
		this.tempoDieta = tempoDieta;
		this.meta = meta;
	}

	private String getTipoDieta() {
		return tipoDieta;
	}

	private String getMeta() {
		return meta;
	}

	private String[] getDosagemAlimentos() {
		return dosagemAlimentos;
	}

	private int getTempoDieta() {
		return tempoDieta;
	}
}
