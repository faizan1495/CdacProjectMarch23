import React from 'react'
import { Routes, Route} from 'react-router-dom'
import Home from './home'
import Product from './product'
import Cart from './cart'
import Contact from './contact'
import About from './About'
import Shipping from './Shipping'
import Refund from './Refund'
import Terms from './Terms'
import Login from './Login'
import Register from './Register'
import AddressDetails from './AddressDetails'
import Cancle from './Cancle'
const Rout = ({product, setProduct, detail, view, close, setClose, cart, setCart, addtocart}) => {
  return (
    <>
    <Routes>
        <Route path='/' element={<Home detail={detail} view={view} close={close} setClose={setClose} addtocart={addtocart}/>}/>
        <Route path='/product' element={<Product product={product} setProduct={setProduct} detail={detail} view={view} close={close} setClose={setClose} addtocart={addtocart}/>} />
        <Route path='/cart' element={<Cart cart={cart} setCart={setCart} />} />
        <Route path='/contact' element={<Contact />} />
        <Route path='/about' element={<About />} />
        <Route path='/shipping' element={<Shipping />} />
        <Route path='/refund' element={<Refund />} />
        <Route path='/login' element={<Login />} />
        <Route path='/register' element={<Register />} />
        <Route path='/terms' element={<Terms />} />
        <Route path='/addressDetails' element={<AddressDetails />} />
        <Route path='/cancle' element={<Cancle />} />
    </Routes>
    </>
  )
}

export default Rout