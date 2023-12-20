package GUI;

import Entidades.Admin;
import Entidades.Alumno;
import Entidades.Curso;
import Service.AlumnoService;
import Service.CursoService;
import Service.ServiceException;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAdminGUI implements ActionListener {
    AlumnoService alumnoService = new AlumnoService();
    CursoService cursoService = new CursoService();
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel textoPanelPrincipal = new JLabel("¿Desea crear cursos o dar de alta a alumnos?");
    //ALUMNOS
    JPanel panelAltaAlumnos = new JPanel();
    JButton botonAltaAlumnos = new JButton("Dar alta a alumnos");
    JButton botonAltaAlumno = new JButton("Dar de alta al alumnos");
    JButton botonVolverADivisionAlumno = new JButton("Volver atras");
    JLabel alumnoCorreoLabel = new JLabel("Ingrese su correo: ");
    JLabel alumnoContraseñaLabel = new JLabel("Ingrese su contraseña: ");
    JLabel alumnoNombreLabel = new JLabel("Ingrese su  nombre: ");
    JLabel alumnoApellidoLabel = new JLabel("Ingrese su apellido: ");
    JTextField alumnoCorreoField = new JTextField();
    JPasswordField alumnoContraseñaField = new JPasswordField();
    JTextField alumnoNombreField = new JTextField();
    JTextField alumnoApellidoField = new JTextField();

    //CURSOS
    JPanel panelCrearCursos = new JPanel();
    JButton botonCrearCursos = new JButton("Crear cursos");
    JButton botonCrearCurso = new JButton("Crear el cursos");
    JButton botonVolverADivisionCurso = new JButton("Volver atras");
    JLabel cursoCodCursoLabel = new JLabel("Ingrese el codigo del curso: ");
    JLabel cursoNombreLabel = new JLabel("Ingrese el nombre del curso: ");
    JLabel cursoNombreProfesorLabel = new JLabel("Ingrese el nombre del profesor: ");
    JLabel cursoCorreoProfesorLabel = new JLabel("Ingrese el correo del profesor: ");
    JLabel cursoCupoLabel = new JLabel("Ingrese el cupo maximo del curso: ");
    JLabel cursoPrecioLabel = new JLabel("Ingrese el precio del curso: ");

    JTextField cursoCodCursoField = new JTextField();
    JTextField cursoNombreField = new JTextField();
    JTextField cursoNombreProfesorField = new JTextField();
    JTextField cursoCorreoProfesorField = new JTextField();
    JTextField cursoCupoField = new JTextField();
    JTextField cursoPrecioField = new JTextField();





    public HomeAdminGUI(Admin admin, JFrame frame){

        //DAR ALTA A ALUMNO
        alumnoCorreoLabel.setBounds(50, 50, 150, 25);
        alumnoContraseñaLabel.setBounds(50, 100, 150, 25);
        alumnoNombreLabel.setBounds(50, 155, 150, 25);
        alumnoApellidoLabel.setBounds(50, 200, 150, 25);


        alumnoCorreoField.setBounds(200, 50, 205, 25);
        alumnoContraseñaField.setBounds(200, 100, 205, 25);
        alumnoNombreField.setBounds(200, 150, 205, 25);
        alumnoApellidoField.setBounds(200, 200, 205, 25);

        botonAltaAlumnos.setBounds(150, 150, 150, 50);
        botonAltaAlumnos.addActionListener(this);
        botonAltaAlumnos.setFocusable(false);

        botonAltaAlumno.setBounds(75, 300, 150, 50);
        botonAltaAlumno.addActionListener(this);
        botonAltaAlumno.setFocusable(false);

        botonVolverADivisionAlumno.setBounds(250, 300, 150, 50);
        botonVolverADivisionAlumno.addActionListener(this);
        botonVolverADivisionAlumno.setFocusable(false);


        panelAltaAlumnos.add(alumnoCorreoLabel);
        panelAltaAlumnos.add(alumnoContraseñaLabel);
        panelAltaAlumnos.add(alumnoNombreLabel);
        panelAltaAlumnos.add(alumnoApellidoLabel);
        panelAltaAlumnos.add(botonAltaAlumno);
        panelAltaAlumnos.add(alumnoCorreoField);
        panelAltaAlumnos.add(alumnoContraseñaField);
        panelAltaAlumnos.add(alumnoNombreField);
        panelAltaAlumnos.add(alumnoApellidoField);
        panelAltaAlumnos.add(botonVolverADivisionAlumno);


        panelAltaAlumnos.setLayout(null);
        panelAltaAlumnos.setBounds(0, 0, 640, 640);
        panelAltaAlumnos.setVisible(false);

        //CREAR CURSO

        cursoCodCursoLabel.setBounds(50, 50, 200, 25);
        cursoNombreLabel.setBounds(50, 100, 200, 25);
        cursoNombreProfesorLabel.setBounds(50, 150, 200, 25);
        cursoCorreoProfesorLabel.setBounds(50, 200, 200, 25);
        cursoCupoLabel.setBounds(50, 250, 200, 25);
        cursoPrecioLabel.setBounds(50, 300, 200, 25);

        cursoCodCursoField.setBounds(250, 50, 205, 25);
        cursoNombreField.setBounds(250, 100, 205, 25);
        cursoNombreProfesorField.setBounds(250, 150, 205, 25);
        cursoCorreoProfesorField.setBounds(250, 200, 205, 25);
        cursoCupoField.setBounds(250, 250, 205, 25);
        cursoPrecioField.setBounds(250, 300, 205, 25);

        botonCrearCursos.setBounds(150, 225, 150, 50);
        botonCrearCursos.addActionListener(this);
        botonCrearCursos.setFocusable(false);

        botonCrearCurso.setBounds(75, 350, 150, 50);
        botonCrearCurso.addActionListener(this);
        botonCrearCurso.setFocusable(false);

        botonVolverADivisionCurso.setBounds(250, 350, 150, 50);
        botonVolverADivisionCurso.addActionListener(this);
        botonVolverADivisionCurso.setFocusable(false);


        panelCrearCursos.add(cursoCodCursoLabel);
        panelCrearCursos.add(cursoNombreLabel);
        panelCrearCursos.add(cursoNombreProfesorLabel);
        panelCrearCursos.add(cursoCorreoProfesorLabel);
        panelCrearCursos.add(cursoCupoLabel);
        panelCrearCursos.add(cursoPrecioLabel);
        panelCrearCursos.add(cursoCodCursoField);
        panelCrearCursos.add(cursoNombreField);
        panelCrearCursos.add(cursoNombreProfesorField);
        panelCrearCursos.add(cursoCorreoProfesorField);
        panelCrearCursos.add(cursoCupoField);
        panelCrearCursos.add(cursoPrecioField);
        panelCrearCursos.add(botonCrearCurso);
        panelCrearCursos.add(botonVolverADivisionCurso);



        panelCrearCursos.setLayout(null);
        panelCrearCursos.setBounds(0, 0, 640, 640);
        panelCrearCursos.setVisible(false);


        //PANEL PRINCIPAL
        textoPanelPrincipal.setBounds(150,50,300,50);
        panel.add(botonAltaAlumnos);
        panel.add(botonCrearCursos);
        panel.add(textoPanelPrincipal);

        panel.setLayout(null);
        panel.setBounds(0, 0, 640, 640);
        panel.setVisible(true);
        //FRAME

        frame.add(panel);
        frame.add(panelAltaAlumnos);
        frame.add(panelCrearCursos);

        frame.setTitle("HomeAdmins");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 640);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

        if (e.getSource() == botonAltaAlumnos) {
            panelAltaAlumnos.setVisible(true);
            panel.setVisible(false);
        }

        if (e.getSource() == botonVolverADivisionAlumno) {
            panelAltaAlumnos.setVisible(false);
            panel.setVisible(true);
        }

        if (e.getSource() == botonCrearCursos) {
            panelCrearCursos.setVisible(true);
            panel.setVisible(false);
        }

        if (e.getSource() == botonVolverADivisionCurso) {
            panelCrearCursos.setVisible(false);
            panel.setVisible(true);
        }

        if (e.getSource() == botonAltaAlumno) {
            String correo = alumnoCorreoField.getText();
            String contraseña = alumnoContraseñaField.getText();
            String nombre = alumnoNombreField.getText();
            String apellido = alumnoApellidoField.getText();
            Alumno alumno = new Alumno(correo, contraseña , nombre, apellido);
            panelAltaAlumnos.setVisible(false);
            panel.setVisible(true);
            try {
                alumnoService.guardarAlumno(alumno);
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == botonCrearCurso) {
            String codCurso = cursoCodCursoField.getText();
            String nombreCurso = cursoNombreField.getText();
            String nombreProfesor = cursoNombreProfesorField.getText();
            String correoProfesor = cursoCorreoProfesorField.getText();
            String cupoCurso = cursoCupoField.getText();
            String precioCurso = cursoPrecioField.getText();

            int codCursoNumero = Integer.parseInt(codCurso);
            int cupoCursoNumero = Integer.parseInt(cupoCurso);
            int precioCursoNumero = Integer.parseInt(precioCurso);

            Curso curso = new Curso(codCursoNumero,nombreCurso,nombreProfesor,correoProfesor,cupoCursoNumero,precioCursoNumero);
            panelCrearCursos.setVisible(false);
            panel.setVisible(true);

            try {

                cursoService.guardarCurso(curso);
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
