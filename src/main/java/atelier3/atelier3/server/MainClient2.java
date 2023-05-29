package atelier3.atelier3.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class MainClient2 {
    public static void main(String[] args) {
        System.out.println("Client");

        Client client = new Client("Client2", "BLACK", "localhost");

        try {
            Socket s = new Socket("localhost", 5000);

            //Connexion au serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(in.readLine());

            //Afficher l'ip du client
            System.out.println("Mon IP : " + s.getLocalAddress());

            //Envoi de l'ip au serveur
            PrintWriter out = new PrintWriter(s.getOutputStream());
            out.println(s.getLocalAddress());
            out.flush();





            out.close();
            in.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
