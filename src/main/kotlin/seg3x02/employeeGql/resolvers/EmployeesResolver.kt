package seg3x02.employeeGql.resolvers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import seg3x02.employeeGql.entity.Employee
import seg3x02.employeeGql.repository.EmployeesRepository
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.MutationMapping

@Controller
@RequestMapping("/graphql")
class EmployeesResolver(private val employeesRepository: EmployeesRepository) {

    @QueryMapping
    fun employees(): List<Employee> {
        return employeesRepository.findAll()
    }

    @MutationMapping
    fun addEmployee(
        name: String,
        dateOfBirth: String,
        city: String,
        salary: Float,
        gender: String?,
        email: String?
    ): Employee {
        val employee = Employee(name, dateOfBirth, city, salary, gender, email)
        return employeesRepository.save(employee)
    }
}