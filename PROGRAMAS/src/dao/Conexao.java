package dao;

import java.sql.SQLException;

public class Conexao{
    //banco de dados nome
    private static final String URL="jdbc:mysql://localhost:3306/bdUnivel2026?useSSL=false&allowPublicKeyRetrieval=trye&serverTimezone=UTC";
    
    //usuario padrao do mysql
    private static final String USER="root"; //seu usuário do MySQL
    private static final String PASSWORD="univel";
    //sua senha do MySQL que foi cadastrada quando você instalou o banco

    public static Connection conectar(){
        try {
            //Carrega explicitamente o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Tenta conectar
            conexao=DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conectado com sucesso ao MySQL!");
            //mensagem no terminal
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do MySQL nao encontrado: " + e.getMessage());
        } catch (SQLException e){
            System.out.println("Erro ao conectar: "+e.getMessage());
        }
        return conexao;
    }    
    
}