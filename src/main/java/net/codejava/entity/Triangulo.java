package net.codejava.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Triangulo {
    public Long id;
    public double base;
    public double altura;
    public double perimetro;
    public double area;

    public Triangulo() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double area(){
        return ( (this.base * this.altura) / 2 );
    }

    public double perimetro(){
        return (this.base*3);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public double getArea() {
        return area;
    }
}
