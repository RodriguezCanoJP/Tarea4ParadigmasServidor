import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.json.*;

public class InnerServer extends Thread {

    private Integer clienteServerNum;

    public InnerServer(Integer clienteServerNum){
        this.clienteServerNum = clienteServerNum;
    }

    @Override
    public void run(){
        /*
        comunicacion con los diferentes clientes. Se crea un buffer que lee byte por byte del input stream y lo convierte a string
        divide ese string por las llaves que se esperan del objeto json y se utilizan los valores para actualizar las posiciones de los carros
        envia un objeto json por el socket del server
         */
        Boolean isClosed = true;
        Socket inputSocket = server.getClienteAcceptSocket(clienteServerNum);

        try {
            InputStream in = inputSocket.getInputStream();
            while (isClosed) {
                try {

                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    byte[] data = new byte[1024];
                    int bytesRead;


                    while ((bytesRead = in.read(data, 0, data.length)) != -1) {
                        buffer.write(data, 0, bytesRead);
                        if (in.available() == 0) {
                            break;
                        }
                    }
                    String receivedMessage = buffer.toString("UTF-8");
                    JSONObject inputJson = new JSONObject(receivedMessage);
                    JSONArray outputArray = new JSONArray();


                    if (inputJson.has("isActive")) {
                        //espera un mensaje especifico del cliente para standby y el color que elige del carro
                        System.out.println("Activando cliente " + clienteServerNum);
                        server.setClienteActive(inputJson.getBoolean("isActive"), clienteServerNum);
                        server.agregaCarro(inputJson.getString("color"));
                    }

                    if (inputJson.has("c") && inputJson.getBoolean("isActive") == true) {
                        System.out.println("Activando cliente " + clienteServerNum);
                        server.setClienteActive(true, clienteServerNum);
                    }


                    for(int i = 0; i < cliente.getNumClientes(); i++) {
                        JSONObject outputJson = new JSONObject();
                        if(i != clienteServerNum){
                            int seccion = server.getPista().carros.get(i).seccion;
                            float distancia = server.getPista().carros.get(i).distancia;
                            String color = server.getPista().carros.get(i).color;

                            outputJson.put("seccion", seccion);
                            outputJson.put("distancia", distancia);
                            outputJson.put("color", color);
                            outputArray.put(outputJson);
                        }
                    }

                    //try (OutputStreamWriter out = new OutputStreamWriter(inputSocket.getOutputStream(),  StandardCharsets.UTF_8)) {
                        //out.write(outputArray.toString());
                    //}

                    buffer.close();


                } catch (IOException e) {
                    System.err.println("IOException: " + e.getMessage());
                }
            }
            in.close();
            inputSocket.close();
        }catch (IOException e){
            System.err.println("IOException: " + e.getMessage());
        }
    }                
}