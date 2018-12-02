import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioCole {
private static List<Usuario> userList = new ArrayList<Usuario>();
    
    public static void adicionaLista(Usuario u){
        userList.add(u);
    }
    
    public static void removeLista(String email){
        for(Usuario n: userList){
            if(n.getEmail().equals(email))
            userList.remove(n);
        }
    }
    
    public static List<Usuario> pesquisaUser(String atvFis){
       return userList.stream().filter(u -> u.getAtvFis().equals(atvFis)).collect(Collectors.toList());
    }
    public static List<Usuario> getUserList() {
		return userList;
	}

	public static void setUserList(List<Usuario> userList) {
		UsuarioCole.userList = userList;
	}
}

