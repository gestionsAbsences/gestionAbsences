import React, { Component } from 'react';
import {Router, Route} from 'react-router';
import createBrowserHistory from 'history/createBrowserHistory';

// import axios from 'axios'

// import '../Bootstrap/dist/css/sb-admin-2.css'
import './page.css';

const history = createBrowserHistory();

import EnConstruction from './EnConstruction/EnConstruction.js';
import Authentification from './Authentification/Authentification.js';
import ModifMotDePasse from './ModifMotDePasse/ModifMotDePasse.js';
import ListeDemandes from './ListeDemandes/ListeDemandes.js';
import NouvelleDemande from './NouvelleDemande/NouvelleDemande.js';
import DeclareAbsence from './DeclareAbsence/DeclareAbsence.js';
import MonCalendrier from './Calendrier/MonCalendrier.js';
import CalendrierEquipe from './Calendrier/CalendrierEquipe.js';
import CalendrierEntreprise from './Calendrier/CalendrierEntreprise.js';

class Page extends Component {

  render() {
    return (
      <Router history={history}>
        <div>
          <div className="voffset">&nbsp;</div>
          <div className="page">
            <Route path="/accueil"               component={ListeDemandes} />
            <Route path="/listedemnade"          component={ListeDemandes} />
            <Route path="/nouvelledemnade"       component={NouvelleDemande} />
            <Route path="/declareabsence"        component={DeclareAbsence} />
            <Route path="/reliquatconges"        component={EnConstruction} />
            <Route path="/moncalendrier"         component={MonCalendrier} />
            <Route path="/calendrierequipe"      component={CalendrierEquipe} />
            <Route path="/calendrierentreprise"  component={CalendrierEntreprise} />
            <Route path="/gestionpersonnel"      component={EnConstruction} />
            <Route path="/gestionequipe"         component={EnConstruction} />
            <Route path="/aide"                  component={EnConstruction} />
            <Route path="/apropos"               component={EnConstruction} />
            <Route path="/deconnexion"           component={Authentification} />
            <Route path="/modifmotdepasse"       component={ModifMotDePasse} />
          </div>
          <div className="marge"></div>
        </div>
      </Router>
    );
  }
}

export default Page;
