package Base;
import java.sql.*;

public class Conexion {
    private String usrDB;
    private String passDB;
    private String urlDB;
    private String driverClassName;
    
    private Connection conn = null;
    private Statement instruction = null;
    
    public Conexion(){
        this.usrDB = "root";
        this.passDB = "n0m3l0";
        this.urlDB = "jdbc:mysql://localhost/usuarios";
        this.driverClassName = "com.mysql.jdbc.Driver";
    }
    
    //Conexion a BD
    public void Conectar(){
        try{
            Class.forName(this.driverClassName).newInstance();
            conn = DriverManager.getConnection(urlDB, usrDB, passDB);
        }
        catch (Exception err){
            System.out.println("Error "+ err.getMessage());
        }
    }
    
    //Cerrar conexion a BD
    public void cierraConexion() throws SQLException{
        this.conn.close();
    }
    
    //Metodos para ejecutar sentencias SQL
    public ResultSet consulta (String consulta) throws SQLException {
        instruction = conn.createStatement();
        return instruction.executeQuery(consulta);
    }
    
   //metodo para comprobar el estado de la conexión   
    public String getConexion(){
    Connection cn = null;
    String msg = "";
    try{
        Class.forName(driverClassName);
        cn = DriverManager.getConnection(urlDB, usrDB, passDB);
        msg=("Conexion Satisfactoria");
    }
    catch (Exception e){
        msg=("Error de conexion: "+e);
    }
    return msg;
    }
}
