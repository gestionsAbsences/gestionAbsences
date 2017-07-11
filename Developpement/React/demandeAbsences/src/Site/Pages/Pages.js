import React, { Component } from 'react';
import { Switch, Router, Route } from 'react-router'
import createBrowserHistory from 'history/createBrowserHistory';

import './pages.css';

const history = createBrowserHistory();

// Liste des composants importés associés aux pages à afficher
// import EnConstruction from './EnConstruction/EnConstruction.js';  // signale que la page demandée est en construction
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

  constructor (props) {
    super(props); // Récupère le Props du parent
    this.props=props;
  }

// propUserEmailFille = (valeur) => {
//   this.props.transUserEmail(valeur);
// }

// ---------------------------------------------------------------------
// Liste des fonctions associées au route ci-dessous
// Il s'agit de "render" la page adéquate accompagnée des props mère
// ---------------------------------------------------------------------
ListeDemandes = () => {
  return <ListeDemandes employe={this.props.employe} />
}

NouvelleDemande = () => {
  return <NouvelleDemande employe={this.props.employe} />
}

DeclareAbsence = () => {
  return <DeclareAbsence employe={this.props.employe} />
}

ReliquatConges = () => {
  return <ReliquatConges employe={this.props.employe} />
}

MonCalendrier = () => {
  return <MonCalendrier employe={this.props.employe} />
}

CalendrierEquipe = () => {
  return <CalendrierEquipe employe={this.props.employe} />
}

CalendrierEntreprise = () => {
  return <CalendrierEntreprise employe={this.props.employe} />
}

GestionPersonnel = () => {
  return <GestionPersonnel employe={this.props.employe} />
}

GestionEquipe = () => {
  return <GestionEquipe employe={this.props.employe} />
}

Aide = () => { // Aide est élaboré en fonction du role de l'utilisateur
  return <Aide employe={this.props.employe.role} />
}

Authentification = () => {
  return <Authentification employe={this.props.employe} transUserEmail={this.props.transUserEmail} />
}

ModifMotDePasse = () => {
  return <ModifMotDePasse employe={this.props.employe} />
}

AvisHierarchique = () => {
  return <AvisHierarchique employe={this.props.employe} />
}

AvisRh = () => {
  return <AvisRh employe={this.props.employe} />
}
// ---------------------------------------------------------------------
// Fin de liste de fonction
// ---------------------------------------------------------------------


  render() {
    return (
      <div>
        <Router history={history}>
          <div className="pages">
            <div className="VOffSetPages">&nbsp;</div> {/* Sert à créer un décalage vers le bas voir le CSS */}
            <div className="page pagedesktop">


              {/* Liste des Path associés aux pages à afficher en fonction de la navigation
                  Le render dirige vers une fonction qui sert à charger la page accompagnée du props
                  APropos doit s'afficher inconditionnellement donc sans traitement sur les props */}

              <Switch> {/* Switch permet de limiter le render uniquement au premier path satisfait */}

                {/* Les path exprimés sont en réalité à précéder de //localhost:3000 */}
                <Route exact path="/accueil"               render={this.ListeDemandes} />
                <Route exact path="/listedemandes"         render={this.ListeDemandes} />
                <Route exact path="/nouvelledemande"       render={this.NouvelleDemande} />
                <Route exact path="/declareabsence"        render={this.DeclareAbsence} />
                <Route exact path="/reliquatconges"        render={this.ReliquatConges} />
                <Route exact path="/moncalendrier"         render={this.MonCalendrier} />
                <Route exact path="/calendrierequipe"      render={this.CalendrierEquipe} />
                <Route exact path="/calendrierentreprise"  render={this.CalendrierEntreprise} />
                <Route exact path="/gestionpersonnel"      render={this.GestionPersonnel} />
                <Route exact path="/gestionequipe"         render={this.GestionEquipe} />
{/*
                <Route exact path="/aide"                  component={AvisHierarchique} />
                <Route exact path="/apropos"               component={AvisRh} />
*/}
                <Route exact path="/aide"                  render={this.Aide} />
                <Route exact path="/apropos"               component={APropos} />
                <Route exact path="/deconnexion"           render={this.Authentification} />
                <Route exact path="/modifmotdepasse"       render={this.ModifMotDePasse} />
                <Route exact path="/avishierarchique"      render={this.AvisHierarchique} />
                <Route exact path="/avisrh"                render={this.AvisRh} />

                {/* Ce Route sert à diriger tout URL ne correspondant à aucune page de l'application
                    Forcément positionné en dernier en raison du switch, pour garantir l'exécution
                    des pages de l'appli. ' Sous-entend n'importe quel URL */}
                <Route path="*"                            render={this.Authentification} />

              </Switch>
              </div>

              {/* Ajoute une marge en bas de page permettant de scroller suffisament au dessus du footer fixe */}
              <div className="marge"></div>
            </div>
          </Router>
        </div>
      );
    }
  }

  export default Pages;
