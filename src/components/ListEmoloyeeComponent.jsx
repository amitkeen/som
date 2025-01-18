import React, {useEffect, useState} from 'react'

import { listEmployees } from '../services/EmployeeService'
import { useNavigate } from 'react-router-dom'

const ListEmoloyeeComponent = () => {
    
    const [employees, setEmployees] = useState([])
    const navigator = useNavigate();

    useEffect(() => {
        listEmployees().then((response) => {
            setEmployees(response.data);
        }).catch(error => {

            console.error(error);
        })
    }, [])

    function addNewEmployee() {
        navigator('/add-employee')
    }
   
  return (
    <div className='container'>
        <h1 className='text-center'>List of Employees</h1>

        <button className='btn btn-primary mb-2' onClick={addNewEmployee}>Add Employee</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>
                        Id
                    </th>
                    <th>
                        Employees First name
                    </th>
                    <th>
                        Employees Last Name
                    </th>
                    <th>
                        Employees Email ID
                    </th>
                </tr>
            </thead>

            <tbody>
                {
                    employees.map(employee =>
                        <tr key={employee.id}>
                            <td>
                                {employee.id}
                            </td>
                            <td>
                                {employee.firstName}
                            </td>
                            <td>
                                {employee.lastName}
                            </td>
                            <td>
                                {
                                    employee.email
                                }
                            </td>
                        </tr>
                    )
                }

                <tr>

                </tr>
            </tbody>
        </table>
    </div>
  )
}

export default ListEmoloyeeComponent