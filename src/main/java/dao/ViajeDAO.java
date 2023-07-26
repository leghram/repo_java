package dao;

import models.Viaje;
import utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViajeDAO {

    public List<Viaje> getAllViajes() throws SQLException {
        List<Viaje> viajes = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM VIAJES");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Viaje viaje = new Viaje();
                viaje.setId(resultSet.getInt("id"));
                viaje.setNombre(resultSet.getString("nombre"));
                viaje.setPais(resultSet.getString("pais"));
                viaje.setPuntuacion(resultSet.getDouble("puntuacion"));
                viaje.setIsFavorite(resultSet.getInt("is_favorite"));
                viaje.setUrlImage(resultSet.getString("url_image"));
                viaje.setUserId(resultSet.getInt("user_id"));

                viajes.add(viaje);
            }
        }

        return viajes;
    }
    public List<Viaje> getTop3ViajesByUserId(int userId) throws SQLException {
        List<Viaje> viajes = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM VIAJES WHERE user_id = ? ORDER BY puntuacion DESC LIMIT 3");
        ) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Viaje viaje = new Viaje();
                viaje.setId(resultSet.getInt("id"));
                viaje.setNombre(resultSet.getString("nombre"));
                viaje.setPais(resultSet.getString("pais"));
                viaje.setPuntuacion(resultSet.getDouble("puntuacion"));
                viaje.setIsFavorite(resultSet.getInt("is_favorite"));
                viaje.setUrlImage(resultSet.getString("url_image"));
                viaje.setUserId(resultSet.getInt("user_id"));

                viajes.add(viaje);
            }
        }

        return viajes;
    }

    public List<Viaje> getViajesFavoritosByUserId(int userId) throws SQLException {
        List<Viaje> viajes = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM VIAJES WHERE user_id = ? AND is_favorite = 1");
        ) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Viaje viaje = new Viaje();
                viaje.setId(resultSet.getInt("id"));
                viaje.setNombre(resultSet.getString("nombre"));
                viaje.setPais(resultSet.getString("pais"));
                viaje.setPuntuacion(resultSet.getDouble("puntuacion"));
                viaje.setIsFavorite(resultSet.getInt("is_favorite"));
                viaje.setUrlImage(resultSet.getString("url_image"));
                viaje.setUserId(resultSet.getInt("user_id"));

                viajes.add(viaje);
            }
        }

        return viajes;
    }


    public List<Viaje> getViajesByUserId(int userId) throws SQLException {
        List<Viaje> viajes = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM VIAJES WHERE user_id = ?");
        ) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Viaje viaje = new Viaje();
                viaje.setId(resultSet.getInt("id"));
                viaje.setNombre(resultSet.getString("nombre"));
                viaje.setPais(resultSet.getString("pais"));
                viaje.setPuntuacion(resultSet.getDouble("puntuacion"));
                viaje.setIsFavorite(resultSet.getInt("is_favorite"));
                viaje.setUrlImage(resultSet.getString("url_image"));
                viaje.setUserId(resultSet.getInt("user_id"));

                viajes.add(viaje);
            }
        }

        return viajes;
    }

    public void createViaje(Viaje viaje) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO VIAJES (nombre, pais, puntuacion, is_favorite, url_image, user_id) VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, viaje.getNombre());
            statement.setString(2, viaje.getPais());
            statement.setDouble(3, viaje.getPuntuacion());
            statement.setInt(4, viaje.getIsFavorite());
            statement.setString(5, viaje.getUrlImage());
            statement.setInt(6, viaje.getUserId());

            statement.executeUpdate();
        }
    }

    public void updateViaje(Viaje viaje) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE VIAJES SET nombre = ?, pais = ?, puntuacion = ?, is_favorite = ?, url_image = ?, user_id = ? WHERE id = ?")) {
            statement.setString(1, viaje.getNombre());
            statement.setString(2, viaje.getPais());
            statement.setDouble(3, viaje.getPuntuacion());
            statement.setInt(4, viaje.getIsFavorite());
            statement.setString(5, viaje.getUrlImage());
            statement.setInt(6, viaje.getUserId());
            statement.setInt(7, viaje.getId());

            statement.executeUpdate();
        }
    }

    public void deleteViaje(int id) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM VIAJES WHERE id = ?")) {
            statement.setInt(1, id);

            statement.executeUpdate();
        }
    }
}
