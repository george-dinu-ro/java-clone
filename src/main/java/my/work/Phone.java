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
public class Phone {

	public enum Type {
		HOME, MOBILE, WORK
	}

	private String number;

	private Type type;
}
