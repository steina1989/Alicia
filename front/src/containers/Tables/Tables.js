import React from 'react';
import { Link } from 'react-router-dom';
import Assignment from '../Assignment';

export const AssignmentTable = props => {
  const assignments = props.assignments.map(assignment => (
    <li key={assignment.id}>
      <Assignment assignment={assignment} />
    </li>
  ));
  return (
    <div>
      <Link to={'/createAssignment/1'}>Create a new assignment?</Link>
      <ul>{assignments}</ul>
    </div>
  );
};

export const CourseTable = props => {
  const courses = props.courses.map(course => (
    <li key={course.id}>
      <Link
        to="/assignments"
        onClick={e => props.openCourseHandler(course.id, e)}
      >
        {' '}
        {course.name}
      </Link>
    </li>
  ));

  return <ul>{courses}</ul>;
};
