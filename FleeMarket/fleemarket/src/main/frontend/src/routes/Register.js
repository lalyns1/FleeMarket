import {ReactComponent as Logo} from "../assets/images/logo.svg";
import {Form} from 'react-bootstrap';
import styles from "../assets/styles/login.module.css";
import React, {useState, useEffect} from "react";
import axios from "axios";

import propType from "prop-types";
import { Link } from "react-router-dom";


function Register () {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [checked, setChecked] = useState(false);

    const getUsername = (event) => {
        setUsername(event.target.value);
        setChecked(false);
    };
    const getPassword = (event) => setPassword(event.target.value);
    
    const Register = (username, password) => {
        var data = JSON.stringify({
            "username": username,
            "password": password
        });

        var config = {
            method: 'post',
            url: 'http://localhost:8080/api/users/register',
            headers: { 
                'Content-Type': 'application/json'
            },
            data : data
        };

        axios(config)
        .then(function (response) {
            console.log(JSON.stringify(response.data));
        })
        .catch(function (error) {
            console.log("hi error");
            alert(error.response.data.message);
        });
    }

    const checkDuple = (username) => {
        var data = JSON.stringify({
            "username": username,
            "password": ""
        });

        var config = {
            method: 'post',
            url: 'http://localhost:8080/api/users/register/check',
            headers: { 
                'Content-Type': 'application/json'
            },
            data : data
        };

        axios(config)
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            const check = !response.data.data;
            if(check) {
                alert("사용 가능한 Username 입니다.");
                setChecked(true);

                console.log(checked);
            }
            else {
                alert("중복된 Username이 존재합니다.");
                setChecked(false);
            }
        })
        .catch(function (error) {
            alert(error.response.data.message);
        });
    }

    const handleSummit = (e) => {
        e.preventDefault();
        checkDuple(username);
    };

    Register.propType = {
        username: propType.string.isRequired,
        password: propType.string.isRequired
    }

    return (
        <div className={styles.login_box}>   
            <div className={styles.login_form}>
            <div className={styles.brand_logo}>
                <Logo alt="logo" />
            </div>
            <h4> 회원가입 </h4>
            <h6 className={styles.font_wight_light}> 회원가입 </h6>
            <div className={styles.form_box}>
                <Form onSubmit={handleSummit}>
                    <Form.Group>
                        <Form.Control
                        value={username}
                        type="text"
                        placeholder="Username"
                        size="lg"
                        className={styles.form_input}
                        onChange={getUsername}
                        />
                        <button> 중복 확인 </button>
                    </Form.Group>
                    

                    <br>
                    </br>
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
            </div>
            
                <div>
                    <button 
                     disabled={!checked}
                     value="signup"
                     onClick={ (event) => {{Register(username,password)}}}
                     className ={styles.form_button}
                    > SIGN UP </button>
                </div>
            </div>

            <Link to="/users/Login">Login 페이지로 돌아가기</Link>
        </div>
    );
}

export default Register;