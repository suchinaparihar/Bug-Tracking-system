package chat.client;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

 
public class developerAgent1 extends Agent {
	private static final long serialVersionUID = 1L;

	protected void setup() {
				
		// Define the behaviour
		CyclicBehaviour loop; 
        loop = new CyclicBehaviour(this) {
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				
				// Receive the incoming message
				ACLMessage aclMsg = receive();
                
				// Interpret the message
                if (aclMsg != null) {
                	System.out.println(myAgent.getLocalName() + "> Received message from: " + aclMsg.getSender());
                	System.out.println("Message content: " + aclMsg.getContent());
                	// TODO Aufgabe 1
                }
                
				block(); // Stop the behaviour until next message is received
			}
        };
        addBehaviour(loop);
	}
}

