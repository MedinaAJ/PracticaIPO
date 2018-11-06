/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author 9alej
 */
import Dominio.Proyecto;
import Dominio.Tarea;
import Dominio.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import javax.swing.JOptionPane; 
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;


public class Conectar { 
    Connection conexion; 
    Statement sentencia;
    //private final String NOMBRE_BASE_DE_DATOS = "C:\\Users\\9alej\\Documents\\NetBeansProjects\\IPO\\MaGesft\\MaGesft\\BD\\BBDDIPO.accdb";
    private final String CLAVE_BASE_DE_DATOS = "";
    private final String USUARIO_BASE_DE_DATOS = "admin";
    private String NOMBRE_BASE_DE_DATOS;
   // private final String USUARIO_BASE_DE_DATOS = "admin";


 public Conectar(String ruta){
     NOMBRE_BASE_DE_DATOS=ruta;
 }
 public void PrepararBaseDatos() { 
        try{ 
            conexion=DriverManager.getConnection("jdbc:ucanaccess://"+this.NOMBRE_BASE_DE_DATOS,this.USUARIO_BASE_DE_DATOS,this.CLAVE_BASE_DE_DATOS);
            
        } 
        catch (Exception e) { 
            JOptionPane.showMessageDialog(null,"Error al realizar la conexion "+e);
        } 
        try { 
            sentencia=conexion.createStatement( 
                    ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY); 
            
            System.out.println("Se ha establecido la conexión correctamente");
        } 
        catch (Exception e) { 
            JOptionPane.showMessageDialog(null,"Error al crear el objeto sentencia "+e);
        } 
    }
 
 public void desconectar(){
        try {
            conexion.close();            
            System.out.println("La conexion a la base de datos a terminado");
        } catch (SQLException ex) {
            System.out.println( ex.getMessage() );
        }       
   }
 
 public boolean verificarContraseña(String User, String Pass){
        String Nombre = "";
        String Clave = "";
   
        String sql = " SELECT Nombre, Clave "
                 + " FROM Login "
                 + " WHERE (((Nombre) Like '" + User + "%') AND ((Clave) Like '" + Pass + "%')) ";
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                Nombre = res.getString( "Nombre" );
                Clave = res.getString( "Clave" );
             }
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
        
        return (User.equals(Nombre) && Pass.equals(Clave));
               
    }

 public void CambiarContraseña (String claveAntigua, String claveNueva, String usuario){
        String sql = 
         "UPDATE Login SET Clave = '" + claveNueva + "' WHERE Nombre='" + usuario + "';";
        System.out.println(sql);
        System.out.println(usuario);
        try{
            PreparedStatement pstm = conexion.prepareCall( sql );      
            int res = pstm.executeUpdate();
            pstm.close();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public int AñadirProyecto(Proyecto p, String fC) {
        String sql = "INSERT INTO Proyecto (Nombre, Descripcion, miembrosEquipo, responsableProyecto, fechaCreacion)"
                + " VALUES ('" + p.getNombre() + "', '" + p.getDescripcion() + "', "
                + "'" + p.getMiembros() + "', '" + p.getResponsable() + "', '"+fC+"');" ;
        try{
            PreparedStatement pstm = conexion.prepareCall( sql );      
            int res1 = pstm.executeUpdate();
            pstm.close();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
        String sql2 = "SELECT MAX(Id) as maxid FROM Proyecto;";
        int id = 0;
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql2 );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                id = Integer.parseInt(res.getString( "maxid" ));
             }
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
        
        return id;
    }

    public void CargarProyectos(DefaultListModel idList, DefaultListModel nameList) {
        String sql = " SELECT Id, Nombre"
                 + " FROM Proyecto ";
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                idList.addElement(res.getString( "Id" ));
                nameList.addElement(res.getString("Nombre"));
             }
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public String[] CargarDatosProyecto(String Id, String nombre, String descripcion, String responsable, String miembros) {
        String sql = " SELECT * FROM Proyecto WHERE Id = " + Id + " ;";
        String datos[] = new String[5];
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                nombre = res.getString( "Nombre" );
                descripcion = res.getString( "Descripcion" );
                miembros = res.getString("miembrosEquipo");
                responsable = res.getString("responsableProyecto");
                datos[4] = res.getString("fechaCreacion");
             }
             
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
        datos[0]=nombre; datos[1]=descripcion; datos[3]=miembros; datos[2]=responsable;
        
        return datos;
    }

    public void ModificarProyecto(Proyecto p, String Id, String fI) {
        String sql = 
         "UPDATE Proyecto SET Nombre = '" + p.getNombre() + "' , Descripcion = '"
                + p.getDescripcion() + "' , responsableProyecto = '" 
                + p.getResponsable() + "' , miembrosEquipo = '" 
                + p.getMiembros()+ "', fechaCreacion = '"+fI+"' WHERE Id= " + Id + " ;";
        
        try{
            PreparedStatement pstm = conexion.prepareCall( sql );      
            int res = pstm.executeUpdate();
            pstm.close();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public void EliminarProyecto(String id) {
        String sql = "DELETE FROM Proyecto WHERE Id=" + id + ";";
        
        try{
            PreparedStatement pstm = conexion.prepareCall( sql );      
            int res = pstm.executeUpdate();
            pstm.close();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public void CargarUsuarios(DefaultListModel nameList) {
        String sql = " SELECT nombreUsuario"
                 + " FROM Usuario ";
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                nameList.addElement(res.getString("nombreUsuario"));
             }
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public String[] CargarDatosUsuario(String nombre) {
        String sql = " SELECT * FROM Usuario WHERE nombreUsuario = '" + nombre + "' ;";
        String datos[] = new String[5];
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                datos[0] = res.getString( "nombreUsuario" );
                datos[1] = res.getString( "DNI" );
                datos[2] = res.getString("Estudios");
                datos[3] = res.getString("Rol");
                datos[4] = res.getString("Foto");
             }
             
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }        
        return datos;
    }

    public String CargarRol(String usuarioAct) {
        String sql = " SELECT Rol FROM Usuario WHERE nombreUsuario = '" + usuarioAct + "' ;";
        String rol = "";
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                rol = res.getString("Rol");
             }
             
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
        
        return rol;
    }
    //EN ESTE METODO HAY UN FALLO, EL ID QUE DEVUELVE ES NULL
    
    public String AñadirTarea(Tarea p, String fI, String fF, String ruta) {
        
        String sql = "INSERT INTO Tarea (Proyecto, Nombre, Prioridad, Estado, usuarioResponsable, Descripcion, fechaCreacion, fechaFinalizacion, FotoAdjunta)"
                + " VALUES ('" + p.getProyecto() + "', '" + p.getNombre() + "', '" + p.getPrioridad()+ "', "
                + "'" + p.getEstado() + "', '" + p.getUsuarioResponsable() + "' ,'" + p.getDescripcion() + "', '" + fI + "', '" + fF + "', '" + ruta + "');" ;
        try{
            PreparedStatement pstm = conexion.prepareCall( sql );      
            int res1 = pstm.executeUpdate();
            pstm.close();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
        
        String sql2 = "SELECT MAX(Id) as maxid FROM Tarea;";
        String id = "";
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql2 );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                 id = res.getString("maxid");
             }
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
        
        return id;
    }

    public String[] CargarUsuarios() {
        String sql = " SELECT nombreUsuario"
                 + " FROM Usuario ";
        ArrayList<String> nombre = new ArrayList<String>();
        String[] users;
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                nombre.add(res.getString("nombreUsuario"));
             }
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
        users = new String[nombre.size()];
        for(int i = 0; i<users.length; i++){
            users[i]=nombre.get(i);
        }
       return users; 
    }

    public String[] CargarProyectos() {
        String sql = " SELECT Id"
                 + " FROM Proyecto ";
        ArrayList<String> nombre = new ArrayList<String>();
        String[] proyects;
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                nombre.add(res.getString("Id"));
             }
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
        proyects = new String[nombre.size()];
        for(int i = 0; i<proyects.length; i++){
            proyects[i]=(String) nombre.get(i);
        }
        
       return proyects;
    }

    public void CargarTareas(DefaultListModel nameList, DefaultListModel idList) {
        String sql = " SELECT Id, Nombre"
                 + " FROM Tarea ";
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                idList.addElement(res.getString( "Id" ));
                nameList.addElement(res.getString("Nombre"));
             }
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public String CargarNombreProyecto(String id) {
        String nombre = "";
        String sql = " SELECT Nombre"
                 + " FROM Proyecto WHERE Id = '" + id + "' ;";
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                nombre = res.getString( "Nombre" );
             }
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
        return nombre;
    }

    public void EliminarUsuario(String dato) {
        String sql = "DELETE FROM Usuario WHERE nombreUsuario= '" + dato + "';";
        
        try{
            PreparedStatement pstm = conexion.prepareCall( sql );      
            int res = pstm.executeUpdate();
            pstm.close();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public void AñadirUsuario(Usuario u) {
        String sql = "INSERT INTO Usuario (nombreUsuario, DNI, Estudios, Rol)"
                + " VALUES ('" + u.getNombre() + "', '" + u.getDni() + "', "
                + "'" + u.getEstudios() + "', '" + u.getRol() + "');" ;
        
        try{
            PreparedStatement pstm = conexion.prepareCall( sql );      
            int res1 = pstm.executeUpdate();
            pstm.close();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public String[] CargarDatosTarea(String ID) {
        String sql = " SELECT * FROM Tarea WHERE Id = " + ID + " ;";
        String datos[] = new String[9];
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                datos[0] = res.getString( "Proyecto" );
                datos[1] = res.getString( "Nombre" );
                datos[2] = res.getString("Prioridad");
                datos[3] = res.getString("Estado");
                datos[4] = res.getString("usuarioResponsable");
                datos[5] = res.getString("Descripcion");
                datos[6] = res.getString("fechaCreacion");
                datos[7] = res.getString("fechaFinalizacion");
                datos[8] = res.getString("FotoAdjunta");
             }
             
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }        
        return datos;
    }

    public void ModificarTarea(String selectedValue, Tarea p, String fI, String fF, String ruta) {
        String sql = 
         "UPDATE Tarea SET Proyecto = " + p.getProyecto() + " , Nombre = '"
                + p.getNombre() + "' , Prioridad = '" 
                + p.getPrioridad() + "' , Estado = '" 
                + p.getEstado() + "', usuarioResponsable = '" 
                + p.getUsuarioResponsable() + "', fechaCreacion = '" + fI + "', fechaFinalizacion = '"+ fF+"', Descripcion = '" 
                + p.getDescripcion() + "', FotoAdjunta = '" + ruta + "'  WHERE Id= " + selectedValue + " ;";
        
        try{
            PreparedStatement pstm = conexion.prepareCall( sql );      
            int res = pstm.executeUpdate();
            pstm.close();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public void EliminarTarea(String selectedValue) {
        String sql = "DELETE FROM Tarea WHERE Id= " + selectedValue + ";";
        
        try{
            PreparedStatement pstm = conexion.prepareCall( sql );      
            int res = pstm.executeUpdate();
            pstm.close();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public void ModificarUsuario(Usuario u) {
        System.out.println(u.getNombre());
        String sql = 
         "UPDATE Usuario SET nombreUsuario = '" + u.getNombre() + "' , DNI = '"
                + u.getDni() + "' , Estudios = '" 
                + u.getEstudios() + "' , Rol = '" 
                + u.getRol() + "'  WHERE nombreUsuario = '" + u.getNombre() + "' ;";
        
        try{
            PreparedStatement pstm = conexion.prepareCall( sql );      
            int res = pstm.executeUpdate();
            pstm.close();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public void CargarMensajes(DefaultListModel nameList_m, String usuario) {
       String sql = " SELECT Id"
                 + " FROM Mensajes WHERE Usuario = '" + usuario + "' OR Usuario = 'ALL' ;";
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                nameList_m.addElement(res.getString("Id"));
             }
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public String ConsultarMensajes(String usuario, String selectedIndex) {
        String mensaje = "";
        String sql = " SELECT *"
                 + " FROM Mensajes " + "  WHERE Id = " + selectedIndex + " AND (Usuario = '" + usuario + "' OR Usuario = 'ALL');";
        
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                mensaje = res.getString("Mensaje");
             }
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
        return mensaje;
    }

    public void enviarMensaje(String usuario, String mensaje) {
        String sql = "INSERT INTO Mensajes (Usuario, Mensaje)"
                + " VALUES ('" + usuario + "', '" + mensaje + "');" ;
        
        try{
            PreparedStatement pstm = conexion.prepareCall( sql );      
            int res1 = pstm.executeUpdate();
            pstm.close();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public void EliminarMensaje(String selected) {
        String sql = "DELETE FROM Mensajes WHERE Id= " + selected + ";";
        
        try{
            PreparedStatement pstm = conexion.prepareCall( sql );      
            int res = pstm.executeUpdate();
            pstm.close();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public void modificarFechaAcceso(String usuario, String ultimoAcceso) {
        String sql = 
         "UPDATE Login SET ultimoAcceso = '" + ultimoAcceso + "'  WHERE Nombre = '" + usuario + "' ;";
        try{
            PreparedStatement pstm = conexion.prepareCall( sql );      
            int res = pstm.executeUpdate();
            pstm.close();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    public String FechaUltimoAcceso(String usuario) {
        String fecha = "";
        String sql = " SELECT ultimoAcceso"
                 + " FROM Login " + "  WHERE Nombre = '" + usuario + "' ;";
        
        try{
            PreparedStatement pstm = conexion.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                fecha = res.getString("ultimoAcceso");
             }
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
        
        return fecha;
    }
    
    public void AñadirUsuario(Usuario u, String ruta) {
        String sql = "INSERT INTO Usuario (nombreUsuario, DNI, Estudios, Rol, Foto)"
                + " VALUES ('" + u.getNombre() + "', '" + u.getDni() + "', "
                + "'" + u.getEstudios() + "', '" + u.getRol() + "', '" + ruta +"');" ;
        
        try{
            PreparedStatement pstm = conexion.prepareCall( sql );      
            int res1 = pstm.executeUpdate();
            pstm.close();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

}


