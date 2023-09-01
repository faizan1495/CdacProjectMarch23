import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../css/Login.css';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errors, setErrors] = useState({});

  const handleSubmit = (e) => {
    e.preventDefault();

    const newErrors = {};

    if (!email || !/\S+@\S+\.\S+/.test(email)) {
      newErrors.email = 'Enter a valid email address';
    }

    if (!password || password.length < 6) {
      newErrors.password = 'Password must be at least 6 characters long';
    }

    if (Object.keys(newErrors).length > 0) {
      setErrors(newErrors);
      return;
    }

    // Validation passed, you can proceed with login logic here
  };

  return (
    <div className="login-container">
      <div className="login-form">
      <div style={{textAlign:"center"}}>
          <img src='./images/Logo.png' alt='logo'width={120}></img>
      </div>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>Email:</label>
            <input type="email" className="form-control" value={email} onChange={(e) => setEmail(e.target.value)} />
            {errors.email && <p className="error-text">{errors.email}</p>}
          </div>
          <div className="form-group">
            <label>Password:</label>
            <input type="password" className="form-control" value={password} onChange={(e) => setPassword(e.target.value)} />
            {errors.password && <p className="error-text">{errors.password}</p>}
          </div>
          <div className="form-group" style={{textAlign:"center"}}>
            <button type="submit" className="btn btn-primary">Login</button>
          </div>
          <div style={{textAlign:"center"}}>
          <h5>Don't have an account? </h5>
          <a href='/register'>Register</a>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Login;
