package Concrete;

import Abstract.BaseCustomerManager;
import Abstract.CustomerCheckService;
import Entities.Customer;

public class NeroCustomerManager extends BaseCustomerManager { 
															//implements CustomerService olabilirdi fakat nero ve starbucks'�n veritaban�na ekleme kodlar� ayn�.
															//Bu y�zden interface yerine abstract s�n�f kullan�lmal�.
															//�nterface kullansayd�k ayr� ayr� NeroCustomerManager ve StarbucksCustomerManager'da save metodunu implemente ederdik.
															//NeroCustomerManager extends BaseCustomerManager kullanarak'da dolayl� yoldan CustomerService'deki save metodunu miras olarak alm�� oldu.
	
	private CustomerCheckService customerService; //DI

	public NeroCustomerManager(CustomerCheckService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@Override
	public void save(Customer customer) {
		if (customerService.checkIfRealPerson(customer)) 
		{
			super.save(customer); //Burada Nero ve Starbucks'�n db ekleme kodlar� ayn� oldu�undan BaseCustomerManager'daki metodu ikisini'de ayr� ayr� yazsayd�k yani BaseCustomerManager olmasayd� DRY'a ayk�r� olurdu.
		}
		else {
			
			System.out.println("Not a real person");
		}
	}
											
}
