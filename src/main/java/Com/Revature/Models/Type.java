package Com.Revature.Models;

import java.io.Serializable;

public class Type implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String operationtype;

	
	public Type() {
		super();
	}
	
	public Type(int id) {
		super();
		this.id = id;
	}
	
	public Type(int id, String operationtype) {
		super();
	
		this.operationtype = operationtype;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getoperationtype() {
		return operationtype;
	}

	public void setoperationtype(String operationtype) {
		this.operationtype = operationtype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((operationtype == null) ? 0 : operationtype.hashCode());
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
		Type other = (Type) obj;
		if (id != other.id)
			return false;
		if (operationtype == null) {
			if (other.operationtype != null)
				return false;
		} else if (!operationtype.equals(other.operationtype))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", operationtype=" + operationtype + "]";
	}

	
}
