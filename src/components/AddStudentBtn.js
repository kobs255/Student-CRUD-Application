import { Link } from "react-router-dom";
export default function AddStudentBtn() {
  return (
    <div className="text-center">
      <Link to="/editStudent">
        <button
          className="btn btn-success"
          style={{ width: "40%", margin: "auto" }}
        >
          Add Student
        </button>
      </Link>
    </div>
  );
}
