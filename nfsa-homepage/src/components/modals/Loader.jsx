import { Box } from '@mui/material'
import React from 'react'

function Loader() {
  return (
    <Box
    sx={{
        position: "absolute",
        top: "50%",
        left: "50%",
        transform: "translate(-50%, -50%)",
        bgcolor: "gray",
        boxShadow: 24,
    }}
>
    <div className="bg-[whitesmoke] w-full p-5 flex flex-col gap-10 rounded-md h-full overflow-auto">
    <div class="border-gray-300 h-20 w-20 animate-spin rounded-full border-8 border-t-blue-600" />
    </div></Box>
  )
}

export default Loader