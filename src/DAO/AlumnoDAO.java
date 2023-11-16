package DAO;

import Entidades.Alumno;

import java.sql.*;

public class AlumnoDAO implements DAO<Alumno>{

    private String DB_JDBC_DRIVER = "org.h2.Driver";
    private String DB_URL = "jdbc:h2:C:\\Users\\juanl\\IdeaProjects\\Turnera media";
    private String DB_USER ="sa";
    private String DB_PASSWORD = "";

    @Override
    public void guardar(Alumno alumno) throws DAOException{

        Connection connection = null;
        // es un objeto que se utiliza para poder ejecutar un query multiples veces con distintos parametros
        PreparedStatement preparedStatement = null;

        try {
            //Levantar el driver y conectarnos
            //si no encuentra los drivers tira excepcion y sino devuelve un TRUE
            Class.forName(DB_JDBC_DRIVER);
            //generamos una conexion con la base de datos que se le dio en los parametros
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            // se crea la sentencia SQL
            preparedStatement = connection.prepareStatement("INSERT INTO alumnos VALUES(?,?,?,?,?)");
            preparedStatement.setLong(1,alumno.getId());
            preparedStatement.setString(2,alumno.getNombreUsuario());
            preparedStatement.setString(3,alumno.getContraseña());
            preparedStatement.setString(4,alumno.getNombre());
            preparedStatement.setString(5,alumno.getApellido());

            // Ejecutar la sentencia y executeUpdate inserta los datos en la tabla
            int res = preparedStatement.executeUpdate();


            System.out.println("Registros insertados: " + res);


        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void modificar(Alumno alumno) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = connection.prepareStatement("UPDATE alumnos NOMBREUSUARIO=?, CONTRASEÑA=?, NOMBRE=?, APELLIDO=? WHERE ID=?");

            preparedStatement.setString(1, alumno.getNombreUsuario());
            preparedStatement.setString(2,alumno.getContraseña());
            preparedStatement.setString(3,alumno.getNombre());
            preparedStatement.setString(4,alumno.getApellido());
            preparedStatement.setLong(5,alumno.getId());


            int res = preparedStatement.executeUpdate();


            System.out.println("Registros modificados: " + res);


        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void eliminar(long id) throws DAOException{

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement = connection.prepareStatement("DELETE FROM alumnos WHERE ID=?");
            preparedStatement.setLong(1,id);


            int res = preparedStatement.executeUpdate();

            System.out.println("Registros eliminados: " + res);


        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }

    }

    @Override
    public Alumno buscar(long id) throws DAOException{

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Alumno alumno = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM alumnos WHERE id=?");
            preparedStatement.setLong(1,id);

            //guardas los resultados del select en la variable res
            ResultSet res = preparedStatement.executeQuery();

            //luego insertas los datos en que conseguiste del select en un objeto de Alumno
            while(res.next()) //.next devuelve un true si hay datos en la tabla
            {
                alumno = new Alumno();
                alumno.setId( res.getLong("ID") );
                alumno.setContraseña( res.getString("CONTRASEÑA") );
                alumno.setNombreUsuario(res.getString("NOMBREUSUARIO"));
                alumno.setNombre(res.getString("NOMBRE"));
                alumno.setApellido(res.getString("APELLIDO"));

            }

        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }

        return alumno;
    }

}

