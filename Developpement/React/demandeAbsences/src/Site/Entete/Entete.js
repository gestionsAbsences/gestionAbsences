import React, { Component } from 'react';

import '../Bootstrap/dist/css/sb-admin-2.css'
import './entete.css';

import logo from '../Medias/Logo.jpg';

let nom="WALTER";
let prenom="Lisandra";
let matricule="GDUW23";

class Entete extends Component {
  render() {
    return (
      <div>
        <header>
          <div className="header breadcrumb">
            <img className="logo" src={logo} alt="" />
            {nom} {prenom} - {matricule}
          </div>
        </header>
      </div>
    );
  }
}

export default Entete;
