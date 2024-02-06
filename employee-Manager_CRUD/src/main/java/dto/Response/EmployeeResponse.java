package dto.Response;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeResponse implements Serializable {
	private Long id;
	private String name;
	private String gender;
	private Date dateofBirth;
	private String address;

}
