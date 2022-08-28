import "./App.css";
import { getAllStudents } from "./services/StudentService";
import Layout from "./wrapper/Layout";
import Table from "./components/Table";
import { useEffect, useState, createContext } from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import AddOrEditStudentPage from "./components/pages/AddOrEditStudentPage";
export const studentContext = createContext();
function App() {
  const [students, setStudents] = useState([]);
  useEffect(() => {
    async function fetchData() {
      setStudents(await getAllStudents());
    }
    fetchData();
  }, []);
  return (
    <Layout>
      <studentContext.Provider value={{ students, setStudents }}>
        <Router>
          <Routes>
            <Route path="/" exact element={<Table />} />
            <Route
              path="/editStudent"
              exact
              element={<AddOrEditStudentPage />}
            />
          </Routes>
        </Router>
      </studentContext.Provider>
    </Layout>
  );
}

export default App;
