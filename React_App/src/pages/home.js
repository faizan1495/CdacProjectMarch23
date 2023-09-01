import React from 'react'
import { FiTruck } from 'react-icons/fi';
import { BsCurrencyRupee } from 'react-icons/bs';
import { CiPercent } from 'react-icons/ci';
import { BiHeadphone } from 'react-icons/bi';
import { AiOutlineShoppingCart, AiOutlineCloseCircle } from 'react-icons/ai';
import { BsEye } from 'react-icons/bs';
import Homeproduct from '../homeproduct';
import '../css/home.css'
import Mycarousel from '../components/Mycarousel';
const Home = ({detail, view, close, setClose, addtocart}) => {
  return (
    <>
        {
        close ?
        <div className='product_detail'>
        <div className='container'>
            <button onClick={() => setClose(false)} className='closebtn'><AiOutlineCloseCircle /></button>
            {
                detail.map((curElm) => 
                {
                    return(
                        <div className='productbox'>
                            <div className='img-box'>
                                <img src={curElm.Img} alt={curElm.Title}></img>
                            </div>
                            <div className='detail'>
                                <h4>{curElm.Cat}</h4>
                                <h2>{curElm.Title}</h2>
                                <h3>{curElm.Price}</h3>
                                <button onClick={() => addtocart (curElm)}>Add To Cart</button>
                            </div>
                        </div>
                    )
                })
            }
            <div className='productbox'></div>
        </div>
    </div> : null
    }
   <div style={{paddingBottom:"10px",paddingTop:"10px",paddingLeft:"10px",paddingRight:"10px"}}><Mycarousel/></div>
    <div className='product_type'>
      <div className='container'>
        <div className='box'>
          <div className='img_box'>
            <img src='./img/sev/GOD SEV.jpg' alt='Sev'></img>
          </div>
        </div>
        <div className='box'>
          <div className='img_box'>
            <img src='./img/bhujia/Mari Shig Bhujiya.jpg' alt='Bhujia'></img>
          </div>
        </div>
        <div className='box'>
          <div className='img_box'>
            <img src='./img/dal/chatpati chana dal.JPG' alt='Dal'></img>
          </div>
        </div>
        <div className='box'>
          <div className='img_box'>
            <img src='./img/chiwda/kolhapuri mix.JPG' alt='Chiwda'></img>
          </div>
        </div>
      </div>
    </div>
    <div className='about'>
      <div className='container'>
        <div className='box'>
          <div className='icon'>
            <FiTruck />
          </div>
          <div className='detail'>
          <h3>Free Shipping</h3>
            <p>Oder above ₹1000</p>
          </div>
        </div>
        <div className='box'>
          <div className='icon'>
            <BsCurrencyRupee />
          </div>
          <div className='detail'>
            <h3>Return & Refund</h3>
            <p>Money Back Gaurenty</p>
          </div>
        </div>
        <div className='box'>
          <div className='icon'>
            <CiPercent />
          </div>
          <div className='detail'>
            <h3>Member Discount</h3>
            <p>On every Oder</p>
          </div>
        </div>
        <div className='box'>
          <div className='icon'>
            <BiHeadphone />
          </div>
          <div className='detail'>
            <h3>Customer Support</h3>
            <p>Every Time Call Support</p>
          </div>
        </div>
      </div>
    </div>
    <div className='product'>
      <h2>Top Products</h2>
      <div className='container'>
        {
          Homeproduct.map((curElm) => 
          {
            return(
              <div className='box' key={curElm.id}>
                <div className='img_box'>
                  <img src={curElm.Img} alt={curElm.Title}></img>
                  <div className='icon'>
                    <li onClick={() => addtocart (curElm)}><AiOutlineShoppingCart /></li>
                    <li onClick={() => view (curElm)}><BsEye /></li>                                   
                  </div>
                </div>
                <div className='detail'>
                  <p>{curElm.Cat}</p>
                  <h3>{curElm.Title}</h3>
                  <h4>₹{curElm.Price}</h4>
                </div>
              </div>
            )
          })
        }
      </div>
    </div>
    </>
  )
}

export default Home