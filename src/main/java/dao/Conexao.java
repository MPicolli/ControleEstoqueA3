package dao;

import java.sql.Connection;

@SuppressWarnings("unused")
public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/controle_estoque";
    private static final String USUARIO = "root";
    private static final String SENHA = "123";

    static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}