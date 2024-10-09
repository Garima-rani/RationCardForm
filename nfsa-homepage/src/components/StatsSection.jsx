import React, { useEffect, useState } from 'react';
import './StatsSection.css';
import axios from 'axios';

const StatsSection = () => {
  const [stats, setStats] = useState([]) ;
  const fetchStats = async()=>{
    try{
    // const response = await axios.get("http://localhost:8080/api/stats") ;
    const response = await axios.get("http://localhost:8080/api/stats")
    // console.log(response);
    setStats(response.data);
    }catch(err){console.log(err)}

    
  }
  useEffect(() => {
   
     fetchStats()
  }, []);

  if (!stats || stats.length === 0) {
    return <div>No stats available</div>;
  }

  return (
    <div className="stats-container">
      {stats.map((item, index) => (
        <div key={index} className="stat-item">
          <div className="stat-content">
            <p className="stats-title">{item.title}</p>
            <p className="stats-value">{item.value}</p>
            <p className="stats-date">As on {new Date().toLocaleDateString()}</p>
          </div>
          <img src={item.icon} alt={item.title} className="stats-icon" />
        </div>
      ))}
    </div>
  );
};

export default StatsSection;
