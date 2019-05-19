'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
// end::vars[]

const tableStyle={
		border: '1px solid black'
		}

const trStyle = {
		outline: 'thin solid',
		background : 'CCC'
}

// tag::app[]
class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {
			staffs: []
		};
	}

	componentDidMount() {
		client({method: 'GET', path: '/poc/staffs'}).done(response => {
			this.setState({staffs: response.entity /* response.entity._embedded.staffs */  });
		});
	}

	render() {
		return (
			<StaffList staffs={this.state.staffs}/>
		)
	}
}
// end::app[]

// tag::staff-list[]
class StaffList extends React.Component {
	render() {
		const staffs = this.props.staffs.map(staff =>
			<Staff /* key={staff._links.self.href} */ staff={staff}/>
		);
		return (
			<table style={tableStyle}>
				<tbody>
					<tr style={trStyle}>
						<th>Staff Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Address Id</th>
					</tr>
					{staffs}
				</tbody>
			</table>
		)
	}
}
// end::staff-list[]

// tag::staff[]
class Staff extends React.Component {
	render() {
		return (
			<tr style={trStyle}>
				<td>{this.props.staff.staffId}</td>
				<td>{this.props.staff.firstName}</td>
				<td>{this.props.staff.lastName}</td>
				<td>{this.props.staff.addressId}</td>
			</tr>
		)
	}
}
// end::staff[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]

