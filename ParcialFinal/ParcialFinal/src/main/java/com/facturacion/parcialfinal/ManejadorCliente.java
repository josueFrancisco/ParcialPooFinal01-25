/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.facturacion.parcialfinal;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * 00360524 RENE ALEJANDRO TREJO MORAL
 * 00191223 JOSUE FRANCISCO PEÑA DURAN
 * 00042223 Darwin Enrique Ortiz Sandoval
 * @author Darwin
 */
public class ManejadorCliente implements Runnable {
     
    private Socket socket;

    public ManejadorCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream())
        ) {
            String nombre = entrada.readUTF();
            int numero = entrada.readInt();

            System.out.println("Cliente " + nombre + " conectado");

            int cuadrado = numero * numero;
            String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            String respuesta = "¡Bienvenido, " + nombre + "!\n"
                             + "Cuadrado de " + numero + " es: " + cuadrado + "\n"
                             + "Fecha y hora actual del servidor: " + fechaHora;

            salida.writeUTF(respuesta);

            System.out.println("Cliente " + nombre + " desconectado");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}




