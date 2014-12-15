package br.com.caelum.jdbc.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.ConnectionFactory;

import com.mysql.jdbc.PreparedStatement;

public class JDBCInsere {
	public static void main(String[] args) throws SQLException{
		// conectando
		Connection con = new ConnectionFactory().getConnection();
		
		//cria um preparestatement
		String sql = "insert into contatos" +
		" (nome,email,endereco,dataNascimento)" +
		" values (?,?,?,?)";
		
		PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
		
		//preenche valores
		stmt.setString(1, "Caelum");
		stmt.setString(2, "contato@caelum.com.br");
		stmt.setString(3, "R. Vergueiro 3185 cj57");
		stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		
		//executa
		stmt.execute();
		stmt.close();
		
		System.out.println("Gravado!");
		
		con.close();
	}
}
