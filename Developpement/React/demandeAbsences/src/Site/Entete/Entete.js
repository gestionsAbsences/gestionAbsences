import React, { Component } from 'react';

import Menu from '../BarDeNav/Menu.js';

import './entete.css';
import logo from '../Medias/Logo.jpg';
import menumob from '../Medias/MenuMobile3.jpg';

class Entete extends Component {

  constructor (props) {
    super(props); // Récupère le Props du parent
    this.props=props;
  }

  render() {
    return (
      <header>
        <div className="header breadcrumb container-fluid entete">
          <div className="row">

            <div className="col-xs-12 entete">

              <img className="logohead" src={logo} alt="" />

              <span className="nom">{this.props.nom}</span>
              <span className="prenom">{this.props.prenom}</span>
              <span className="matricule">{this.props.matricule}</span>

              <div className="pull-right">
                <div className="menudesktop breadcrumb">
                  <span className="conge">Congés payés : <span className="compteur">{this.props.nbCa}</span> j</span>
                  <span className="rtt">RTT : <span className="compteur">{this.props.nbRtt}</span> j</span>
                  <span className="repos">Repos compensateurs : <span className="compteur">{this.props.nbRc}</span> h</span>
                </div>

                <div className="menumobile panel-group">
                  <ul className="iconemenumobile">
                    <li className="dropdown">
                      <a className="dropdown-toggle" data-toggle="dropdown" href="#">
                        <div><img className="logomenu" src={menumob} alt="" /></div>
                      </a>
                      <div className="dropdown-menu dropdown-messages pull-right">
                        <Menu cas={2}
                              role={this.props.role} />
                      </div>
                    </li>
                  </ul>

                </div>
              </div>
            </div>

          </div>
        </div>
      </header>
    );
  }
}

export default Entete;
