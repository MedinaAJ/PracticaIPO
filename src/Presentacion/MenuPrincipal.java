/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

LAS TAREAS SE PUEDEN CONSULTAR USANDO FILTROS

SE VALORA POR:
Complejidad                         |
Calidad y usabilidad                |
Funcionamiento y estabilidad        |   => Cumplimiento de requisitos (mirar jcalendar)
Creatividad y originalidad          |
*/
package Presentacion;

import Dominio.*;
import Persistencia.Conectar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.ListModel;
import org.jvnet.substance.SubstanceLookAndFeel;
/**
 *
 * @author 9alej
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    
    public MenuPrincipal() {
        
        initComponents();
        c.PrepararBaseDatos();
        Lista_Mensajes.setModel(nameList_m);
        Lista_ID_Tareas.setModel(nameList_t);
        Lista_Nombre_Tareas.setModel(idList_t);
        Lista_Usuarios.setModel(nameList_u);
        Lista_ID_Proyecto.setModel(idList_p);
        Lista_Nombre_Proyecto.setModel(nameList_p);
        //c.CargarMensajes(nameList_m);
        c.CargarTareas(idList_t, nameList_t);
        c.CargarProyectos(idList_p, nameList_p);
        c.CargarUsuarios(nameList_u);
        this.setLocationRelativeTo(null);
        usuarios = c.CargarUsuarios();
        proyectos = c.CargarProyectos();
        cmbUsuario.setModel(new javax.swing.DefaultComboBoxModel(usuarios));
        cmbProyecto.setModel(new javax.swing.DefaultComboBoxModel(proyectos));
        lblNombreProyecto_t.setText(c.CargarNombreProyecto((String) cmbProyecto.getSelectedItem()));
        btnAdd_t.setEnabled(false);
        btnAdd_p.setEnabled(false);
        btnAñadir_u.setEnabled(false);
    }
    
   
    public MenuPrincipal(String usuario, String rutaBBDD) {
        initComponents();
        this.usuario=usuario;
        this.rutaBBDD=rutaBBDD;
        c = new Conectar(rutaBBDD);
        c.PrepararBaseDatos();
        lblAcceso.setText(c.FechaUltimoAcceso(usuario));
        Lista_Mensajes.setModel(nameList_m);
        Lista_ID_Tareas.setModel(nameList_t);
        Lista_Nombre_Tareas.setModel(idList_t);
        Lista_Usuarios.setModel(nameList_u);
        Lista_ID_Proyecto.setModel(idList_p);
        Lista_Nombre_Proyecto.setModel(nameList_p);
        c.CargarMensajes(nameList_m, usuario);
        c.CargarTareas(idList_t, nameList_t);
        c.CargarProyectos(idList_p, nameList_p);
        c.CargarUsuarios(nameList_u);
        this.setLocationRelativeTo(null);
        usuarios = c.CargarUsuarios();
        proyectos = c.CargarProyectos();
        cmbUsuario.setModel(new javax.swing.DefaultComboBoxModel(usuarios));
        cmbProyecto.setModel(new javax.swing.DefaultComboBoxModel(proyectos));
        lblNombreProyecto_t.setText(c.CargarNombreProyecto((String) cmbProyecto.getSelectedItem()));
        jLabel2.setText(usuario);
        btnAdd_t.setEnabled(false);
        btnAdd_p.setEnabled(false);
        btnAñadir_u.setEnabled(false);
    }
    
    public MenuPrincipal(String usuario, String contraseña, String rutaBBDD) {
        initComponents();
        this.contraseña = contraseña;
        this.usuario=usuario;
        this.rutaBBDD=rutaBBDD;
        c = new Conectar(rutaBBDD);
        c.PrepararBaseDatos();
        lblAcceso.setText(c.FechaUltimoAcceso(usuario));
        Lista_Mensajes.setModel(nameList_m);
        Lista_ID_Tareas.setModel(nameList_t);
        Lista_Nombre_Tareas.setModel(idList_t);
        Lista_Usuarios.setModel(nameList_u);
        
        listaUsuarios_p.setModel(nameList_u);
        
        listaMiembros_p.setModel(miembrList);
        Lista_ID_Proyecto.setModel(idList_p);
        Lista_Nombre_Proyecto.setModel(nameList_p);
        c.CargarMensajes(nameList_m, usuario);
        c.CargarTareas(idList_t, nameList_t);
        c.CargarProyectos(idList_p, nameList_p);
        c.CargarUsuarios(nameList_u);
        this.setLocationRelativeTo(null);
        usuarios = c.CargarUsuarios();
        proyectos = c.CargarProyectos();
        cmbUsuario.setModel(new javax.swing.DefaultComboBoxModel(usuarios));
        
        boxResponsable_p.setModel(new javax.swing.DefaultComboBoxModel(usuarios));
        cmbProyecto.setModel(new javax.swing.DefaultComboBoxModel(proyectos));
        lblNombreProyecto_t.setText(c.CargarNombreProyecto((String) cmbProyecto.getSelectedItem()));
        jLabel2.setText(usuario);
        btnAdd_t.setEnabled(false);
        btnAdd_p.setEnabled(false);
        btnAñadir_u.setEnabled(false);
    }
    
    public MenuPrincipal(String usuario, String contraseña, String rutaBBDD, String idioma) {
        initComponents();
        cambiarIdioma(idioma);
        lenguaje = idioma;
        this.contraseña = contraseña;
        this.usuario=usuario;
        this.rutaBBDD=rutaBBDD;
        c = new Conectar(rutaBBDD);
        c.PrepararBaseDatos();
        lblAcceso.setText(c.FechaUltimoAcceso(usuario));
        Lista_Mensajes.setModel(nameList_m);
        Lista_ID_Tareas.setModel(nameList_t);
        Lista_Nombre_Tareas.setModel(idList_t);
        Lista_Usuarios.setModel(nameList_u);
        
        listaUsuarios_p.setModel(nameList_u);
        
        listaMiembros_p.setModel(miembrList);
        Lista_ID_Proyecto.setModel(idList_p);
        Lista_Nombre_Proyecto.setModel(nameList_p);
        c.CargarMensajes(nameList_m, usuario);
        c.CargarTareas(idList_t, nameList_t);
        c.CargarProyectos(idList_p, nameList_p);
        c.CargarUsuarios(nameList_u);
        this.setLocationRelativeTo(null);
        usuarios = c.CargarUsuarios();
        proyectos = c.CargarProyectos();
        cmbUsuario.setModel(new javax.swing.DefaultComboBoxModel(usuarios));       
        boxResponsable_p.setModel(new javax.swing.DefaultComboBoxModel(usuarios));
        cmbProyecto.setModel(new javax.swing.DefaultComboBoxModel(proyectos));
        lblNombreProyecto_t.setText(c.CargarNombreProyecto((String) cmbProyecto.getSelectedItem()));
        jLabel2.setText(usuario);
        btnAdd_t.setEnabled(false);
        btnAdd_p.setEnabled(false);
        btnAñadir_u.setEnabled(false);
    }
    

    public void cambiarIdioma(String nombreIdioma){
         idioma =new Idioma(nombreIdioma);
        
        btnAyuda.setText(idioma.getProperty("btnAyuda"));
        lblRutaFoto.setText(idioma.getProperty("lblRutaFoto"));
        lblSeleccioneUsuario.setText(idioma.getProperty("lblSeleccioneUsuario"));
        btnBuscarFoto.setText(idioma.getProperty("btnBuscarFoto"));
        lblFoto_u.setText(idioma.getProperty("lblFoto_u"));
        lblnameUser_u.setText(idioma.getProperty("lblnameUser_u"));
        lblEstudios_u.setText(idioma.getProperty("lblEstudios_u"));
        btnAñadir_u.setText(idioma.getProperty("btnAdd"));
        checkAdd_u.setText(idioma.getProperty("btnAdd"));
        btnModificar_u.setText(idioma.getProperty("btnModify"));
        btnBorrar_u.setText(idioma.getProperty("btnDelete"));
        btnLimpiarCampos_u.setText(idioma.getProperty("Cleanfields"));
        btnSalir.setText(idioma.getProperty("btnSalir"));
        lblu_main.setText(idioma.getProperty("lblu_main"));
        lblUltimoAcceso.setText(idioma.getProperty("lblUltimoAcceso"));
        lblNombre_Proyecto.setText(idioma.getProperty("lblNombre_Proyecto"));
        lblname_p.setText(idioma.getProperty("lblname_p"));
        lblDescr_p.setText(idioma.getProperty("lblDescr_p"));
        lblResp_p.setText(idioma.getProperty("lblResp_p"));
        lblU_p.setText(idioma.getProperty("lblu_main"));
        lblMiem_p.setText(idioma.getProperty("lblMiem_p"));        
        btnAddM_p.setText(idioma.getProperty("btnAdd"));
        checkAdd_p.setText(idioma.getProperty("btnAdd"));
        btnAdd_p.setText(idioma.getProperty("btnAdd"));
        btnDeleteM_p.setText(idioma.getProperty("btnDeleteM_p"));
        btnDelete_p.setText(idioma.getProperty("btnDelete"));
        btnModificar_p.setText(idioma.getProperty("btnModify"));
        btnLimpiarCampos_p.setText(idioma.getProperty("btnLimpiarCampos_p"));
        lblNameTask.setText(idioma.getProperty("lblNameTask"));
        lblName_T.setText(idioma.getProperty("lblname_p"));
        lblpriority_t.setText(idioma.getProperty("lblpriority_t"));
        lblstate_T.setText(idioma.getProperty("lblstate_T"));        
        lblDescr_t.setText(idioma.getProperty("lblDescr_t"));
        lblUsResp_t.setText(idioma.getProperty("lblUsResp_t"));
        IDpro_t.setText(idioma.getProperty("IDpro_t"));
        lblNamePr_t.setText(idioma.getProperty("lblNamePr_t"));
        lbldateI.setText(idioma.getProperty("lbldateI"));
        lblInicio_p.setText(idioma.getProperty("lbldateI"));
        dateFi_t.setText(idioma.getProperty("dateFi_t"));
        checkAdd_t.setText(idioma.getProperty("btnAdd"));
        btnAdd_t.setText(idioma.getProperty("btnAdd"));
        btnLimpiarCampos_t.setText(idioma.getProperty("Cleanfields"));
        btnDelete_t.setText(idioma.getProperty("btnDelete"));
        btnModificar_t.setText(idioma.getProperty("btnModify"));
        lblOldPass.setText(idioma.getProperty("lblOldPass"));
        lblNewPass.setText(idioma.getProperty("lblNewPass"));
        lblRNewPass.setText(idioma.getProperty("lblRNewPass"));
        btnCambiarContraseña.setText(idioma.getProperty("btnCambiarContraseña"));
        lblTema.setText(idioma.getProperty("lblTema"));
        lblIDM.setText(idioma.getProperty("lblIDM"));
        lblContMens.setText(idioma.getProperty("lblContMens"));
        btnDelete_m.setText(idioma.getProperty("btnDelete_m"));
        btnCrearMensaje.setText(idioma.getProperty("btnCrearMensaje"));
        btnCerrarSesion.setText(idioma.getProperty("btnCerrarSesion"));
        
        aboutMe.setBorder(javax.swing.BorderFactory.createTitledBorder(idioma.getProperty("aboutME")));
        paneChangePass.setBorder(javax.swing.BorderFactory.createTitledBorder(idioma.getProperty("paneChangePass")));
        
        tpUsuarios.setTitleAt(0, idioma.getProperty("TituloUsuario"));
        tpProyecto.setTitleAt(0, idioma.getProperty("TituloProyecto"));
        tpTareas.setTitleAt(0, idioma.getProperty("TituloTarea"));
        tpOpciones.setTitleAt(0, idioma.getProperty("TituloOpciones"));
        tpMensajes.setTitleAt(0, idioma.getProperty("TituloMensajes"));        
                
        tpMain.setTitleAt(0, idioma.getProperty("TituloUsuario"));
        tpMain.setTitleAt(1, idioma.getProperty("TituloProyecto"));
        tpMain.setTitleAt(2, idioma.getProperty("TituloTarea"));
        tpMain.setTitleAt(3, idioma.getProperty("TituloOpciones"));
        tpMain.setTitleAt(4, idioma.getProperty("TituloMensajes"));
        
        error1 = idioma.getProperty("error1");
        error2 = idioma.getProperty("error2");
        error3 = idioma.getProperty("error3");
        error4 = idioma.getProperty("error4");
        error5 = idioma.getProperty("error5");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel29 = new javax.swing.JLabel();
        aboutMe = new javax.swing.JPanel();
        lblu_main = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblUltimoAcceso = new javax.swing.JLabel();
        lblAcceso = new javax.swing.JLabel();
        tpMain = new javax.swing.JTabbedPane();
        tpUsuarios = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Lista_Usuarios = new javax.swing.JList<>();
        lblnameUser_u = new javax.swing.JLabel();
        lblDNI_u = new javax.swing.JLabel();
        lblEstudios_u = new javax.swing.JLabel();
        lblSeleccioneUsuario = new javax.swing.JLabel();
        txtUsuario_u = new javax.swing.JTextField();
        txtDni_u = new javax.swing.JTextField();
        txtEstudios_u = new javax.swing.JTextField();
        btnLimpiarCampos_u = new javax.swing.JButton();
        btnAñadir_u = new javax.swing.JButton();
        btnModificar_u = new javax.swing.JButton();
        btnBorrar_u = new javax.swing.JButton();
        checkAdd_u = new javax.swing.JCheckBox();
        lblFoto_u = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        btnBuscarFoto = new javax.swing.JButton();
        lblRutaFoto = new javax.swing.JTextField();
        tpProyecto = new javax.swing.JTabbedPane();
        tpProyectos = new javax.swing.JPanel();
        lblDescr_p = new javax.swing.JLabel();
        lblResp_p = new javax.swing.JLabel();
        btnModificar_p = new javax.swing.JButton();
        lblMiem_p = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Lista_Nombre_Proyecto = new javax.swing.JList<>();
        txtNombre_p = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista_ID_Proyecto = new javax.swing.JList<>();
        lblNombre_Proyecto = new javax.swing.JLabel();
        txtDescripcion_p = new javax.swing.JTextField();
        lblname_p = new javax.swing.JLabel();
        btnDelete_p = new javax.swing.JButton();
        btnAdd_p = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        btnLimpiarCampos_p = new javax.swing.JButton();
        checkAdd_p = new javax.swing.JCheckBox();
        boxResponsable_p = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        listaMiembros_p = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        listaUsuarios_p = new javax.swing.JList<>();
        lblU_p = new javax.swing.JLabel();
        btnAddM_p = new javax.swing.JButton();
        btnDeleteM_p = new javax.swing.JButton();
        dateInicio_p = new com.toedter.calendar.JDateChooser();
        lblInicio_p = new javax.swing.JLabel();
        tpTareas = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        lblNameTask = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblUsResp_t = new javax.swing.JLabel();
        txtDescripcion_t = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        Lista_Nombre_Tareas = new javax.swing.JList<>();
        lblstate_T = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Lista_ID_Tareas = new javax.swing.JList<>();
        cmbProyecto = new javax.swing.JComboBox();
        IDpro_t = new javax.swing.JLabel();
        lblDescr_t = new javax.swing.JLabel();
        lblName_T = new javax.swing.JLabel();
        txtNombre_t = new javax.swing.JTextField();
        lblNamePr_t = new javax.swing.JLabel();
        txtEstado_t = new javax.swing.JTextField();
        lblpriority_t = new javax.swing.JLabel();
        txtPrioridad_t = new javax.swing.JTextField();
        lblNombreProyecto_t = new javax.swing.JLabel();
        cmbUsuario = new javax.swing.JComboBox();
        btnAdd_t = new javax.swing.JButton();
        btnDelete_t = new javax.swing.JButton();
        btnModificar_t = new javax.swing.JButton();
        btnLimpiarCampos_t = new javax.swing.JButton();
        checkAdd_t = new javax.swing.JCheckBox();
        lbldateI = new javax.swing.JLabel();
        dateInicio = new com.toedter.calendar.JDateChooser();
        dateFi_t = new javax.swing.JLabel();
        dateFin = new com.toedter.calendar.JDateChooser();
        IconoImagen = new javax.swing.JLabel();
        btnAddImg_p = new javax.swing.JButton();
        tpOpciones = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        paneChangePass = new javax.swing.JPanel();
        lblOldPass = new javax.swing.JLabel();
        lblNewPass = new javax.swing.JLabel();
        lblRNewPass = new javax.swing.JLabel();
        txtpassOld = new javax.swing.JTextField();
        txtPassNew2 = new javax.swing.JTextField();
        txtPassNew = new javax.swing.JTextField();
        btnCambiarContraseña = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        lblTema = new javax.swing.JLabel();
        DesignBox = new javax.swing.JComboBox<>();
        tpMensajes = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtMensajes = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        Lista_Mensajes = new javax.swing.JList<>();
        lblIDM = new javax.swing.JLabel();
        lblContMens = new javax.swing.JLabel();
        btnCrearMensaje = new javax.swing.JButton();
        btnDelete_m = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jLabel29.setText("jLabel29");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        aboutMe.setBorder(javax.swing.BorderFactory.createTitledBorder("Sobre mi"));

        lblu_main.setText("Usuario :");

        jLabel2.setText("Nombre_Usuario");

        lblUltimoAcceso.setText("Ultimo acceso :");

        lblAcceso.setText("Fecha_Ultimo_Acceso");

        javax.swing.GroupLayout aboutMeLayout = new javax.swing.GroupLayout(aboutMe);
        aboutMe.setLayout(aboutMeLayout);
        aboutMeLayout.setHorizontalGroup(
            aboutMeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutMeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblu_main)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(90, 90, 90)
                .addComponent(lblUltimoAcceso)
                .addGap(28, 28, 28)
                .addComponent(lblAcceso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        aboutMeLayout.setVerticalGroup(
            aboutMeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutMeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aboutMeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblu_main)
                    .addComponent(jLabel2)
                    .addComponent(lblUltimoAcceso)
                    .addComponent(lblAcceso))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tpMain.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        Lista_Usuarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                Lista_UsuariosValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(Lista_Usuarios);

        lblnameUser_u.setText("Nombre de usuario :");

        lblDNI_u.setText("DNI :");

        lblEstudios_u.setText("Estudios :");

        lblSeleccioneUsuario.setText("Por favor, seleccione a un usuario de la lista para acceder a su informacion personal :");

        btnLimpiarCampos_u.setText("Limpiar Campos");
        btnLimpiarCampos_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCampos_uActionPerformed(evt);
            }
        });

        btnAñadir_u.setText("Añadir");
        btnAñadir_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadir_uActionPerformed(evt);
            }
        });

        btnModificar_u.setText("Modificar");
        btnModificar_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar_uActionPerformed(evt);
            }
        });

        btnBorrar_u.setText("Borrar");
        btnBorrar_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar_uActionPerformed(evt);
            }
        });

        checkAdd_u.setText("Añadir");
        checkAdd_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAdd_uActionPerformed(evt);
            }
        });

        lblFoto_u.setText("Foto :");

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        btnBuscarFoto.setText("Elija foto");
        btnBuscarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFotoActionPerformed(evt);
            }
        });

        lblRutaFoto.setText("Ruta de la foto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblnameUser_u)
                                    .addComponent(lblDNI_u)
                                    .addComponent(lblEstudios_u)
                                    .addComponent(lblFoto_u)
                                    .addComponent(btnBuscarFoto))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(lblRutaFoto))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDni_u, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtUsuario_u, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                                            .addComponent(txtEstudios_u)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnLimpiarCampos_u, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkAdd_u)
                                .addGap(18, 18, 18)
                                .addComponent(btnAñadir_u, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnModificar_u, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBorrar_u, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblSeleccioneUsuario))
                .addGap(82, 82, 82))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSeleccioneUsuario)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarFoto)
                            .addComponent(lblRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lblFoto_u)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario_u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnameUser_u))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDni_u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDNI_u))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstudios_u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstudios_u))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiarCampos_u)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnModificar_u, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAñadir_u, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkAdd_u))
                            .addComponent(btnBorrar_u, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );

        tpUsuarios.addTab("Usuarios", jPanel2);

        tpMain.addTab("Usuarios", tpUsuarios);

        lblDescr_p.setText("Descripción :");

        lblResp_p.setText("Responsable :");

        btnModificar_p.setText("Modificar");
        btnModificar_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar_pActionPerformed(evt);
            }
        });

        lblMiem_p.setText("Miembros :");

        Lista_Nombre_Proyecto.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                Lista_Nombre_ProyectoValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(Lista_Nombre_Proyecto);

        txtNombre_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre_pActionPerformed(evt);
            }
        });

        jLabel9.setText("ID : ");

        Lista_ID_Proyecto.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                Lista_ID_ProyectoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(Lista_ID_Proyecto);

        lblNombre_Proyecto.setText("Nombre del Proyecto :");

        lblname_p.setText("Nombre :");

        btnDelete_p.setText("Eliminar");
        btnDelete_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete_pActionPerformed(evt);
            }
        });

        btnAdd_p.setText("Añadir");
        btnAdd_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd_pActionPerformed(evt);
            }
        });

        jLabel13.setText("ID:");

        btnLimpiarCampos_p.setText("Limpiar");
        btnLimpiarCampos_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCampos_pActionPerformed(evt);
            }
        });

        checkAdd_p.setText("Añadir");
        checkAdd_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAdd_pActionPerformed(evt);
            }
        });

        jScrollPane8.setViewportView(listaMiembros_p);

        jScrollPane9.setViewportView(listaUsuarios_p);

        lblU_p.setText("Usuarios :");

        btnAddM_p.setText("Añadir");
        btnAddM_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddM_pActionPerformed(evt);
            }
        });

        btnDeleteM_p.setText("Quitar");
        btnDeleteM_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteM_pActionPerformed(evt);
            }
        });

        lblInicio_p.setText("Fecha de Inicio :");

        javax.swing.GroupLayout tpProyectosLayout = new javax.swing.GroupLayout(tpProyectos);
        tpProyectos.setLayout(tpProyectosLayout);
        tpProyectosLayout.setHorizontalGroup(
            tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tpProyectosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tpProyectosLayout.createSequentialGroup()
                        .addComponent(lblNombre_Proyecto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tpProyectosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tpProyectosLayout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tpProyectosLayout.createSequentialGroup()
                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAddM_p, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                            .addComponent(btnDeleteM_p, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
                                    .addGroup(tpProyectosLayout.createSequentialGroup()
                                        .addComponent(lblU_p)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMiem_p)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tpProyectosLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(checkAdd_p)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdd_p, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnDelete_p, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar_p)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiarCampos_p, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tpProyectosLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblname_p)
                                    .addComponent(lblDescr_p)
                                    .addComponent(jLabel13)
                                    .addComponent(lblResp_p)
                                    .addComponent(lblInicio_p))
                                .addGap(30, 30, 30)
                                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescripcion_p)
                                    .addComponent(txtNombre_p)
                                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boxResponsable_p, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateInicio_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(44, 44, 44))))
        );
        tpProyectosLayout.setVerticalGroup(
            tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tpProyectosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblNombre_Proyecto))
                .addGap(18, 18, 18)
                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(22, 22, 22))
            .addGroup(tpProyectosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtId))
                .addGap(18, 18, 18)
                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblname_p)
                    .addComponent(txtNombre_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescr_p)
                    .addComponent(txtDescripcion_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResp_p)
                    .addComponent(boxResponsable_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateInicio_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInicio_p))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblU_p, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMiem_p))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tpProyectosLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnAddM_p)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteM_p))
                    .addComponent(jScrollPane9)
                    .addComponent(jScrollPane8))
                .addGap(29, 29, 29)
                .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiarCampos_p, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tpProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(checkAdd_p)
                        .addComponent(btnAdd_p, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete_p, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnModificar_p, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        tpProyecto.addTab("Proyectos", tpProyectos);

        tpMain.addTab("Proyectos", tpProyecto);

        lblNameTask.setText("Nombre de la tarea");

        jLabel17.setText("ID : ");

        lblUsResp_t.setText("Usuario responsable :");

        Lista_Nombre_Tareas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                Lista_Nombre_TareasValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(Lista_Nombre_Tareas);

        lblstate_T.setText("Estado :");

        Lista_ID_Tareas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                Lista_ID_TareasValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(Lista_ID_Tareas);

        cmbProyecto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ListaProyectos" }));
        cmbProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProyectoActionPerformed(evt);
            }
        });

        IDpro_t.setText("ID proyecto :");

        lblDescr_t.setText("Descripcion :");

        lblName_T.setText("Nombre :");

        lblNamePr_t.setText("Nombre Proyecto :");

        lblpriority_t.setText("Prioridad :");

        lblNombreProyecto_t.setText("NOMBRE_PROYECTO");

        cmbUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ListaUsuarios" }));
        cmbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUsuarioActionPerformed(evt);
            }
        });

        btnAdd_t.setText("Añadir");
        btnAdd_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd_tActionPerformed(evt);
            }
        });

        btnDelete_t.setText("Eliminar");
        btnDelete_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete_tActionPerformed(evt);
            }
        });

        btnModificar_t.setText("Modificar");
        btnModificar_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar_tActionPerformed(evt);
            }
        });

        btnLimpiarCampos_t.setText("Limpiar Campos");
        btnLimpiarCampos_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCampos_tActionPerformed(evt);
            }
        });

        checkAdd_t.setText("Añadir");
        checkAdd_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAdd_tActionPerformed(evt);
            }
        });

        lbldateI.setText("Fecha Inicio");

        dateFi_t.setText("Fecha Fin");

        IconoImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        btnAddImg_p.setText("Añadir Imagen");
        btnAddImg_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImg_pActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblNameTask)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblName_T)
                                            .addComponent(lblpriority_t)
                                            .addComponent(lblstate_T)
                                            .addComponent(lblDescr_t)
                                            .addComponent(lblUsResp_t)
                                            .addComponent(lblNamePr_t)
                                            .addComponent(IDpro_t))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombre_t)
                                            .addComponent(txtPrioridad_t)
                                            .addComponent(txtEstado_t)
                                            .addComponent(txtDescripcion_t)
                                            .addComponent(cmbUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbProyecto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblNombreProyecto_t, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(dateFi_t)
                                                    .addComponent(lbldateI))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(dateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(btnAddImg_p, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                .addGap(117, 117, 117)))
                                        .addComponent(IconoImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(checkAdd_t)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd_t, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiarCampos_t)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete_t, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnModificar_t)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblNameTask)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5)))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName_T)
                            .addComponent(txtNombre_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblpriority_t)
                            .addComponent(txtPrioridad_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblstate_T)
                            .addComponent(txtEstado_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescr_t)
                            .addComponent(txtDescripcion_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsResp_t))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDpro_t))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNamePr_t)
                            .addComponent(lblNombreProyecto_t))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnAddImg_p)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateFi_t)
                                    .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbldateI)
                                    .addComponent(dateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(84, 84, 84))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(IconoImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnLimpiarCampos_t, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnDelete_t, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnModificar_t, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(checkAdd_t))
                                        .addContainerGap())
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnAdd_t, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25))))))))
        );

        tpTareas.addTab("Tareas", jPanel3);

        tpMain.addTab("Tareas", tpTareas);

        paneChangePass.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambiar Contraseña"));

        lblOldPass.setText("Introduzca su antigua contraseña");

        lblNewPass.setText("Introduzca su nueva contraseña");

        lblRNewPass.setText("Vuelva a introducirla, por favor");

        btnCambiarContraseña.setText("Cambiar Contraseña");
        btnCambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneChangePassLayout = new javax.swing.GroupLayout(paneChangePass);
        paneChangePass.setLayout(paneChangePassLayout);
        paneChangePassLayout.setHorizontalGroup(
            paneChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneChangePassLayout.createSequentialGroup()
                .addGroup(paneChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneChangePassLayout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(btnCambiarContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneChangePassLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(paneChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblOldPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRNewPass, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(41, 41, 41)
                        .addGroup(paneChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpassOld, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                            .addComponent(txtPassNew, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                            .addComponent(txtPassNew2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))))
                .addGap(35, 35, 35))
        );
        paneChangePassLayout.setVerticalGroup(
            paneChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneChangePassLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(paneChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOldPass)
                    .addComponent(txtpassOld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(paneChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewPass)
                    .addComponent(txtPassNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(paneChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRNewPass)
                    .addComponent(txtPassNew2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnCambiarContraseña)
                .addContainerGap())
        );

        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        lblTema.setText("Elija el tema de la aplicacion : ");

        DesignBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AutumnSkin", "BusinessBlackSteelSkin", "BusinessBlueSteelSkin", "BusinessSkin", "CremeCoffeeSkin", "CremeSkin", "EmeraldDuskSkin", "FieldOfWheatSkin", "FindingNemoSkin", "GreenMagicSkin", "MagmaSkin", "MangoSkin", "MistAquaSkin", "ModerateSkin", "NebulaBrickWallSkin", "NebulaSkin", "OfficeBlue2007Skin", "OfficeSilver2007Skin", "RavenGraphiteGlassSkin", "RavenGraphiteSkin", "RavenSkin", "SaharaSkin" }));
        DesignBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesignBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblTema)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DesignBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(paneChangePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(93, 93, 93))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(paneChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTema)
                .addGap(18, 18, 18)
                .addComponent(DesignBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpOpciones.addTab("Opciones", jPanel4);

        tpMain.addTab("Opciones", tpOpciones);

        txtMensajes.setColumns(20);
        txtMensajes.setRows(5);
        jScrollPane6.setViewportView(txtMensajes);

        Lista_Mensajes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                Lista_MensajesValueChanged(evt);
            }
        });
        jScrollPane7.setViewportView(Lista_Mensajes);

        lblIDM.setText("ID Mensaje: ");

        lblContMens.setText("Contenido del mensaje:");

        btnCrearMensaje.setText("Enviar mensaje");
        btnCrearMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMensajeActionPerformed(evt);
            }
        });

        btnDelete_m.setText("Eliminar mensaje");
        btnDelete_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete_mActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIDM))
                .addGap(71, 71, 71)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblContMens)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnDelete_m, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrearMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIDM)
                    .addComponent(lblContMens))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCrearMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(btnDelete_m, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        tpMensajes.addTab("Mensajes", jPanel6);

        tpMain.addTab("Mensajes", tpMensajes);

        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/information.png"))); // NOI18N
        btnAyuda.setText("Ayuda");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/logout.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.setDefaultCapable(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aboutMe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40)
                        .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tpMain)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tpMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(aboutMe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificar_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar_pActionPerformed
        // TODO add your handling code here:
        if(Lista_ID_Proyecto.getSelectedValue()!=null){
             nombre = txtNombre_p.getText();
            descripcion = txtDescripcion_p.getText();
            miembros = "";
            if(!miembrList.isEmpty()){
                for(int i=0; i<miembrList.getSize(); i++){
                    miembros += (String) miembrList.get(i) + ",";
                }
            }
            responsable = (String) boxResponsable_p.getSelectedItem();
            Id_p = txtId.getText();
            String fechaInicio = DateFormat.getDateInstance().format(this.dateInicio_p.getCalendar().getTime());
        
            Proyecto p = new Proyecto(nombre, descripcion, responsable, miembros);
            
            c.ModificarProyecto(p, Id_p, fechaInicio);
            this.setVisible(false);
            MenuPrincipal m = new MenuPrincipal(usuario, contraseña, rutaBBDD, lenguaje);
            m.setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione algún proyecto y algun miembro del proyecto para proceder a modificarlo");
        }
    }//GEN-LAST:event_btnModificar_pActionPerformed

    private void Lista_Nombre_ProyectoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_Lista_Nombre_ProyectoValueChanged
        // TODO add your handling code here:
        //Seleccion va a ser un numero entre 0 y n, siendo n el tamaño de la lista-1
        seleccion_p = Lista_Nombre_Proyecto.getSelectedIndex();
        Lista_ID_Proyecto.setSelectedIndex(seleccion_p);

    }//GEN-LAST:event_Lista_Nombre_ProyectoValueChanged

    private void Lista_ID_ProyectoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_Lista_ID_ProyectoValueChanged
        // TODO add your handling code here:
        seleccion_p = Lista_ID_Proyecto.getSelectedIndex();
        Lista_Nombre_Proyecto.setSelectedIndex(seleccion_p);
        Id_p = Lista_ID_Proyecto.getSelectedValue();
        txtId.setText(Id_p);
        miembrList.clear();
        datos_p = c.CargarDatosProyecto(Id_p, nombre, descripcion, responsable, miembros);
        txtNombre_p.setText(datos_p[0]);
        txtDescripcion_p.setText(datos_p[1]);
        boxResponsable_p.setSelectedItem(datos_p[2]);
        String[] miembros = datos_p[3].split(",");
        Date fechaParseadaF;
        try {
            fechaParseadaF = new SimpleDateFormat("dd-MMM-yyyy").parse(datos_p[4]);
            dateInicio_p.setDate(fechaParseadaF);
        } catch (ParseException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0; i<miembros.length;i++){
            miembrList.addElement(miembros[i]);
        }
    }//GEN-LAST:event_Lista_ID_ProyectoValueChanged

    private void btnDelete_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete_pActionPerformed
        // TODO add your handling code here:
        if(Lista_ID_Proyecto.getSelectedValue()!=null){
            confirmar = showConfirmDialog(null, "¿Seguro que quieres eliminar este proyecto?", "¡ Cuidado !",
                JOptionPane.YES_NO_OPTION);
            if(confirmar == JOptionPane.YES_OPTION){
                c.EliminarProyecto(Lista_ID_Proyecto.getSelectedValue());
                this.setVisible(false);
                MenuPrincipal a = new MenuPrincipal(usuario, contraseña, rutaBBDD, lenguaje);
                a.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(null, error5);
        }
    }//GEN-LAST:event_btnDelete_pActionPerformed

    private void btnAdd_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd_pActionPerformed
        // TODO add your handling code here:
        nombre = txtNombre_p.getText();
        descripcion = txtDescripcion_p.getText();
        miembros = "";
        if(!miembrList.isEmpty()){
            for(int i=0; i<miembrList.getSize(); i++){
                miembros += (String) miembrList.get(i) + ",";
            }
        }
        String fechaInicio = DateFormat.getDateInstance().format(this.dateInicio_p.getCalendar().getTime());
        responsable = (String) boxResponsable_p.getSelectedItem();
        Proyecto p = new Proyecto(nombre, descripcion, responsable, miembros);
        id_p = c.AñadirProyecto(p, fechaInicio);
        /*
        nameList_p.addElement(p.getNombre());
        idList_p.addElement(id_p);*/
        MenuPrincipal m = new MenuPrincipal(usuario, contraseña, rutaBBDD, lenguaje);
        this.setVisible(false);
        m.setVisible(true);
    }//GEN-LAST:event_btnAdd_pActionPerformed

    private void Lista_UsuariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_Lista_UsuariosValueChanged
        // TODO add your handling code here:
        NombreUsuario = Lista_Usuarios.getSelectedValue();
        
        datos_u = c.CargarDatosUsuario(Lista_Usuarios.getSelectedValue());
        txtUsuario_u.setText(datos_u[0]);
        txtDni_u.setText(datos_u[1]);
        txtEstudios_u.setText(datos_u[2]);
        icon = new ImageIcon(datos_u[4]);
        lblFoto.setIcon(icon);
    }//GEN-LAST:event_Lista_UsuariosValueChanged

    private void btnLimpiarCampos_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCampos_uActionPerformed
        // TODO add your handling code here:
        txtUsuario_u.setText("");
        txtDni_u.setText("");
        txtEstudios_u.setText("");
    }//GEN-LAST:event_btnLimpiarCampos_uActionPerformed

    private void btnAñadir_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadir_uActionPerformed
        // TODO add your handling code here:
        datos_u = new String[5];
        datos_u[0] = txtUsuario_u.getText();
        datos_u[1] = txtDni_u.getText();
        datos_u[2] = txtEstudios_u.getText();

        u = new Usuario(datos_u[0], datos_u[1], datos_u[2], true);
        c.AñadirUsuario(u, lblRutaFoto.getText());
        this.setVisible(false);
        MenuPrincipal m = new MenuPrincipal(usuario, contraseña, rutaBBDD, lenguaje);
        m.setVisible(true);
    }//GEN-LAST:event_btnAñadir_uActionPerformed

    private void btnModificar_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar_uActionPerformed
        // TODO add your handling code here:
    if(NombreUsuario.equals(txtUsuario_u.getText())){
        datos_u[0] = txtUsuario_u.getText();
        datos_u[1] = txtDni_u.getText();
        datos_u[2] = txtEstudios_u.getText();

        u = new Usuario(datos_u[0], datos_u[1], datos_u[2], true);
        c.ModificarUsuario(u);
        this.setVisible(false);
        MenuPrincipal m = new MenuPrincipal(usuario, contraseña, rutaBBDD, lenguaje);
        m.setVisible(true);
    }else{
            JOptionPane.showMessageDialog(null, "¡El nombre del usuario no se puede modificar!");
        }
    }//GEN-LAST:event_btnModificar_uActionPerformed

    private void btnBorrar_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar_uActionPerformed
        // TODO add your handling code here:
        if(Lista_Usuarios.getSelectedValue()!=null){
            c.EliminarUsuario(datos_u[0]);
            this.setVisible(false);
            MenuPrincipal a = new MenuPrincipal(usuario, contraseña, rutaBBDD, lenguaje);
            a.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, error4);
        }
    }//GEN-LAST:event_btnBorrar_uActionPerformed

    private void Lista_Nombre_TareasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_Lista_Nombre_TareasValueChanged
        // TODO add your handling code here:
        seleccion_t = Lista_Nombre_Tareas.getSelectedIndex();
        Lista_ID_Tareas.setSelectedIndex(seleccion_t);
    }//GEN-LAST:event_Lista_Nombre_TareasValueChanged

    private void Lista_ID_TareasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_Lista_ID_TareasValueChanged
        // TODO add your handling code here:
        seleccion_t = Lista_ID_Tareas.getSelectedIndex();
        Lista_Nombre_Tareas.setSelectedIndex(seleccion_t);
        ID_t = Lista_ID_Tareas.getSelectedValue();
        datos_t = c.CargarDatosTarea(ID_t);
        cmbProyecto.setSelectedItem(datos_t[0]);
        lblNombreProyecto_t.setText(c.CargarNombreProyecto((String) cmbProyecto.getSelectedItem()));
        txtNombre_t.setText(datos_t[1]);
        txtPrioridad_t.setText(datos_t[2]);
        txtEstado_t.setText(datos_t[3]);
        cmbUsuario.setSelectedItem(datos_t[4]);
        txtDescripcion_t.setText(datos_t[5]);
        IconoImagen.setIcon(new ImageIcon(datos_t[8]));
        try {
                Date fechaParseadaC= new SimpleDateFormat("dd-MMM-yyyy").parse(datos_t[6]);
                Date fechaParseadaF= new SimpleDateFormat("dd-MMM-yyyy").parse(datos_t[7]);
                dateInicio.setDate(fechaParseadaC);
                dateFin.setDate(fechaParseadaF);
            } catch (ParseException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_Lista_ID_TareasValueChanged

    private void cmbProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProyectoActionPerformed
        // TODO add your handling code here:
        lblNombreProyecto_t.setText(c.CargarNombreProyecto((String) cmbProyecto.getSelectedItem()));
    }//GEN-LAST:event_cmbProyectoActionPerformed

    private void btnAdd_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd_tActionPerformed
        // TODO add your handling code here:    FotoAdjunta
        //String Nombre, String prioridad, String estado, String descripcion, String usuario, String proyecto    
        String fechaInicio = DateFormat.getDateInstance().format(this.dateInicio.getCalendar().getTime());
        String fechaFin = DateFormat.getDateInstance().format(this.dateFin.getCalendar().getTime());
        
        Tarea p = new Tarea(txtNombre_t.getText(), txtPrioridad_t.getText(), txtEstado_t.getText(), txtDescripcion_t.getText(), (String) cmbUsuario.getSelectedItem(), (String) cmbProyecto.getSelectedItem());
        ID_t = c.AñadirTarea(p, fechaInicio, fechaFin, rutaTarea);
        IDtarea = Integer.parseInt(ID_t);
        System.out.println(IDtarea);
        nameList_t.addElement(p.getNombre());
        idList_t.addElement(IDtarea);
        this.setVisible(false);
        MenuPrincipal z = new MenuPrincipal(usuario, contraseña, rutaBBDD, lenguaje);
        z.setVisible(true);
    }//GEN-LAST:event_btnAdd_tActionPerformed

    private void btnDelete_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete_tActionPerformed
        // TODO add your handling code here:
        c.EliminarTarea(Lista_ID_Tareas.getSelectedValue());
        this.setVisible(false);
        MenuPrincipal z = new MenuPrincipal(usuario, contraseña, rutaBBDD, lenguaje);
        z.setVisible(true);
    }//GEN-LAST:event_btnDelete_tActionPerformed

    private void btnModificar_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar_tActionPerformed
        // TODO add your handling code here:
        Tarea p = new Tarea(txtNombre_t.getText(), txtPrioridad_t.getText(), txtEstado_t.getText(), txtDescripcion_t.getText(), (String) cmbUsuario.getSelectedItem(), (String) cmbProyecto.getSelectedItem());
        String fechaInicio = DateFormat.getDateInstance().format(this.dateInicio.getCalendar().getTime());
        String fechaFin = DateFormat.getDateInstance().format(this.dateInicio.getCalendar().getTime());
        c.ModificarTarea(Lista_ID_Tareas.getSelectedValue(), p, fechaInicio, fechaFin, rutaTarea);
        this.setVisible(false);
        MenuPrincipal z = new MenuPrincipal(usuario, contraseña, rutaBBDD, lenguaje);
        z.setVisible(true);
    }//GEN-LAST:event_btnModificar_tActionPerformed

    private void txtNombre_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre_pActionPerformed

    private void btnLimpiarCampos_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCampos_tActionPerformed
        // TODO add your handling code here:
        txtNombre_t.setText("");
        txtPrioridad_t.setText("");
        txtEstado_t.setText("");
        txtDescripcion_t.setText("");
        cmbUsuario.setSelectedIndex(0);
        cmbProyecto.setSelectedIndex(0);
        
    }//GEN-LAST:event_btnLimpiarCampos_tActionPerformed

    private void btnLimpiarCampos_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCampos_pActionPerformed
        // TODO add your handling code here:
        miembrList.clear();
        boxResponsable_p.setSelectedIndex(0);
        txtNombre_p.setText("");
        txtDescripcion_p.setText("");
        txtId.setText("");
    }//GEN-LAST:event_btnLimpiarCampos_pActionPerformed

    private void Lista_MensajesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_Lista_MensajesValueChanged
        // TODO add your handling code here:
        System.out.println(Lista_Mensajes.getSelectedValue());
        mensaje = c.ConsultarMensajes(usuario, Lista_Mensajes.getSelectedValue());
        txtMensajes.setText(mensaje);
        
    }//GEN-LAST:event_Lista_MensajesValueChanged

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
        confirmar = showConfirmDialog(null, error3, "¡ Cuidado !",
                JOptionPane.YES_NO_OPTION);
        if(confirmar == JOptionPane.YES_OPTION){
            Inicio c = new Inicio();
            this.setVisible(false);
            c.setVisible(true);
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnCambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContraseñaActionPerformed
        // TODO add your handling code here:
        if(!txtPassNew.getText().equals(txtPassNew2.getText())){
            JOptionPane.showMessageDialog(null, "Error contraseña nueva 1 y contraseña nueva 2");
        }   
        else if(!contraseña.equals(txtpassOld.getText())){
            JOptionPane.showMessageDialog(null, "Error contraseña vieja 1 y contraseña vieja 2");
        }
        else{
            confirmar = showConfirmDialog(null, "¿Seguro que quieres cambiar la contraseña?", "¡ Cuidado !",
                JOptionPane.YES_NO_OPTION);
            if(confirmar == JOptionPane.YES_OPTION){
                claveAntigua = txtpassOld.getText();
                claveNueva = txtPassNew2.getText();
                c.CambiarContraseña(claveAntigua, claveNueva, usuario);
                JOptionPane.showMessageDialog(null, "Su contraseña ha sido cambiada correctamente");
            }
        }
    }//GEN-LAST:event_btnCambiarContraseñaActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        // TODO add your handling code here:
        Ayuda a = new Ayuda(this, lenguaje);
        this.setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void checkAdd_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAdd_pActionPerformed
        // TODO add your handling code here:
        if(checkAdd_p.isSelected()){
            btnAdd_p.setEnabled(true);
            btnDelete_p.setEnabled(false);
            btnModificar_p.setEnabled(false);
        }else{
            btnAdd_p.setEnabled(false);
            btnDelete_p.setEnabled(true);
            btnModificar_p.setEnabled(true);
        }
    }//GEN-LAST:event_checkAdd_pActionPerformed

    private void checkAdd_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAdd_tActionPerformed
        // TODO add your handling code here:
        if(checkAdd_t.isSelected()){
            btnAdd_t.setEnabled(true);
            btnDelete_t.setEnabled(false);
            btnModificar_t.setEnabled(false);
        }else{
            btnAdd_t.setEnabled(false);
            btnDelete_t.setEnabled(true);
            btnModificar_t.setEnabled(true);
        }
    }//GEN-LAST:event_checkAdd_tActionPerformed

    private void checkAdd_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAdd_uActionPerformed
        // TODO add your handling code here:
        if(checkAdd_u.isSelected()){
            btnBuscarFoto.setEnabled(true);
            btnAñadir_u.setEnabled(true);
            btnBorrar_u.setEnabled(false);
            btnModificar_u.setEnabled(false);
        }else{
            btnBuscarFoto.setEnabled(false);
            btnAñadir_u.setEnabled(false);
            btnBorrar_u.setEnabled(true);
            btnModificar_u.setEnabled(true);
        }
    }//GEN-LAST:event_checkAdd_uActionPerformed

    private void btnCrearMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearMensajeActionPerformed
        // TODO add your handling code here:
        Enviar a = new Enviar(this, c, lenguaje);
        this.setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_btnCrearMensajeActionPerformed

    private void cmbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUsuarioActionPerformed

    private void btnDelete_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete_mActionPerformed
        // TODO add your handling code here:     
        c.EliminarMensaje(Lista_Mensajes.getSelectedValue());
        this.setVisible(false);
        MenuPrincipal z = new MenuPrincipal(usuario, contraseña, rutaBBDD, lenguaje);
        z.setVisible(true);
    }//GEN-LAST:event_btnDelete_mActionPerformed

    private void DesignBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesignBoxActionPerformed
        // TODO add your handling code here:
        try{
           JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
           SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin." + DesignBox.getSelectedItem()); // Setencia que aplica el skin Creme de Substance
           
           //SubstanceLookAndFeel.setCurrentTheme( "org.jvnet.substance.theme.SubstanceAquaTheme" ); // Se aplica el tema Aqui de Substance
           //SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermar");//Ejemplo de aplicacion de un watermark de Substance
       } catch (Exception e){
           e.printStackTrace();
       }
    }//GEN-LAST:event_DesignBoxActionPerformed

    private void btnDeleteM_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteM_pActionPerformed
        // TODO add your handling code here:
        if((Lista_ID_Proyecto.getSelectedValue()!=null || checkAdd_p.isSelected()) && listaMiembros_p.getSelectedValue()!=null){
            miembrList.removeElementAt(listaMiembros_p.getSelectedIndex());
        }else{
            JOptionPane.showMessageDialog(null, error2);
        }
    }//GEN-LAST:event_btnDeleteM_pActionPerformed

    private void btnAddM_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddM_pActionPerformed
        // TODO add your handling code here:
        if((Lista_ID_Proyecto.getSelectedValue()!=null || checkAdd_p.isSelected()) && listaUsuarios_p.getSelectedValue()!=null){
            miembrList.addElement(listaUsuarios_p.getSelectedValue());
        }else{
            JOptionPane.showMessageDialog(null, error1);
        }
    }//GEN-LAST:event_btnAddM_pActionPerformed

    private void btnBuscarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFotoActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if ( result == JFileChooser.APPROVE_OPTION ){
                String Ruta = fileChooser.getSelectedFile().getAbsolutePath();
                lblRutaFoto.setText(Ruta);
                //if(c.guardarfoto(Ruta)){
                    icon = new ImageIcon(Ruta);
                    lblFoto.setIcon(icon);
                    //JOptionPane.showMessageDialog(this,"La imagen '" + fileChooser.getSelectedFile().getName()+"' se guardo en la Base de Datos Access...");
                //}
        }
    }//GEN-LAST:event_btnBuscarFotoActionPerformed

    private void btnAddImg_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImg_pActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if ( result == JFileChooser.APPROVE_OPTION ){
                String Ruta = fileChooser.getSelectedFile().getAbsolutePath();
                rutaTarea = Ruta;
                    icon = new ImageIcon(Ruta);
                    IconoImagen.setIcon(icon);
        }
    }//GEN-LAST:event_btnAddImg_pActionPerformed
    public String getUsuario(){
        return usuario;
    }
    public String getBBDD(){
        return rutaBBDD;
    }
    public String getContrasenia(){
        return contraseña;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> DesignBox;
    private javax.swing.JLabel IDpro_t;
    private javax.swing.JLabel IconoImagen;
    private javax.swing.JList<String> Lista_ID_Proyecto;
    private javax.swing.JList<String> Lista_ID_Tareas;
    private javax.swing.JList<String> Lista_Mensajes;
    private javax.swing.JList<String> Lista_Nombre_Proyecto;
    private javax.swing.JList<String> Lista_Nombre_Tareas;
    private javax.swing.JList<String> Lista_Usuarios;
    private javax.swing.JPanel aboutMe;
    private javax.swing.JComboBox<String> boxResponsable_p;
    private javax.swing.JButton btnAddImg_p;
    private javax.swing.JButton btnAddM_p;
    private javax.swing.JButton btnAdd_p;
    private javax.swing.JButton btnAdd_t;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnAñadir_u;
    private javax.swing.JButton btnBorrar_u;
    private javax.swing.JButton btnBuscarFoto;
    private javax.swing.JButton btnCambiarContraseña;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCrearMensaje;
    private javax.swing.JButton btnDeleteM_p;
    private javax.swing.JButton btnDelete_m;
    private javax.swing.JButton btnDelete_p;
    private javax.swing.JButton btnDelete_t;
    private javax.swing.JButton btnLimpiarCampos_p;
    private javax.swing.JButton btnLimpiarCampos_t;
    private javax.swing.JButton btnLimpiarCampos_u;
    private javax.swing.JButton btnModificar_p;
    private javax.swing.JButton btnModificar_t;
    private javax.swing.JButton btnModificar_u;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox checkAdd_p;
    private javax.swing.JCheckBox checkAdd_t;
    private javax.swing.JCheckBox checkAdd_u;
    private javax.swing.JComboBox cmbProyecto;
    private javax.swing.JComboBox cmbUsuario;
    private javax.swing.JLabel dateFi_t;
    private com.toedter.calendar.JDateChooser dateFin;
    private com.toedter.calendar.JDateChooser dateInicio;
    private com.toedter.calendar.JDateChooser dateInicio_p;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblAcceso;
    private javax.swing.JLabel lblContMens;
    private javax.swing.JLabel lblDNI_u;
    private javax.swing.JLabel lblDescr_p;
    private javax.swing.JLabel lblDescr_t;
    private javax.swing.JLabel lblEstudios_u;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblFoto_u;
    private javax.swing.JLabel lblIDM;
    private javax.swing.JLabel lblInicio_p;
    private javax.swing.JLabel lblMiem_p;
    private javax.swing.JLabel lblNamePr_t;
    private javax.swing.JLabel lblNameTask;
    private javax.swing.JLabel lblName_T;
    private javax.swing.JLabel lblNewPass;
    private javax.swing.JLabel lblNombreProyecto_t;
    private javax.swing.JLabel lblNombre_Proyecto;
    private javax.swing.JLabel lblOldPass;
    private javax.swing.JLabel lblRNewPass;
    private javax.swing.JLabel lblResp_p;
    private javax.swing.JTextField lblRutaFoto;
    private javax.swing.JLabel lblSeleccioneUsuario;
    private javax.swing.JLabel lblTema;
    private javax.swing.JLabel lblU_p;
    private javax.swing.JLabel lblUltimoAcceso;
    private javax.swing.JLabel lblUsResp_t;
    private javax.swing.JLabel lbldateI;
    private javax.swing.JLabel lblnameUser_u;
    private javax.swing.JLabel lblname_p;
    private javax.swing.JLabel lblpriority_t;
    private javax.swing.JLabel lblstate_T;
    private javax.swing.JLabel lblu_main;
    private javax.swing.JList<String> listaMiembros_p;
    private javax.swing.JList<String> listaUsuarios_p;
    private javax.swing.JPanel paneChangePass;
    private javax.swing.JTabbedPane tpMain;
    private javax.swing.JTabbedPane tpMensajes;
    private javax.swing.JTabbedPane tpOpciones;
    private javax.swing.JTabbedPane tpProyecto;
    private javax.swing.JPanel tpProyectos;
    private javax.swing.JTabbedPane tpTareas;
    private javax.swing.JTabbedPane tpUsuarios;
    private javax.swing.JTextField txtDescripcion_p;
    private javax.swing.JTextField txtDescripcion_t;
    private javax.swing.JTextField txtDni_u;
    private javax.swing.JTextField txtEstado_t;
    private javax.swing.JTextField txtEstudios_u;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextArea txtMensajes;
    private javax.swing.JTextField txtNombre_p;
    private javax.swing.JTextField txtNombre_t;
    private javax.swing.JTextField txtPassNew;
    private javax.swing.JTextField txtPassNew2;
    private javax.swing.JTextField txtPrioridad_t;
    private javax.swing.JTextField txtUsuario_u;
    private javax.swing.JTextField txtpassOld;
    // End of variables declaration//GEN-END:variables
    private String nombre, descripcion, prioridad, responsable, miembros, Id_p, ID_t;
    private Conectar c;
    private DefaultListModel idList_p = new DefaultListModel();
    private DefaultListModel nameList_p = new DefaultListModel();
    private DefaultListModel idList_t = new DefaultListModel();
    private DefaultListModel nameList_t = new DefaultListModel();
    private DefaultListModel nameList_u = new DefaultListModel();
    private DefaultListModel nameList_m = new DefaultListModel();   
    private DefaultListModel miembrList = new DefaultListModel();
    private int seleccion_p,seleccion_t, IDtarea, id_p, confirmar;
    private Usuario u;
    private String contraseña;
    private String[] datos_t, datos_u, datos_p;
    private String usuario, mensaje;
    private String[] usuarios;
    private String[] proyectos;   
    private String claveAntigua, claveNueva, rutaBBDD;
    private Icon icon;
    private Idioma idioma;    
    private String lenguaje;
    private String error1, error2, error3, error4, error5, rutaTarea, NombreUsuario;
}
