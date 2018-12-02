
public class Dieta {
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
	
	public double tmb(double peso, double altura,int idade,String sexo) {
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
		// Precisamos inicializar vetor com as quantidades de nutrientes para cada tipo de dieta e pessoa. além de definir a meta melhor que dessa forma geral.
		if(anonimo.getAtvFis().equals("Sedentario")) {
			if(anonimo.getMeta().equals("Emagrecer")) {
				kcal=(tmb*1.2)-200;
				inicializar("Emagrecer",vet,4,anonimo.getPesoKG()-5);
			}
			if(anonimo.getMeta().equals("Engordar")) {
				kcal=(tmb*1.2)+200;
				inicializar("Engordar",vet,5,anonimo.getPesoKG()+4);
			
			}
			if(anonimo.getMeta().equals("Manter")) {
				kcal=tmb*1.2;
				inicializar("Manter",vet,6,anonimo.getPesoKG());
			}
		}
		if(anonimo.getAtvFis().equals("Baixo")) {
			if(anonimo.getMeta().equals("Emagrecer")) {
				kcal=(tmb*1.375)-200;
				inicializar("Emagrecer",vet,4,anonimo.getPesoKG()-5);
			}
			if(anonimo.getMeta().equals("Engordar")) {
				kcal=(tmb*1.375)+200;
				inicializar("Engordar",vet,5,anonimo.getPesoKG()+4);
			}
			if(anonimo.getMeta().equals("Manter")) {
				kcal=tmb*1.375;
				inicializar("Manter",vet,6,anonimo.getPesoKG());
			}
		}
		if(anonimo.getAtvFis().equals("Medio")) {
			if(anonimo.getMeta().equals("Emagrecer")) {
				kcal=(tmb*1.55)-200;
				inicializar("Emagrecer",vet,4,anonimo.getPesoKG()-5);
			}
			if(anonimo.getMeta().equals("Engordar")) {
				kcal=(tmb*1.55)+200;
				inicializar("Engordar",vet,5,anonimo.getPesoKG()+4);
			}
			if(anonimo.getMeta().equals("Manter")) {
				kcal=tmb*1.55;
				inicializar("Manter",vet,6,anonimo.getPesoKG());
			}
		}
		if(anonimo.getAtvFis().equals("Alto")) {
			if(anonimo.getMeta().equals("Emagrecer")) {
				kcal=(tmb*1.725)-200;
				inicializar("Emagrecer",vet,4,anonimo.getPesoKG()-5);
			}
			if(anonimo.getMeta().equals("Engordar")) {
				kcal=(tmb*1.725)+200;
				inicializar("Engordar",vet,5,anonimo.getPesoKG()+4);
			}
			if(anonimo.getMeta().equals("Manter")) {
				kcal=tmb*1.725;
				inicializar("Manter",vet,6,anonimo.getPesoKG());
			}
		}
		if(anonimo.getAtvFis().equals("Muito alto")) {
			if(anonimo.getMeta().equals("Emagrecer")) {
				kcal=(tmb*1.9)-200;
				inicializar("Emagrecer",vet,4,anonimo.getPesoKG()-5);
			}
			if(anonimo.getMeta().equals("Engordar")) {
				kcal=(tmb*1.9)+200;
				inicializar("Engordar",vet,5,anonimo.getPesoKG()+4);
			}
			if(anonimo.getMeta().equals("Manter")) {
				kcal=tmb*1.9;
				inicializar("Manter",vet,6,anonimo.getPesoKG());
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

	public String getTipoDieta() {
		return tipoDieta;
	}

	public float getMetaKg() {
		return metaKg;
	}

	public String[] getDosagemAlimentos() {
		return dosagemAlimentos;
	}

	public int getTempoDietaMeses() {
		return tempoDietaMeses;
	}

	public void setTempoDietaMeses(int parseInt) {
		// TODO Auto-generated method stub
		
	}

	public void setTipoDieta(String idSTR) {
		// TODO Auto-generated method stub
		
	}

	public void setMetaKg(float parseFloat) {
		// TODO Auto-generated method stub
		
	}

	public void setTmb(double parseDouble) {
		// TODO Auto-generated method stub
		
	}

	public void setKcal(double parseDouble) {
		// TODO Auto-generated method stub
		
	}

	public double getTmb() {
		return tmb;
	}

	public double getKcal() {
		return kcal;
	}
}
