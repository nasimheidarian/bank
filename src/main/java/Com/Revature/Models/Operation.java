package Com.Revature.Models;

import java.io.Serializable;

public class Operation implements Serializable {
private static final long serialVersionUID = 1L;
	
	private int id;
	private Type type;
	private Account account;
	private double amount;
	
	public Operation() {
		super();
	}
	
	public Operation(int id) {
		super();
		this.id = id;
	}
	
	public Operation(int id, Type type, Account account, float amount) {
		super();
	
		this.type = type;
		this.account = account;
		this.amount = amount;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Type gettype() {
		return type;
	}

	public void settype(Type type) {
		this.type =type;
	}

	public Account getaccount() {
		return account;
	}

	public void setaccount(Account account) {
		this.account = account;
	}
	

	public double getamount() {
		return amount;
	}

	public void setamount(double amount) {
		this.amount= amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Operation other = (Operation) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", type=" + type + ", account=" + account + ", amount=" + amount + "]";
	}

		
	}

	
	


