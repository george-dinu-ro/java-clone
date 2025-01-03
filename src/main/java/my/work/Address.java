package my.work;

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
public class Address implements Cloneable {

	private String street;

	private int number;

	@Override
	protected Address clone() throws CloneNotSupportedException {
		return (Address) super.clone();
	}

}
