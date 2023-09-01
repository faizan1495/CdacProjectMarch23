
import React from 'react'
import { Carousel, Col, Container, Row } from 'react-bootstrap'
function Mycarousel() {
  return (
    <>
        <Container fluid>
            <Row>
                <Col>
                  <Carousel>
                    <Carousel.Item>
                         <img className='d-block w-100' src='images/image1.png' alt=''/>
                    </Carousel.Item>
                    <Carousel.Item>
                         <img className='d-block w-100' src='images/image2.png' alt=''/>
                    </Carousel.Item>
                    <Carousel.Item>
                         <img className='d-block w-100' src='images/image4.png' alt=''/>
                    </Carousel.Item>
                  </Carousel>
                </Col>
            </Row>
        </Container>
    </>
  )
}

export default Mycarousel
