package br.com.edubarbieri.protectedapi;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_GET_EMPLOYEE')")
	public String getAllEmployee(Principal e){
		System.out.println(e);
		return "getAllEmployee";
	}
	
	@PostMapping
//	@PreAuthorize("hasAuthority('ROLE_ADMIN_EMPLOYEE')")
	public String createEmployee(){
		return "createEmployee";
	}
	
}
