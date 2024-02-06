package dto.Request;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeRequest implements Serializable {
	private String name;

	private String gender;
	private Date dateofBirth;
	private String address;

}
