import React, { Component } from 'react'
import '../css/cancle.css';
import Button from 'react-bootstrap/Button';
export class Cancle extends Component {
  render() {
    return (
      <>
      <div className='cancle'>
      <h1>  Oder Is Cancelled </h1>
      <img src='./images/thank you.png' alt='logo' id="thank" ></img>
      <br/> <br/> <br/> <br/>

      <Button className='btn' onClick={()=>window.location.href='/'}>Back to Home</Button>
      </div>
      </>
    )
  }
}

export default Cancle