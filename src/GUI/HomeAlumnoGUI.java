package GUI;
import javax.swing.*;

import Entidades.Alumno;

public class HomeAlumnoGUI  {
    JFrame frame = new JFrame();




    public HomeAlumnoGUI(Alumno alumno, JFrame frame){
        frame.setTitle("HomeAlumnos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 640);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
