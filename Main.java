import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost:3306/eventos";
        final String USER = "root";
        final String PASSWORD = "root99";
        final String CONSULTA = "select * from evento";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado!");

            Statement st = con.createStatement();
            System.out.println("Statemant criado!");

            String query = "insert into evento (nome, local, data, participantes) values (?, ?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(query);

            String evento = JOptionPane.showInputDialog("Digite o nome do evento");
            String local = JOptionPane.showInputDialog("Digite o local do evento");
            String data = JOptionPane.showInputDialog("Digite a data do evento");
            String participantes = JOptionPane.showInputDialog("Digite a quantidade de participantes do evento");


            stmt.setString(1, evento);
            stmt.setString(2, local);
            stmt.setString(3, data);
            stmt.setString(4, participantes);


            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Dados inseridos!");

            ResultSet resultSet = stmt.executeQuery(CONSULTA);

            while(resultSet.next()){
                System.out.println(resultSet.getString("nome"));
                System.out.println(resultSet.getString("local"));
                System.out.println(resultSet.getString("data"));
                System.out.println(resultSet.getString("participantes"));




            }

        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }

    }
}
