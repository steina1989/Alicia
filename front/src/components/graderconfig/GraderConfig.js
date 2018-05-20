import React, { Component } from 'react';
import './GraderConfig.css';

export default class GraderConfig extends Component {
  render = () => {
    return (
      <div className="graderConfig">
        <form onSubmit={this.onFormSubmit}>
          <p>Fegra</p>
          <label className="switch">
            <input type="checkbox" />
            <span className="slider round" />
          </label>
        </form>
      </div>
    );
  };
}
