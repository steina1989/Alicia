import React, { Component } from 'react';
import SplitterLayout from 'react-splitter-layout';
import SyntaxHighlighter from 'react-syntax-highlighter';
import { foundation } from 'react-syntax-highlighter/styles/hljs';
import GraderConfig from '../../components/graderconfig';
import GraderFeedback from '../../components/graderfeedback';
import Api from '../../Api';
import './Grader.css';

class Grading extends Component {
  constructor(props) {
    super(props);
    this.onFeedbackChange = this.onFeedbackChange.bind(this);
    this.onFeedbackSubmit = this.onFeedbackSubmit.bind(this);
    this.state = {
      finished: false,
      sourceCode: '',
      sourceCodeBeautified: '',
      distance: 0,
      formatterDiagnostics: null,
      feedback: {
        comment: '',
        grade: 1
      }
    };
  }

  componentDidMount = async () => {
    this.getNextAnswer();
  };

  getNextAnswer = async () => {
    const { assignmentId } = this.props.match.params;
    const response = await Api.get(
      `answers/search/nextUnmarkedByAssignmentId?id=${assignmentId}`
    );
    const { answers } = response.result._embedded;
    if (answers.length === 0) {
      return this.setState({ finished: true });
    }
    this.setState({ ...answers[0] });
  };

  onFeedbackSubmit = async evt => {
    evt.preventDefault();
    const { feedback, id } = this.state;
    const patch = {
      feedback,
      marked: true
    };
    try {
      const response = await Api.post(patch, `answers/${id}`, 'PATCH');
    } catch (error) {
      console.log(error);
    }
    this.getNextAnswer();
  };
  onFeedbackChange = evt => {
    const { name, value } = evt.target;
    const { feedback } = this.state;
    if (name) {
      feedback[name] = value;
    }
    this.setState({ feedback });
  };

  // Get assignment question for ease of grading. Not top prio.
  loadAssignment() {}

  render() {
    const {
      sourceCode,
      sourceCodeBeautified,
      formatterDiagnostics,
      feedback,
      finished
    } = this.state;

    let source = sourceCodeBeautified ? sourceCodeBeautified : sourceCode;

    if (finished) {
      source = 'Þú hefur klárað að fara yfir öll verkefnin';
    }
    return (
      <div className="grader">
        <SplitterLayout vertical percentage secondaryInitialSize={30}>
          <div>
            <SplitterLayout
              percentage
              primaryIndex={1}
              secondaryInitialSize={20}
            >
              <GraderConfig />
              <div>
                <SplitterLayout secondaryInitialSize={350}>
                  <SyntaxHighlighter language="java" style={foundation}>
                    {source}
                  </SyntaxHighlighter>
                  <GraderFeedback
                    {...feedback}
                    onFeedbackChange={this.onFeedbackChange}
                    onFeedbackSubmit={this.onFeedbackSubmit}
                  />
                </SplitterLayout>
              </div>
            </SplitterLayout>
          </div>
          <div>{formatterDiagnostics}</div>
        </SplitterLayout>
      </div>
    );
  }
}

export default Grading;
