import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NutricionistaCole{
    private static List<Nutricionista> nutriList = new ArrayList<Nutricionista>();
    
    public static void adicionaLista(Nutricionista n){
        nutriList.add(n);
    }
    
    public static void removeLista(String email){
        for(Nutricionista n: nutriList){
            if(n.getEmail().equals(email))
            nutriList.remove(n);
        }
    }
    
    public static List<Nutricionista> pesquisaNutri(String esc){
       return nutriList.stream().filter(n -> n.getEscolaridade().equals(esc)).collect(Collectors.toList());
    }
    public static List<Nutricionista> getNutriList() {
		return nutriList;
	}

	public static void setNutriList(List<Nutricionista> nutriList) {
		NutricionistaCole.nutriList = nutriList;
	}
}