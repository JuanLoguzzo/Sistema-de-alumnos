package DAO;

import Entidades.Admin;
import Entidades.Alumno;
import Entidades.Inscripciones;

import java.sql.*;


public class AdminDAO implements DAO<Admin>{
    private String DB_JDBC_DRIVER = "org.h2.Driver";
    private String DB_URL = "jdbc:h2:C:\\Users\\juanl\\IdeaProjects\\Turnera media";
    private String DB_USER ="sa";
    private String DB_PASSWORD = "";

    @Override
    public void guardar(Admin admin) throws DAOException{

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT into Admin Values(?,?)");
            preparedStatement.setString(1,admin.getCorreo());
            preparedStatement.setString(2,admin.getContraseña());


            int res = preparedStatement.executeUpdate();

            System.out.println("Registros insertados: " + res);

        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }
    public void modificar(Admin elemento) throws DAOException {
    }

    public void eliminar(long id) throws DAOException {
    }

    public Admin buscar(long id) throws DAOException {
        return null;
    }
    public Admin buscar2(String correo) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Admin admin = null;

        try {
            Class.forName(this.DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(this.DB_URL, this.DB_USER, this.DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Admin  WHERE NOMBREUSUARIO=?");
            preparedStatement.setString(1, correo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                admin = new Admin();
                admin.setCorreo(correo);
                admin.setContraseña(resultSet.getString("CONTRASEÑA"));

            }

            return admin;
        } catch (SQLException | ClassNotFoundException var6) {
            throw new DAOException(var6.getMessage());
        }
    }
}
