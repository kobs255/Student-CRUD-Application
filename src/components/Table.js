import { Fragment, useContext } from "react";
import { studentContext } from "../App";
import AddStudentBtn from "./AddStudentBtn";
import PageHeader from "./PageHeader";
import StudentsList from "./StudentsList";

export default function Table() {
  const { students } = useContext(studentContext);
  if (students.length > 0) {
    return (
      <Fragment>
        <PageHeader title="Student Management System" />
        <AddStudentBtn />
        <table className="table" style={{marginTop:"2em"}}>
          <thead className="thead-light">
            <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th>Actions</th>
            </tr>
          </thead>
          <StudentsList />
        </table>
      </Fragment>
    );
  } else {
    return (
      <div style={{ textAlign: "center" }}>
        There are currently no students. Add some by clicking the button below.
        <hr></hr>
        <br></br>
        <AddStudentBtn />
      </div>
    );
  }
}
