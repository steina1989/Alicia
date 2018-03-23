import React from 'react';
import { Link } from 'react-router-dom';
import './Header.css';


const Header = props => (
    <div className="Navbar">
        <header>
            <nav>
                <ul>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/about">About</Link>
                    </li>
                    <li>
                        <Link to="/course" onClick={props.courseHandler} >Courses</Link>
                    </li>
                </ul>
            </nav>
        </header>
    </div>);


export default Header;
