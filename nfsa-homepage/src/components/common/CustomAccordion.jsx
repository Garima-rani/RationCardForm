import React from 'react';

import {
    Accordion,
    AccordionItem,
    AccordionItemHeading,
    AccordionItemButton,
    AccordionItemPanel,
} from 'react-accessible-accordion';

// Demo styles, see 'Styles' section below for some notes on use.
import 'react-accessible-accordion/dist/fancy-example.css';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { setName } from '../../redux/slices/masterSlice';

export default function CustomAccordion() {
  const navigate = useNavigate()
  const dispatch = useDispatch() ;
    return (
        <Accordion allowZeroExpanded>
            <AccordionItem>
                <AccordionItemHeading>
                    <AccordionItemButton>
                       Master
                    </AccordionItemButton>
                </AccordionItemHeading>
                <AccordionItemPanel>
                <Accordion allowZeroExpanded>
            <AccordionItem>
                <AccordionItemHeading>
                    <AccordionItemButton>
                       
                       National Master
                    </AccordionItemButton>
                </AccordionItemHeading>
                <AccordionItemPanel  onClick={()=>{ dispatch(setName("commodity-group")) ;navigate("/master/data")}}>
                  Commodity Groups
                </AccordionItemPanel>
                <AccordionItemPanel  onClick={()=>{ dispatch(setName("languages")) ;navigate("/master/data")}}>
                  Language Master
                </AccordionItemPanel>
                <AccordionItemPanel  onClick={()=>{ dispatch(setName("states")) ;navigate("/master/data")}}>
                  States Master
                </AccordionItemPanel>
                <AccordionItemPanel  onClick={()=>{ dispatch(setName("colors")) ;navigate("/master/data")}}>
                  Color Master
                </AccordionItemPanel>
                <AccordionItemPanel  onClick={()=>{ dispatch(setName("commodity-forms")) ;navigate("/master/data")}}>
                  Commodity Form Master
                </AccordionItemPanel>
                <AccordionItemPanel  onClick={()=>{ dispatch(setName("procurement-types")) ;navigate("/master/data")}}>
                  ProcurementType Master
                </AccordionItemPanel>
                <AccordionItemPanel  onClick={()=>{ dispatch(setName("ownership-types")) ;navigate("/master/data")}}>
                  OwnershipType Master
                </AccordionItemPanel>
                <AccordionItemPanel  onClick={()=>{ dispatch(setName("categories")) ;navigate("/master/data")}}>
                  CategoryType Master
                </AccordionItemPanel>
                <AccordionItemPanel  onClick={()=>{ dispatch(setName("measurement-units")) ;navigate("/master/data")}}>
                  Measurement Unit Master
                </AccordionItemPanel>
                <AccordionItemPanel  onClick={()=>{ dispatch(setName("cropseasons")) ;navigate("/master/data")}}>
                  Crop Season Master
                </AccordionItemPanel>
                <AccordionItemPanel  onClick={()=>{ dispatch(setName("modules")) ;navigate("/master/data")}}>
                  Module Master
                </AccordionItemPanel>
                <AccordionItemPanel  onClick={()=>{ dispatch(setName("commodities")) ;navigate("/master/data")}}>
                  Commodity Master
                </AccordionItemPanel>
            </AccordionItem>
          
        </Accordion>
                </AccordionItemPanel>
            </AccordionItem>
          
        </Accordion>
    );
}