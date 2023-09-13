import React from "react";
import {Link} from 'react-router-dom';

import '../styles/NavBar.css';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'

/* In HTML we use Hyperlink for Navigation - <a href="">
In ReactJS we use Router for Navigation */

const NavBar = () => {

    return(
        <nav className="navbar">
            <ul className="nav-list">
                <li className="nav-item">
                    <Link to="/register" className="nav-link">
                        <span><FontAwesomeIcon icon="camera-retro"></FontAwesomeIcon></span>&nbsp;
                        Register</Link>
                </li>

                <li className="nav-item">
                    <Link to="/login" className="nav-link">
                        <span><FontAwesomeIcon icon="sign-in"></FontAwesomeIcon></span>&nbsp;
                        Login</Link>
                </li>

                <li className="nav-item">
                    <Link to="/about" className="nav-link">About Us</Link>
                </li>
            </ul>
        </nav>
    );
}

export default NavBar;