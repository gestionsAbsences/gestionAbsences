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

  componentDidMount () {
    axios
      .get('http://localhost:8080/validation/listeAbsences?equipe='+this.props.employe.nomEquipe)
      .then(res => {
        this.setState({
          validationAbs: res.data
        });
      })
      .catch((error) => {
        console.log("Axios : Problème d'accès à la ressource http://localhost:8080/validation/listeAbsences?equipe="+this.props.employe.nomEquipe);
    });
    console.log("WillMount : ");
    console.log(this.state.validationAbs);
    console.log("Equipe : "+this.props.employe.nomEquipe);
    console.log(this.props.employe);
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
        <td>{absence.debut}</td>
        <td>{absence.fin}</td>
        <td>{absence.statut}</td>
        <td>{this.action(this.props.employe.role, absence.statut, absence.debut)}</td>
      </tr>;
      console.log('trtValidation : '+this.props.employe.matricule, absence.matricule);
    }
    return res;
  }

  action = (role, absence) => {
    let laDate = new Date();
    let laDateDuJour = laDate.getFullYear() +""+ ("0"+laDate.getMonth()).substr(-2) +""+ ("0"+laDate.getDate()).substr(-2);
    let debut =  absence.debut.substr(0,4) + "" +  absence.debut.substr(5,2) + "" + absence.debut.substr(-2);
    let relance="/absence/reflateAbsence?numDemande="+absence.numDemande;
    let annule="/absence/deleteAbsence?numDemande="+absence.numDemande;
    let lien;

    if (absence.statut==="Nouvelle demande" && role===0) {
      lien=<div><a href={relance}>Relancer</a> ou <a href={annule}>Annuler</a></div>;
    }
    if (absence.statut==="En attente de validation du Responsable" && role===0) {
      lien=<div><p><a href={relance}>Relancer</a> ou <a href={annule}>Annuler</a></p></div>;
    }
    if (absence.statut==="En attente de décision RH" && role===0) {
      lien=<div><a href={relance}>Relancer</a> ou <a href={annule}>Annuler</a></div>;
    }
    if (absence.statut==="Validé" && role===0 && debut>=laDateDuJour) {
      lien=<div><a href={annule}>Annuler</a></div>;
    }
    if (absence.statut==="En attente de validation du Responsable" && role===1 && debut>=laDateDuJour) {
      lien=<div><a href="/avishierarchique">Décider</a></div>;
    }
    if (absence.statut==="En attente de décision RH" && role===1) {
      lien=<div><a href={relance}>Relancer</a> ou <a href={annule}>Annuler</a></div>;
    }
    if (absence.statut==="Validé" && role===1 && debut>=laDateDuJour) {
      lien=<div><a href={annule}>Annuler</a></div>;
    }
    if (absence.statut==="En attente de décision RH" && role===2) {
      lien=<div><a href="/avisrh">Décider</a></div>;
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
                      <td>{absence.debut}</td>
                      <td>{absence.fin}</td>
                      <td>{absence.statut}</td>
                      <td>{this.action(this.props.employe.role, absence)}</td>
                    </tr>
                  )
                }
                {
                  this.state.validationAbs.map(
                    (absence, i) =>
                    this.trtValidation(i, absence)
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
