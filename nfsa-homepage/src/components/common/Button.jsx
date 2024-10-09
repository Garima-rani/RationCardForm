import React  from "react";
// import Spinner from "./Spinner";
export default function Button({
    children,
    type = "button",
    className = "",
    disabled , 
    loading , 
    ...props 
}) {

   
    if(loading ){
        return (
            <div  className={`w-fit  bg-[#127EDC] outline-none p-[8px] text-center  rounded-[8px] text-white hover:bg-[#00005A] ${disabled && "opacity-50"} ${className}`} {...props}>
           {/* <Spinner /> */}
           Loading...
        </div>
        )
    }
    return ( 
       
        <button type={type}  disabled = {disabled} className={`w-fit mb-2  bg-[#127EDC] outline-none py-[8px] px-[15px] text-center rounded-[8px] text-white hover:bg-[#00005A] ${disabled && "opacity-50"} ${className}`} {...props}>
            {children}
        </button>
    )
}