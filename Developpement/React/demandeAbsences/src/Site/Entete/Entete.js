import React, { Component } from 'react';
// import axios from 'axios';
//
import '../Bootstrap/dist/css/sb-admin-2.css'
import './entete.css';

import logo from '../Medias/Logo.jpg';

let nom="PEREZ";
let prenom="Lucien";
let matricule="GATR62";
let nbCa=14;
let nbRtt=11;
let nbRc=34;

class Entete extends Component {
  render() {
    return (
      <div>
        <header>
          <div className="header breadcrumb container">
          <div className="row">

            <div className="col-md-1">
              <img className="logohead" src={logo} alt="" />
            </div>

            <div className="navbar-form col-md-5">
              <span className="nom">{nom}</span>
              <span className="prenom">{prenom}</span>
              <span className="matricule">{matricule}</span>
            </div>

            <div className="navbar-form col-md-6 pull-right">
              <div className="pull-right">
                <span className="conge">Congés payés : <span className="compteur">{nbCa}</span> j</span>
                <span className="rtt">RTT : <span className="compteur">{nbRtt}</span> j</span>
                <span className="repos">Repos compensateurs : <span className="compteur">{nbRc}</span> h</span>
              </div>
            </div>

          </div>
          </div>
        </header>
      </div>
    );
  }
}

export default Entete;
