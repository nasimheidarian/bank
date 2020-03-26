package Com.Revature.Models;

import java.io.Serializable;

public class Account implements Serializable {



private static final long serialVersionUID = 1L;

private int id;
private double balance;
private Client client;


public Account() {
	super();
}

public Account(int id) {
	super();
	this.id = id;
}

public Account(int id, double balance, Client client) {
	super();

	this.balance = balance;
	this.client = client;

}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public double getbalance() {
	return balance;
}

public void setbalance(double balance) {
	this.balance = balance;
}

public Client getclient() {
	return client;
}

public void setclient(Client client) {
	this.client = client;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(balance);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((client == null) ? 0 : client.hashCode());
	result = prime * result + id;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Account other = (Account) obj;
	if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
		return false;
	if (client == null) {
		if (other.client != null)
			return false;
	} else if (!client.equals(other.client))
		return false;
	if (id != other.id)
		return false;
	return true;
}

@Override
public String toString() {
	return "Account [id=" + id + ", balance=" + balance + ", client=" + client + "]";
}

}
