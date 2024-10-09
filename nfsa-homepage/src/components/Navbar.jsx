import React from 'react';
import './Navbar.css';

const Navbar = () => {
    return (
        <div className="navbar-container">

            <div className="navbar-icon">
                <img src="/lms-logo.jpg" alt="Icon1" />
                <p>Learning Management System</p>
            </div>
           
            <div className="navbar-icon">
                <img src="/FPS-logo.png" alt="Icon1" />
                <p> Fair Price Shop </p>
            </div>
            <div className="navbar-icon">
                <img src="/Rc-logo.png" alt="Icon1" />
                <p>Ration Cards </p>
            </div>

            <div className="navbar-icon">
                <img src="/Allo-logo.jpeg" alt="Icon1" />
                <p>Allocation </p>
            </div>

            <div className="navbar-icon">
                <img src="/Annavitran-logo.png" alt="Icon1" />
                <p>Annavitran </p>
            </div>

            <div className="navbar-icon">
                <img src="/Citizen-logo.png" alt="Icon1" />
                <p> Citizen Corner</p>
            </div>

            <div className="navbar-icon">
                <img src="/IMPDS-logo.png" alt="Icon1" />
                <p>IMPDS </p>
            </div>

            <div className="navbar-icon">
                <img src="/Dbt-logo.png" alt="Icon1" />
                <p> D. B. T.</p>
            </div>
            
            <div className="search-bar">
                <input type="text" placeholder="Search - Keyword" />
                <button>Search</button>
            </div>
        </div>
    );
};

export default Navbar;
