package my.work;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Person {

	private String firstName;

	private String lastName;

	private int age;

	private List<Phone> phones;

	private Address address;
}
