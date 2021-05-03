package Concrete;

import Abstract.BaseCustomerManager;
import Entities.Customer;
import Abstract.CustomerCheckService;

public class StarbucksCustomerManager extends BaseCustomerManager{  //implements CustomerService olabilirdi fakat nero ve starbucks'�n veritaban�na ekleme kodlar� ayn�.
																	//Bu y�zden interface yerine abstract s�n�f kullan�lmal�.
																	//�nterface kullansayd�k ayr� ayr� NeroCustomerManager ve StarbucksCustomerManager'da save metodunu implemente ederdik.
																	//StarbucksCustomerManager extends BaseCustomerManager kullanarak'da dolayl� yoldan CustomerService'deki save metodunu miras olarak alm�� oldu.
	
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


