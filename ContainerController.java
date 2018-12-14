 
package chat.client;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

 
public class ContainerController {
	
 
	private static void startMainContainer() throws StaleProxyException {
        		
		Runtime runtime = jade.core.Runtime.instance();
		runtime.setCloseVM(true);

		Profile profile = new ProfileImpl("127.0.0.1", 1099, null);
		profile.setParameter(Profile.GUI, "true");

		AgentContainer mainContainer = runtime.createMainContainer(profile);

		AgentController pmAgent = mainContainer.createNewAgent("pmAgent", pmAgent.class.getName(), new Object[0]);
		pmAgent.start();

		AgentController developerAgent1 = mainContainer.createNewAgent("developerAgent1", developerAgent1.class.getName(), new Object[0]);
		developerAgent1.start();
		
		AgentController developerAgent2 = mainContainer.createNewAgent("developerAgent2", developerAgent2.class.getName(), new Object[0]);
		developerAgent2.start();
		
		AgentController developerAgent3 = mainContainer.createNewAgent("developerAgent3", developerAgent3.class.getName(), new Object[0]);
		developerAgent3.start();
	}
 
	public static void main(String[] args) {
		
		try {
			startMainContainer();
		} catch (StaleProxyException e) {
			System.out.println("Main container could not be started.");
			e.printStackTrace();
		}
	}		
	 
}
