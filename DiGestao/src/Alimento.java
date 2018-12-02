
public class Alimento {
	private String tipo, dosagem;
	public String carboidratos,manganes, potassio, lipideos, gordurasTrans, gordurasTotais, gordurasSaturadas,proteinas;
	public String fibraAlimentar, calcio, ferro, sodio, colesterol, valorEnergetico;
	private float preco;
	
	public Alimento(String tipo, String dosagem, String carboidratos, String manganes, String potassio, String lipideos,
			String gordurasTrans, String gordurasTotais, String gordurasSaturadas, String proteinas, String fibraAlimentar, String calcio,
			String ferro, String sodio, String colesterol, String valorEnergetico, float preco) {
		this.tipo = tipo;
		this.dosagem = dosagem;
		this.carboidratos = carboidratos;
		this.manganes = manganes;
		this.potassio = potassio;
		this.lipideos = lipideos;
		this.gordurasTrans = gordurasTrans;
		this.gordurasTotais = gordurasTotais;
		this.gordurasSaturadas = gordurasSaturadas;
		this.proteinas = proteinas;
		this.fibraAlimentar = fibraAlimentar;
		this.calcio = calcio;
		this.ferro = ferro;
		this.sodio = sodio;
		this.colesterol = colesterol;
		this.valorEnergetico = valorEnergetico;
		this.preco = preco;
	}

	public Alimento() {
		// TODO Auto-generated constructor stub
	}

	public String geraReceita(Alimento[] receita) {
		return receita[1].tipo + receita[2].tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public String getCarboidratos() {
		return carboidratos;
	}

	public void setCarboidratos(String carboidratos) {
		this.carboidratos = carboidratos;
	}

	public String getmanganes() {
		return manganes;
	}

	public void setmanganes(String manganes) {
		this.manganes = manganes;
	}

	public String getpotassio() {
		return potassio;
	}

	public void setpotassio(String potassio) {
		this.potassio = potassio;
	}

	public String getlipideos() {
		return lipideos;
	}

	public void setlipideos(String lipideos) {
		this.lipideos = lipideos;
	}

	public String getGordurasTrans() {
		return gordurasTrans;
	}

	public void setGordurasTrans(String gordurasTrans) {
		this.gordurasTrans = gordurasTrans;
	}

	public String getGordurasTotais() {
		return gordurasTotais;
	}

	public void setGordurasTotais(String gordurasTotais) {
		this.gordurasTotais = gordurasTotais;
	}

	public String getGordurasSaturadas() {
		return gordurasSaturadas;
	}

	public void setGordurasSaturadas(String gordurasSaturadas) {
		this.gordurasSaturadas = gordurasSaturadas;
	}

	public String getProteinas() {
		return proteinas;
	}

	public void setProteinas(String proteinas) {
		this.proteinas = proteinas;
	}

	public String getFibraAlimentar() {
		return fibraAlimentar;
	}

	public void setFibraAlimentar(String fibraAlimentar) {
		this.fibraAlimentar = fibraAlimentar;
	}

	public String getCalcio() {
		return calcio;
	}

	public void setCalcio(String calcio) {
		this.calcio = calcio;
	}

	public String getFerro() {
		return ferro;
	}

	public void setFerro(String ferro) {
		this.ferro = ferro;
	}

	public String getSodio() {
		return sodio;
	}

	public void setSodio(String sodio) {
		this.sodio = sodio;
	}

	public String getColesterol() {
		return colesterol;
	}

	public void setColesterol(String colesterol) {
		this.colesterol = colesterol;
	}

	public String getValorEnergetico() {
		return valorEnergetico;
	}

	public void setValorEnergetico(String valorEnergetico) {
		this.valorEnergetico = valorEnergetico;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

}
