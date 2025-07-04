/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.facturacion.parcialfinal;

import java.io.*;
import java.net.*;
/**
 *
 * @author Darwin
 */
public class ServidorCuadrado {
           public static void main(String[] args) {
        int puerto = 5000;
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado en el puerto " + puerto);
            while (true) {
                Socket socketCliente = serverSocket.accept();
                Thread hilo = new Thread(new ManejadorCliente(socketCliente));
                hilo.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
