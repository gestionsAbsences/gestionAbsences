import React, { Component } from 'react';
import { Router, Route } from 'react-router'
import createBrowserHistory from 'history/createBrowserHistory';
// import { Router, Route, Link, IndexRoute, hashHistory, browserHistory } from 'react-router'

import './pages.css';

const history = createBrowserHistory();

// Liste des composants liés aux pages à afficher
import EnConstruction from './EnConstruction/EnConstruction.js';
import Authentification from './Authentification/Authentification.js';
import ModifMotDePasse from './ModifMotDePasse/ModifMotDePasse.js';
import ListeDemandes from './ListeDemandes/ListeDemandes.js';
import NouvelleDemande from './NouvelleDemande/NouvelleDemande.js';
import DeclareAbsence from './DeclareAbsence/DeclareAbsence.js';
import MonCalendrier from './Calendrier/MonCalendrier.js';
import CalendrierEquipe from './Calendrier/CalendrierEquipe.js';
import CalendrierEntreprise from './Calendrier/CalendrierEntreprise.js';
import ReliquatConges from './ReliquatConges/ReliquatConges.js';
import GestionPersonnel from './GestionPersonnel/GestionPersonnel.js';
import GestionEquipe from './GestionEquipe/GestionEquipe.js';
import APropos from '../APropos/APropos.js';
import Aide from '../Aide/Aide.js';
import AvisHierarchique from './AvisHierarchique/AvisHierarchique.js';
import AvisRh from './AvisRh/AvisRh.js';

class Pages extends Component {

  render() {
    return (
      <div>
        <Router history={history}>
          <div>
            <div className="voffset">&nbsp;</div>
            <div className="page">

              {/* Liste des Path associés aux pages à afficher en fonction de la navigation */}

              <Route exact path="/accueil"               component={ListeDemandes} />
              <Route exact path="/listedemandes"         component={ListeDemandes} />
              <Route exact path="/nouvelledemande"       component={NouvelleDemande} />
              <Route exact path="/declareabsence"        component={DeclareAbsence} />
              <Route exact path="/reliquatconges"        component={ReliquatConges} />
              <Route exact path="/moncalendrier"         component={MonCalendrier} />
              <Route exact path="/calendrierequipe"      component={CalendrierEquipe} />
              <Route exact path="/calendrierentreprise"  component={CalendrierEntreprise} />
              <Route exact path="/gestionpersonnel"      component={GestionPersonnel} />
              <Route exact path="/gestionequipe"         component={GestionEquipe} />
              <Route exact path="/aide"                  component={Aide} />
              <Route exact path="/apropos"               component={APropos} />
              <Route exact path="/deconnexion"           component={Authentification} />
              <Route exact path="/modifmotdepasse"       component={ModifMotDePasse} />

              <Route exact path="/avishierarchique"      component={AvisHierarchique} />
              <Route exact path="/avisrh"                component={AvisRh} />

              {/* <Route path="*"                            component={Authentification} /> */}

            </div>
            <div className="marge"></div>
          </div>
        </Router>
      </div>
    );
  }
}

export default Pages;
