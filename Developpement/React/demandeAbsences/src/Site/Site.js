import React, {Component} from 'react';

import './site.css';

// Import des composants de la page
import Entete from './Entete/Entete.js';
import BarDeNav from './BarDeNav/BarDeNav.js';
import PiedPage from './PiedPage/PiedPage.js';
import Pages from './Pages/Pages.js';

class Site extends Component {
    render() {
    return (
      <div>
        <Entete />   {/* Affiche le header de la page */}
        <BarDeNav /> {/* Affiche la barre de navigation (latérale) */}
        <Pages />    {/* Affiche le body en fonction de la navigation */}
        <PiedPage /> {/* Affiche le footer */}
      </div>
    )
  }
}

export default Site;
