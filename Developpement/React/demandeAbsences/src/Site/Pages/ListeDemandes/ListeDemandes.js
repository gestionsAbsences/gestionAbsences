import React, { Component } from 'react';

import './listedemandes.css';


class ListeDemandes extends Component {

  constructor(props) {
    super(props); // Récupère le Props du parent
    this.props=props;
  }

  formatDate(date) { // Convertit la date au format dd/mm/aaaa
    return (
      date.substr(-2) + "/" + date.substr(5,2) + "/" + date.substr(0,4)
    )
  }

  action = (role, statut, dateDebut) => {
    let laDate = new Date();
    let laDateDuJour = laDate.getFullYear() +""+ ("0"+laDate.getMonth()).substr(-2) +""+ ("0"+laDate.getDate()).substr(-2);
    let debut =  dateDebut.substr(0,4) + "" +  dateDebut.substr(5,2) + "" + dateDebut.substr(-2);
    let lien;

    if (statut==="Nouvelle demande" && role===0) {
      lien=<div><a href="#">Relancer</a> ou <a href="#">Annuler</a></div>;
    }
    if (statut==="En attente de validation du Responsable" && role===0) {
      lien=<div><a href="#">Relancer</a> ou <a href="#">Annuler</a></div>;
    }
    if (statut==="En attente de décision RH" && role===0) {
      lien=<div><a href="#">Relancer</a> ou <a href="#">Annuler</a></div>;
    }
    if (statut==="Validé" && role===0 && debut>=laDateDuJour) {
      lien=<div><a href="#">Annuler</a></div>;
    }
    if (statut==="En attente de validation du Responsable" && role===1 && debut>=laDateDuJour) {
      lien=<div><a href="#">Décider</a></div>;
    }
    if (statut==="En attente de décision RH" && role===1) {
      lien=<div><a href="#">Relancer</a> ou <a href="#">Annuler</a></div>;
    }
    if (statut==="Validé" && role===1 && debut>=laDateDuJour) {
      lien=<div><a href="#">Annuler</a></div>;
    }
    if (statut==="En attente de décision RH" && role===2) {
      lien=<div><a href="#">Décider</a></div>;
    }

    return lien;
  }

  /*formatDemande(demande) { // Convertit le N° Demande au format DEMXXXXXX
    return (
      "DEM" + ("000000" + demande).substr(-6)
    )
  }*/

  render() {
    return (
      <div>
        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de la page */}
            <h3 className="panel-title">Liste de vos dernières demandes</h3>
          </div>   {/*3   fin */}
          <div className="">   {/*14   Tableau */}
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
              </thead>  {/*15 Fin */}
              <tbody>   {/*16 Contenu du tableau */}
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
                      <td>{this.action(this.props.employe.role, absence.statut, absence.debut)}</td>
                    </tr>
                  )
                }
              </tbody>{/*16 Fin */}
            </table>

          </div>   {/*14 Fin */}
        </div>   {/*2 Fin */}
        <div className="VOffSetBasPages">&nbsp;</div>   {/*1   Cosmétique Ajout d'une marge en dessous du formulaire réglable via le css voffsetpos */}{/*1    fin */}
      </div>
    );
  }
}

export default ListeDemandes;
