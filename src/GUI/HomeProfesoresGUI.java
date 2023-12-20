package GUI;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Entidades.Alumno;
import Entidades.Curso;
import Entidades.Profesor;

import Service.AlumnoService;
import Service.CursoService;
import Service.ProfesorService;
import Service.ServiceException;
public class HomeProfesoresGUI {

    CursoService cursoService = new CursoService();

    JFrame frame = new JFrame();
    JPanel panelListaCursos = new JPanel();
    JLabel listaCursosLabel = new JLabel("Lista de cursos:");
    JComboBox<Curso> listaCursosBox = new JComboBox();
    JButton botonModificar = new JButton();


    public HomeProfesoresGUI(Profesor profesor, JFrame frame){

        //COMBO BOX
        listaCursosLabel.setBounds(25,50,100,50);
        listaCursosBox.setBounds(150,50,300,50);
        cursoService.cargarCursos(listaCursosBox);



        //PANEL
        panelListaCursos.add(listaCursosLabel);
        panelListaCursos.add(botonModificar);
        panelListaCursos.add(listaCursosBox);

        panelListaCursos.setVisible(true);
        panelListaCursos.setLayout(null);
        panelListaCursos.setBounds(0, 0, 640, 640);


        //FRAME
        frame.add(panelListaCursos);
        frame.setTitle("HomeProfesores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 640);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
