import Student from "./Student";
import { useContext } from "react";
import { studentContext } from "../App";
export default function StudentsList() {
  const {students} = useContext(studentContext);
  return (
    <tbody>
      {students.map((info) => {
        return <Student key={info.id} info={info} />;
      })}
    </tbody>
  );
}
