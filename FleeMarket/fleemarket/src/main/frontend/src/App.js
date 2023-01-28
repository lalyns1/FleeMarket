import logo from './logo.svg';
import './App.css';
import axios from 'axios';
axios.defaults.baseURL = "http://localhost:8080";

function App() {
  function login(res) {
    console.log(res);
    res.data.data.get("");

    return "aa";
  }

  function setValue(res) {
    var username;
    username = res;
  }

  function getValue() {
    return username;
  }

  axios.get("/index")
      .then(login).then()
      .catch()
      .finally();

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
