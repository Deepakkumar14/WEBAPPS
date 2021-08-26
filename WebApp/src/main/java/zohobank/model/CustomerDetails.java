package zohobank.model;

public class CustomerDetails {
	   private int customerId;
	   private String fullName,city;
	   
	   
	   public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	

	    public int getCustomerId() {
	        return this.customerId;
	    }

	    public void setCustomerId(int customerId) {
	        this.customerId = customerId;
	    }
	    
	    public String getCity() {
	        return this.city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }
	    
	    @Override
	    public String toString() {
	        return  "Customer_id: " + customerId +"\t"+" Name: " + fullName +"\t"+" City: " + city+"\n";
	    }
	    
	   
	}


