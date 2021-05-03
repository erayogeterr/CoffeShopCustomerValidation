//SENARYO 
//    Kahve d�kkanlar� i�in m��teri y�netimi yapan bir sistem yazmak istiyoruz.
//    Starbucks ve Nero firmas� i�in �al���yoruz.
//    �ki firma da m��terilerini veritaban�na kaydetmek istiyor.(�kisininde veritaban�na ekleme kodlar� ayn�)
//    Starbucks m��terileri kaydederken,mutlaka mernis do�rulamas� istiyor. (https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx?op=TCKimlikNoDogrula)
//    Nero m��terileri kaydederken b�yle bir �ey istemiyor.


import java.time.LocalDate;

import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.CustomerCheckManager;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		
		BaseCustomerManager customerManagerStarbucks = new StarbucksCustomerManager(new MernisServiceAdapter()); 
		BaseCustomerManager customerManagerNero = new NeroCustomerManager(new CustomerCheckManager()); //Bir zaman sonra Neroda MernisDo�rulama isterse di�er kodlara hi� dokunmadan ekleyebiliriz.
																									   //new MernisServiceAdapter()
		Customer customerStarbucks = new Customer();
		customerStarbucks.setId(1);;
		customerStarbucks.setFirstName("Eray");
		customerStarbucks.setLastName("�geter");
		customerStarbucks.setNationalityId("11223334455");
		customerStarbucks.setDateOfBirth(LocalDate.of(1998, 3, 17));
		customerManagerStarbucks.save(customerStarbucks);
		
		System.out.println("-----------------------------------------------------------------");
		
		Customer customerNero = new Customer();
		customerNero.setId(1);
		customerNero.setFirstName("Kerem");
		customerNero.setLastName("Altay");
		customerNero.setNationalityId("99887776655");
		customerNero.setDateOfBirth(LocalDate.of(2005,11,18));
		customerManagerNero.save(customerNero);
	}

}