/*
CPCS 371 Group Project
Group --(DashDash)
Names:
    Motasem Ali Bamashmous 2045661
    Mohammed Aljudaibi 2035778
    Sultan humusani 2036377
    Hamed Fallatah 2035900
 */
package tcpproject_groupdashdash;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class DashDash_client {

    public static void main(String[] args) throws IOException {
        //goes to current device with localhostname and port
        DashDash_client client = new DashDash_client("127.0.0.1", 5000);
    }

    private Socket socket;
    private int ServerPort;
    private String address;
    private DataOutputStream output;
    private DataInputStream ServerInput;

    public DashDash_client(String address, int ServerPort) throws IOException {
        this.address = address;
        this.ServerPort = ServerPort;
        
        //attempts to create socket with the address and if it connects creates the need input and output streams
        try {
            socket = new Socket(this.address, this.ServerPort);
            if (socket.isConnected()) {
                output = new DataOutputStream(socket.getOutputStream());
                ServerInput = new DataInputStream(socket.getInputStream());
                System.out.println("Connected to Server");
            }
            //catches any errors while attempting to connect
        } catch (Exception E) {
            System.out.println("Connection could not be established");
            System.exit(0);
        }
        
        //used to read input from the user
        readInput();
    }

    public void readInput() throws IOException {
        //scanner to read from user
        Scanner read = new Scanner(System.in);
        char repeat = 'y';
        
        //keeps asking user for input while the input is not n
        while (repeat != 'n') {
            char charSearch;
            //keeps asking for character to search, until given exactly one character
            while (true) {
                System.out.print("Enter a Character to be searched: ");
                String search = read.nextLine().toLowerCase();
                if (search.length() > 1) {
                    System.out.println("Too long, enter only 1 character");
                    continue;
                }
                charSearch = search.charAt(0);
                break;
            }
            
            //asks for sentance to search through
            System.out.print("Enter a String: ");
            String sentence = read.nextLine();
            
            //sends the sentance and the charter to search to server
            output.writeUTF(String.format("%s,%s", sentence, charSearch));
            
            //gets the numbers of times the charter repeats from the server
            System.out.printf("The number of Occurrences are: %d\n", ServerInput.readInt());
            
            String choice = "";
            //this will now asked the user if they want to repeat or not
            while (true) {
                System.out.printf("Want to repeat?(Y/N): ");
                choice = read.nextLine().toLowerCase();
                if (!choice.equals("y") && !choice.equals("n")) {
                    System.out.println("Incorrect input, enter either (Y/N)");
                    continue;
                }
                repeat = choice.charAt(0);
                break;   
            }
        }
        //this will send to the server that the client isn't gonna send anything else
        output.writeUTF("n");
        System.out.println(ServerInput.readUTF());
    }
}
