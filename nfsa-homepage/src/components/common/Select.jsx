import React, { useId } from "react";

function Select(
  {
    options,
    label,
    placeholder = "",
    className,
    labelClassName,
    errors,
    disabled = false,
    readOnly = false,
    required,
    k="" , 
    ...props
  },
  ref
) {
  const id = useId();

  return (
    <div className={`w-full mb-2  `}>
      <label htmlFor={id} className={` ${labelClassName} `}>
        {label}
        {required ? (
          <span className="text-red-500 text-[18px]"> *</span>
        ) : (
          <span className="text-red-500 text-[18px]"> </span>
        )}
      </label>
      <div className="relative">
        <select
          ref={ref}
          readOnly ={readOnly}
          id={id}
          disabled={disabled ? true : false}
          {...props}
          className={` bg-[--input-background] capitalize border border-[--border-color] p-[8px]  rounded-[3px]  w-full hover:border-[#838894] outline-none ${className} 
            ${readOnly ? "text-opacity-50" : ""} ${
            disabled ? "bg-gray-300" : ""
          } `}
        >
          <option value="">{placeholder ? placeholder : "Select One"}</option>
          {options?.map((option, i) => {
            
            return(
            <option className="capitalize" key={i} value={option?.name?.toLowerCase() || option?.stateName || option?.languageName ||   option}>
              {option?.name || option?.stateName || option?.languageName || option[k] || option}
            </option>
          )})}
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
