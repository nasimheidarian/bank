package Com.Revature.services;

import java.util.List;

import Com.Revature.Daos.ClientDao;
import Com.Revature.Daos.ClientDaoImpl;
import Com.Revature.Models.Client;

public class ClientServices {

private static final Client Client = null;
private ClientDao ClientDao = new ClientDaoImpl();
	
	public List<Client> getAllClient(){
		return ClientDao.getClient();
	}

	public Client getClientById(int id) {
		return ClientDao.getClientById(id);
	}
	
	public Client getClientByUserNameAndPassword(String username,String password) {
		return ClientDao.getClientByUserNameAndPassword(username, password);
	}
	
	public boolean createClient (Client c) { 	
		 int clntCreated = ClientDao.createClient(c);
		if(clntCreated != 0 ) {
			return true;
		}
		return false;
		
		//return ClientDao.createClient(Client);
	}
	
	public boolean updateClient(Client c) {
		int clntsUpdated = ClientDao.updateClient(c);
		if(clntsUpdated != 0) {
			return true;
		}
		return false;
	}
	
	public boolean deleteClient(Client c) {
		int clntsDeleted = ClientDao.deleteClient(c);
		if(clntsDeleted != 0) {
			return true;
		}
		return false;
	}
	
}


