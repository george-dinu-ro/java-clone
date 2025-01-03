package my.work;

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

	private List<Phone> phones;

	private Address address;

	@Override
	public Person clone() throws CloneNotSupportedException {
		return (Person) super.clone();
	}
	
}
