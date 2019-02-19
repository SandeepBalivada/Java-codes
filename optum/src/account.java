class accountinfo{
	int accno;
	String accname;
	double accbalance;
	void details(int n,String name,double b)
	{
	  accno= n;
	  accname= name;
	  accbalance = b;
	  
	}
	int deposit(double dep)
	{
		accbalance = accbalance+dep;
		System.out.println("Rs."+dep+" money deposited in account: "+accno);
		return 0;
		
	}
	int withdraw(double wdraw)
	{
		if(accbalance<wdraw)
			System.out.println("Insufficient balance \n Balance is :" + accbalance);
		else
			{
			accbalance = accbalance - wdraw;
			System.out.println("Rs."+wdraw+" money withdrawn from account: "+accno);
			}
		return 0;
	}
	void dispbalance()
	{
		System.out.println("Balance is:" + accbalance);
	}
	
}
public class account {

	public static void main(String[] args) {
		accountinfo a = new accountinfo();
		a.details(15425,"Sandeep",1500);
		a.dispbalance();
		a.deposit(1000);
		a.dispbalance();
		a.withdraw(1800.75);
		a.dispbalance();
		
		System.out.println("working well right");
		
	}

}
