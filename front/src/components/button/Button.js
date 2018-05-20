import React from 'react';
import './Button.css';

const Button = props => {
  const { onClick, children, className } = props;
  const classes = `Button ${className}`;
  return (
    <button className={classes} onClick={onClick}>
      {children}
    </button>
  );
};

export default Button;
