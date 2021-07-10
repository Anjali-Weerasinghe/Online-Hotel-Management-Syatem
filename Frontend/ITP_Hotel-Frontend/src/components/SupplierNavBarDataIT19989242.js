import React from 'react'
import* as BsIcons from "react-icons/bs";
import* as MdIcons from "react-icons/md";
import* as BiIcons from "react-icons/bi";
import* as CgIcons from "react-icons/cg";
import* as FaIcons from "react-icons/fa";
import* as IconName  from "react-icons/ai";
import* as IoIcons  from "react-icons/io5";



export const SidebarData=[
    {
        title:'Home',
        path:'/',
        icon:<IconName.AiFillHome/>,
        cName:'nav-text'
    },

    {
        title:'Supplier List',
        path:'/view-supplier',
        icon:<BsIcons.BsFillPersonLinesFill/>,
        cName:'nav-text'
        
    },
    {
        title:'Add Supplier ',
        path:'/supplier',
        icon:<IoIcons.IoPersonAdd/>,
        cName:'nav-text'
        
    },

    {
        title:'Purchased Item List',
        path:'/view-purchaseditem',
        icon:<FaIcons.FaTruck/>,
        cName:'nav-text'
    },
    {
        title:'Add Purchased Item',
        path:'/purchaseditem',
        icon:<BsIcons.BsCardList/>,
        cName:'nav-text'
    },
   
    {
        title:'Sign Out',
        path:'/',
        icon:<FaIcons.FaSignOutAlt/>,
        cName:'nav-text'
    },
]
