
public class CriarDieta {
	private String tipoDieta;
	private float metaKg;
	private String[] dosagemAlimentos = new String[15];
	private int tempoDietaMeses;
	public double tmb, kcal;
	
	public void historicoUsuario() {

	}

	public void preencherAlimentosHist() {
		//Neste método o usuário preencherá o que comeu e haverá o calculo do que falta comer.
	}
	
	public double tmb(double peso, double altura,double idade,String sexo) {
		if(sexo.equals("M")) {
			 tmb= 88.36+(13.4*peso)+(4.8*(altura*100))-(5.7*idade);
		}
		if(sexo.equals("F")) {
			tmb= 447.6+(9.2*peso)+(3.1*(altura*100))-(4.3*idade);
					}
		return tmb;
	}
	
	public void consultaParametros(Usuario anonimo) {
		String[] vet = new String[15];
		
		if(anonimo.getAtvFis().equals("Sedentario")) {
			if(anonimo.getMeta().equals("Emagrecer")) {
				kcal=(tmb*1.2)-200;
			}
			if(anonimo.getMeta().equals("Engordar")) {
				kcal=(tmb*1.2)+200;
			}
			if(anonimo.getMeta().equals("Manter")) {
				kcal=tmb*1.2;
			}
		}
		if(anonimo.getAtvFis().equals("Baixo")) {
			if(anonimo.getMeta().equals("Emagrecer")) {
				kcal=(tmb*1.375)-200;
			}
			if(anonimo.getMeta().equals("Engordar")) {
				kcal=(tmb*1.375)+200;
			}
			if(anonimo.getMeta().equals("Manter")) {
				kcal=tmb*1.375;
			}
		}
		if(anonimo.getAtvFis().equals("Medio")) {
			if(anonimo.getMeta().equals("Emagrecer")) {
				kcal=(tmb*1.55)-200;
			}
			if(anonimo.getMeta().equals("Engordar")) {
				kcal=(tmb*1.55)+200;
			}
			if(anonimo.getMeta().equals("Manter")) {
				kcal=tmb*1.55;
			}
		}
		if(anonimo.getAtvFis().equals("Alto")) {
			if(anonimo.getMeta().equals("Emagrecer")) {
				kcal=(tmb*1.725)-200;
			}
			if(anonimo.getMeta().equals("Engordar")) {
				kcal=(tmb*1.725)+200;
			}
			if(anonimo.getMeta().equals("Manter")) {
				kcal=tmb*1.725;
			}
		}
		if(anonimo.getAtvFis().equals("Muito alto")) {
			if(anonimo.getMeta().equals("Emagrecer")) {
				kcal=(tmb*1.9)-200;
			}
			if(anonimo.getMeta().equals("Engordar")) {
				kcal=(tmb*1.9)+200;
			}
			if(anonimo.getMeta().equals("Manter")) {
				kcal=tmb*1.9;
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
