package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Entidades.Admin;
import Entidades.Alumno;
import Entidades.Profesor;

import Service.AdminService;
import Service.AlumnoService;
import Service.ProfesorService;
import Service.ServiceException;


public class LoginGUI implements ActionListener {

    AlumnoService alumnoService = new AlumnoService();
    ProfesorService profesorService = new ProfesorService();
    AdminService adminService = new AdminService();

    JFrame frame = new JFrame();
    //ALUMNO
    JPanel panelLoginAlumno = new JPanel();
    JLabel alumnoUsuarioLabel = new JLabel("Ingrese su correo: ");
    JLabel alumnoContraseñaLabel = new JLabel("Ingrese su contraseña: ");
    JButton loginAlumnos = new JButton("Ingresar como alumno");
    JButton loginAlumno = new JButton("Alumno");
    JButton alumnoVolverDivisionLogin = new JButton("volver al Login");
    JTextField alumnoUsuarioField = new JTextField();
    JPasswordField alumnoContraseñaField = new JPasswordField();

    //PROFESORES
    JPanel panelLoginProfesor = new JPanel();
    JButton loginProfesores = new JButton("Ingresar como profesor");
    JButton loginProfesor = new JButton("Profesor");
    JButton profesorVolverDivisionLogin = new JButton("volver al Login");
    JLabel profesorUsuarioLabel = new JLabel("Ingrese su correo: ");
    JLabel profesorContraseñaLabel = new JLabel("Ingrese su contraseña: ");
    JTextField profesorUsuarioField = new JTextField();
    JPasswordField profesorContraseñaField = new JPasswordField();

    //ADMIN
    JPanel panelLoginAdmin = new JPanel();
    JLabel adminUsuarioLabel = new JLabel("Ingrese su correo: ");
    JLabel adminContraseñaLabel = new JLabel("Ingrese su contraseña: ");
    JButton loginAdmins = new JButton("Ingresar como admin");
    JButton loginAdmin = new JButton("Admin");
    JButton adminVolverDivisionLogin = new JButton("volver al Login");
    JTextField adminUsuarioField = new JTextField();
    JPasswordField adminContraseñaField = new JPasswordField();

    //DIVISION Y OTROS
    JPanel panelDivisionLogin = new JPanel();
    JLabel textoDivisionLogin = new JLabel("Como que tipo de usuario quiere iniciar sesion");
    JLabel mensajeLabel = new JLabel();
    JButton registrarse = new JButton("Registrarse");







    public LoginGUI() {
    //LOGIN ALMUNOS
        alumnoUsuarioLabel.setBounds(50, 50, 150, 25);
        alumnoContraseñaLabel.setBounds(50, 100, 150, 25);

        alumnoUsuarioField.setBounds(200, 50, 205, 25);
        alumnoContraseñaField.setBounds(200, 100, 205, 25);

        loginAlumnos.setBounds(25, 270, 200, 100);
        loginAlumnos.addActionListener(this);
        loginAlumnos.setFocusable(false);

        loginAlumno.setBounds(150, 150, 150, 50);
        loginAlumno.addActionListener(this);
        loginAlumno.setFocusable(false);

        alumnoVolverDivisionLogin.setBounds(250, 270, 220, 100);
        alumnoVolverDivisionLogin.addActionListener(this);
        alumnoVolverDivisionLogin.setFocusable(false);

        panelLoginAlumno.add(alumnoUsuarioLabel);
        panelLoginAlumno.add(alumnoContraseñaLabel);
        panelLoginAlumno.add(loginAlumnos);
        panelLoginAlumno.add(alumnoUsuarioField);
        panelLoginAlumno.add(alumnoContraseñaField);
        panelLoginAlumno.add(alumnoVolverDivisionLogin);

        panelLoginAlumno.setLayout(null);
        panelLoginAlumno.setBounds(0, 0, 640, 640);
        panelLoginAlumno.setVisible(false);

        //LOGIN PROFESORES

        profesorUsuarioLabel.setBounds(50, 50, 150, 25);
        profesorContraseñaLabel.setBounds(50, 100, 150, 25);

        profesorUsuarioField.setBounds(200, 50, 205, 25);
        profesorContraseñaField.setBounds(200, 100, 205, 25);

        profesorVolverDivisionLogin.setBounds(250, 270, 220, 100);
        profesorVolverDivisionLogin.addActionListener(this);
        profesorVolverDivisionLogin.setFocusable(false);

        loginProfesores.setBounds(25, 270, 200, 100);
        loginProfesores.addActionListener(this);
        loginProfesores.setFocusable(false);

        loginProfesor.setBounds(150, 225, 150, 50);
        loginProfesor.addActionListener(this);
        loginProfesor.setFocusable(false);

        panelLoginProfesor.add(profesorUsuarioLabel);
        panelLoginProfesor.add(profesorContraseñaLabel);
        panelLoginProfesor.add(loginProfesores);
        panelLoginProfesor.add(profesorUsuarioField);
        panelLoginProfesor.add(profesorContraseñaField);
        panelLoginProfesor.add(profesorVolverDivisionLogin);

        panelLoginProfesor.setLayout(null);
        panelLoginProfesor.setBounds(0, 0, 640, 640);
        panelLoginProfesor.setVisible(false);

        //LOGIN ADMINS
        adminUsuarioLabel.setBounds(50, 50, 150, 25);
        adminContraseñaLabel.setBounds(50, 100, 150, 25);

        adminUsuarioField.setBounds(200, 50, 205, 25);
        adminContraseñaField.setBounds(200, 100, 205, 25);

        loginAdmins.setBounds(25, 270, 200, 100);
        loginAdmins.addActionListener(this);
        loginAdmins.setFocusable(false);

        loginAdmin.setBounds(350, 225, 150, 50);
        loginAdmin.addActionListener(this);
        loginAdmin.setFocusable(false);

        adminVolverDivisionLogin.setBounds(250, 270, 220, 100);
        adminVolverDivisionLogin.addActionListener(this);
        adminVolverDivisionLogin.setFocusable(false);

        panelLoginAdmin.add(adminUsuarioLabel);
        panelLoginAdmin.add(adminContraseñaLabel);
        panelLoginAdmin.add(loginAdmins);
        panelLoginAdmin.add(adminUsuarioField);
        panelLoginAdmin.add(adminContraseñaField);
        panelLoginAdmin.add(adminVolverDivisionLogin);

        panelLoginAdmin.setLayout(null);
        panelLoginAdmin.setBounds(0, 0, 640, 640);
        panelLoginAdmin.setVisible(false);

        //DIVISION LOGIN
        textoDivisionLogin.setBounds(150,50,300,50);

        registrarse.setBounds(150, 300, 150, 50);
        registrarse.addActionListener(this);
        registrarse.setFocusable(false);

        panelDivisionLogin.add(registrarse);
        panelDivisionLogin.add(textoDivisionLogin);
        panelDivisionLogin.add(loginProfesor);
        panelDivisionLogin.add(loginAlumno);
        panelDivisionLogin.add(loginAdmin);
        panelDivisionLogin.setLayout(null);
        panelDivisionLogin.setBounds(0,0,640,640);
        panelDivisionLogin.setVisible(true);

        mensajeLabel.setBounds(115, 285, 250, 35);



        //FRAME

        frame.add(mensajeLabel);
        frame.add(panelDivisionLogin);
        frame.add(panelLoginAlumno);
        frame.add(panelLoginProfesor);
        frame.add(panelLoginAdmin);


        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 640);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {



        if (e.getSource() == loginAlumno) {
            panelLoginAlumno.setVisible(true);
            panelDivisionLogin.setVisible(false);
        }

        if (e.getSource() == alumnoVolverDivisionLogin) {
            panelLoginAlumno.setVisible(false);
            panelDivisionLogin.setVisible(true);
        }

        if (e.getSource() == loginProfesor) {
            panelLoginProfesor.setVisible(true);
            panelDivisionLogin.setVisible(false);
        }

        if (e.getSource() == profesorVolverDivisionLogin) {
            panelLoginProfesor.setVisible(false);
            panelDivisionLogin.setVisible(true);
        }

        if (e.getSource() == loginAdmin) {
            panelLoginAdmin.setVisible(true);
            panelDivisionLogin.setVisible(false);
        }

        if (e.getSource() == adminVolverDivisionLogin) {
            panelLoginAdmin.setVisible(false);
            panelDivisionLogin.setVisible(true);
        }


        String correo;
        String contraseña;
        if (e.getSource() == loginAlumnos) {
            correo = alumnoUsuarioField.getText();
            contraseña = alumnoContraseñaField.getText();
            new Alumno(correo, contraseña);
            if (alumnoService.buscar2Alumno(correo, contraseña, this.frame)) {
                panelLoginAlumno.setVisible(false);
            }
        }

        if (e.getSource() == loginProfesores) {
            correo = profesorUsuarioField.getText();
            contraseña = profesorContraseñaField.getText();
            new Profesor(correo, contraseña);
            if (profesorService.buscar2Profesor(correo, contraseña, this.frame)) {
                panelLoginProfesor.setVisible(false);
            }
        }
        if (e.getSource() == loginAdmins) {
            correo = adminUsuarioField.getText();
            contraseña = adminContraseñaField.getText();
            new Admin(correo, contraseña);
            if (adminService.buscar2Admin(correo, contraseña, this.frame)) {
                panelLoginAdmin.setVisible(false);
            }
        }



        if(e.getSource()==registrarse){
            new RegistrarseGUI ();
            frame.dispose();
        }

    }
}