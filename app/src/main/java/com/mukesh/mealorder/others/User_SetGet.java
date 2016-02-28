package com.mukesh.mealorder.others;

public class User_SetGet {
	private String Username,Password,Phone,FirstName,LastName,email,itemdesc,itemid,itemPrice,basketitem,basketprice,basketquantity;
	
	public User_SetGet() {
		
		
	}	
	public void setUsername(String Username) {
		this.Username=Username;
	}
	public String getUsername() {
		return Username;
	}
	
	public void setPassword(String Password) {
		this.Password=Password;
	}
	public String getPassowrd() {
		return Password;
	}
	
	public void setPhone(String Phone) {
		this.Phone=Phone;
	}
	public String getPhone() {
		return Phone;
	}

    public void setFirstname(String Firstname) {
        this.FirstName=Firstname;
    }
    public String getFirstname() {return FirstName;}

    public void setLasttname(String Lasttname) {
        this.LastName=Lasttname;
    }
    public String getLastname() {return LastName;}

    public void setEmail(String email) {
        this.email=email;
    }
    public String getEmail() {return email;}



    public void setItem(String itemid) {
        this.itemid=itemid;
    }
    public String getItem() {return itemid;}

    public void setItemDesc(String itemdesc) {
        this.itemdesc=itemdesc;
    }
    public String getItemDesc() {return itemdesc;}

    public void setItemPrice(String itemPrice) {
        this.itemPrice=itemPrice;}
    public String getItemPrice() {return itemPrice;}





    public void setBasketItemPrice(String basketprice) {
        this.basketprice=basketprice;
    }
    public String getBasketItemPrice() {return basketprice;}

    public void setBasketItemQuantity(String basketquantity) {
        this.basketquantity=basketquantity;
    }
    public String getBasketItemQuantity() {return basketquantity;}

    public void setBasketItem(String basketitem) {
        this.basketitem=basketitem;
    }
    public String getBasketItem() {return basketitem;}

}
