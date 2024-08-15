import React, { useId } from "react";

function Select(
  {
    options,
    label,
    placeholder = "",
    className,
    labelClassName,
    errors,
    disabled=false , 
    readOnly = false , 
    required,
    ...props
  },
  ref
) {
  const id = useId();

  return (
    <div className={`w-full mb-2  `}>
      <label htmlFor={id} className={` ${labelClassName} `}>
        {label}
        {required && <span className="text-red-500 text-[18px]">{" "}*</span>}
      </label>
      <div className="relative">
      
          <select
            ref={ref}
            id={id}
            disabled = {disabled ?  true :  false }
            {...props}
            className={` bg-[--input-background] border border-[--border-color] p-[8px]  rounded-[3px]  w-full hover:border-[#838894] outline-none ${className} 
            ${  readOnly ? "text-opacity-50" : ""  } ${  disabled ? "bg-gray-300" : ""  } `}
          >
            <option value="">
              {placeholder ? placeholder : "Select One"}
            </option>
            {options?.map((option, i) => (
              <option key={i} value={option.toLowerCase()}>
                {option}
              </option>
            ))}
            
          </select>
      

      </div>

      {errors && (
        <span className="ml-2 text-xs tracking-wide text-red-500">
          {` ${errors.message}`}
        </span>
      )}
    </div>
  );
}

export default React.forwardRef(Select);
