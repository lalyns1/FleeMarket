import {
    BrowserRouter as Router,
    Routes,
    Route,
  } from "react-router-dom"
import Login from "./routes/Login";
import Register from "./routes/Register";

function App() {
    
    return (
        <Router>
            <Routes>
                <Route path="/users/login" element={<Login />} />
                <Route path="/users/register" element={<Register />} />
            </Routes>
        </Router>
    );
}

  export default App;
  