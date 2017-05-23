import React, { Component } from 'react';

import '../Bootstrap/dist/css/sb-admin-2.css'
import './piedPage.css';

import logo1 from '../Medias/Java_Logo.svg';
import logo2 from '../Medias/React_Logo.svg';

class PiedPage extends Component {
  render() {
    return (
      <div>
        <footer>
          <div className="footer breadcrumb">
            ©Copyright 2017   -   Par Fred, Jean et Mokhtar de La Poste.promo1@Simplon
            <img className="logo logo1" src={logo1} alt="" />
            <img className="logo logo2" src={logo2} alt="" />
          </div>
        </footer>
      </div>
    )
  }
}
export default PiedPage;
