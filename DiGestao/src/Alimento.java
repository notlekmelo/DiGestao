
public class Alimento {
	private String tipo, dosagem;
	public int carboidratos,vitaminaA, vitaminaB, vitaminaC, gordurasTrans, gordurasTotais, gordurasSaturadas,proteinas;
	public int fibraAlimentar, calcio, ferro, sodio, colesterol, valorEnergetico;
	private float preco;
	
	public Alimento(String tipo, String dosagem, int carboidratos, int vitaminaA, int vitaminaB, int vitaminaC,
			int gordurasTrans, int gordurasTotais, int gordurasSaturadas, int proteinas, int fibraAlimentar, int calcio,
			int ferro, int sodio, int colesterol, int valorEnergetico, float preco) {
		this.tipo = tipo;
		this.dosagem = dosagem;
		this.carboidratos = carboidratos;
		this.vitaminaA = vitaminaA;
		this.vitaminaB = vitaminaB;
		this.vitaminaC = vitaminaC;
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

	public String geraReceita(Alimento[] receita) {
		return receita[1].tipo + receita[2].tipo;
	}

}
