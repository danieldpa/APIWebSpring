package med.voll.api.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class DatabaseTestController {

    private final DataSource dataSource;

    public DatabaseTestController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/test-db-connection")
    public String testConnection() {
        try (Connection connection = dataSource.getConnection()) {
            return "Conexão com o banco de dados realizada com sucesso!";
        } catch (Exception e) {
            return "Falha ao conectar com o banco de dados: " + e.getMessage();
        }
    }
}

