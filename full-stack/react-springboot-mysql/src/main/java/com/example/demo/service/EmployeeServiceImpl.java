package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResorceNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto){
		// TODO Auto-generated method stub
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee =employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee =employeeRepository.findById(employeeId)
		.orElseThrow(()-> new ResorceNotFoundException("employee not exist with a given id : "+ employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees =employeeRepository.findAll();
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		// TODO Auto-generated method stub
		Employee employee =employeeRepository.findById(employeeId).orElseThrow(
					()->new ResorceNotFoundException("employee is not exist in the given id : "+employeeId)
				);
		
		employee.setFirstName(updatedEmployee.getFirstname());
		employee.setLastName(updatedEmployee.getLastname());
		employee.setEmail(updatedEmployee.getEmail());
		
		Employee updatedEmployeeObj=employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee =employeeRepository.findById(employeeId).orElseThrow(
				()->new ResorceNotFoundException("employee is not exist in the given id : "+employeeId)
			);
		employeeRepository.deleteById(employeeId);
		
	}
	
}
