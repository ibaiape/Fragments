package com.example.dm2.fragments;

import java.io.Serializable;

public class Libro implements Serializable{
    private int isbn;
    private String titulo;
    private String autor;
    private String resumen;

    public Libro(){}

    public Libro(int isbn, String titulo, String autor, String resumen) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.resumen = resumen;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
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

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String toString(){
        return this.titulo+", por "+this.autor+". "+this.resumen;
    }
}
