/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parcial02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author juan.parroquiano
 */
public class Parcial02 {

    private static ServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        int port = 9005;
        Parcial02 parcial02 = new Parcial02(); 
        parcial02.serve(port);
    }
    
    public void serve(int port) throws IOException
    {
        Socket clientSocket = null;
        ServerSocket serverSocket = new ServerSocket(port);
        //System.out.println("Escuchando...");
        //while (true)
        {
            clientSocket = serverSocket.accept();
            handle(clientSocket);
        }
    }
    void handle(Socket client) throws IOException {
                
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String inputLine = null;
        String outputLine;
        
        //System.out.println("InputLine..."+inputLine);
        
        while ((inputLine = in.readLine()) != null) {
            //System.out.println("Escuchando: " + inputLine);
            
            String start = inputLine;       
            String[] parts = start.split(" ");
            //System.out.println("parts[0] "+ parts[0]);
            //System.out.println("parts[1] "+ parts[1]);           
            String url = parts[1]; 
            String path = url, query = "";
            int q = url.indexOf('?');
                        
            if (q >= 0) {                
                path = url.substring(0, q);
                query = url.substring(q + 1);
            }
            //System.out.println("path"+path);
            switch (path) {
                case "/linearsearch":
                    out.print(linearSearch(query));
                    break;
                case "/binarysearch":
                    out.print(binarySearch(query));
            }
            out.flush();
        }
    }
    
    public String linearSearch(String query) {
        String[] listStr;
        int[] list = null;
        int n = 0;
        
        listStr = query.split("&")[0].split("=")[1].split(",");
        System.out.println("listStr "+ listStr);
        if (list != null) {
            System.out.println("list != null");
            for (int i = 0; i < listStr.length; i++) {

                if (list[i] == n) {
                    return this.okLineal(listStr, n, i);
                }
            }
        }
        return this.okLineal(listStr, n, -1);
    }
    
    public String binarySearch(String query) {
        
        int min = 0; 
        int len = 0; 
        int[] listB = null;
        int n = 0;
        
        while (min <= len) {
            int mid = min + (len - min) / 2;
            if (listB[mid] == n) {
                return this.okbinary(listB, n, mid);
            }
            if (listB[mid] < n) {
                min = mid + 1;
            } else {
                len = mid - 1;
            }
        }
        return this.okbinary(listB, n, -1);
    }
    
    
    
    public String okLineal(String[] listStr, int valu, int n) {

        return "{\"operation\":\"linearSearch\", "
                + "\"value\":\"" + valu + "\", "
                + "\"output\":\"" + n + "\"}";

        /*return "{\"operation\":\"linearSearch\", " 
                + "\"inputlist\":\""+ listStr +"\", "
                + "\"value\":\""+ valu +"\", "
                + "\"output\":\""+ n +"\"}";*/
    }
    
    public String okbinary(int[] list, int value, int n) {
        return "{\"operation\":\"binarySearch\", "
                + "\"inputlist\":\"" + list + "\", "
                + "\"value\":\"" + value + "\", "
                + "\"output\":\"" + n + "\"}";
    }
    
}

