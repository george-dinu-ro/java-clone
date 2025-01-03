package my.work;

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
public class Phone implements Cloneable {

	private String number;

	@Override
	protected Phone clone() throws CloneNotSupportedException {
		return (Phone) super.clone();
	}
	
}
