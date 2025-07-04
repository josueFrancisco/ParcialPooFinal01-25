/* 
René Alejandro Trejo Morales 00360524.
Darwin Enriquez Ortiz Sandoval 00042223.
Josue Francisco Peña Duran 00191223.
*/

package com.mycompany.clientecuadrado;

import java.io.*;
import java.net.*;   
import java.util.Scanner;

public class ClienteCuadrado {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 5000;

        try (
            Socket socket = new Socket(host, puerto);
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.print("Ingresa tu nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingresa un numero entero: ");
            int numero = scanner.nextInt();

            salida.writeUTF(nombre);
            salida.writeInt(numero);
            
            String respuesta = entrada.readUTF();
            System.out.println("\nRespuesta del servidor:\n" + respuesta);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






