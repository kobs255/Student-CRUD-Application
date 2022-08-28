import axios from "axios";

const prefix = "http://localhost:3333/api/students/";

async function getAllStudents() {
  let students = [];
  await axios.get(prefix).then((val) => {
    students = val.data;
  });
  console.log(students);
  return students;
}

async function addOrUpdateStudent(studentInfo) {
  let students = [];
  await axios
    .put(prefix, studentInfo)
    .then(async () => {
      console.log("Updated student successfully.");
      //Fetch students again to get updated values
      students = await getAllStudents();
    })
    .catch(() => {
      console.error("Failed to update student.");
    });
  return students;
}

async function deleteStudent(studentId) {
  console.log(prefix + studentId);
  await axios.delete(prefix + studentId);
}

export { getAllStudents, deleteStudent, addOrUpdateStudent };
