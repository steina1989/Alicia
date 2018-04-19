import React from 'react';
import { NavLink } from 'react-router-dom';
import './Header.css';

const Header = props => {
  return (
    <div className="Navbar">
      <header>
        <nav>
          <ul>
            <li>
              <NavLink to="/" exact activeclassname="active">
                Home
              </NavLink>
            </li>
            <li>
              <NavLink to="/courses" activeclassname="active">
                Courses
              </NavLink>
            </li>
          </ul>
        </nav>
      </header>
    </div>
  );
};

export default Header;
