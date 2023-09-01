import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../css/Register.css';
import { signUp } from '../services/user-service';
const Register = () => {
  const [userNameId, setuserNameId] = useState('');
  const [email, setEmail] = useState('');
  const [encryptedPassword, setencryptedPassword] = useState('');
  const [errors, setErrors] = useState({});

  const handleSubmit = (e) => {
    e.preventDefault();

    const newErrors = {};

    if (!userNameId) {
      newErrors.name = 'Name is required';
    }

    if (!email || !/\S+@\S+\.\S+/.test(email)) {
      newErrors.email = 'Enter a valid email address';
    }

    if (!encryptedPassword || encryptedPassword.length < 6) {
      newErrors.password = 'Password must be at least 6 characters long';
    }


    if (Object.keys(newErrors).length > 0) {
      setErrors(newErrors);
      return;
    }
     signUp(e.Object).then((res)=>{
      console.log(res);
      console.log("success");
     }).catch((error)=>{
      console.log(error);
     })
  };

  return (
    <div className="registration-container">
      <div className="registration-form">
      <div style={{textAlign:"center"}}>
          <img src='./images/Logo.png' alt='logo'width={120}></img>
      </div>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>Name:</label>
            <input type="text" className="form-control" value={userNameId} onChange={(e) => setuserNameId(e.target.value)} />
            {errors.name && <p className="error-text">{errors.userNameId}</p>}
          </div>
          <div className="form-group">
            <label>Email:</label>
            <input type="email" className="form-control" value={email} onChange={(e) => setEmail(e.target.value)} />
            {errors.email && <p className="error-text">{errors.email}</p>}
          </div>
          <div className="form-group">
            <label>Password:</label>
            <input type="password" className="form-control" value={encryptedPassword} onChange={(e) => setencryptedPassword(e.target.value)} />
            {errors.password && <p className="error-text">{errors.encryptedPassword}</p>}
          </div>
    
          <div className="form-group" style={{textAlign:"center"}}>
            <button type="submit" className="btn btn-primary">Register</button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Register;
