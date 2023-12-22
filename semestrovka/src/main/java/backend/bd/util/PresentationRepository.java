package backend.bd.util;

import backend.bd.model.Presentation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PresentationRepository {
    private final Connection connection;

    public PresentationRepository(Connection connection) {
        this.connection = connection;
    }

    public void create(Presentation presentation) throws SQLException {
        String query = "INSERT INTO presentations (presentation_id, user_id, name, folder_id, template_name, request_presentation_id, cost, status, creation_date, data_change) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, presentation.getPresentationId());
            statement.setObject(2, presentation.getUserId());
            statement.setString(3, presentation.getName());
            statement.setString(4, presentation.getFolder_Id());
            statement.setString(5, presentation.getTemplate_name());
            statement.setObject(6, presentation.getRequestPresentationId());
            statement.setDouble(7, presentation.getCost());
            statement.setString(8, presentation.getStatus());
            statement.setString(9, presentation.getCreationDate());
            statement.setString(10, presentation.getDataChange());
            statement.executeUpdate();
        }
    }

    public Presentation read(UUID presentationId) throws SQLException {
        String query = "SELECT * FROM presentations WHERE presentation_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, presentationId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapPresentation(resultSet);
                }
            }
        }
        return null;
    }

    public void update(Presentation presentation) throws SQLException {
        String query = "UPDATE presentations SET user_id = ?, name = ?, folder_id = ?, template_name = ?, request_presentation_id = ?, cost = ?, status = ?, creation_date = ?, data_change = ? " +
                "WHERE presentation_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, presentation.getUserId());
            statement.setString(2, presentation.getName());
            statement.setString(3, presentation.getFolder_Id());
            statement.setString(4, presentation.getTemplate_name());
            statement.setObject(5, presentation.getRequestPresentationId());
            statement.setDouble(6, presentation.getCost());
            statement.setString(7, presentation.getStatus());
            statement.setString(8, presentation.getCreationDate());
            statement.setString(9, presentation.getDataChange());
            statement.setObject(10, presentation.getPresentationId());
            statement.executeUpdate();
        }
    }

    public void delete(UUID presentationId) throws SQLException {
        String query = "DELETE FROM presentations WHERE presentation_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, presentationId);
            statement.executeUpdate();
        }
    }

    public List<Presentation> getAll() throws SQLException {
        List<Presentation> presentations = new ArrayList<>();
        String query = "SELECT * FROM presentations";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                presentations.add(mapPresentation(resultSet));
            }
        }
        return presentations;
    }

    private Presentation mapPresentation(ResultSet resultSet) throws SQLException {
        return Presentation.builder()
                .presentationId((UUID) resultSet.getObject("presentation_id"))
                .userId((UUID) resultSet.getObject("user_id"))
                .name(resultSet.getString("name"))
                .folder_Id(resultSet.getString("folder_id"))
                .template_name(resultSet.getString("template_name"))
                .requestPresentationId((UUID) resultSet.getObject("request_presentation_id"))
                .cost(resultSet.getDouble("cost"))
                .status(resultSet.getString("status"))
                .creationDate(resultSet.getString("creation_date"))
                .dataChange(resultSet.getString("data_change"))
                .build();
    }
}