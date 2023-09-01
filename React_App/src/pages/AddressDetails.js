import React from 'react';
// import {order} from "../services/Order-Service.js"
// import {toast} from 'react-toastify'
import '../css/address.css';
import Button from 'react-bootstrap/Button';
import {  MDBCard, MDBCardBody, MDBCardImage, MDBCol, MDBContainer, MDBIcon, MDBInput, MDBRow, MDBTypography } from 'mdb-react-ui-kit';

export default function AddressDetails() {

    
   
  return (
    <MDBContainer className="py-5" style={{ maxWidth: '1100px' }}>
      <MDBRow className="justify-content-center align-items-center">
        <MDBCol>
          <MDBCard className="my-4 shadow-3">
            <MDBRow className="g-0">
              <MDBCol md="6" className="d-xl-block bg-image">
                <MDBCardImage src="https://mdbcdn.b-cdn.net/img/Others/extended-example/delivery.webp" alt="Sample photo" fluid />
                <div className='mask' style={{ backgroundColor: 'rgba(0, 0, 0, 0.6)' }}>
                  <div className="justify-content-center align-items-center h-100">
                    <div className="text-center" style={{ marginTop: '220px' }}>
                      <MDBIcon fas icon="truck text-white" size="3x" />
                      <p className="text-white title-style">Lorem ipsum delivery</p>
                      <p className="text-white mb-0"></p>
                      <figure className="text-center mb-0">
                        <blockquote className="blockquote text-white">
                          <p className="pb-3">
                            <MDBIcon fas icon="quote-left text-primary" size="xs" style={{color: 'hsl(210, 100%, 50%)'}} />
                            <span className="lead font-italic">Everything at your doorstep.</span>
                            <MDBIcon fas icon="quote-right text-primary" size="xs" style={{color: 'hsl(210, 100%, 50%)'}} />
                          </p>
                        </blockquote>
                      </figure>
                    </div>
                  </div>
                </div>
              </MDBCol>
            
              <MDBCol md="6">
                <MDBCardBody className="p-md-5 text-black">
                  <MDBTypography tag="h3" className="mb-4 text-uppercase">Delivery Info</MDBTypography>

                  <MDBRow>
                    <MDBCol md="6" className="mb-4">
                      <MDBInput label='Address Line 1' type='text' size="lg" />
                    </MDBCol>
                    <MDBCol md="6" className="mb-4">
                      <MDBInput label='Address Line 2' type='text' size="lg" />
                    </MDBCol>
                  </MDBRow>

                  <MDBInput label='Phone Number' type='text' className="mb-4" size="lg" />

                  <MDBRow>
                    <MDBCol md="6" className="mb-4">
                      <MDBInput label='State' type='text' size="lg" />
                    </MDBCol>
                    <MDBCol md="6" className="mb-4">
                      <MDBInput label='City' type='text' size="lg" />
                    </MDBCol>
                  </MDBRow>

                  <MDBInput label='Zip' type='text' className="mb-4" size="lg" />


                  <div className="d-flex justify-content-end pt-3">
                    {/* <MDBBtn size="lg" className="ms-2" style={{backgroundColor: 'hsl(210, 100%, 50%)'}}>Payment</MDBBtn> */}
                    </div>
                    <Button className='btn' onClick={()=>window.location.href='/payment'}>Payment</Button>
                    <br/>
                   < br/>
          
                   <Button className='btn' onClick={()=>window.location.href='/cancle'}>Cancle</Button>
                  </MDBCardBody>
                </MDBCol>
              </MDBRow>
            </MDBCard>
          </MDBCol>
        </MDBRow>
      </MDBContainer>
    );
  }