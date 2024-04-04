import React from "react";
import { ThemeProvider } from '@mui/material/styles';
import { styled, createTheme } from "@mui/material/styles"; 
import MuiDrawer from "@mui/material/Drawer";
import MuiAppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import IconButton from "@mui/material/IconButton";
import { Stack, Box } from "@mui/material";
import Avatar from "@mui/material/Avatar";
import effigo_logo from "../assets/icons/effigo_logo.svg";
import PoweredByLogo from "../assets/icons/powered_by.svg";
import NotificationsOutlinedIcon from "@mui/icons-material/NotificationsOutlined";
import DrawerMenu from "./DrawerMenu";

const drawerWidth = 220;

const openedMixin = (theme) => ({
  width: drawerWidth,
  transition: theme.transitions.create("width", {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.enteringScreen,
  }),
  overflowX: "hidden",
});

const closedMixin = (theme) => ({
  transition: theme.transitions.create("width", {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.leavingScreen,
  }),
  overflowX: "hidden",
  width: `calc(${theme.spacing(7)} + 1px)`,
  [theme.breakpoints.up("sm")]: {
    width: `calc(${theme.spacing(8)} + 1px)`,
  },
});

const AppBar = styled(MuiAppBar)(({ theme, open }) => ({
  zIndex: theme.zIndex.drawer + 1,
  marginLeft: open ? drawerWidth : 0,
  transition: theme.transitions.create(["width", "margin"], {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.leavingScreen,
  }),
}));

const Drawer = styled(MuiDrawer)(({ theme, open }) => ({
  width: drawerWidth,
  flexShrink: 0,
  whiteSpace: "nowrap",
  boxSizing: "border-box",
  ...(open && {
    ...openedMixin(theme),
    "& .MuiDrawer-paper": openedMixin(theme),
  }),
  ...(!open && {
    ...closedMixin(theme),
    "& .MuiDrawer-paper": closedMixin(theme),
  }),
}));

const drawerTheme = createTheme({
  components: {
    MuiDrawer: {
      styleOverrides: {
        paper: {
          backgroundColor: "white",
          boxShadow: "5px 0px 5px 0px rgba(0, 0, 0, 0.06)",
        },
      },
    },
  },
});

const DrawerHeader = styled("div")(({ theme }) => ({
  display: "flex",
  alignItems: "center",
  justifyContent: "flex-end",
  padding: theme.spacing(0, 1),
  ...theme.mixins.toolbar,
}));

const Layout = () => {
  const [open, setOpen] = React.useState(false);

  const extractInitials = (fullName) => {
    const nameParts = fullName.split(" ");
    if (nameParts.length > 1) {
      const firstNameInitial = nameParts[0].charAt(0).toUpperCase();
      const lastNameInitial = nameParts[1].charAt(0).toUpperCase();
      return `${firstNameInitial}${lastNameInitial}`;
    } else {
      return nameParts[0].charAt(0).toUpperCase();
    }
  };

  return (
    <>
      <Box className="effigo-navbar">
        <ThemeProvider theme={drawerTheme}>
          <Drawer
            variant="permanent"
            open={open}
            onMouseEnter={() => setOpen(true)}
            onMouseLeave={() => setOpen(false)}
          >
            <DrawerHeader />
            <DrawerMenu open={open} />
            <Stack position="absolute" bottom={30} marginLeft={1}>
            <img src={PoweredByLogo} alt="Powered by" /> 
            </Stack>
          </Drawer>
        </ThemeProvider>
        <AppBar position="fixed" open={open} color="inherit">
          <Toolbar>
            <Stack>
            <img src={effigo_logo} alt="Powered by" /> 
            </Stack>
            <Stack
              direction="row"
              justifyContent="flex-end"
              width={"100%"}
              alignItems="center"
              gap={1}
            >
              <IconButton color="primary">
                <NotificationsOutlinedIcon />
              </IconButton>
              <Avatar
                sx={{
                  fontSize: "16px",
                  height: "34px",
                  width: "34px",
                  color: "black",
                  backgroundColor: "rgba(28, 61, 114, 0.10)",
                }}
                alt=""
              >
                {/* You'll likely replace "U" with initials */}
                U 
              </Avatar>
            </Stack>
          </Toolbar>
        </AppBar>
      </Box>
    </>
  );
};

export default Layout;

