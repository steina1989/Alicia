import React, { PureComponent } from 'react';
import { Link } from 'react-router-dom';
import './CourseCard.css';

export default class CourseCard extends PureComponent {
  render = () => {
    const { name, identifier, count, onClickHandler } = this.props;
    const assignmentString = count === 1 ? 'assignment.' : 'assignments.';
    return (
      <div className="CourseCard" onClick={onClickHandler}>
        <div className="container">
          <h4>{name}</h4>
          <b>{identifier}</b>
          <p>{`${count} ${assignmentString}`}</p>
        </div>
      </div>
    );
  };
}
