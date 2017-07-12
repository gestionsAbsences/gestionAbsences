import React, { Component } from 'react';

import './entete.css';
import logo from '../Medias/Logo.jpg';

class Entete extends Component {

  constructor (props) {
    super(props); // Récupère le Props du parent
    this.props=props;
  }

  render() {
    return (
      <header>
        <div className="header breadcrumb container-fluid premierplan">
          <div className="row">

            <div className="col-md-1">
              <img className="logohead" src={logo} alt="" />
            </div>

            <div className="navbar-form col-md-5">
              <span className="nom">{this.props.nom}</span>
              <span className="prenom">{this.props.prenom}</span>
              <span className="matricule">{this.props.matricule}</span>
            </div>

            <div className="navbar-form col-md-6 pull-right">
              <div className="pull-right">
                <span className="conge">Congés payés : <span className="compteur">{this.props.nbCa}</span> j</span>
                <span className="rtt">RTT : <span className="compteur">{this.props.nbRtt}</span> j</span>
                <span className="repos">Repos compensateurs : <span className="compteur">{this.props.nbRc}</span> h</span>
              </div>
            </div>

          </div>
        </div>
      </header>
    );
  }
}

export default Entete;
