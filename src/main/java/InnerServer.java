import java.io.*;
import java.net.*;
import java.util.ArrayList;

import org.json.*;

public class InnerServer extends Thread {

    private Integer clienteServerNum;

    public InnerServer(Integer clienteServerNum){
        this.clienteServerNum = clienteServerNum;
    }

    @Override
    public void run(){
        Boolean isClosed = true;
        Socket inputSocket = server.getClienteAcceptSocket(clienteServerNum);

        try {
            InputStream in = inputSocket.getInputStream();
            OutputStream out = inputSocket.getOutputStream();
            while (isClosed) {
                try {

                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    byte[] data = new byte[1024];
                    int bytesRead;


                    while ((bytesRead = in.read(data, 0, data.length)) != -1) {
                        buffer.write(data, 0, bytesRead);
                        if (in.available() == 0) {
                            break; // Exit loop if no more data is available
                        }
                    }
                    // Convert buffer to string and print the received message
                    String receivedMessage = buffer.toString("UTF-8");
                    JSONObject inputJson = new JSONObject(receivedMessage);
                    JSONArray outputArray = new JSONArray();


                    if (inputJson.has("isActive")) {
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

                    byte[] responseBytes = responseMessage.getBytes("UTF-8");
                    out.write(responseBytes);







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