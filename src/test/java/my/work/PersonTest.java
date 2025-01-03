package my.work;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void givenDeepClone_thenMutablePropertiesWillNotReuseReferences() throws CloneNotSupportedException {		
		var originalPerson = Person.builder()
				.name("John")
				.age(25)
				.address(
						Address.builder()
						.street("Main Street")
						.number(10)
						.build())
				.phones(List.of(
						Phone.builder()
						.number("123456789")
						.build()))
				.build();

		var clonedPerson = originalPerson.clone();
		
		assertSameValuesAndDifferentReferences(originalPerson, clonedPerson);
		
		originalPerson.setName("Jane");
		originalPerson.setAge(30);
		originalPerson.getAddress().setStreet("Second Street");
		originalPerson.getAddress().setNumber(20);
		originalPerson.getPhones().get(0).setNumber("987654321");
		
		assertClonedValuesNotChanged(originalPerson, clonedPerson);
	}

	private void assertSameValuesAndDifferentReferences(Person originalPerson, Person clonedPerson) {
		assertThat(originalPerson).isNotSameAs(clonedPerson);
		
		assertThat(originalPerson.getName()).isEqualTo(clonedPerson.getName());

		assertThat(originalPerson.getAge()).isEqualTo(clonedPerson.getAge());
		
		assertThat(originalPerson.getAddress()).isNotSameAs(clonedPerson.getAddress());
				
		assertThat(originalPerson.getAddress().getStreet()).isEqualTo(clonedPerson.getAddress().getStreet());

		assertThat(originalPerson.getAddress().getNumber()).isEqualTo(clonedPerson.getAddress().getNumber());
		
		assertThat(originalPerson.getPhones()).isNotSameAs(clonedPerson.getPhones());

		assertThat(originalPerson.getPhones().get(0)).isNotSameAs(clonedPerson.getPhones().get(0));

		assertThat(originalPerson.getPhones().get(0).getNumber()).isEqualTo(clonedPerson.getPhones().get(0).getNumber());
	}
	
	private void assertClonedValuesNotChanged(Person originalPerson, Person clonedPerson) {		
		assertThat(originalPerson).isNotSameAs(clonedPerson);
		
		assertThat(originalPerson.getName()).isEqualTo("Jane");

		assertThat(clonedPerson.getName()).isEqualTo("John");

		assertThat(originalPerson.getAge()).isEqualTo(30);

		assertThat(clonedPerson.getAge()).isEqualTo(25);
		
		assertThat(originalPerson.getAddress()).isNotSameAs(clonedPerson.getAddress());
				
		assertThat(originalPerson.getAddress().getStreet()).isEqualTo("Second Street");

		assertThat(clonedPerson.getAddress().getStreet()).isEqualTo("Main Street");

		assertThat(originalPerson.getAddress().getNumber()).isEqualTo(20);

		assertThat(clonedPerson.getAddress().getNumber()).isEqualTo(10);
		
		assertThat(originalPerson.getPhones()).isNotSameAs(clonedPerson.getPhones());

		assertThat(originalPerson.getPhones().get(0)).isNotSameAs(clonedPerson.getPhones().get(0));

		assertThat(originalPerson.getPhones().get(0).getNumber()).isEqualTo("987654321");

		assertThat(clonedPerson.getPhones().get(0).getNumber()).isEqualTo("123456789");
	}
	
}
