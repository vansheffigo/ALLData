import React from "react";
import ListItem from "@mui/material/ListItem";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";
import List from "@mui/material/List";
import DashboardIcon from "@mui/icons-material/Dashboard";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";
import ReceiptLongIcon from '@mui/icons-material/ReceiptLong';
import { useLocation } from "wouter";
import { Link } from 'react-router-dom'; 


const menuItems = [
  {
    title: "Dashboard",
    path: "/",
    icon: <DashboardIcon />,
  },
  {
    title: "Retro Billing",
    path: "/retro",
    icon: <ReceiptLongIcon />,
  },
];

const DrawerMenu = ({ open }) => {
  const [location] = useLocation();
  const [selectedItem, setSelectedItem] = React.useState("");

  return (
    <List>
      {menuItems.map((menuItem) => {
        return (
          <ListItem
            disablePadding
            key={menuItem.title}
            sx={{ display: "block", borderLeft: "6px solid  transparent" }}
            onClick={() => setSelectedItem(menuItem.title)}
            className={location === menuItem.path ? "activeLink" : ""}
          >
            <Link
              to={menuItem.path}
              style={{ textDecoration: "none", display: "flex" }}
            >
              <ListItemButton
                sx={{
                  minHeight: 48,
                }}
              >
                <ListItemIcon
                  sx={{
                    minWidth: 0,
                    justifyContent: "center",
                  }}
                >
                  <Box py={1} pr={1} pl={0} alignItems={"center"}>
                    {menuItem.icon}
                  </Box>
                </ListItemIcon>
                <ListItemText
                  primary={<Typography>{menuItem.title}</Typography>}
                  sx={{ opacity: open ? 1 : 0, pl: 2 }}
                />
              </ListItemButton>
            </Link>
          </ListItem>
        );
      })}
    </List>
  );
};

export default DrawerMenu;
