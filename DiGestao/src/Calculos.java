
public class Calculos{
	public double imc,pi,piMin,piMax,tmb;
	
	public double imc(double altura, double peso){
		imc=peso/(altura*altura);
		return imc;
	}
	
	public double pesoIdeal(float altura) {
		pi=(21.75*(altura*altura));
//		piMin=(float) (18.5*(altura*altura));
//		piMax=25*(altura*altura);
		return pi;
	}
	
	public double tmb(double peso, double altura,double idade, String sexo) {
		if(sexo.equals("M")) {
			tmb= 88.36+(13.4*peso)+(4.8*(altura*100))-(5.7*idade);
		}
		if(sexo.equals("F")) {
			tmb= 447.6+(9.2*peso)+(3.1*(altura*100))-(4.3*idade);
					}
		return tmb;
	}
	
	public double atividadeFisica(String nivAtivFis) {
	if(nivAtivFis.equals("Sedentario")) {
		return tmb*1.2;
	}
	if(nivAtivFis.equals("Baixo")) {
		return tmb*1.375;
	}
	if(nivAtivFis.equals("Medio")) {
		return tmb*1.55;
	}
	if(nivAtivFis.equals("Alto")) {
		return tmb*1.725;
	}
	if(nivAtivFis.equals("Muito alto")) {
		return tmb*1.9;
	}
	return 0;
	}
	
	public double manterPeso(String nivAtivFis) {
		if(nivAtivFis.equals("Sedentario")) {
			return tmb*1.2;
		}
		if(nivAtivFis.equals("Baixo")) {
			return tmb*1.375;
		}
		if(nivAtivFis.equals("Medio")) {
			return tmb*1.55;
		}
		if(nivAtivFis.equals("Alto")) {
			return tmb*1.725;
		}
		if(nivAtivFis.equals("Muito alto")) {
			return tmb*1.9;
		}
		return 0;
	}
	
	public double perderPeso(String nivAtivFis) {
		if(nivAtivFis.equals("Sedentario")) {
			return (tmb*1.2)-200;
		}
		if(nivAtivFis.equals("Baixo")) {
			return (tmb*1.375)-200;
		}
		if(nivAtivFis.equals("Medio")) {
			return (tmb*1.55)-200;
		}
		if(nivAtivFis.equals("Alto")) {
			return (tmb*1.725)-200;
		}
		if(nivAtivFis.equals("Muito alto")) {
			return (tmb*1.9)-200;
		}
		return 0;
	}
	
	public double ganharPeso(String nivAtivFis) {
		if(nivAtivFis.equals("Sedentario")) {
			return (tmb*1.2)+200;
		}
		if(nivAtivFis.equals("Baixo")) {
			return (tmb*1.375)+200;
		}
		if(nivAtivFis.equals("Medio")) {
			return (tmb*1.55)+200;
		}
		if(nivAtivFis.equals("Alto")) {
			return (tmb*1.725)+200;
		}
		if(nivAtivFis.equals("Muito alto")) {
			return (tmb*1.9)+200;
		}
		return 0;
	}
	
}
