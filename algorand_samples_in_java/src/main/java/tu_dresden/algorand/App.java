package tu_dresden.algorand;

import com.algorand.algosdk.algod.client.ApiException;
import com.algorand.algosdk.algod.client.api.AlgodApi;
import com.algorand.algosdk.algod.client.model.NodeStatus;
import com.algorand.algosdk.v2.client.common.AlgodClient;
import com.algorand.algosdk.v2.client.common.Client;



/**
 * Hello world!
 *
 */
public class App 
{
	final static String ALGOD_API_ADDR = "localhost";
	final static Integer ALGOD_PORT = 4001;
	final static String ALGOD_API_TOKEN = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

	final static String ALGOD_API_ADDR_EXTERNAL = "https://api.host.com";
	final static String ALGOD_API_KEY = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    
    
    public static void algorandAPI()
    {
    	AlgodClient client = (AlgodClient) new AlgodClient(ALGOD_API_ADDR, ALGOD_PORT, ALGOD_API_TOKEN);
    	AlgodApi apiInstance = new AlgodApi();
    	try
    	{
    		NodeStatus status = apiInstance.getStatus();
    		System.out.println("Algorand network status: " + status);
    		
    	} catch(ApiException e)
    	{
    		e.printStackTrace();
    	}
    	
    }
}
