package backend.bd.util;

import backend.bd.model.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CommentRepository {
    private final Connection connection;

    public CommentRepository(Connection connection) {
        this.connection = connection;
    }

    public void create(Comment comment) throws SQLException {
        String query = "INSERT INTO comments (comment_id, author_id, comment, presentation, status_user) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, comment.getCommentId());
            statement.setObject(2, comment.getAuthorId());
            statement.setString(3, comment.getComment());
            statement.setObject(4, comment.getPresentation());
            statement.setString(5, comment.getStatusUser());
            statement.executeUpdate();
        }
    }

    public Comment read(UUID commentId) throws SQLException {
        String query = "SELECT * FROM comments WHERE comment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, commentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Comment.builder()
                            .commentId((UUID) resultSet.getObject("comment_id"))
                            .authorId((UUID) resultSet.getObject("author_id"))
                            .comment(resultSet.getString("comment"))
                            .presentation((UUID) resultSet.getObject("presentation"))
                            .statusUser(resultSet.getString("status_user"))
                            .build();
                }
            }
        }
        return null;
    }

    public void update(Comment comment) throws SQLException {
        String query = "UPDATE comments SET author_id = ?, comment = ?, presentation = ?, status_user = ? WHERE comment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, comment.getAuthorId());
            statement.setString(2, comment.getComment());
            statement.setObject(3, comment.getPresentation());
            statement.setString(4, comment.getStatusUser());
            statement.setObject(5, comment.getCommentId());
            statement.executeUpdate();
        }
    }

    public void delete(UUID commentId) throws SQLException {
        String query = "DELETE FROM comments WHERE comment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, commentId);
            statement.executeUpdate();
        }
    }

    public List<Comment> getAll() throws SQLException {
        List<Comment> comments = new ArrayList<>();
        String query = "SELECT * FROM comments";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Comment comment = Comment.builder()
                        .commentId((UUID) resultSet.getObject("comment_id"))
                        .authorId((UUID) resultSet.getObject("author_id"))
                        .comment(resultSet.getString("comment"))
                        .presentation((UUID) resultSet.getObject("presentation"))
                        .statusUser(resultSet.getString("status_user"))
                        .build();
                comments.add(comment);
            }
        }
        return comments;
    }
}