package kr.co.testCode.jpa;

import jakarta.persistence.*;
import lombok.*;
//import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="testtable")
public class testtableVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	
	private String phone;
	
}
