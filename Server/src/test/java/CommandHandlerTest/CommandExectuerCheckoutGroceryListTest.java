package CommandHandlerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ClientServerApi.CommandDescriptor;
import ClientServerApi.CommandWrapper;
import ClientServerApi.ResultDescriptor;
import CommandHandler.CommandExecuter;
import SQLDatabase.SQLDatabaseConnection;
import SQLDatabase.SQLDatabaseException.ClientNotConnected;
import SQLDatabase.SQLDatabaseException.CriticalError;
import SQLDatabase.SQLDatabaseException.GroceryListIsEmpty;

@RunWith(MockitoJUnitRunner.class)
public class CommandExectuerCheckoutGroceryListTest {

	@Mock
	private SQLDatabaseConnection sqlDatabaseConnection;

	@Before
	public void setup() {
		PropertyConfigurator.configure("../log4j.properties");
	}
	
	@Test
	public void checkoutGroceryListSuccessfulTest() {
		int cartID = 1;
		String command = new CommandWrapper(cartID, CommandDescriptor.CHECKOUT_GROCERY_LIST).serialize();
		CommandExecuter commandExecuter = new CommandExecuter(command);
		CommandWrapper out;
		
		try {
			Mockito.doNothing().when(sqlDatabaseConnection).cartCheckout(cartID);
		} catch (CriticalError | ClientNotConnected | GroceryListIsEmpty e) {
			e.printStackTrace();
			fail();
		}
		
		out = commandExecuter.execute(sqlDatabaseConnection);
		
		assertEquals(ResultDescriptor.SM_OK, out.getResultDescriptor());
	}
	
	@Test
	public void checkoutGroceryListCriticalErrorTest() {
		int cartID = 1;
		String command = new CommandWrapper(cartID, CommandDescriptor.CHECKOUT_GROCERY_LIST).serialize();
		CommandExecuter commandExecuter = new CommandExecuter(command);
		CommandWrapper out;
		
		try {
			Mockito.doThrow(new CriticalError()).when(sqlDatabaseConnection).cartCheckout(cartID);
		} catch (ClientNotConnected | GroceryListIsEmpty e) {
			e.printStackTrace();
			fail();
		} catch (CriticalError __) {
			/* Successful */
		}
		
		out = commandExecuter.execute(sqlDatabaseConnection);
		
		assertEquals(ResultDescriptor.SM_ERR, out.getResultDescriptor());
	}
	
	@Test
	public void checkoutGroceryListClientNotConnectedTest() {
		int cartID = 1;
		String command = new CommandWrapper(cartID, CommandDescriptor.CHECKOUT_GROCERY_LIST).serialize();
		CommandExecuter commandExecuter = new CommandExecuter(command);
		CommandWrapper out;
		
		try {
			Mockito.doThrow(new ClientNotConnected()).when(sqlDatabaseConnection).cartCheckout(cartID);
		} catch (CriticalError | GroceryListIsEmpty e) {
			e.printStackTrace();
			fail();
		} catch (ClientNotConnected __) {
			/* Successful */
		}
		
		out = commandExecuter.execute(sqlDatabaseConnection);
		
		assertEquals(ResultDescriptor.SM_SENDER_IS_NOT_CONNECTED, out.getResultDescriptor());
	}
}