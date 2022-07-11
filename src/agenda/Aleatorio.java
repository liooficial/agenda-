/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Marifer
 */
public class Aleatorio {
    private RandomAccessFile raf;

    private void writePerson(long num, Agenda person) throws IOException {
        this.raf.seek(num * Agenda.SIZE); //Ubica el cursos identificado
        byte[] record = person.toBytes();
        this.raf.write(record);
    }

    private Agenda readPerson(long num) throws IOException {
        this.raf.seek(num * Agenda.SIZE); 
        byte[] record = new byte[Agenda.SIZE];
        this.raf.read(record);
        return Agenda.fromBytes(record);
    }

    public static void main(String args[]) {
           new Aleatorio().ejecutar();
    }

    public void ejecutar() {
        try {
            this.raf = new RandomAccessFile("Agenda.dat", "rw");
            Agenda p1 = new Agenda( "Juan", "calle #2", "juan@gmail",77572727);
            Agenda p2 = new Agenda( "Laura", "calle #4", "laura@gmail",7756789);
            Agenda p3 = new Agenda( "Camila", "calle #8", "cami@gmail",7752345);
            Agenda p4 = new Agenda( "Camila", "calle #8", "cami@gmail",7752345);
            //Person p4 = new Person(8984, "Susi", 24, true);
            
            this.writePerson(0, p1);
            this.writePerson(1, p2);
            this.writePerson(2, p3);
            this.writePerson(3, p4);
            //this.writePerson(1000, p3);
            
            Agenda p;
            p = this.readPerson(0);
            System.out.println("p= " + p);
            p = this.readPerson(1);
            System.out.println("p= " + p);
            p = this.readPerson(2);
            System.out.println("p= " + p);
            
            this.writePerson(3, p4);
            p= this.readPerson(3);
            System.out.println("p = " + p);
            /*
            this.writePerson(1, p1);
            p = this.readPerson(1);
            System.out.println("p = " + p);*/
            String Nombre;
            int cont = 0;

            Scanner sc = new Scanner(System.in);
            System.out.println("Dime el nombre de la persona que quieres buscar: ");
            Nombre = sc.nextLine();
            for (int i = 0; i < Agenda.SIZE; i++) {
                p = this.readPerson(i);
                if (Nombre.equalsIgnoreCase(p.getNombre())) {
                    System.out.println("p= " + p);
                    cont += 1;
                }
            }
            if (cont== 1) {
                
                System.out.println("Registo encontrado");
            }else {
                if (cont < 1) {
                System.out.println("Registo no existe");
                }
                if (cont >= 2) {
                System.out.println("Registo repretido");
                }
            }

        } catch (IOException e) {
            //System.out.println("Something has gone wrong!!!");
        }

    }

    public void Consulta(String Agenda) {

    }

}

