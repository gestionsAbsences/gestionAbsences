import React, {Component} from 'react';
// import {Router, Route} from 'react-router';
// import createBrowserHistory from 'history/createBrowserHistory';
// import axios  from 'axios';

import 'semantic-ui-css/semantic.min.css';
import './site.css';

import Entete from './Entete/Entete.js';
import BarDeNav from './BarDeNav/BarDeNav.js';
// import APropos from './APropos/APropos.js';
// import Aide from './Aide/Aide.js';
import PiedPage from './PiedPage/PiedPage.js';
import Page from './Page/Page.js';

import './Bootstrap/dist/css/sb-admin-2.css'

// const history = createBrowserHistory();

class Site extends Component {

<<<<<<< HEAD
  // constructor(props) {
  //   super(props);
  // }

=======
  constructor(props) {
    super(props);
  }
>>>>>>> master
  render() {
    return (
      <div>
        <Entete />
        <BarDeNav />
        <Page />
        <PiedPage />
      </div>
    )
  }
}

export default Site;
