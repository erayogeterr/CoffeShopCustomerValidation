package Concrete;

import Abstract.BaseCustomerManager;
import Entities.Customer;
import Abstract.CustomerCheckService;

public class StarbucksCustomerManager extends BaseCustomerManager{  //implements CustomerService olabilirdi fakat nero ve starbucks'ýn veritabanýna ekleme kodlarý ayný.
																	//Bu yüzden interface yerine abstract sýnýf kullanýlmalý.
																	//Ýnterface kullansaydýk ayrý ayrý NeroCustomerManager ve StarbucksCustomerManager'da save metodunu implemente ederdik.
																	//StarbucksCustomerManager extends BaseCustomerManager kullanarak'da dolaylý yoldan CustomerService'deki save metodunu miras olarak almýþ oldu.
	
	private final CustomerCheckService customerCheckService; //DI
	
	public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
		super();
		this.customerCheckService = customerCheckService;
	}

	@Override
	public void save(Customer customer) {
		
		 if(customerCheckService.checkIfRealPerson(customer))
	        {
	            super.save(customer);
	        }
	        else
	        {
	            System.out.println("Not a real person");
	        }
	
	}
	
}


