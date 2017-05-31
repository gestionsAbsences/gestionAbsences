import React, { Component } from 'react';
import axios from 'axios';

import './entete.css';
import logo from '../Medias/Logo.jpg';

let nom="PEREZ";

class Entete extends Component {

    constructor(props) {
        super(props);
        this.state = {
            nom:"",
            prenom:"",
            matricule:"",
            nbCa:0,
            nbRtt:0,
            nbRc:0
      }
    }

    componentDidMount() {
         axios.get('http://localhost:8080/emp/getEmploye?nom='+nom)
            .then(res => {
                this.setState({
                  nom: res.data[0].nom,
                  prenom: res.data[0].prenom,
                  matricule: res.data[0].matricule,
                  nbCa: res.data[0].nbCa,
                  nbRtt: res.data[0].nbRtt,
                  nbRc: res.data[0].nbRc
              });
        });
    }

  render() {
    return (
      <header>
        <div className="header breadcrumb container-fluid">
          <div className="row">

            <div className="col-md-1">
              <img className="logohead" src={logo} alt="" />
            </div>

            <div className="navbar-form col-md-5">
              <span className="nom">{this.state.nom}</span>
              <span className="prenom">{this.state.prenom}</span>
              <span className="matricule">{this.state.matricule}</span>
            </div>

            <div className="navbar-form col-md-6 pull-right">
              <div className="pull-right">
                <span className="conge">Congés payés : <span className="compteur">{this.state.nbCa}</span> j</span>
                <span className="rtt">RTT : <span className="compteur">{this.state.nbRtt}</span> j</span>
                <span className="repos">Repos compensateurs : <span className="compteur">{this.state.nbRc}</span> h</span>
              </div>
            </div>

          </div>
        </div>
      </header>
    );
  }
}

export default Entete;
