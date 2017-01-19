package persistence;

public class Parametre {
    
    private static String iphost="127.0.0.1" ;
    private String data;
    private static String userName;
    private static String host;
    
    private static String password;
    private static int Port=8081 ;
    private static String Util ;
    
    public Parametre(String username,String password,String data){
        this.data=data;
        Parametre.userName=username;
        Parametre.password=password;
        host="jdbc:mysql://"+ iphost+":3306/"+data+"?useUnicode=true&characterEncoding=UTF-8";
    }

	public static String getIPHOST() {
		return iphost;
	}

	public String getData() {
		return data;
	}

	public static String getUsername() {
		return userName;
	}

	public static String getHost() {
		return host;
	}

	public static String getPassword() {
		return password;
	}

	public static int getPort() {
		return Port;
	}

	public static String getUtil() {
		return Util;
	}
   
}
