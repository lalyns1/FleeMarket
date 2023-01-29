import {ReactComponent as Logo} from "../assets/images/logo.svg";
import {Form} from 'react-bootstrap';
import styles from "../assets/styles/login.module.css";
import {useState, useEffect} from "react";
import axios from "axios";

import { Link } from "react-router-dom";

function Login () {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const getUsername = (event) => setUsername(event.target.value);
    const getPassword = (event) => setPassword(event.target.value);
    
    const SignIn = (username, password) => {
        var data = JSON.stringify({
            "username": username,
            "password": password
        });

        var config = {
            method: 'post',
            url: 'http://localhost:8080/api/users/login',
            headers: { 
                'Content-Type': 'application/json'
            },
            data : data
        };

        console.log(config.headers)

        axios(config)
        .then(function (response) {
            console.log(JSON.stringify(response.data));
        })
        .catch(function (error) {
            console.log("hi");
        });
    }

    return (
        <div className={styles.login_box}>   
            <div className={styles.login_form}>
            <div className={styles.brand_logo}>
                <Logo alt="logo" />
            </div>
            <h4> Hello! let's get started </h4>
            <h6 className={styles.font_wight_light}> Sign in to continue. </h6>
            <Form>
                <Form.Group>
                    <Form.Control
                     value={username}
                     type="text"
                     placeholder="Username"
                     size="lg"
                     className={styles.form_input}
                     onChange={getUsername}
                     />
                     
                </Form.Group>
                <Form.Group>
                    <Form.Control
                     value={password}
                     type="password"
                     placeholder="Password" 
                     size="lg" 
                     className={styles.form_input}
                     onChange={getPassword}
                     />
                </Form.Group>
            </Form>
                <div>
                    <button 
                     onClick={ (event) => {{SignIn(username,password)}}}
                     className ={styles.form_button}
                    > SIGN IN </button>
                </div>
            </div>
            
            <Link to="/users/Register">회원 가입 하러 가기</Link>
        </div>
    );
}

export default Login;