package Com.Revature.Daos;

import java.util.List;

import Com.Revature.Models.Client;

public interface ClientDao{
	
	public List<Client> getClient();
	public Client getClientById(int id);
	public int createClient (Client c);
	public int updateClient (Client c);
	public int deleteClient(Client c);
	public Client getClientByUserNameAndPassword(String username, String password);
	public Client createClientWithFunction(String firstname,String lastname,String email,String username, String password);

}


