import React, { Component } from 'react';

// import '../Bootstrap/dist/css/sb-admin-2.css'
import './piedPage.css';

import logo1 from '../Medias/Java_Logo.svg';
import logo2 from '../Medias/React_Logo.svg';
import logo3 from '../Medias/MySQL_Logo.jpg';
import logo4 from '../Medias/Spring_Logo.png';
import logo5 from '../Medias/Bootstrap_Logo.png';
import logo6 from '../Medias/JS_Logo.jpg';
import logo7 from '../Medias/jQuery_Logo.png';

class PiedPage extends Component {
  render() {
    return (
      <div>
        <footer>
          <div className="footer breadcrumb">
            GestionAbsences©2017   -   Par Fred, Jean et Mokhtar de La Poste.promo1@Simplon avec la participation de
            <img className="logo1" src={logo1} alt="" />,
            <img className="logo2" src={logo2} alt="" />,
            <img className="logo3" src={logo3} alt="" />,
            <img className="logo4" src={logo4} alt="" />,
            <img className="logo5" src={logo5} alt="" />,
            <img className="logo6" src={logo6} alt="" />et
            <img className="logo7" src={logo7} alt="" />.
          </div>
        </footer>
      </div>
    )
  }
}
export default PiedPage;
