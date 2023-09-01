import React from 'react'
import { AiOutlineShoppingCart } from 'react-icons/ai';
import { BsEye } from 'react-icons/bs';
import { AiOutlineCloseCircle } from 'react-icons/ai';
import { useAuth0 } from "@auth0/auth0-react";
import Productdetail from '../productdetail'
import '../css/product.css'
const Product = ({product, setProduct, detail, view, close, setClose, addtocart}) => {


    const { loginWithRedirect,isAuthenticated} = useAuth0();
    const filtterproduct = (product) =>
    {
        const update = Productdetail.filter((x) => 
        {
           return x.cat === product;
        })
        setProduct(update);
    }
    const AllProducts = () => 
    {
        setProduct(Productdetail)
    }
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
                                <img src={curElm.img} alt={curElm.Title}></img>
                            </div>
                            <div className='detail'>
                                <h4>{curElm.cat}</h4>
                                <h2>{curElm.title}</h2>
                                <h3>₹{curElm.price}</h3>
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
    <div className='products'>
        <h2># Products</h2>
        <p>Home . products</p>
        <div className='container'>
            <div className='filter'>
                <div className='categories'>
                    <h3>categories</h3>
                    <ul>
                    <li onClick={() => AllProducts ()}>All Products</li>
                        <li onClick={() => filtterproduct ("Bhujia")}>Bhujia</li>
                        <li onClick={() => filtterproduct ("Chivda")}>Chivda</li>
                        <li onClick={() => filtterproduct ("Dal")}>Dal</li>
                        <li onClick={() => filtterproduct ("Sev")}>Sev</li>
                        <li onClick={() => filtterproduct ("Sweet")}>Sweet</li>
                        <li onClick={() => filtterproduct ("Other")}>Other</li>

                    </ul>
                </div>
            </div>
            <div className='productbox'>
                <div className='contant'>
                    {
                        product.map((curElm) => 
                        {
                            return(
                                <>
                                    <div className='box' key={curElm.id}>
                                        <div className='img_box'>
                                          <img src={curElm.img} alt={curElm.title}></img>
                                          <div className='icon'>
                                            {
                                                isAuthenticated ? 
                                                <li onClick={() => addtocart (curElm)}><AiOutlineShoppingCart /></li>
                                                :
                                                <li onClick={() => loginWithRedirect()}><AiOutlineShoppingCart /></li>
                                            }
                                            <li onClick={() => view (curElm)}><BsEye /></li>                                
                                          </div>
                                        </div>
                                        <div className='detail'>
                                          <p>{curElm.cat}</p>
                                          <h3>{curElm.title}</h3>
                                          <h4>₹{curElm.price}</h4>
                                        </div>
                                      </div>
                                </>
                            )
                        })
                    }
                </div>
            </div>
        </div>
    </div>
    </>
  )
}

export default Product