import React from 'react';
import { Link } from 'react-router-dom';
import './Header.css';


const Header = () => (
    <div className="Navbar">
        <header>
            <nav>
                <ul>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/grader/1">Grader</Link>
                    </li>
                    <li>
                        <Link to="/about">About</Link>
                    </li>
                </ul>
            </nav>
        </header>
    </div>);


export default Header;
