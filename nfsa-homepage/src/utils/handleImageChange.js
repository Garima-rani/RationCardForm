export const handleImageChange = async (event , methods , name , setLoading) => {
    const file = event.target.files[0];
    setLoading(true);
    if (file) {
      const formData = new FormData();
      formData.append('file', file);
      formData.append('upload_preset', 'garimaCloud'); // Replace with your upload preset
      
      try {
        const response = await fetch(`https://api.cloudinary.com/v1_1/dyavtbarf/image/upload`, {
          method: 'POST',
          body: formData,
        });
        const result = await response.json();
        console.log(result) ; 
        methods.setValue(name ,result.secure_url);
        setLoading(false) ;
      } catch (error) {
        console.error('Error uploading image:', error);
        setLoading(false) ;
      }
    }
  };


  export const handleDocumentChange = async (event, methods, name, setLoading) => {
    const file = event.target.files[0];
    console.log(event.target.files) ;
    setLoading(true);
    
    if (file) {
      const formData = new FormData();
      formData.append('file', file);
      formData.append('upload_preset', 'garimaCloud'); // Replace with your document-specific preset
      
      try {
        const response = await fetch(`https://api.cloudinary.com/v1_1/dyavtbarf/raw/upload`, {
          method: 'POST',
          body: formData,
        });
        const result = await response.json();
        console.log(result);
        methods.setValue(name, result.secure_url); // Set document URL
        setLoading(false);
      } catch (error) {
        console.error('Error uploading document:', error);
        setLoading(false);
      }
    }
  };
  