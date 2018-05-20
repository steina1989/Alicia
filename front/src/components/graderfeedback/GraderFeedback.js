import React, { Component } from 'react';
import './GraderFeedback.css';
import Button from '../button';

export default class GraderFeedback extends Component {
  render = () => {
    const { grade, comment, onFeedbackSubmit, onFeedbackChange } = this.props;
    return (
      <div className="graderfeedback">
        <form onSubmit={this.onFeedbackSubmit}>
          <fieldset>
            <legend>Endurgjöf:</legend>
            <span>
              Athugasemd:{' '}
              <input
                type="text"
                name="comment"
                value={comment}
                onChange={onFeedbackChange}
              />
            </span>
            <span>
              Einkunn:{' '}
              <input
                type="number"
                name="grade"
                value={grade}
                onChange={onFeedbackChange}
                min="0"
                max="1"
                step="0.1"
              />
            </span>
          </fieldset>
          <Button onClick={onFeedbackSubmit}>Senda inn einkunn</Button>
        </form>
      </div>
    );
  };
}
