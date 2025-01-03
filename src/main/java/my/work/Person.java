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
public class Person {

	private String name;

	private int age;

	@Builder.Default
	private List<Phone> phones = new ArrayList<>();

	private Address address;

	public Person(Person person) {
		this.name = person.name;
		this.age = person.age;
		this.phones = person.phones.stream().map(Phone::new).toList();
		this.address = new Address(person.address);
	}

}
