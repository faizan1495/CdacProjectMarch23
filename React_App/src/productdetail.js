import axios from 'axios';

const API_BASE_URL = 'http://localhost:8023/api/users/product/all';
const fetchProducts = async () => {
    try {
      const response = await axios.get(API_BASE_URL);
      return response.data;
    } catch (error) {
      console.error('Error fetching products:', error);
      throw error;
    }
  };
const Productdetail = await fetchProducts();
    
export default Productdetail;