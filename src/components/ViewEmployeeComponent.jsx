import React, { useState } from 'react'
import { getEmployee } from '../services/EmployeeService'
import { useParams } from 'react-router-dom';

const ViewEmployeeComponent = () => {

    const [employee, setEmployee]=useState([])

    const {id}= useParams();
    useState(()=>{
        getEmployee(id).then((response)=>{
            setEmployee(response.data)
        }).catch(error=>{
            console.error(error);
        })
    },[])
    
  return (
    <div>
            <br></br>
        <div className = "card col-md-6 offset-md-3">
            <h3 className = "text-center"> View Employee Details</h3>
            <div className = "card-body">
                <div className = "d-flex">
                    <label> Employee First Name: </label>
                    <div className='ms-3'> { employee.firstname }</div>
                </div>
                <div className = "d-flex">
                    <label> Employee Last Name: </label>
                    <div className='ms-3'> { employee.lastname }</div>
                </div>
                <div className = "d-flex">
                    <label> Employee Email ID: </label>
                <div className='ms-3'> { employee.email }</div>
                </div>
            </div>

        </div>
    </div>
  )
}

export default ViewEmployeeComponent
