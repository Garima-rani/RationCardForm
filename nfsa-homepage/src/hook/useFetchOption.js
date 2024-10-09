import axios from "axios";
import { useEffect, useState } from "react";

export const useFetchOptions = (endpoint) => {
    const [options, setOptions] = useState([]);
    const [loading, setLoading] = useState(true);
  
    useEffect(() => {
      const fetchOptions = async () => {
        try {
          console.log(endpoint , "endpoint") 
          const response = await axios.get("http://localhost:8080"+endpoint);
          setOptions(response.data);
          console.log(response.data) ; 
          
        } catch (error) {
          console.error("Error fetching options:", error);
        } finally {
          setLoading(false);
        }
      };
  
      fetchOptions();
    }, [endpoint]);
    return { options, loading  };
  };