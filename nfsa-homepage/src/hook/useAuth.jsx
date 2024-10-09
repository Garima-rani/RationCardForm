import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const useAuth = () => {
  const [authenticated, setAuthenticated] = useState(false);
  const [loading, setLoading] = useState(true); // Added loading state
  const navigate = useNavigate();

  useEffect(() => {
    const checkAuth = async () => {
      try {
        
        const response = await axios.get('http://localhost:8080/api/auth/check', { 
          withCredentials: true
        });
        if (response.status === 200) {
          setAuthenticated(true);
        } else {
          setAuthenticated(false);
          navigate('/official-login'); // Redirect to login if not authenticated
        }
      } catch (error) {
        console.error('Authentication check failed:', error); // Improved error logging
        setAuthenticated(false);
        navigate('/official-login'); // Redirect to login if there's an error
      } finally {
        setLoading(false); // Stop loading once check is complete
      }
    };

    checkAuth();
  }, [navigate]);

  if (loading) {
    return null; // Or a loading spinner if preferred
  }

  return authenticated;
};

export default useAuth;
