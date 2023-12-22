package backend.bd.util;

import backend.bd.model.Slide;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SlideRepository {
    private final Connection connection;

    public SlideRepository(Connection connection) {
        this.connection = connection;
    }

    public void create(Slide slide) throws SQLException {
        String query = "INSERT INTO slides (id, presentation_id, title, text, img_id_list, setting, num_slide) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, slide.getId());
            statement.setObject(2, slide.getPresentationID());
            statement.setString(3, slide.getTitle());
            statement.setString(4, slide.getText());
            statement.setArray(5, connection.createArrayOf("text", slide.getImgIdList().toArray()));
            statement.setString(6, slide.getSetting());
            statement.setInt(7, slide.getNumSlide());
            statement.executeUpdate();
        }
    }

    public Slide read(UUID id) throws SQLException {
        String query = "SELECT * FROM slides WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapSlide(resultSet);
                }
            }
        }
        return null;
    }

    public void update(Slide slide) throws SQLException {
        String query = "UPDATE slides SET presentation_id = ?, title = ?, text = ?, img_id_list = ?, setting = ?, num_slide = ? " +
                "WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, slide.getPresentationID());
            statement.setString(2, slide.getTitle());
            statement.setString(3, slide.getText());
            statement.setArray(4, connection.createArrayOf("text", slide.getImgIdList().toArray()));
            statement.setString(5, slide.getSetting());
            statement.setInt(6, slide.getNumSlide());
            statement.setObject(7, slide.getId());
            statement.executeUpdate();
        }
    }

    public void delete(UUID id) throws SQLException {
        String query = "DELETE FROM slides WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, id);
            statement.executeUpdate();
        }
    }

    public List<Slide> getAll() throws SQLException {
        List<Slide> slides = new ArrayList<>();
        String query = "SELECT * FROM slides";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                slides.add(mapSlide(resultSet));
            }
        }
        return slides;
    }

    private Slide mapSlide(ResultSet resultSet) throws SQLException {
        Slide slide = new Slide();
        slide.setId((UUID) resultSet.getObject("id"));
        slide.setPresentationID((UUID) resultSet.getObject("presentation_id"));
        slide.setTitle(resultSet.getString("title"));
        slide.setText(resultSet.getString("text"));
        slide.setImgIdList((List<String>) resultSet.getArray("img_id_list").getArray());
        slide.setSetting(resultSet.getString("setting"));
        slide.setNumSlide(resultSet.getInt("num_slide"));
        return slide;
    }
}