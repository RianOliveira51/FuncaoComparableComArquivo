package com.example.classcomparable.entities;

public class Employee implements Comparable<Employee> {
    private String name;
    private Double salary;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    //Ele serve para comparar um objeto com o outro
    @Override
    public int compareTo(Employee other) {
        //aqui estamos comparando o nome de cada funcionario por isso comparamos o name com o other.getName()
        return name.compareTo(other.getName());

        //caso quiser por salario.
        //return salary.compareTo(other.getSalary());

        //order decrescente o salario, só colocar - na frente
        //return -salary.compareTo(other.getSalary());
    }
}
