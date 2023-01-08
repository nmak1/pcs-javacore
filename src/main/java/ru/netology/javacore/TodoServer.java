package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    private int port = 8989;
    private Todos todos;


    public TodoServer(int port, Todos todos) {
        this.port = port ;
        this.todos = todos ;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (
                        Socket clientSocket = serverSocket.accept();
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());
                    String json = in.readLine();
                    Gson gson = new Gson();
                    TaskManager taskManager = gson.fromJson(json, TaskManager.class);
                    switch (taskManager.type) {
                        case ("ADD"):
                            todos.addTask(taskManager.task);
                            break;
                        case ("REMOVE"):
                            todos.removeTask(taskManager.task);
                            break;
                    }
                    out.println(todos.getAllTasks());
                    System.out.println(taskManager);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

