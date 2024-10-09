import React from 'react';
//import './MainContent.css';

function MainContent() {
  return (
    <main className="main-content">
      <section className="hero-section">
        <h2>Welcome to NFSA</h2>
        <p>Ensuring food safety and standards for the nation.</p>
      </section>
      { <section className="info-section">
        <div className="info-box">
          <h3>Our Mission</h3>
          <p>To ensure safe and wholesome food for all.</p>
        </div>
        <div className="info-box">
          <h3>Latest News</h3>
          <p>Stay updated with the latest developments.</p>
        </div>
        <div className="info-box">
          <h3>Resources</h3>
          <p>Access various resources and guidelines.</p>
        </div>
      </section> }
    </main>
  );
}

export default MainContent;
