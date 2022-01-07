package br.com.projetowebjspdao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {

	//vari�veis globais
	private Connection con;
	private Statement s;
	
	//dados de conex�o
	private final String enderecoFisicoBanco = "";
	private final String banco = "";
	private final String usuario = "";
	private final String senha = "";
	private static String mensagem;
	
	
	
	/**
	 * M�todo respons�vel por abrir conex�o com banco de dados
	 */
	
	public void conectar(){
		
		try {
			if(con == null || con.isClosed()) {
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection(enderecoFisicoBanco + banco, usuario, senha);
				System.out.println("Conex�o aberta...");
			}
		}
		
		catch(Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	
	/**
	 * M�todo respons�vel por fechar a conex�o com banco de dados
	 */
	public void desconectar() {
		if(con != null) {
			try {
				if(s != null) {
					s.close();
					s = null;
				}
				con.close();
				System.out.println("Conex�o fechada...");
			}catch(Exception e) {
				System.out.println("Error: " + e);
			}
		}
	}
		
	/**
	 * M�todo utilizado para executar atualiza��es:
	 * atualizar, deletar, incluir	
	 * @param sql
	 * @return
	 */
	public int executarAtualizacao(String sql) {
		mensagem = "Sucesso na execu��o";
		try {
			conectar();
			if(s == null) {
				s = con.createStatement();
			}
			
			//executando sql...
			int rs = s.executeUpdate(sql);
			System.out.println(mensagem);
			desconectar();
			return rs;
		}catch(Exception e) {
			desconectar();
			mensagem = "Error: " + e;
			System.out.println(mensagem);
		}
		
		return(0);
		
	}
	
	/**
	 * M�todo utilizado para executar uma consulta passando
	 * uma query
	 * @param sql
	 * @return
	 */
	public ResultSet executarConsulta(String sql) {
		mensagem = "Sucesso na execu��o";
		try {
			if(s == null) {
				s = con.createStatement();
			}
			System.out.println("Executando SQL de consulta... ");
			//Armazena o resultado da consulta...
			ResultSet rs= s.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			mensagem = "Error: " + e;
			System.out.println(mensagem);
		}
		return null;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
