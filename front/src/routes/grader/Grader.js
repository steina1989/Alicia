import React, { Component } from 'react';
import SplitterLayout from 'react-splitter-layout';
import SyntaxHighlighter from 'react-syntax-highlighter';
import { foundation } from 'react-syntax-highlighter/styles/hljs';
import './Grader.css';

class Grading extends Component {
  constructor(props) {
    super(props);
    this.state = {
      code: '',
      index: 0,
      answers: null
    };
  }

  handleKeyPress = evt => {
    if (evt.key === 'ArrowRight' || evt.key === 'ArrowLeft') {
      const delta = evt.key === 'ArrowRight' ? 1 : -1;
      let newIndex = this.state.index + delta;
      // Roll back if out of range.
      if (newIndex < 0 || newIndex >= this.state.answers.length) {
        newIndex = this.state.index;
        return;
      }
      const code = this.state.answers[newIndex].sourceCode;
      this.setState({ index: newIndex, code });
    }
  };

  componentDidMount() {
    const assignId = this.props.match.params.assignmentId;
    fetch(`/api/assignments/${assignId}/answers`)
      .then(resp => resp.json())
      .then(res => {
        this.setState({ answers: res._embedded.answers });
        const code = res._embedded.answers[this.state.index].sourceCode;
        this.setState({ code });
      });
  }

  render() {
    return (
      <div onKeyDown={this.handleKeyPress} tabIndex="0" className="Grader">
        <SplitterLayout vertical percentage secondaryInitialSize={30}>
          <div>
            <SplitterLayout
              percentage
              primaryIndex={1}
              secondaryInitialSize={20}
            >
              <div>Upper left</div>
              <div>
                <SplitterLayout secondaryInitialSize={300}>
                  <SyntaxHighlighter language="java" style={foundation}>
                    {this.state.code}
                  </SyntaxHighlighter>
                  <div>Upper right</div>
                </SplitterLayout>
              </div>
            </SplitterLayout>
          </div>
          <div>Command line Pane</div>
        </SplitterLayout>
      </div>
    );
  }
}

export default Grading;
