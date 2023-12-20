package GUI;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Entidades.Alumno;
import Entidades.Profesor;

import Service.AlumnoService;
import Service.ProfesorService;
import Service.ServiceException;;

public class RegistrarseGUI implements ActionListener {


    AlumnoService alumnoService = new AlumnoService();
    ProfesorService profesorService = new ProfesorService();
    JFrame frame = new JFrame();
    JPanel panelDivisionRegistrar = new JPanel();
    JPanel panelRegistrarAlumno = new JPanel();
    JPanel panelRegistrarProfesor = new JPanel();
    JLabel textoDivisionRegistrar = new JLabel("Como que tipo de usuario quiere registrarse");
    JButton registrarAlumnos = new JButton("Registrarse como alumno");
    JButton registrarProfesores = new JButton("Registrarse como profesor");
    JButton registrarAlumno = new JButton("Alumno");
    JButton registrarProfesor = new JButton("Profesor");
    JButton alumnoVolverDivisionRegistrar = new JButton("volver al registo");
    JButton profesorVolverDivisionRegistrar = new JButton("volver al registo");
    JButton login = new JButton("volver al login");

    JLabel alumnoCorreoLabel = new JLabel("Ingrese su correo: ");
    JLabel alumnoContraseñaLabel = new JLabel("Ingrese su contraseña: ");
    JLabel alumnoNombreLabel = new JLabel("Ingrese su  nombre: ");
    JLabel alumnoApellidoLabel = new JLabel("Ingrese su apellido: ");

    JTextField alumnoCorreoField = new JTextField();
    JPasswordField alumnoContraseñaField = new JPasswordField();
    JTextField alumnoNombreField = new JTextField();
    JTextField alumnoApellidoField = new JTextField();

    JLabel profesorCorreoLabel = new JLabel("Ingrese su correo: ");
    JLabel profesorContraseñaLabel = new JLabel("Ingrese su contraseña: ");
    JLabel profesorNombreLabel = new JLabel("Ingrese su  nombre: ");
    JLabel profesorApellidoLabel = new JLabel("Ingrese su apellido: ");


    JTextField profesorCorreoField = new JTextField();
    JPasswordField profesorContraseñaField = new JPasswordField();
    JTextField profesorNombreField = new JTextField();
    JTextField profesorApellidoField = new JTextField();

    public RegistrarseGUI() {

        //REGISTRAR ALUMNOS

        alumnoCorreoLabel.setBounds(50, 50, 150, 25);
        alumnoContraseñaLabel.setBounds(50, 100, 150, 25);
        alumnoNombreLabel.setBounds(50, 155, 150, 25);
        alumnoApellidoLabel.setBounds(50, 200, 150, 25);


        alumnoCorreoField.setBounds(200, 50, 205, 25);
        alumnoContraseñaField.setBounds(200, 100, 205, 25);
        alumnoNombreField.setBounds(200, 150, 205, 25);
        alumnoApellidoField.setBounds(200, 200, 205, 25);

        registrarAlumnos.setBounds(25, 270, 200, 100);
        registrarAlumnos.addActionListener(this);
        registrarAlumnos.setFocusable(false);

        registrarAlumno.setBounds(150, 150, 150, 50);
        registrarAlumno.addActionListener(this);
        registrarAlumno.setFocusable(false);

        alumnoVolverDivisionRegistrar.setBounds(250, 270, 220, 100);
        alumnoVolverDivisionRegistrar.addActionListener(this);
        alumnoVolverDivisionRegistrar.setFocusable(false);


        panelRegistrarAlumno.add(alumnoCorreoLabel);
        panelRegistrarAlumno.add(alumnoContraseñaLabel);
        panelRegistrarAlumno.add(alumnoNombreLabel);
        panelRegistrarAlumno.add(alumnoApellidoLabel);
        panelRegistrarAlumno.add(registrarAlumnos);
        panelRegistrarAlumno.add(alumnoCorreoField);
        panelRegistrarAlumno.add(alumnoContraseñaField);
        panelRegistrarAlumno.add(alumnoNombreField);
        panelRegistrarAlumno.add(alumnoApellidoField);
        panelRegistrarAlumno.add(alumnoVolverDivisionRegistrar);


        panelRegistrarAlumno.setLayout(null);
        panelRegistrarAlumno.setBounds(0, 0, 640, 640);
        panelRegistrarAlumno.setVisible(false);

        //REGISTRAR PROFESORES

        profesorCorreoLabel.setBounds(50, 50, 150, 25);
        profesorContraseñaLabel.setBounds(50, 100, 150, 25);
        profesorNombreLabel.setBounds(50, 155, 150, 25);
        profesorApellidoLabel.setBounds(50, 200, 150, 25);


        profesorCorreoField.setBounds(200, 50, 205, 25);
        profesorContraseñaField.setBounds(200, 100, 205, 25);
        profesorNombreField.setBounds(200, 150, 205, 25);
        profesorApellidoField.setBounds(200, 200, 205, 25);

        profesorVolverDivisionRegistrar.setBounds(250, 270, 220, 100);
        profesorVolverDivisionRegistrar.addActionListener(this);
        profesorVolverDivisionRegistrar.setFocusable(false);

        registrarProfesores.setBounds(25, 270, 200, 100);
        registrarProfesores.addActionListener(this);
        registrarProfesores.setFocusable(false);


        registrarProfesor.setBounds(150, 225, 150, 50);
        registrarProfesor.addActionListener(this);
        registrarProfesor.setFocusable(false);


        panelRegistrarProfesor.add(profesorCorreoLabel);
        panelRegistrarProfesor.add(profesorContraseñaLabel);
        panelRegistrarProfesor.add(profesorNombreLabel);
        panelRegistrarProfesor.add(profesorApellidoLabel);
        panelRegistrarProfesor.add(registrarProfesores);
        panelRegistrarProfesor.add(profesorCorreoField);
        panelRegistrarProfesor.add(profesorContraseñaField);
        panelRegistrarProfesor.add(profesorNombreField);
        panelRegistrarProfesor.add(profesorApellidoField);
        panelRegistrarProfesor.add(profesorVolverDivisionRegistrar);


        panelRegistrarProfesor.setLayout(null);
        panelRegistrarProfesor.setBounds(0, 0, 640, 640);
        panelRegistrarProfesor.setVisible(false);

        //DIVISION REGISTRAR
        textoDivisionRegistrar.setBounds(150, 50, 300, 50);

        login.setBounds(150, 300, 150, 50);
        login.addActionListener(this);
        login.setFocusable(false);

        panelDivisionRegistrar.add(login);
        panelDivisionRegistrar.add(textoDivisionRegistrar);
        panelDivisionRegistrar.add(registrarProfesor);
        panelDivisionRegistrar.add(registrarAlumno);
        panelDivisionRegistrar.setLayout(null);
        panelDivisionRegistrar.setBounds(0, 0, 640, 640);
        panelDivisionRegistrar.setVisible(true);

        //FRAME
        frame.add(panelDivisionRegistrar);
        frame.add(panelRegistrarProfesor);
        frame.add(panelRegistrarAlumno);

        frame.setTitle("Registrarse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 640);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
            if (e.getSource() == registrarAlumno) {
                panelRegistrarAlumno.setVisible(true);
                panelDivisionRegistrar.setVisible(false);
            }

            if (e.getSource() == alumnoVolverDivisionRegistrar) {
                panelRegistrarAlumno.setVisible(false);
                panelDivisionRegistrar.setVisible(true);
            }

            if (e.getSource() == profesorVolverDivisionRegistrar) {
                panelRegistrarProfesor.setVisible(false);
                panelDivisionRegistrar.setVisible(true);
            }

            if (e.getSource() == registrarProfesor) {
                panelRegistrarProfesor.setVisible(true);
                panelDivisionRegistrar.setVisible(false);
            }


            if (e.getSource() == registrarAlumnos) {
                String correo = alumnoCorreoField.getText();
                String contraseña = alumnoContraseñaField.getText();
                String nombre = alumnoNombreField.getText();
                String apellido = alumnoApellidoField.getText();
                Alumno alumno = new Alumno(correo, contraseña , nombre, apellido);
                LoginGUI login = new LoginGUI();
                frame.dispose();

                try {
                    alumnoService.guardarAlumno(alumno);


                } catch (ServiceException ex) {
                    throw new RuntimeException(ex);
                }
            }

            if (e.getSource() == registrarProfesores) {
                String correo = profesorCorreoField.getText();
                String contraseña = profesorContraseñaField.getText();
                String nombre = profesorNombreField.getText();
                String apellido = profesorApellidoField.getText();
                Profesor profesor = new Profesor(correo, contraseña, nombre, apellido);
                LoginGUI login = new LoginGUI();
                frame.dispose();

                try {
                    profesorService.guardarProfesor(profesor);

                } catch (ServiceException ex) {
                    throw new RuntimeException(ex);
                }
            }
        if (e.getSource() == login){
            new LoginGUI ();
            frame.dispose();
        }
        }




}

