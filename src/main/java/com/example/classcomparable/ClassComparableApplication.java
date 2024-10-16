package com.example.classcomparable;

import com.example.classcomparable.entities.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/*Faça um programa para ler um arquivo contendo funcionários (nome e salário) no formato .cvs,
armazenando-os em uma lista. Depois, ordenar a lista por nome e mostrar o resultado na tela.
Nota: o caminho do arquivo pode ser informado “Hardcode” (no código)*/

@SpringBootApplication
public class ClassComparableApplication {

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        String path = "C:\\temp\\in.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String employeeCsv = br.readLine();
            while(employeeCsv != null){
                String[] fields = employeeCsv.split(",");

                list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                employeeCsv = br.readLine();
            }
            /*Collections.sort(list) - Não aceita order lista <T>, somente se for uma tipo comparable
            Para corrigir isso devemos implementar a class Comparable na entitis employee*/
            Collections.sort(list);
            for(Employee emp : list){
                System.out.println(emp.getName() + ", " + emp.getSalary());
            }
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }


}
