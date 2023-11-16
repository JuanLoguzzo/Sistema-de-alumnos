package GUI;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Entidades.Alumno;
import Entidades.Profesor;

import Service.AlumnoService;
import Service.ProfesorService;
import Service.ServiceException;


public class UsuarioGUI implements ActionListener {
    AlumnoService alumnoService = new AlumnoService();
    ProfesorService profesorService = new ProfesorService();

    JFrame frame = new JFrame();

    JPanel panelDivision = new JPanel();
    JPanel panelAlumno = new JPanel();
    JPanel panelProfesor = new JPanel();

    JLabel textoDivision = new JLabel("Como que tipo de usuario quiere iniciar sesion");
    JLabel alumnoUsuarioLabel = new JLabel("Ingrese su usuario: ");
    JLabel alumnoContraseñaLabel = new JLabel("Ingrese su contraseña: ");
    JLabel alumnoNombreLabel = new JLabel("Ingrese su  nombre: ");
    JLabel alumnoApellidoLabel = new JLabel("Ingrese su apellido: ");

    JButton registrarAlumnos = new JButton("Registrarse como alumno");
    JButton registrarProfesores = new JButton("Registrarse como profesor");
    JButton registrarAlumno = new JButton("Alumno");
    JButton registrarProfesor = new JButton("Profesor");
    JButton volverDivision1 = new JButton("volver al registo");
    JButton volverDivision2 = new JButton("volver al registo");
    JButton eliminarAlumnoButton = new JButton("ELIMINAR");
    JButton eliminarProfesorButton = new JButton("ELIMINAR");

    JTextField alumnoUsuarioField = new JTextField();
    JPasswordField alumnoContraseñaField = new JPasswordField();
    JTextField alumnoNombreField = new JTextField();
    JTextField alumnoApellidoField = new JTextField();

    JLabel profesorUsuarioLabel = new JLabel("Ingrese su usuario: ");
    JLabel profesorContraseñaLabel = new JLabel("Ingrese su contraseña: ");
    JLabel profesorNombreLabel = new JLabel("Ingrese su  nombre: ");
    JLabel profesorApellidoLabel = new JLabel("Ingrese su apellido: ");
    JLabel profesorIDLabel = new JLabel("Ingrese su id: ");
    JLabel alumnoIDLabel = new JLabel("Ingrese su id: ");

    JTextField profesorUsuarioField = new JTextField();
    JPasswordField profesorContraseñaField = new JPasswordField();
    JTextField profesorNombreField = new JTextField();
    JTextField profesorApellidoField = new JTextField();
    JTextField profesorIdField = new JTextField();
    JTextField alumnoIdField = new JTextField();


    public UsuarioGUI() {


        //ALUMNOS

        alumnoUsuarioLabel.setBounds(50, 50, 150, 25);
        alumnoContraseñaLabel.setBounds(50, 100, 150, 25);
        alumnoNombreLabel.setBounds(50, 155, 150, 25);
        alumnoApellidoLabel.setBounds(50, 200, 150, 25);


        alumnoUsuarioField.setBounds(200, 50, 205, 25);
        alumnoContraseñaField.setBounds(200, 100, 205, 25);
        alumnoNombreField.setBounds(200, 150, 205, 25);
        alumnoApellidoField.setBounds(200, 200, 205, 25);

        registrarAlumnos.setBounds(25, 270, 200, 100);
        registrarAlumnos.addActionListener(this);
        registrarAlumnos.setFocusable(false);

        registrarAlumno.setBounds(150, 150, 220, 100);
        registrarAlumno.addActionListener(this);
        registrarAlumno.setFocusable(false);

        volverDivision1.setBounds(250, 270, 220, 100);
        volverDivision1.addActionListener(this);
        volverDivision1.setFocusable(false);

        eliminarAlumnoButton.setBounds(390, 400, 220, 100);
        eliminarAlumnoButton.addActionListener(this);
        eliminarAlumnoButton.setFocusable(false);

        alumnoIdField.setBounds(175, 435, 205, 25);
        alumnoIDLabel.setBounds(50, 435, 205, 25);

        panelAlumno.add(alumnoUsuarioLabel);
        panelAlumno.add(alumnoContraseñaLabel);
        panelAlumno.add(alumnoNombreLabel);
        panelAlumno.add(alumnoApellidoLabel);
        panelAlumno.add(registrarAlumnos);
        panelAlumno.add(alumnoUsuarioField);
        panelAlumno.add(alumnoContraseñaField);
        panelAlumno.add(alumnoNombreField);
        panelAlumno.add(alumnoApellidoField);
        panelAlumno.add(volverDivision1);
        panelAlumno.add(eliminarAlumnoButton);
        panelAlumno.add(alumnoIdField);
        panelAlumno.add(alumnoIDLabel);

        panelAlumno.setLayout(null);
        panelAlumno.setBounds(0,0,640,640);
        panelAlumno.setVisible(false);

        //PROFESORES

        profesorUsuarioLabel.setBounds(50, 50, 150, 25);
        profesorContraseñaLabel.setBounds(50, 100, 150, 25);
        profesorNombreLabel.setBounds(50, 155, 150, 25);
        profesorApellidoLabel.setBounds(50, 200, 150, 25);


        profesorUsuarioField.setBounds(200, 50, 205, 25);
        profesorContraseñaField.setBounds(200, 100, 205, 25);
        profesorNombreField.setBounds(200, 150, 205, 25);
        profesorApellidoField.setBounds(200, 200, 205, 25);

        volverDivision2.setBounds(250, 270, 220, 100);
        volverDivision2.addActionListener(this);
        volverDivision2.setFocusable(false);

        registrarProfesores.setBounds(25, 270, 200, 100);
        registrarProfesores.addActionListener(this);
        registrarProfesores.setFocusable(false);


        registrarProfesor.setBounds(150, 325, 220, 100);
        registrarProfesor.addActionListener(this);
        registrarProfesor.setFocusable(false);

        eliminarProfesorButton.setBounds(390, 400, 220, 100);
        eliminarProfesorButton.addActionListener(this);
        eliminarProfesorButton.setFocusable(false);

        profesorIdField.setBounds(175, 435, 205, 25);
        profesorIDLabel.setBounds(50, 435, 205, 25);

        panelProfesor.add(profesorUsuarioLabel);
        panelProfesor.add(profesorContraseñaLabel);
        panelProfesor.add(profesorNombreLabel);
        panelProfesor.add(profesorApellidoLabel);
        panelProfesor.add(registrarProfesores);
        panelProfesor.add(profesorUsuarioField);
        panelProfesor.add(profesorContraseñaField);
        panelProfesor.add(profesorNombreField);
        panelProfesor.add(profesorApellidoField);
        panelProfesor.add(volverDivision2);
        panelProfesor.add(profesorIdField);
        panelProfesor.add(eliminarProfesorButton);
        panelProfesor.add(profesorIDLabel);

        panelProfesor.setLayout(null);
        panelProfesor.setBounds(0,0,640,640);
        panelProfesor.setVisible(false);

        //DIVISION
        textoDivision.setBounds(150,50,300,50);

        panelDivision.add(textoDivision);
        panelDivision.add(registrarProfesor);
        panelDivision.add(registrarAlumno);
        panelDivision.setLayout(null);
        panelDivision.setBounds(0,0,640,640);
        panelDivision.setVisible(true);









        frame.add(panelDivision);
        frame.add(panelProfesor);
        frame.add(panelAlumno);

        frame.setTitle("sistema de alumnos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 640);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == registrarAlumno) {
            panelAlumno.setVisible(true);
            panelDivision.setVisible(false);


        }
        if (e.getSource() == volverDivision1) {
            panelAlumno.setVisible(false);
            panelDivision.setVisible(true);


        }
        if (e.getSource() == volverDivision2) {
            panelProfesor.setVisible(false);
            panelDivision.setVisible(true);


        }
        if (e.getSource() == registrarProfesor) {
            panelProfesor.setVisible(true);
            panelDivision.setVisible(false);


        }
        if (e.getSource() == eliminarAlumnoButton) {
            long id = Long.parseLong(alumnoIdField.getText());

            try {
                alumnoService.eliminarAlumno(id);

            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == eliminarProfesorButton) {
            long id = Long.parseLong(profesorIdField.getText());

            try {
                profesorService.eliminarProfesor(id);

            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == registrarAlumnos) {
            String usuario = alumnoUsuarioField.getText();
            String contraseña = alumnoContraseñaField.getText();
            String nombre = alumnoNombreField.getText();
            String apellido = alumnoApellidoField.getText();
            Alumno alumno = new Alumno(1, usuario, contraseña, nombre, apellido);

            try {
                alumnoService.guardarAlumno(alumno);

            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == registrarProfesores) {
            String usuario = profesorUsuarioField.getText();
            String contraseña = profesorContraseñaField.getText();
            String nombre = profesorNombreField.getText();
            String apellido = profesorApellidoField.getText();
            Profesor profesor = new Profesor(1, usuario, contraseña, nombre, apellido);

            try {
                profesorService.guardarProfesor(profesor);

            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}