import React, { Component } from 'react';
import {Router, Route} from 'react-router';
import createBrowserHistory from 'history/createBrowserHistory';

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

            <Route path="/accueil"               component={ListeDemandes} />
            <Route path="/listedemandes"         component={ListeDemandes} />
            <Route path="/nouvelledemande"       component={NouvelleDemande} />
            <Route path="/declareabsence"        component={DeclareAbsence} />
            <Route path="/reliquatconges"        component={ReliquatConges} />
            <Route path="/moncalendrier"         component={MonCalendrier} />
            <Route path="/calendrierequipe"      component={CalendrierEquipe} />
            <Route path="/calendrierentreprise"  component={CalendrierEntreprise} />
            <Route path="/gestionpersonnel"      component={GestionPersonnel} />
            <Route path="/gestionequipe"         component={GestionEquipe} />
            <Route path="/aide"                  component={Aide} />
            <Route path="/apropos"               component={APropos} />
            <Route path="/deconnexion"           component={Authentification} />
            <Route path="/modifmotdepasse"       component={ModifMotDePasse} />

            <Route path="/avishierarchique"      component={AvisHierarchique} />
            <Route path="/avisrh"                component={AvisRh} />

          </div>
          <div className="marge"></div>
        </div>
      </Router>
      </div>
    );
  }
}

export default Pages;
