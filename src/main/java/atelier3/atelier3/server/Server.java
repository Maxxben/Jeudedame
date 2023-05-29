package atelier3.atelier3.server;

import atelier3.atelier3.launcher.GUIStarter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Serveur");

        try {
            //Creation des sockets
            ServerSocket sS = new ServerSocket(5000);
            sS.setSoTimeout(10000);

            //Attente de la connexion de 2 clients
            Socket s = sS.accept();
            Socket s2 = sS.accept();

            //Connexion du client1
            PrintWriter out = new PrintWriter(s.getOutputStream());
            out.println("Connexion au serveur réussie");
            out.flush();

            //Connexion du client2
            PrintWriter out2 = new PrintWriter(s2.getOutputStream());
            out2.println("Connexion au serveur réussie");
            out2.flush();

            out.println("** Debut de la partie **");
            out.flush();

            out2.println("** Debut de la partie **");
            out2.flush();

            //Reception de l'ip du client1
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String ipClient = in.readLine();
            System.out.println("IP du client 1 : " + ipClient);

            //Reception de l'ip du client2
            BufferedReader in2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));
            String ipClient2 = in2.readLine();
            System.out.println("IP du client 2 : " + ipClient2);

            //Lancement du jeu
            GUIStarter.main(args);

            //reception du coup du client
            String coup = in.readLine();
            System.out.println("Le client a joué : " + coup);







            //Fermeture des sockets
            in.close();
            in2.close();
            out.close();
            out2.close();
            sS.close();
            s.close();
            s2.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}