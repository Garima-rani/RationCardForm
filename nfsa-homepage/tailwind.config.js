// tailwind.config.js
module.exports = {
  content: [
    './src/**/*.{js,jsx,ts,tsx}', // Update with your project's file paths
  ],
  theme: {
    extend: {
      // You can add other theme extensions here if needed
    },
  },
  plugins: [
    function ({ addUtilities }) {
      addUtilities({
        '.hide-scrollbar': {
       
          '&::-webkit-scrollbar': {
            display: 'none', // For Chrome, Safari, and Opera
          },
          '-ms-overflow-style': 'none', // For Internet Explorer and Edge
          'scrollbar-width': 'none', // For Firefox
        },
      });
    },
  ],
};
