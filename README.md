# Networks Project (CPCS-371)
This is the final project for the Networks course, this project utilizes Javas net and io libraries to communicate between two files. 
- `java.net.Socket` is used to create an endpoint to communicate between the two files. 
- `java.net.ServerSocket` creates a server socket that waits for requests to come through the network. __You will need to give Java access to your firewall for this to work.__
- `java.io.DataInputStream` and `java.io.DataOutputStream` are used for communicating between the two files.
## Problem Statement
You are required to create a pair of **Client** and **Server** Programs. The client and the server will use **TCP** as the transport protocol. The client sends a character and a string to the server. The character and the string are taken as inputs from a user on the client side. The server checks the number of occurrences of the character in the string and then sends the number to the client. The client displays the number on its screen. The server entertains the connected client as long as the client does not send a terminating condition. 
## Sample Input/Output (At the client) 
Enter a Character to be searched: t 
Enter a String: This string is entered at the client side by a user 
The number of Occurrences are: 6 
Want to repeat (Y/N): Y 
Enter a Character to be searched: z
Enter a String: Give another string 
The number of Occurrences are: 0 
Want to repeat (Y/N): N 
Thank You!
