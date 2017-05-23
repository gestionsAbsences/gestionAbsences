import React, { Component } from 'react';
import axios from 'axios';

import '../Bootstrap/dist/css/sb-admin-2.css'
import './entete.css';

import logo from '../Medias/Logo.jpg';

class Entete extends Component {

      constructor(props) {
          super(props);
          this.state = {
              employes: []
          }
      }

      componentDidMount() {
           axios.get('http://localhost:8080/emp/getEmploye?nom=perez')
              .then(res => {
                  console.log(res.data);
                  this.setState({employes: res.data});
          });
      }

  render() {
    return (
      <div>
        <header>
          <div className="header breadcrumb">
          <div className="employe">
              {
                  this.state.employes.map(
                    (employe, i) =>
                    <span key={i}>
                      <span className="identite">
                      <img className="logo" src={logo} alt="" />
                        <span className="nom">{employe.nom}</span>
                        <span className="prenom">{employe.prenom}</span>
                        <span className="matricule">{employe.matricule}</span>
                      </span>
                      <span className="info">
                        <span className="conge">Congés payés : {employe.nbCa} j</span>
                        <span className="rtt">RTT : {employe.nbRtt} j</span>
                        <span className="repos">Repos compensateur : {employe.nbRc} h</span>
                      </span>
                    </span>
                    )
                  }
              </div>
          </div>
        </header>
      </div>
    );
  }
}

export default Entete;
