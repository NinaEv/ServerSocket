package javacore.task_serverSocket;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("GET / HTTP/1.1\n" + "Host: localhost\n\n\n");
            String resp = in.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            System.out.println("Ошибка соединения: " + e.getMessage());
        }
    }
}

