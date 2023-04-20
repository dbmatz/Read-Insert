package com.prova.modelo;

/*
 * create table livro(
 * 		id serial not null,
 * 		titulo varchar(50) not null,
 * 		autor varchar(50) not null,
 * 		genero varchar(50) not null,
 * 		primary key(id)
 * );
 * 
 */

public class Biblioteca {
	private int id;
	private String titulo;
	private String autor;
	private String genero;
	public Biblioteca() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Biblioteca(String titulo, String autor, String genero) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
