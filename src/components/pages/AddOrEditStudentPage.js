import { Fragment, useRef, useContext } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { addOrUpdateStudent } from "../../services/StudentService";
import PageHeader from "../PageHeader";
import { studentContext } from "../../App";

export default function AddOrEditStudentPage() {
  const { setStudents } = useContext(studentContext);
  const location = useLocation();
  const navigate = useNavigate();
  let isEditableUser = location.state !== null;
  let { id, firstName, lastName, email } = isEditableUser
    ? location.state.studentInfo
    : {
        id: 0,
        firstName: "",
        lastName: "",
        email: "",
      };
  const fName = useRef(firstName);
  const lName = useRef(lastName);
  const emil = useRef(email);
  const handleSubmit = async (event) => {
    event.preventDefault();
    setStudents(
      await addOrUpdateStudent({
        id: id,
        firstName: fName.current.value,
        lastName: lName.current.value,
        email: emil.current.value,
      })
    );
    navigate("/");
  };

  return (
    <Fragment>
      <div
        style={{
          width: "75%",
          margin: "10em auto",
          border: "1px solid white",
          boxShadow:
            "rgba(50, 50, 93, 0.25) 0px 50px 100px -20px, rgba(0, 0, 0, 0.3) 0px 30px 60px -30px, rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset",
          padding: "3em",
          borderRadius: "10px",
        }}
      >
        <PageHeader title={isEditableUser ? "Edit Student" : "Add Student"} />
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="firstNameInput">First Name:</label>
            <input
              type="text"
              className="form-control"
              id="firstNameInput"
              defaultValue={firstName}
              ref={fName}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="lastNameInput">Last Name:</label>
            <input
              type="text"
              className="form-control"
              id="lastNameInput"
              defaultValue={lastName}
              ref={lName}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="emailInput">Email:</label>
            <input
              type="email"
              className="form-control"
              id="emailInput"
              defaultValue={email}
              ref={emil}
              required
            />
          </div>
          <div className="submitDiv" style={{ textAlign: "center" }}>
            <input
              style={{ marginTop: "1em", width: "25%" }}
              type="submit"
              className="btn btn-outline-secondary"
              value="Submit"
            />
          </div>
        </form>
      </div>
    </Fragment>
  );
}
