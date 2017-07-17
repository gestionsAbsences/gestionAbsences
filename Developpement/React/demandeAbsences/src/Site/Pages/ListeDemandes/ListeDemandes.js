import React, { Component } from 'react';

import axios from 'axios';

import './listedemandes.css';

class ListeDemandes extends Component {

  constructor(props) {
    super(props); // Récupère le Props du parent
    this.props=props;
    this.state={
      debut: '',
      fin: '',
      type: '',
      statut: '',
      numDemande: '',
      nom: '',
      prenom: '',
      validationAbs: []
    }
  }

  // Convertit la date du format aaaa-mm-dd vers le format dd/mm/aaaa
  formatDate = (date) => {
    let res;
    res=date.substr(-2) + "/" + date.substr(5,2) + "/" + date.substr(0,4);
    return res;
  }

  componentDidMount () {
    //Requête HTTP destinée au Back
    axios({
      method: 'get',
      url: '/validation/listeAbsences?equipe='+this.props.employe.nomEquipe,
      data: {},
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
      }
    })
      .then(res => {

        // Incorpore les données dans le State
        this.setState({
          validationAbs: res.data
        });
        if (this.props.employe.modeDev) {
          console.log("Requête satisfaite : ");
          console.log(res);
          console.log("");
        }
      })
      // Traitement des erreurs en mode de Dev.
      .catch((error) => {
        if (this.props.employe.modeDev) {
          if (axios.isCancel(error)) {
            console.log("La requête a été annulée :");
            console.log('Request canceled', error.message);
            console.log("");
          } else if (error.response) {
            console.log("La requête est transmise mais retourne une erreur <200 ou >=300 :");
            console.log(error.response.data);
            console.log(error.response.status);
            console.log(error.response.headers);
            console.log("");
          } else if (error.request) {
            console.log("La requête est transmise mais ne retourne pas de réponse : ");
            console.log(error.request);
            console.log("");
          } else {
            console.log("La requête n'a pu être transmise et déclenche une erreur : ");
            console.log('Error', error.message);
            console.log("");
          }
          console.log("Error.config : ");
          console.log(error.config);
          console.log("");
        }
      });
  }

  trtValidation = (indice, absence) => {
    let res;
    if (this.props.employe.matricule!==absence.matricule) {
      res=<tr key={indice}>
        <td>{absence.numDemande}</td>
        <td>{absence.nom}</td>
        <td>{absence.prenom}</td>
        <td>{this.props.employe.nomResponsable}</td>
        <td>{this.props.employe.prenomResponsable}</td>
        <td>{absence.type}</td>
        <td>{this.formatDate(absence.debut)}</td>
        <td>{this.formatDate(absence.fin)}</td>
        <td>{absence.statut}</td>
        <td>{this.action(this.props.employe.role, absence.statut, absence.debut)}</td>
      </tr>;
    }
    return res;
  }

  action = (role, absence, cas) => {
    let lien;
    let laDate = new Date();
    let laDateDuJour=laDate.getFullYear() +""+ ("0"+(laDate.getMonth()+1)).substr(-2) +""+ ("0"+laDate.getDate()).substr(-2);
    let debut=absence.debut.substr(0,4) + "" +  absence.debut.substr(5,2) + "" + absence.debut.substr(-2);
    let relance="/absence/reflateAbsence?numDemande="+absence.numDemande;
    let annule="/absence/deleteAbsence?numDemande="+absence.numDemande;

    if (absence.statut==="Nouvelle demande") {
      lien=<div><a href={relance}>Relancer</a> ou <a href={annule}>Annuler</a></div>;
    }
    if (absence.statut==="En attente de validation du Responsable" && cas===1) {
      lien=<div><p><a href={relance}>Relancer</a> ou <a href={annule}>Annuler</a></p></div>;
    }
    if (absence.statut==="En attente de validation du Responsable" && cas===2) {
      lien=<div><a href="/avishierarchique">Décider</a></div>;
    }
    if (absence.statut==="En attente de décision RH" && cas===1) {
      lien=<div><a href={relance}>Relancer</a> ou <a href={annule}>Annuler</a></div>;
    }
    if (absence.statut==="En attente de décision RH" && cas===2) {
      lien=<div><a href="/avisrh">Décider</a></div>;
    }
    if (absence.statut==="Validé" && debut>=laDateDuJour && cas===1) {
      lien=<div><a href={annule}>Annuler</a></div>;
    }

    return lien;
  }

  render() {
    return (
      <div>
        <div className="panel panel-default">{/*2   Formulaire */}
          <div className="panel-heading">{/*3   Titre de la page */}
            <h3 className="panel-title">Liste de vos dernières demandes</h3>
          </div>{/*3   fin */}
          <div className="">{/*14   Tableau */}
            <table className="table table-bordered table-hover table-striped tablesupmargebas">{/*   Cosmétique Tablesupmargebas, supprime la marge en bas du tableau */}{/* fin */}
              <thead>{/*15   Entête du tableau */}
                <tr>
                  <th>N° demande</th>
                  <th>Nom</th>
                  <th>Prénom</th>
                  <th>Nom Resp</th>
                  <th>Prénom Resp</th>
                  <th>Type</th>
                  <th>Début</th>
                  <th>Fin</th>
                  <th>Statut</th>
                  <th>Action</th>
                </tr>
              </thead>{/*15 Fin */}
              <tbody>{/*16 Contenu du tableau */}
                {
                  this.props.employe.absences.map(
                    (absence, i) =>
                    <tr key={i}>
                      <td>{absence.numDemande}</td>
                      <td>{this.props.employe.nom}</td>
                      <td>{this.props.employe.prenom}</td>
                      <td>{this.props.employe.nomResponsable}</td>
                      <td>{this.props.employe.prenomResponsable}</td>
                      <td>{absence.type}</td>
                      <td>{this.formatDate(absence.debut)}</td>
                      <td>{this.formatDate(absence.fin)}</td>
                      <td>{absence.statut}</td>
                      <td>{this.action(this.props.employe.role, absence, 1)}</td>
                    </tr>
                  )
                }
                {
                  this.state.validationAbs.map(
                    (absence, i) =>
                    this.trtValidation(i, absence, 2)
                  )
                }
              </tbody>{/*16 Fin */}
            </table>

          </div>{/*14 Fin */}
        </div>{/*2 Fin */}
        <div className="VOffSetBasPages">&nbsp;</div>{/*1   Cosmétique Ajout d'une marge en dessous du formulaire réglable via le css voffsetpos */}{/*1    fin */}
      </div>
    );
  }
}

export default ListeDemandes;
