package com.ejemplo.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@CrossOrigin(origins = "*")
@RestController
public class HomeController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/")
    public String home() {
        return "¡Bienvenido! La aplicación Spring Boot está funcionando.";
    }

    @GetMapping("/check-db")

    public String checkDatabaseConnection() {
        try (Connection connection = dataSource.getConnection()) {
            if (connection.isValid(1)) {
                return "Conexión a la base de datos exitosa.";
            } else {
                return "La conexión a la base de datos falló.";
            }
        } catch (SQLException e) {
            return "Error de conexión a la base de datos: " + e.getMessage();
        }
    }
}
