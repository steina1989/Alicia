'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
import SplitterLayout from 'react-splitter-layout';
// end::vars[]

// tag::app[]
class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {employees: []};
	}
	
	render() {

	    return (
	    	      <SplitterLayout vertical={true}>
	    	        <div>Steina the scoundrel</div>
	    	        <div>Hallgrímur the wise</div>
	    	      </SplitterLayout>
	    	    );
	}
}
// end::app[]

// tag::employee-list[]
class EmployeeList extends React.Component{
	render() {
		var employees = this.props.employees.map(employee =>
			<Employee key={employee._links.self.href} employee={employee}/>
		);
		return (
			<table>
				<tbody>
					<tr>cat
						<th>Og þetta por favour? :)</th>
						<th>Last Name</th>
						<th>Description</th>
					</tr>
					{employees}
				</tbody>
			</table>
		)
	}
}
// end::employee-list[]

// tag::employee[]
class Employee extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.employee.firstName}</td>
				<td>{this.props.employee.lastName}</td>
				<td>{this.props.employee.description}</td>
			</tr>
		)
	}
}
// end::employee[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]

