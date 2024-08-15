import React, { useId } from "react";

const Input = React.forwardRef(function Input(
  {
    label = "",
    required,
    type = "text",
    className = "",
    labelClassName = "",
    name = "",
    errors,
    $id , 
    disabled = false , 
    readOnly = false,
    ...props
  },
  ref
) {
  const id = useId();
  return (
    <div className={` relative  mb-2 `}>
      <label
        className={`   ${labelClassName}`}
        htmlFor={$id ? $id : id}
      >
        {label}
        {required && <span className="text-red-500 text-[18px]">{" "}*</span>}
      </label>
      <div className="relative ">
        <input
          name={name}
          type={type}
          readOnly={readOnly}
          disabled ={disabled}
          className={` bg-[--input-background] border border-[--border-color] p-[8px] pl-[12px] rounded-[3px]   w-full hover:border-[#838894] outline-none ${className} 
            ${  readOnly ? "text-opacity-50" : ""  }  ${  disabled ? "bg-gray-300" : ""  }`}
          ref={ref}
          {...props}
          id={$id ? $id : id}
        />
      </div>
      {errors && (
        <span className="ml-2 text-xs tracking-wide text-red-500">
          {` ${errors.message}`}
        </span>
      )}
    </div>
  );
});

export default Input;


// ${
//             icon ? "pl-[40px]" : ""
//           }