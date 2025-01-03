package my.work;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Person implements Cloneable {

	private String name;

	private int age;

	@Builder.Default
	private List<Phone> phones = new ArrayList<>();

	private Address address;

	@Override
	public Person clone() throws CloneNotSupportedException {
		var person = (Person) super.clone();
		person.setAddress(address.clone());
		person.setPhones(new ArrayList<>());

		for (var phone : phones) {
			person.getPhones().add(phone.clone());
		}

		return person;
	}

}
