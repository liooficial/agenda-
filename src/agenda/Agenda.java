/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agenda;
/**
 *
 * @author Marifer
 */
public class Agenda {
    private String Nombre;
    private String direccion;
    private String email;
    private long numero;
    
    private static final int nom_LIMIT = 30;
    private static final int dire_LIMIT = 30;
    private static final int email_LIMIT = 30;
    public static final int SIZE = 2 * nom_LIMIT + 2 * dire_LIMIT + 2 * email_LIMIT + 8; 
    
    public Agenda(String Nombre, String direccion, String email, long numero) {
        this.Nombre = Nombre;
        this.direccion = direccion;
        this.email = email;
        this.numero = numero;
    }

    public String getNombre() {
        return Nombre;
    }


    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public long getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Agenda{" + "Nombre=" + Nombre + ", Dirección=" + direccion + ", E-mail=" + email + ", Número=" + numero + '}';
    }
    
    public byte[] toBytes(){ //serializada
        byte[] record = new byte[SIZE];
        int offset= 0;
        Utils.packLong(numero, record, offset);
        offset +=8;
        Utils.packLimitedString(Nombre, nom_LIMIT, record, offset);
        offset += 2 * nom_LIMIT;
        Utils.packLimitedString(direccion, dire_LIMIT, record, offset);
        offset += 2 * dire_LIMIT;
        Utils.packLimitedString(email, email_LIMIT, record, offset);
        offset += 2 * email_LIMIT;
        return record;
    }
    
    public static Agenda fromBytes(byte[] record){ //desserializada
        int offset = 0;
        long numero= Utils.unpackLong(record, offset);
        offset += 8;
        String Nombre = Utils.unpackLimitedString(nom_LIMIT, record, offset);
        offset += 2 * nom_LIMIT;
        String direcion = Utils.unpackLimitedString(dire_LIMIT, record, offset);
        offset += 2 * dire_LIMIT;
        String email = Utils.unpackLimitedString(email_LIMIT, record, offset);
        offset += 2 * email_LIMIT;
        
        return new Agenda(Nombre, direcion, email, numero);
    }
 //for 
    
}

