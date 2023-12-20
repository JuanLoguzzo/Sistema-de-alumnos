package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Entidades.Alumno;
import Entidades.Profesor;

import Service.AlumnoService;
import Service.ProfesorService;
import Service.ServiceException;


public class LoginGUI implements ActionListener {

    AlumnoService alumnoService = new AlumnoService();
    ProfesorService profesorService = new ProfesorService();

    JFrame frame = new JFrame();

    JPanel panelDivisionLogin = new JPanel();
    JPanel panelLoginAlumno = new JPanel();
    JPanel panelLoginProfesor = new JPanel();
    JLabel textoDivisionLogin = new JLabel("Como que tipo de usuario quiere iniciar sesion");
    JLabel alumnoUsuarioLabel = new JLabel("Ingrese su correo: ");
    JLabel alumnoContraseñaLabel = new JLabel("Ingrese su contraseña: ");
    JLabel mensajeLabel = new JLabel();
    JButton loginAlumnos = new JButton("Ingresar como alumno");
    JButton loginProfesores = new JButton("Ingresar como profesor");
    JButton registrarse = new JButton("Registrarse");
    JButton loginAlumno = new JButton("Alumno");
    JButton loginProfesor = new JButton("Profesor");
    JButton alumnoVolverDivisionLogin = new JButton("volver al Login");
    JButton profesorVolverDivisionLogin = new JButton("volver al Login");
    JTextField alumnoUsuarioField = new JTextField();
    JPasswordField alumnoContraseñaField = new JPasswordField();
    JLabel profesorUsuarioLabel = new JLabel("Ingrese su correo: ");
    JLabel profesorContraseñaLabel = new JLabel("Ingrese su contraseña: ");
    JTextField profesorUsuarioField = new JTextField();
    JPasswordField profesorContraseñaField = new JPasswordField();




    public LoginGUI() {
    //LOGIN ALMUNOS
        alumnoUsuarioLabel.setBounds(50, 50, 150, 25);
        alumnoContraseñaLabel.setBounds(50, 100, 150, 25);

        alumnoUsuarioField.setBounds(200, 50, 205, 25);
        alumnoContraseñaField.setBounds(200, 100, 205, 25);

        loginAlumnos.setBounds(25, 270, 200, 100);
        loginAlumnos.addActionListener(this);
        loginAlumnos.setFocusable(false);

        loginAlumno.setBounds(150, 150, 220, 100);
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

        loginProfesor.setBounds(150, 275, 220, 100);
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


    //DIVISION LOGIN
        textoDivisionLogin.setBounds(150,50,300,50);

        registrarse.setBounds(150, 400, 220, 100);
        registrarse.addActionListener(this);
        registrarse.setFocusable(false);

        panelDivisionLogin.add(registrarse);
        panelDivisionLogin.add(textoDivisionLogin);
        panelDivisionLogin.add(loginProfesor);
        panelDivisionLogin.add(loginAlumno);
        panelDivisionLogin.setLayout(null);
        panelDivisionLogin.setBounds(0,0,640,640);
        panelDivisionLogin.setVisible(true);

        mensajeLabel.setBounds(115, 285, 250, 35);



    //FRAME
        frame.add(mensajeLabel);
        frame.add(panelDivisionLogin);
        frame.add(panelLoginAlumno);
        frame.add(panelLoginProfesor);


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


        String correo;
        String contraseña;
        if (e.getSource() == loginAlumno) {
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

            try {
                Profesor profesor = profesorService.buscar2Profesor(correo);
                if (profesor != null) {
                    if(profesor.getContraseña().equals(contraseña)){
                        if(profesor.getCorreo().equals(correo)){
                            mensajeLabel.setText("Login Exitoso");
                            mensajeLabel.setForeground(Color.green);
                            HomeProfesoresGUI homePage = new HomeProfesoresGUI(correo, contraseña);
                            frame.dispose();
                        }
                        else{
                            mensajeLabel.setText("Usuario Incorrecto");
                            mensajeLabel.setForeground(Color.red);
                        }
                    }
                    else{
                        mensajeLabel.setText("Contraseña incorrecta");
                        mensajeLabel.setForeground(Color.red);
                    }
                } else {
                    mensajeLabel.setText("Usuario inexistente");
                    mensajeLabel.setForeground(Color.red);
                }
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }

        }

        if(e.getSource()==registrarse){
            new RegistrarseGUI ();
            frame.dispose();
        }

    }
}