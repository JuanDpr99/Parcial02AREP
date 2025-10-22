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
        while (true)
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
            System.out.println("start "+ start);
            /*String url = parts[1]; 
            String path = url, query = "";
            int q = url.indexOf('?');
            
            if (q >= 0) {                
                path = url.substring(0, q);
                query = url.substring(q + 1);
            }*/
            /*
            switch (path) {
                case "/linearSearch":
                    linearSearch(query);
                    break;
                case "/binarySearch":
                    binarySearch(query);
            }*/
            out.flush();
        }
    }
    

    public static int linearSearch(String query) {

        int[] list = null;
        int n = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == n) {
                return i;
            }
        }
        return -1;
    }
        
    
    
    public void binarySearch(String query) {
        
        /*int min = 0; 
        int len; 
        int[] listB =;
        int n;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;*/
    }

}
