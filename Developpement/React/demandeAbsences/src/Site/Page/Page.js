import React, { Component } from 'react';

import '../Bootstrap/dist/css/sb-admin-2.css'
import './page.css';
import axios from 'axios'

import Authentification from './Authentification/Authentification.js';
import ModifMotDePasse from './ModifMotDePasse/ModifMotDePasse.js';
import ListeDemandes from './ListeDemandes/ListeDemandes.js';
import NouvelleDemande from './NouvelleDemande/NouvelleDemande.js';

class Page extends Component {

  constructor(props) {
      super(props);
      this.state = {
          types: []
      }
  }

  componentDidMount() {
       axios.get('http://localhost:8080/type/listeTypeAbsence/')
          .then(res => {
              console.log(res.data);
              this.setState({types: res.data});
      });
  }

  render() {
    return (
      <div>
      {/*
        <ul>
          this.state.types.map(
            (type, i) =>
            <li key={i}>
              {type.nom}
            </li>
          )
        </ul>
*/}

<div className="voffset">&nbsp;</div>
        <div className="page">
          <ListeDemandes />
        </div>
        <div className="marge"></div>
      </div>
    );
  }
}

export default Page;
