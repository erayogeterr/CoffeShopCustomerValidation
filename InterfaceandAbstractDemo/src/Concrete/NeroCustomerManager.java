package Concrete;

import Abstract.BaseCustomerManager;
import Abstract.CustomerCheckService;
import Entities.Customer;

public class NeroCustomerManager extends BaseCustomerManager { 
															//implements CustomerService olabilirdi fakat nero ve starbucks'ýn veritabanýna ekleme kodlarý ayný.
															//Bu yüzden interface yerine abstract sýnýf kullanýlmalý.
															//Ýnterface kullansaydýk ayrý ayrý NeroCustomerManager ve StarbucksCustomerManager'da save metodunu implemente ederdik.
															//NeroCustomerManager extends BaseCustomerManager kullanarak'da dolaylý yoldan CustomerService'deki save metodunu miras olarak almýþ oldu.
	
	private CustomerCheckService customerService; //DI

	public NeroCustomerManager(CustomerCheckService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@Override
	public void save(Customer customer) {
		if (customerService.checkIfRealPerson(customer)) 
		{
			super.save(customer); //Burada Nero ve Starbucks'ýn db ekleme kodlarý ayný olduðundan BaseCustomerManager'daki metodu ikisini'de ayrý ayrý yazsaydýk yani BaseCustomerManager olmasaydý DRY'a aykýrý olurdu.
		}
		else {
			
			System.out.println("Not a real person");
		}
	}
											
}
