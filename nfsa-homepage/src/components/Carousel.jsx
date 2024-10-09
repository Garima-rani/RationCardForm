import React from 'react';
import { Carousel } from 'react-responsive-carousel';
import 'react-responsive-carousel/lib/styles/carousel.min.css';
import './Carousel.css';

function CarouselComponent() {
  return (
    <div className="carousel-container">
      <Carousel
        showThumbs={false}
        autoPlay
        infiniteLoop
        interval={1000} // Adjust the interval to control the speed of the carousel
        showStatus={false}
      >
        <div>
          <img src="/Image1.png" alt="Image 1" />
        </div>
        <div>
          <img src="/Image2.png" alt="Image 2" />
        </div>
        <div>
          <img src="/Image3.png" alt="Image 3" />
        </div>
        <div>
          <img src="/Image4.png" alt="Image 4" />
        </div>
      </Carousel>
    </div>
  );
}

export default CarouselComponent;
