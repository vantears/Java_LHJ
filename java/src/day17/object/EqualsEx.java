package day17.object;

import java.util.Objects;

import lombok.Data;

public class EqualsEx {

	public static void main(String[] args) {
		Customer list[] = {
				new Customer("A", "010-1234-5678"),
				new Customer("B", "010-1111-5678"),
				new Customer("C", "010-5555-5678")
		};
		Customer customer = new Customer("A", "010-1234-5678");
		
		for(Customer tmp : list) {
			if(tmp.equals(customer)) {
				System.out.println("OK");
				return;
				}
			}
		System.out.println("Fail");
		}
	}

@Data
class Customer {
	private String id;
	private String name;
	private String phoneNumber;
	
	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(phoneNumber, other.phoneNumber);
		}
	
	
	}