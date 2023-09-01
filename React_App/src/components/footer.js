import React from 'react'
import '../css/footer.css'
import {AiOutlineMail} from 'react-icons/ai';
import {BsFillTelephoneFill} from 'react-icons/bs'
const Footer = () => {
  return (
    <>
    <div className='footer'>
        <div className='container'>
            <div className='about'>
                <div className='logo'>
                <img  src='images/Logo.png' alt="Logo" width="80px" length="30px" /><br/>
                </div>
                <div className='detail'>   
                 <b>Address:</b>
                 <p>
                     Galawade Road, Dajiba Nagar, MH SH 6, Dajiba Nagar, Amalner, Maharashtra 425401.
                </p>
               <AiOutlineMail/>&nbsp; swadistnamkin@gmail.com <br/>
               <BsFillTelephoneFill/>&nbsp; 8669880088
                </div>
            </div>
            <div className='account'>
            <b>INFORMATION</b><br/><br/>     
             <ul>
                <li>
                    <a href='terms'>Terms & Conditions</a>
                </li><br/><br/>
                <li>
                    <a href='shipping'>Shipping Policy</a>
                </li><br/><br/>
                <li>
                    <a href='refund'>Cancellation/Refund</a>
                </li>
             </ul>
            </div>
            <div className='page'>
            <b>QUICK LINKS</b><br/><br/> 
                <ul>
                     <li><a href="/">Home</a></li><br/><br/> 
                     <li><a href="contact">Contact us</a></li><br/><br/> 
                     <li><a href="about">About us</a></li>
               </ul>   
            </div>
        </div>
    </div>
    </>
  )
}

export default Footer