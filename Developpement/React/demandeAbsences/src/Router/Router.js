import React, { Component } from 'react';
import { Router, Route, Redirect } from 'react-router';
import createBrowserHistory from 'history/createBrowserHistory';

const history = createBrowserHistory();

class RouterComponent extends Component {

  componentWillMount () {
    this.setState({userConnected: true});
  }

  render() {
    return (
      <Router history={history}>
          <div>
          </div>
        </Router>
    );
  }
}

export default RouterComponent;
