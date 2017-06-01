import React, {Component} from 'react';
// import {Router, Route} from 'react-router';
// import createBrowserHistory from 'history/createBrowserHistory';
// import axios  from 'axios';

import './site.css';

import Entete from './Entete/Entete.js';
import BarDeNav from './BarDeNav/BarDeNav.js';
import PiedPage from './PiedPage/PiedPage.js';
import Pages from './Pages/Pages.js';

// const history = createBrowserHistory();

class Site extends Component {
  render() {
    return (
      <div>
        <Entete />
        <BarDeNav />
        <Pages />
        <PiedPage />
      </div>
    )
  }
}

export default Site;
