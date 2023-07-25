package dao;

import models.User;
import utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERS");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setNombre(resultSet.getString("nombre"));
                user.setApellido(resultSet.getString("apellido"));
                user.setCorreo(resultSet.getString("correo"));
                user.setPassword(resultSet.getString("password"));

                users.add(user);
            }
        }

        return users;
    }

    public User getUserById(int id) throws SQLException {
        User user = null;

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERS WHERE id = ?");
             ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setNombre(resultSet.getString("nombre"));
                user.setApellido(resultSet.getString("apellido"));
                user.setCorreo(resultSet.getString("correo"));
                user.setPassword(resultSet.getString("password"));
            }
        }

        return user;
    }

    public User getUserByUsername(String username) throws SQLException {
        User user = null;

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERS WHERE nombre = ?");
        ) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setNombre(resultSet.getString("nombre"));
                user.setApellido(resultSet.getString("apellido"));
                user.setCorreo(resultSet.getString("correo"));
                user.setPassword(resultSet.getString("password"));
            }
        }

        return user;
    }

    public void createUser(User user) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO USERS (nombre, apellido, correo, password) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, user.getNombre());
            statement.setString(2, user.getApellido());
            statement.setString(3, user.getCorreo());
            statement.setString(4, user.getPassword());

            statement.executeUpdate();
        }
    }

    public void updateUser(User user) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE USERS SET nombre = ?, apellido = ?, correo = ?, password = ? WHERE id = ?")) {
            statement.setString(1, user.getNombre());
            statement.setString(2, user.getApellido());
            statement.setString(3, user.getCorreo());
            statement.setString(4, user.getPassword());
            statement.setInt(5, user.getId());

            statement.executeUpdate();
        }
    }

    public void deleteUser(int id) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM USERS WHERE id = ?")) {
            statement.setInt(1, id);

            statement.executeUpdate();
        }
    }
}
